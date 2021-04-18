package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "SkillGems")
public class SkillGem {

    @Transient
    public static final String SEQUENCE_NAME = "skill_gems_sequence";

    @Id
    private Long id;
    private String name;
    private String classId;
    private List<String> gemTags;

    public SkillGem(String name, String classId, List<String> tags) {
        this.name = name;
        this.classId = classId;
        this.gemTags = tags;
    }
}
