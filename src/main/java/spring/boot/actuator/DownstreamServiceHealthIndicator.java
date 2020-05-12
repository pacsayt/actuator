package spring.boot.actuator;

// https://projectreactor.io/docs/core/release/reference/index.html#about-doc
import reactor.core.publisher.Mono;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DownstreamServiceHealthIndicator implements ReactiveHealthIndicator
{

  @Override
  public Mono<Health> health()
  {
    return checkDownstreamServiceHealth().onErrorResume( ex -> Mono.just( new Health.Builder().down(ex).build()));
  }

  private Mono<Health> checkDownstreamServiceHealth()
  {
    // we could use WebClient to check health reactively
    return Mono.just( new Health.Builder().up().build());
  }
}