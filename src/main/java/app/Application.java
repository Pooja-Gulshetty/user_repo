package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@SpringBootApplication
@ComponentScan(basePackages = {"user2Controller", "user2service", "user2Repository", "app"})
@Configuration
@EnableJpaRepositories({"user2Repository"})
@EntityScan(basePackages = {"domain"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }
}
