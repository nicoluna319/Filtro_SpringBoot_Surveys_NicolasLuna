package riwi.demo.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptQuestReq {
    
    @NotBlank(message = "el texto de la pregunta es requerido")
    private String text;

    @NotNull(message = "True or false es obligatorio")
    private Boolean active;

    @NotNull(message = "El id del question es obligatorio")
    private String question;
    
}
