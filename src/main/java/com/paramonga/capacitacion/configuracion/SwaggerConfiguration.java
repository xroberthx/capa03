package com.paramonga.capacitacion.configuracion;

//import com.sun.deploy.ui.AppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//import java.util.logging.Logger;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);

    @Bean
    public Docket swaggerSpringfoxDocket(){
        log.debug("Start Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.paramonga.capacitacion.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .genericModelSubstitutes(ResponseEntity.class);

        watch.stop();
        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return docket;
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Capacitacion Paramonga",
                "Aplicacion de Prueba",
                "Sistema backend vesion 1.0",
                "Derechos Reservados",
                new Contact("Roberth García", "www.agroparamonga.com", "rgarcia@agroparamonga.com"),
                "API License URL", "API license URL", Collections.emptyList());


    }
}
