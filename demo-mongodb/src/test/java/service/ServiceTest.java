package service;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import util.PropertiesUtil;

import java.util.Properties;

/**
 * Created by trieudoan on 5/25/2015.
 */
public abstract class ServiceTest extends TestCase {
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();

    private MongodExecutable mongodExe;
    private MongodProcess mongodProcess;

    @Before
    public void setUp() throws Exception {
        Properties properties = PropertiesUtil.readProperties("db_config.properties");
        int port = Integer.parseInt(properties.getProperty("port"));

        mongodExe = starter.prepare(new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build());

        mongodProcess = mongodExe.start();
    }

    @After
    public void tearDown() throws Exception {
        mongodProcess.stop();
        mongodExe.stop();
    }
}
