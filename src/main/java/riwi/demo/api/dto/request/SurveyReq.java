package riwi.demo.api.dto.request;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyReq {
    
    @NotBlank(message = "el titulo es requerido")
    private String title;

    @NotBlank(message = "descripción es requerido")
    private String description;

    @NotBlank(message = "Fecha es requerido")
    private Timestamp creationDate;

    @NotBlank(message = "True or false es requerido")
    private Boolean active;

    @NotBlank(message = "Id creator es requerido")
    private Long creator;

}
