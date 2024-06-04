package riwi.demo.utils.messages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ErrorMessages {

    private final String message = "hola";

    public static String idNotFound(String entity){
        //    return "No hay registros en la entidad "+entity+ " con el id suministrado";
            final String message = "No hay registros en la entidad %s con el id suministrado";
            return String.format(message, entity);
        }
}
