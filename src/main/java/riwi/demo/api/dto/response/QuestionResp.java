package riwi.demo.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import riwi.demo.utils.enums.Type;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResp {
    
    private String text;
    private Type type;
    private Boolean active;
    private String survey;
    private List<String> optionQuestion;
}
