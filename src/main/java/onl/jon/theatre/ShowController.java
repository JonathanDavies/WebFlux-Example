package onl.jon.theatre;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
class ShowController {

    private final ShowRepository showRepository;

    @GetMapping("/shows")
    Flux<Show> all() {
        return showRepository.findAll();
    }

    @GetMapping("/shows/{id}")
    Mono<Show> byId(@PathVariable String id) {
        return showRepository.findById(id);
    }
}
