package spring.boot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Eleg a
 * <artifactId>spring-boot-starter-actuator</artifactId>
 * fuggoseget betenni, hogy a kovetkezok mukodjenek :
 *
 * http://localhost:8080/actuator/ ezt adja :
 * "self":{"href":"http://localhost:8081/actuator","templated":false},
 * "health":{"href":"http://localhost:8081/actuator/health","templated":false},
 * "health-path":{"href":"http://localhost:8081/actuator/health/{*path}", * "templated":true},
 * "info":{"href":"http://localhost:8081/actuator/info","templated":false}
 *
 * /actuator/metrics/ - kifossa az osszes lehetoseget
 * {"names":["jvm.threads.states","process.files.max","jvm.memory.used","jvm.gc.memory.promoted", ... stb.
 * pl. : http://localhost:9001/actuator/metrics/jvm.threads.states
 * {"name":"jvm.threads.states","description":"The current number of threads having TERMINATED state","baseUnit":"threads","measurements":[{"statistic":"VALUE","value":39.0}],"availableTags":[{"tag":"state","values":["timed-waiting","new","runnable","blocked","waiting","terminated"]}]}
 *
 * http://localhost:9001/actuator/metrics/jvm.buffer.count
 *
 * In Spring Boot 2.0, the in-house metrics were replaced with Micrometer support. Thus, we can expect breaking changes.
 *
 * Erre telleg moccan valamit :
 * http://localhost:9001/actuator/features
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
	public static void main( String[] args)
	{
		SpringApplication.run( ActuatorApplication.class, args);
	}
}
