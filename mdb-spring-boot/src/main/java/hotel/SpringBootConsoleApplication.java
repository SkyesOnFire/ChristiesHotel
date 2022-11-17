package hotel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication 
  implements CommandLineRunner {

    private static Logger LOG = LogManager.getLogger(SpringBootConsoleApplication.class);
 
    @Override
    public void run(String... args) {
        LOG.debug("EXECUTING : command line runner");
 
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}");
            LOG.info(i);
            LOG.info(args[i]);
        }
    }
}