package riwi.demo.api.dto.response;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResp {
    
    private String title;
    private String description;
    private Timestamp creationDate;
    private Boolean active;
    private String creator;
}
