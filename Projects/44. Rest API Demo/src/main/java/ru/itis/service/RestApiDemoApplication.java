package ru.itis.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.itis.service.models.Course;
import ru.itis.service.repositories.CoursesRepository;
import ru.itis.service.repositories.DisciplinesRepository;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.utils.TestDataUtil;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestApiDemoApplication {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.itis.service.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RestApiDemoApplication.class, args);
        TestDataUtil testDataUtil = context.getBean(TestDataUtil.class);
        testDataUtil.initializeData();
    }

}
