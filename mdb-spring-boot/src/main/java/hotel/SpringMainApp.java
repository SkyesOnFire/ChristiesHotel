package hotel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMainApp {
	private static Logger LOG = LogManager
			.getLogger(SpringBootConsoleApplication.class);

	public static void main(String[] args) {
		LOG.debug("STARTING THE TEST APPLICATION");
		SpringApplication.run(SpringBootConsoleApplication.class, args);
		LOG.debug("APPLICATION FINISHED");

		LOG.debug("STARTING THE MONGODB POPULATOR");
		SpringApplication.run(MdbSpringBootApplication.class, args);
		LOG.debug("APPLICATION FINISHED");

		SpringApplication.run(SpringMainApp.class, args);
	}

}