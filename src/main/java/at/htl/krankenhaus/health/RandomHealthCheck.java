package at.htl.krankenhaus.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class RandomHealthCheck implements HealthCheck {

    @ConfigProperty(name = "random.up", defaultValue = "false")
    boolean randomUp;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("Random health check");
        try {
            if(Math.random() > 0.8) {
                throw new RuntimeException("NA NA NA NA NA NA NA NA NA NA NA NA NA NA BATMAN!");
            }
            builder.up();
        } catch (RuntimeException e) {
            builder.down().withData("error", e.getMessage());
        }

        return builder.build();
    }
}
