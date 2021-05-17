package ftn.sbzn.PoEhelperbackend.dto;

import ftn.sbzn.PoEhelperbackend.model.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FirstEntryDTO {

    private List<String> skillSetup;

    private List<String> keystones;

    private WeaponType weaponType;

}
