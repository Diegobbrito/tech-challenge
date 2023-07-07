package br.com.fiap.lanchonete.configuracao;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
            .title("Lanchonete POSTECH")
            .version("1.0")

            .description("API de gerenciamento de cadastro de clientes e gerenciamento de pedidos.")
            .license(mitLicense);
    @Bean
    public OpenAPI api() {
        return new OpenAPI();
    }
}
