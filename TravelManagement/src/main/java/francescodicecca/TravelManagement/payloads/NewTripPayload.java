package francescodicecca.TravelManagement.payloads;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewTripPayload {
    private String destination;
    private LocalDate date;
}
