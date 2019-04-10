package app.timetables.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication(exclude = {
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
		
})
@EntityScan(basePackages= {"app.timetables.api.community.domain", "app.timetables.api.schedule.domain", "app.timetables.api.common"})
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, AppConfig.class, SecurityConfig.class})
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
