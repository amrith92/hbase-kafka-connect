package co.thegeekmachine.hbase;

import co.thegeekmachine.kafka.HBaseSourceConnector;
import com.google.common.collect.Maps;
import org.apache.hadoop.hbase.replication.BaseReplicationEndpoint;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by shroff.amrith on 15/03/16.
 */
public class KafkaHbaseReplicationEndpoint extends BaseReplicationEndpoint {
    private static final Logger log = LoggerFactory.getLogger(KafkaHbaseReplicationEndpoint.class);

    private static final UUID uuid = UUID.randomUUID();

    private final SourceConnector kafkaConnector;

    public KafkaHbaseReplicationEndpoint(final HBaseSourceConnector kafkaConnector) {
        this.kafkaConnector = kafkaConnector;
    }

    @Override
    protected void doStart() {
        kafkaConnector.start(Maps.newHashMap());
        notifyStarted();
    }

    @Override
    protected void doStop() {
        kafkaConnector.stop();
        notifyStopped();
    }

    @Override
    public UUID getPeerUUID() {
        log.debug("Peer UUID: {}", uuid);
        return uuid;
    }

    @Override
    public boolean replicate(final ReplicateContext replicateContext) {
        log.debug("replication (count, entries) = {}, {}", replicateContext.getSize(), replicateContext.getEntries());

        return true;
    }
}
