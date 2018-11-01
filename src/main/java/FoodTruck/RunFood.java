package FoodTruck;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class RunFood {
	private static final Logger log = LoggerFactory.getLogger(RunFood.class);

	public static void main(String[] args) {
        SpringApplication.run(RunFood.class, args);
    }
}
