package mael.simplecodebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SimpleCodeBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCodeBaseApplication.class, args);
    }

}
