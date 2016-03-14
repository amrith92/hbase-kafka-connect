package co.thegeekmachine.kafka;

import co.thegeekmachine.util.Version;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.List;
import java.util.Map;

/**
 * Created by shroff.amrith on 15/03/16.
 */
public class HBaseSourceConnector extends SourceConnector {
    @Override
    public String version() {
        return Version.getVersion();
    }

    @Override
    public void start(final Map<String, String> props) {

    }

    @Override
    public Class<? extends Task> taskClass() {
        return HBaseSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(final int maxTasks) {
        return null;
    }

    @Override
    public void stop() {

    }
}
