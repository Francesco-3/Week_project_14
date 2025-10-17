package francescodicecca.TravelManagement.payloads;

import francescodicecca.TravelManagement.entities.enums.TripStatus;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewTripStatusPayload {
    private TripStatus status;
}
