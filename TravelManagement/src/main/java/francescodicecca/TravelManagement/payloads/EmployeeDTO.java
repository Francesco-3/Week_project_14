package francescodicecca.TravelManagement.payloads;

import jakarta.validation.constraints.*;

public record EmployeeDTO(
        @NotBlank(message = "Lo username è obbligatorio!")
        @Size(min = 2, max = 30, message = "Deve avere una lunghezza compresa tra 2 e 30 caratteri")
        String username,
        @NotBlank(message = "Il nome è obbligatorio!")
        @Size(min = 2, max = 30, message = "Il nome deve avere una lunghezza compresa tra 2 e 30 caratteri")
        String name,
        @NotBlank(message = "Il cognome è obbligatorio!")
        @Size(min = 2, max = 30, message = "Il cognome deve avere una lunghezza compresa tra 2 e 30 caratteri")
        String surname,
        @NotBlank(message = "L'email è obbligatoria!")
        @Email(message = "L'indirizzo email inserito non è nel formato corretto!")
        String email,

        String avatarUrl) {
}
