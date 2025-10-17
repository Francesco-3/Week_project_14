package francescodicecca.TravelManagement.payloads;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewBookingPayload {
    private LocalDate requestDate;
    private String notes;
    private UUID employeeId;
    private UUID tripId;
}
