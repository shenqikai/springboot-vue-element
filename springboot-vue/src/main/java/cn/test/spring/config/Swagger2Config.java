package cn.test.spring.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
//    @Value("${token.header}") private String tokenHeader;
//
//    @Value("${token.name}") private String tokenName;
    @Bean
    public Docket createRestApi() {
/*        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name(tokenHeader).description("input the token for authentication either in the authorization field or in the token field").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        ParameterBuilder aParameterBuilder1 = new ParameterBuilder();
        aParameterBuilder1.name(tokenName).description("input the token for authentication either in the authorization field or in the token field").modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(aParameterBuilder.build());
        aParameters.add(aParameterBuilder1.build());*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
               // .globalOperationParameters(aParameters)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.nutak.user"))
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot RESTful APIs")
                .description("Nutak")
//                .termsOfServiceUrl("http://blog.didispace.com/")
//                .contact("程序猿DD")
                .version("1.0")
                .build();
    }

}
