package co.thegeekmachine.kafka;

import co.thegeekmachine.util.Version;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.util.List;
import java.util.Map;

/**
 * Created by shroff.amrith on 15/03/16.
 */
public class HBaseSourceTask extends SourceTask {
    @Override
    public String version() {
        return Version.getVersion();
    }

    @Override
    public void start(final Map<String, String> map) {

    }

    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        return null;
    }

    @Override
    public void stop() {

    }
}
