package ftn.sbzn.PoEhelperbackend.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SkillGemDataDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("class id")
    private String classId;
    @JsonProperty("gem tags")
    private String gemTags;

    public SkillGemDataDTO(String name, String classId, String gemTags) {
        this.name = name;
        this.classId = classId;
        this.gemTags = gemTags;
    }

    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    @JsonSetter("class id")
    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGemTags() {
        return gemTags;
    }

    @JsonSetter("gem tags")
    public void setGemTags(String gemTags) {
        this.gemTags = gemTags;
    }
}
