package com.sjc.login_boot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
//        @Bean(value = "defaultApi2")
//        public Docket createRestApi() {
//            return new Docket(DocumentationType.SWAGGER_2)
//                    .apiInfo(apiInfo())
//                    .select()
//                    .apis(RequestHandlerSelectors.basePackage("com.sjc.login_boot"))
//                    .paths(PathSelectors.any())
//                    .build();
//        }
//
//        private ApiInfo apiInfo() {
//            return new ApiInfoBuilder()
//                    .title("UserApi")
//                    .description("用户")
//                    .termsOfServiceUrl("http://www.baidu.com/")
//                    .contact("sjc")
//                    .version("1.0")
//                    .build();
//        }

    @Bean
    public Docket defaultApi2() {
        //==
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters       = new ArrayList<>();
        parameterBuilder.name("Authorization").description("Authorization")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameters.add(parameterBuilder.build());
        //==
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sjc.login_boot.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
        return docket;
    }

            private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("UserApi")
                    .description("用户")
                    .termsOfServiceUrl("http://www.baidu.com/")
                    .contact("sjc")
                    .version("1.0")
                    .build();
        }
    @Bean
    public Docket cc() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .groupName("cc")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sjc.login_boot.cc"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiCC() {
        return new ApiInfoBuilder()
                .title("CCApi")
                .description("用户")
                .termsOfServiceUrl("http://www.baidu.com/")
                .contact("sjc")
                .version("1.0")
                .build();
    }

    }
