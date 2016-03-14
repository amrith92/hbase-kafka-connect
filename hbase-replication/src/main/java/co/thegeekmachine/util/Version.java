package co.thegeekmachine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by shroff.amrith on 15/03/16.
 */
public class Version {
    private static final Logger log = LoggerFactory.getLogger(Version.class);
    private static String version = "unknown";

    static {
        try {
            final Properties props = new Properties();
            props.load(Version.class.getResourceAsStream("/hbase-kafka-connect.properties"));
            version = props.getProperty("version", version).trim();
        } catch (Exception e) {
            log.warn("Error while loading version:", e);
        }
    }

    public static String getVersion() {
        return version;
    }
}
