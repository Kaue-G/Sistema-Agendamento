package br.pedro.demofc.config;

import br.pedro.demofc.dtos.DisponibilityDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import org.springframework.data.domain.Page;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(Sort.class)
                .ignoredParameterTypes(Page.class)
                .globalResponseMessage(RequestMethod.GET,responseMessageForGET())
                .globalResponseMessage(RequestMethod.POST,responseMessageForGET())
                .globalResponseMessage(RequestMethod.DELETE,responseMessageForGET())
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("REST API - Agendamento FCamara");
        builder.description("Uma API Rest capaz de realizar agendamentos por dia ou por intervalo de horas em um dado período");
        builder.version("0.1");
        return builder.build();
    }

    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("Erro desconhecido")
                    .build());
        }};
    }
}
