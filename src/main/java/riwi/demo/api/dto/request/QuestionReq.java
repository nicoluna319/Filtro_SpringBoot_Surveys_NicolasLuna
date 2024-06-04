package riwi.demo.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import riwi.demo.utils.enums.Type;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionReq {

    @NotBlank(message = "el texto de la pregunta es requerido")
    private String text;
    
    @NotBlank(message = "El type es requerido")
    private Type type;

    @NotBlank(message = "True or false es requerido")
    private Boolean active;


    
}
