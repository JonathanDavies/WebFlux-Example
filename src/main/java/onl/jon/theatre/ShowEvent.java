package onl.jon.theatre;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
class ShowEvent {

    private String id;
    private Date date;
}
