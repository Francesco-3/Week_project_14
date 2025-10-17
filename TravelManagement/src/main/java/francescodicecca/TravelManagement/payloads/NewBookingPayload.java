package francescodicecca.TravelManagement.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewBookingPayload {
    @NotNull(message = "La data di richiesta è obbligatoria")
    private LocalDate requestDate;

    private String notes;

    @NotNull(message = "L'id è obbligatorio")
    private UUID employeeId;
    @NotNull(message = "L'id è obbligatorio")
    private UUID tripId;
}
