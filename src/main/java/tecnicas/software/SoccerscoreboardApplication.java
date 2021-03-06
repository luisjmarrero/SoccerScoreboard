package tecnicas.software;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class SoccerscoreboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerscoreboardApplication.class, args);
	}

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.select()
				.paths(Predicates.or(
						regex("/games.*"),
						regex("/players.*"),
						regex("/teams.*"),
						regex("/plays.*")
				))
				.build();
	}

	@Component
	@Primary
	public class CustomObjectMapper extends ObjectMapper {
		public CustomObjectMapper() {
			setSerializationInclusion(JsonInclude.Include.NON_NULL);
			configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			enable(SerializationFeature.INDENT_OUTPUT);
		}
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("FootBoard API")
				.description("REST API Docummentation for FootBoard App")
				.license("Apache License Version 2.0")
				.version("1.0")
				.build();
	}

}
