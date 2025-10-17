package francescodicecca.TravelManagement.payloads;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewBookingPayload {
    private LocalDate requestDate;
    private String notes;
    private Long employeeId;
    private Long tripId;
}
