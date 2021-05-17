package ftn.sbzn.PoEhelperbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Build {

    private WeaponType weaponType;
    private List<String> mainSkills;
    private String damageType;

    public Build() {
        this.mainSkills = new ArrayList<>();
    }
}
