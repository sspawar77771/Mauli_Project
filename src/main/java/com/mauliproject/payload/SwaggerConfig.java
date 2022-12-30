package com.mauliproject.payload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo apiInfo(){
       return new ApiInfoBuilder()
                .title("Mauli_Project")
                .description("Mauli_Project_Api_Info")
                .version("1.0")
               .contact(new Contact("Sahil Shashikant Pawar","mauli-project.com","sahilspawar7@gmail.com"))
                .build();
    }

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }
}
