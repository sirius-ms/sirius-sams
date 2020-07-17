package de.unijena.bioinf.ms.gui.compute;

import de.unijena.bioinf.ChemistryBase.chem.PrecursorIonType;
import de.unijena.bioinf.ChemistryBase.ms.PossibleAdducts;
import de.unijena.bioinf.chemdb.DataSource;
import de.unijena.bioinf.chemdb.DataSources;
import de.unijena.bioinf.chemdb.SearchableDatabase;
import de.unijena.bioinf.chemdb.SearchableDatabases;
import de.unijena.bioinf.ms.frontend.subtools.fingerid.FingerIdOptions;
import de.unijena.bioinf.ms.gui.utils.GuiUtils;
import de.unijena.bioinf.ms.gui.utils.jCheckboxList.JCheckBoxList;
import de.unijena.bioinf.ms.gui.utils.jCheckboxList.JCheckboxListPanel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Markus Fleischauer (markus.fleischauer@gmail.com)
 */

//here we can show fingerid options. If it becomes to much, we can change this to a setting like tabbed pane
public class FingerIDConfigPanel extends SubToolConfigPanel<FingerIdOptions> {
    //todo sync db selection with sirius panel

    protected final JCheckboxListPanel<SearchableDatabase> searchDBList;
    public final JCheckboxListPanel<String> adductOptions;
    protected final JToggleButton enforceAdducts;

    public FingerIDConfigPanel(final JCheckBoxList<String> sourceIonization, @Nullable final JCheckBoxList<SearchableDatabase> syncSource) {
        super(FingerIdOptions.class);

        // configure database to search list
        searchDBList = new JCheckboxListPanel<>(new DBSelectionList(), "Search in DBs:");
        GuiUtils.assignParameterToolTip(searchDBList, "StructureSearchDB");
        parameterBindings.put("StructureSearchDB", () -> searchDBList.checkBoxList.getCheckedItems().isEmpty() ? null : String.join(",", getStructureSearchDBStrings()));
        add(searchDBList);

        adductOptions = new JCheckboxListPanel<>(new AdductSelectionList(sourceIonization), "Fallback Adducts");
        GuiUtils.assignParameterToolTip(adductOptions, "AdductSettings.fallback");
        parameterBindings.put("AdductSettings.fallback", () -> getSelectedAdducts().toString());
        add(adductOptions);
        enforceAdducts =  new JToggleButton("enforce", false);
        enforceAdducts.setToolTipText(GuiUtils.formatToolTip("Enforce the selected adducts instead of using them only as fallback."));
        adductOptions.buttons.add(enforceAdducts);
        parameterBindings.put("AdductSettings.enforced", () -> enforceAdducts.isSelected() ? getSelectedAdducts().toString() : null);

        searchDBList.checkBoxList.check(SearchableDatabases.getBioDb());

        if (syncSource != null)
            syncSource.addListSelectionListener(e -> {
                searchDBList.checkBoxList.uncheckAll();
                if (syncSource.getCheckedItems().isEmpty())
                    searchDBList.checkBoxList.check(SearchableDatabases.getBioDb());
                else
                    searchDBList.checkBoxList.checkAll(syncSource.getCheckedItems());
            });
    }

    public PossibleAdducts getSelectedAdducts() {
        return adductOptions.checkBoxList.getCheckedItems().stream().map(PrecursorIonType::parsePrecursorIonType)
                .flatMap(Optional::stream).collect(Collectors.collectingAndThen(Collectors.toSet(), PossibleAdducts::new));
    }

    public List<SearchableDatabase> getStructureSearchDBs() {
        return searchDBList.checkBoxList.getCheckedItems();
    }

    public List<String> getStructureSearchDBStrings() {
        return getStructureSearchDBs().stream().map(db -> {
            if (db.isCustomDb())
                return db.name();
            else
                return DataSources.getSourceFromName(db.name()).map(DataSource::name).orElse(null);
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
