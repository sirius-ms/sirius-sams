package de.unijena.bioinf.sirius.core;
/**
 * Created by Markus Fleischauer (markus.fleischauer@gmail.com)
 * as part of the sirius
 * 19.09.16.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Properties;

/**
 * @author Markus Fleischauer (markus.fleischauer@gmail.com)
 */
public class ApplicationCore {
    private static final String USER_PROPERTIES_FILE_HAEDER = "This is the default Sirius properties file containing default values for all sirius properties that can be set";
    private static final Path USER_PROPERTIES_FILE;
    private static final Properties USER_PROPERTIES;

    public final static Path WORKSPACE;

    public final static String VERSION_STRING;
    public final static String CITATION;
    public final static String CITATION_BIBTEX;


    //creating
    static {
        //intit build properties
        final Properties BUILD_PROPERTIES = new Properties();
        try (InputStream input = ApplicationCore.class.getResourceAsStream("/siriusBuild.properties")) {
            // load a properties file
            BUILD_PROPERTIES.load(input);
            System.getProperties().putAll(BUILD_PROPERTIES);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        final String version = System.getProperty("de.unijena.bioinf.sirius.version");
        VERSION_STRING = version != null ? "Sirius " + version : "Sirius";

        String prop = System.getProperty("de.unijena.bioinf.sirius.cite");
        CITATION = prop != null ? prop : "";
        prop = System.getProperty("de.unijena.bioinf.sirius.cite-bib");
        CITATION_BIBTEX = prop != null ? prop : "";


        //init application properties
        String s = System.getProperty("user.home");
        System.out.println(s);

        final Path DEFAULT_WORKSPACE = Paths.get(s).resolve(".sirius");
        final Map<String, String> env = System.getenv();
        String ws = env.get("SIRIUS_WORKSPACE");

        if (ws != null) {
            Path wsDir = Paths.get(ws);
            if (Files.isDirectory(wsDir)) {
                WORKSPACE = wsDir;
            } else if (Files.notExists(wsDir)) {
                try {
                    Files.createDirectories(wsDir);
                } catch (IOException e) {
                    System.err.println("Could not create Workspace set in environment variable! Falling back to default Workspace - " + DEFAULT_WORKSPACE.toString());
                    //todo use logging
                    e.printStackTrace();
                    wsDir = DEFAULT_WORKSPACE;
                } finally {
                    WORKSPACE = wsDir;
                }
            } else {
                System.err.println(wsDir.toString() + " is not a directory! Falling back to default Workspace - " + DEFAULT_WORKSPACE.toString());//todo use logging (warning)
                WORKSPACE = DEFAULT_WORKSPACE;
            }
        } else {
            WORKSPACE = DEFAULT_WORKSPACE;
        }
        if (Files.notExists(WORKSPACE)) {
            try {
                Files.createDirectories(WORKSPACE);
            } catch (IOException e) {
                System.err.println("Could NOT create Workspace");//todo use logging (error)
                e.printStackTrace();
            }//todo Close application?
        }

        USER_PROPERTIES_FILE = WORKSPACE.resolve("sirius.properties");
        USER_PROPERTIES = new Properties();


        try (InputStream stream = ApplicationCore.class.getResourceAsStream("/sirius.properties")) {
            USER_PROPERTIES.load(stream);
            changeDefaultPropterty("de.unijena.bioinf.sirius.fingerID.cache", WORKSPACE.resolve("csi_fingerid_cache").toString());
        } catch (IOException e) {
            System.err.println("Could NOT create Properties file");//todo use logging (error)
            e.printStackTrace();
        }//todo Close application?


        if (Files.exists(USER_PROPERTIES_FILE)) {
            try (InputStream stream = Files.newInputStream(USER_PROPERTIES_FILE)) {
                Properties tmp =  new Properties();
                tmp.load(stream);
                USER_PROPERTIES.putAll(tmp);
            } catch (IOException e) {
                System.err.println("Could NOT load Properties form user properties file, falling back to default properties");//todo use logging (error)
                e.printStackTrace();
            }
        }

        addDefaultProptery("de.unijena.bioinf.sirius.workspace", WORKSPACE.toAbsolutePath().toString());
        storeUserProperties();

    }

    public static void addDefaultPropteries(File properties) throws IOException {
        addDefaultPropteries(properties.toPath());
    }

    public static void addDefaultPropteries(Path properties) throws IOException {
        Properties p = new Properties();
        p.load(Files.newInputStream(properties));
        addDefaultPropteries(p);
    }

    public static void addDefaultPropteries(Properties properties) {
        System.getProperties().putAll(properties);
        System.getProperties().putAll(USER_PROPERTIES);
    }

    public static void addDefaultProptery(String propertyName, String propertyValue) {
        System.setProperty(propertyName, propertyValue);
        System.getProperties().putAll(USER_PROPERTIES);
    }

    public static void changeDefaultPropterties(Properties properties) {
        System.getProperties().putAll(properties);
        USER_PROPERTIES.putAll(properties);
    }

    public static void changeDefaultPropterty(String propertyName, String propertyValue) {
        System.getProperties().setProperty(propertyName, propertyValue);
        USER_PROPERTIES.setProperty(propertyName, propertyValue);
    }

    public static void changeDefaultProptertiesPersistent(Properties properties) {
        changeDefaultPropterties(properties);
        storeUserProperties();
    }


    public static void changeDefaultProptertyPersistent(String propertyName, String propertyValue) {
        changeDefaultPropterty(propertyName, propertyValue);
        storeUserProperties();
    }

    private static void storeUserProperties() {
        try {
            Files.deleteIfExists(USER_PROPERTIES_FILE);
            try (OutputStream stream = Files.newOutputStream(USER_PROPERTIES_FILE, StandardOpenOption.CREATE_NEW)) {
                USER_PROPERTIES.store(stream, USER_PROPERTIES_FILE_HAEDER);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
