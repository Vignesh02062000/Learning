package processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"controller", "service", "repository", "entity", "config"})
@EnableMongoRepositories(basePackages = "repository")
@EnableDiscoveryClient
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
        }
    }