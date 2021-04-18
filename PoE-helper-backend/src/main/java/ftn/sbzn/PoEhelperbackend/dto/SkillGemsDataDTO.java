package ftn.sbzn.PoEhelperbackend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkillGemsDataDTO {
    @JsonProperty("limits")
    private Object limits;

    @JsonProperty("cargoquery")
    private List<SkillGemDataWrapper> allGemData;

}
