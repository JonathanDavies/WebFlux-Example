package onl.jon.theatre;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@EnableWebFlux
@AllArgsConstructor
public class WebConfig implements WebFluxConfigurer {

    private final ShowHandler showHandler;
    private final ShowEventHandler showEventHandler;

    @Bean
    public RouterFunction<ServerResponse> routeShow() {
        return RouterFunctions
                .route(GET("/shows/{id}/events"), showEventHandler::events)

                .andRoute(GET("/shows/{id}"), showHandler::byId)
                .andRoute(GET("/shows"), showHandler::all);
    }
}
