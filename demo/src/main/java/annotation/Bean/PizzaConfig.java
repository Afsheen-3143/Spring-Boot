package annotation.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 👈 REQUIRED
public class PizzaConfig {

    @Bean
    public Vegpizza vegpizza() {
        return new Vegpizza();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Nonvegpizza nonvegpizza() {
        return new Nonvegpizza();
    }
}
