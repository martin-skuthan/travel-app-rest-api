package pl.java.travelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class TravelAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAppApplication.class, args);
    }

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo("Travel Attraction API",
                "Simple database with travel attraction records",
                "1.00",
                "",
                new Contact("Martin Skuthan","https://www.linkedin.com/in/martin-skuthan-630553190/",
                        "martin.skuthan95@gmail.com"),
                "",
                "",
                Collections.emptyList());

    }

}
