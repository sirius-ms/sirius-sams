/*
 *
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman, Fleming Kretschmer and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schilller University.
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with SIRIUS. If not, see <https://www.gnu.org/licenses/lgpl-3.0.txt>
 */

/*
 *
 *  This file is part of the SIRIUS library for analyzing MS and MS/MS data
 *
 *  Copyright (C) 2013-2020 Kai Dührkop, Markus Fleischauer, Marcus Ludwig, Martin A. Hoffman, Fleming Kretschmer and Sebastian Böcker,
 *  Chair of Bioinformatics, Friedrich-Schilller University.
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with SIRIUS. If not, see <https://www.gnu.org/licenses/lgpl-3.0.txt>
 */

package de.unijena.bioinf.ms.gui.table;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.event.ListEventAssembler;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SiriusGlazedLists {

    public static <E> void multiUpdate(EventList<E> list, Set<E> elementsToUpdate) {
        try {
            list.getReadWriteLock().writeLock().lock();
            final ListEventAssembler<E> eventAssembler = new ListEventAssembler<>(list, list.getPublisher());
            eventAssembler.beginEvent();
            for (int i = 0; i < list.size(); i++) {
                if (elementsToUpdate.contains(list.get(i)))
                    eventAssembler.elementUpdated(i, null, list.get(i));
            }
            eventAssembler.commitEvent();
        } finally {
            list.getReadWriteLock().writeLock().unlock();
        }

    }

    public static <E> boolean refill(EventList<E> list, ArrayList<E> innerList, Collection<E> elementsToFillIn) {
        try {
            list.getReadWriteLock().writeLock().lock();

            if (elementsToFillIn == null || elementsToFillIn.isEmpty()) {
                list.clear();
                return true;
            } else if (innerList.equals(elementsToFillIn)) {
                return false;
            } else {
                try {
                    final ListEventAssembler<E> eventAssembler = new ListEventAssembler<>(list, list.getPublisher());
                    eventAssembler.beginEvent();
                    int index = 0;
                    for (E e : elementsToFillIn) {
                        if (index < innerList.size()) {
                            eventAssembler.elementUpdated(index, innerList.get(index), e);
                            innerList.set(index, e);
                        } else {
                            eventAssembler.elementInserted(index, e);
                            innerList.add(index, e);
                        }
                        index++;
                    }

                    for (int i = innerList.size() - 1; i >= index; i--) {
                        eventAssembler.elementDeleted(i, innerList.get(i));
                        innerList.remove(i);
                    }

                    eventAssembler.commitEvent();
                    return true;
                } catch (Exception e) {
                    LoggerFactory.getLogger(SiriusGlazedLists.class).error("Error during Event list Refill.", e);
                    return false;
                }
            }
        } finally {
            list.getReadWriteLock().writeLock().unlock();
        }
    }

}
