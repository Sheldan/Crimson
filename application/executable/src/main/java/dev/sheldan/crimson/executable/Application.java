package dev.sheldan.crimson.executable;

import dev.sheldan.abstracto.core.service.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class})
@ComponentScan(basePackages = {"dev.sheldan.abstracto", "dev.sheldan.crimson"})
@EnableCaching
@EnableJpaRepositories(basePackages = {"dev.sheldan.abstracto", "dev.sheldan.crimson"})
@EntityScan(basePackages = {"dev.sheldan.abstracto", "dev.sheldan.crimson"})
@EnableTransactionManagement
public class Application implements CommandLineRunner {

    @Autowired
    private Startup startup;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        startup.startBot();
    }

}
