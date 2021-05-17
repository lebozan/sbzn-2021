package ftn.sbzn.PoEhelperbackend.controller;

import ftn.sbzn.PoEhelperbackend.dto.FirstEntryDTO;
import ftn.sbzn.PoEhelperbackend.model.Build;
import ftn.sbzn.PoEhelperbackend.model.SkillGem;
import ftn.sbzn.PoEhelperbackend.model.Tag;
import ftn.sbzn.PoEhelperbackend.service.SkillGemService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/input")
public class UserInputController {

    @Autowired
    public SkillGemService skillGemService;

    @Autowired
    private KieContainer kieContainer;



    @PostMapping(value = "/firstEntry")
    public ResponseEntity<?> firstEntry(@RequestBody FirstEntryDTO firstEntryDTO) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        try {
            Build newBuild = new Build();
            for (String gem : firstEntryDTO.getSkillSetup()) {
                Optional<SkillGem> skillGem = skillGemService.getByName(gem);
                SkillGem sg = skillGem.orElseThrow();
                if (sg.getClassId().equals("Active Skill Gem")) {
                    newBuild.getMainSkills().add(sg.getName());
                }

                for (String tag : sg.getGemTags()) {
                    Tag t = new Tag(tag);

                    System.out.println(t);
                    kieSession.insert(t);

                }

            }
            kieSession.insert(newBuild);

//            kieSession.fireAllRules();

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
