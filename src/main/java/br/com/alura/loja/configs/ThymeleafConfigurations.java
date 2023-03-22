package br.com.alura.loja.configs;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfigurations {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
