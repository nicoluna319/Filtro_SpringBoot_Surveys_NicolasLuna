package riwi.demo.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {

    @NotBlank(message = "el nombre es requerido")
    private String name;

    @Email(message = "el email no es valido")
    @Size(min = 5, max = 100, message = "el email debe tener entre 5 y 100 caracteres")
    private String email;


    @NotBlank(message = "la contraseña es requerida")
    private String password;

    @NotBlank(message = "True or false Requerido")
    private Boolean active;


    
}
