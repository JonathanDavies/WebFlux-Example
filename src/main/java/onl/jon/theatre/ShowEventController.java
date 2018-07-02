package onl.jon.theatre;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;

@RestController
class ShowEventController {

    @GetMapping(path = "/shows/{id}/events", produces = "text/event-stream")
    Flux<ShowEvent> events(@PathVariable String id) {

        return Flux.<ShowEvent>generate(sink -> sink.next(new ShowEvent(id, new Date())))
                .delayElements(Duration.ofSeconds(1));
    }
}
