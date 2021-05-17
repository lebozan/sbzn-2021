package ftn.sbzn.PoEhelperbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/equipment")
public class EquipmentController {

    @GetMapping(value = "/weapons")
    public ResponseEntity<?> getWeaponTypes() {


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/armour")
    public ResponseEntity<?> getArmourTypes() {


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
