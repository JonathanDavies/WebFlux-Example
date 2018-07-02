package onl.jon.theatre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
class ShowHandler {

    private final ShowRepository showRepository;

    Mono<ServerResponse> all(ServerRequest serverRequest) {
        Flux<Show> shows = showRepository.findAll();
        return ServerResponse.ok().body(shows, Show.class);
    }

    Mono<ServerResponse> byId(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Show> show = showRepository.findById(id);
        return ServerResponse.ok().body(show, Show.class);
    }
}
