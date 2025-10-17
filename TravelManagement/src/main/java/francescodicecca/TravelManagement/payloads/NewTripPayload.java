package francescodicecca.TravelManagement.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewTripPayload {
    @NotEmpty(message = "La destinazione è obbligatoria!")
    String destination;
    @NotNull(message = "La data è obbligatoria!")
    LocalDate date;
}
