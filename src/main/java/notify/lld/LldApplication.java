// Advised to configure springboot starter
package notify.lld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAsync
public class LldApplication {

	public static void main(String[] args) {
		SpringApplication.run(LldApplication.class, args);
	}

}
