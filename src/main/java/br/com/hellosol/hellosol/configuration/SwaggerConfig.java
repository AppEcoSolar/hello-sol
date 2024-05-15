package br.com.hellosol.hellosol.configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig  {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Hello Sol")
                        .description("API para Gerenciamento de Usina Solar")
                        .contact(new Contact().name("Comercial Hello Sol").email("hellosol@gmail.com"))
                        .version("1.0.0"));
    }


}

