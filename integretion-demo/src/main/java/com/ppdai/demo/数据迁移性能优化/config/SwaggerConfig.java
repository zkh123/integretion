package com.ppdai.demo.数据迁移性能优化.config;

import com.google.common.base.Predicate;
import com.ppdai.demo.数据迁移性能优化.properties.SwaggerPropperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by huanglijun on 2017/7/31.
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerPropperties.class)
public class SwaggerConfig {

    @Autowired
    private SwaggerPropperties swaggerPropperties;


    @Bean
    public Docket createRestApi() {

        /**
         * Swagger会默认把所有Controller中的RequestMapping方法都生成API出来，实际上我们一般只需要标准接口的（像返回页面的那种Controller方法我们并不需要），
         * 所有你可以按下面的方法来设定要生成API的方法的要求。
         * 如下我针对RestController注解的类和ResponseBody注解的方法才生成Swaager的API，并且排除了特定的类
         */
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class)// 排除
                    return false;
                if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                // 这里设置api 生成的范围，有两种方式:
                // 1.上面通过自定义过滤规则
                // 2,通过定义需要生成API的包路径
                //.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerPropperties.getTitle())//大标题
                .version(swaggerPropperties.getTitle())//版本
                .description(swaggerPropperties.getDescription())
                .contact(new Contact(swaggerPropperties.getContactUser(),swaggerPropperties.getContactUrl(),swaggerPropperties.getContactEmail()))
                .build();
    }
}
