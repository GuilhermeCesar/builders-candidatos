package io.platformbuilders.cliente.config;

import io.platformbuilders.cliente.helper.MessageHelper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static io.platformbuilders.cliente.helper.ErrorCodeEnum.SWAGGER_DESCRIPTION;
import static io.platformbuilders.cliente.helper.ErrorCodeEnum.SWAGGER_NAME;
import static io.platformbuilders.cliente.helper.ErrorCodeEnum.SWAGGER_VERSION;

@RequiredArgsConstructor
@Configuration
public class SpringDocConfig {

    private final MessageHelper messageHelper;

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.swagger-ui.server.list}") final List<String> servers) {
        return new OpenAPI()
                .servers(servers.stream().map(s -> new Server().url(s)).toList())
                .info(new Info()
                        .title(this.messageHelper.get(SWAGGER_NAME))
                        .description(this.messageHelper.get(SWAGGER_DESCRIPTION))
                        .version(this.messageHelper.get(SWAGGER_VERSION))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }


    public static class SwaggerTags {

        public static final String CLIENTE = "Cliente";

        private SwaggerTags() {
            super();
        }
    }
}