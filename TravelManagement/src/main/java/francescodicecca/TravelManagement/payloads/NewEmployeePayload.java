package francescodicecca.TravelManagement.payloads;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NewEmployeePayload {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String avatarUrl;
}
