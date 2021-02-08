package spring.boot.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Eleg a
 * <artifactId>spring-boot-starter-actuator</artifactId>
 * fuggoseget betenni, hogy a kovetkezok mukodjenek :
 *
 * http://localhost:8080/actuator/ kifossa, ami elerheto :
 * "self":{"href":"http://localhost:8081/actuator","templated":false},
 * "health":{"href":"http://localhost:8081/actuator/health","templated":false},
 * "health-path":{"href":"http://localhost:8081/actuator/health/{*path}", * "templated":true},
 * "info":{"href":"http://localhost:8081/actuator/info","templated":false}
 *
 * http://localhost:9001/actuator/metrics/ - kifossa az osszes lehetoseget
 * {"names":["jvm.threads.states","process.files.max","jvm.memory.used","jvm.gc.memory.promoted", ... stb.
 * pl. :
 *   http://localhost:9001/actuator/metrics/jvm.threads.states
 *     {"name":"jvm.threads.states","description":"The current number of threads having TERMINATED state","baseUnit":"threads","measurements":[{"statistic":"VALUE","value":39.0}],"availableTags":[{"tag":"state","values":["timed-waiting","new","runnable","blocked","waiting","terminated"]}]}
 *   http://localhost:9001/actuator/metrics/jvm.buffer.count
 *    name	"jvm.buffer.count"
 *     description	"An estimate of the number of buffers in the pool"
 *     baseUnit	"buffers"
 *     measurements
 *     0
 *     statistic	"VALUE"
 *     value	5
 *     availableTags
 *     0
 *     tag	"id"
 *     values
 *     0	"direct"
 *     1	"mapped"
 *
 * In Spring Boot 2.0, the in-house metrics were replaced with Micrometer support. Thus, we can expect breaking changes.
 *
 * Erre a sajat :
 * http://localhost:9001/actuator/features
 *
 *   Feature_1612792860597
 *   enabled	true
 *   featureName	"Feature_1612792860597"
 *
 * http://localhost:9001/actuator/metrics/jvm.buffer.count
 */
 
 /**
 * Building a RESTful Web Service with Spring Boot Actuator
 * https://spring.io/guides/gs/actuator-service/
 * auditevents
 * beans
 *
 */


@SpringBootApplication
public class ActuatorApplication
{
	private static final Logger LOGGER = LoggerFactory.getLogger( ActuatorApplication.class);

	public static void main( String[] args)
	{
		LOGGER.info( "ActuatorApplication::main() BEGIN ++++++++++");
		LOGGER.info( "ActuatorApplication::main() BEFORE SpringApplication.run() ++++++++++");
		SpringApplication.run( ActuatorApplication.class, args);
		LOGGER.info( "ActuatorApplication::main() END ++++++++++");
	}
}
