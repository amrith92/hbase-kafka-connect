package co.thegeekmachine.hbase;

import org.apache.hadoop.hbase.replication.BaseReplicationEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by shroff.amrith on 15/03/16.
 */
public class KafkaHbaseReplicationEndpoint extends BaseReplicationEndpoint {
    private static final Logger log = LoggerFactory.getLogger(KafkaHbaseReplicationEndpoint.class);

    private static final UUID uuid = UUID.randomUUID();

    public KafkaHbaseReplicationEndpoint() {

    }

    @Override
    protected void doStart() {
        notifyStarted();
    }

    @Override
    protected void doStop() {
        notifyStopped();
    }

    @Override
    public UUID getPeerUUID() {
        log.debug("Peer UUID: {}", uuid);
        return uuid;
    }

    @Override
    public boolean replicate(ReplicateContext replicateContext) {
        log.debug("replication (count, entries) = {}, {}", replicateContext.getSize(), replicateContext.getEntries());

        return true;
    }
}
