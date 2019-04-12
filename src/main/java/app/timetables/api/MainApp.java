package app.timetables.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/*@SpringBootApplication(exclude = {
		WebFluxAutoConfiguration.class,
		RedisAutoConfiguration.class,
		OAuth2ClientAutoConfiguration.class, //?
		ReactiveSecurityAutoConfiguration.class,
		MongoAutoConfiguration.class,
		MongoDataAutoConfiguration.class,
		LdapAutoConfiguration.class,
		ActiveMQAutoConfiguration.class,
		RabbitAutoConfiguration.class,
		ArtemisAutoConfiguration.class,
		BatchAutoConfiguration.class,
		WebSocketMessagingAutoConfiguration.class,
		LiquibaseAutoConfiguration.class,
		JooqAutoConfiguration.class,
		FreeMarkerAutoConfiguration.class,
		CouchbaseAutoConfiguration.class
		
})*/
@SpringBootApplication
//@EntityScan(basePackages= {"app.timetables.api.community.domain", "app.timetables.api.schedule.domain", "app.timetables.api.common"})
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, AppConfig.class, SecurityConfig.class})
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
