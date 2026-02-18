package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import app.model.Cat;

@Configuration
@ComponentScan(basePackages = "app.model")
public class AppConfig {

    @Bean(name = "cat")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cat getCat() {
        return new Cat();
    }
}