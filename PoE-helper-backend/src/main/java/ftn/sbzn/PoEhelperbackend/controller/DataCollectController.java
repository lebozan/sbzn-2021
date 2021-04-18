package ftn.sbzn.PoEhelperbackend.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ftn.sbzn.PoEhelperbackend.dto.SkillGemDataWrapper;
import ftn.sbzn.PoEhelperbackend.dto.SkillGemsDataDTO;
import ftn.sbzn.PoEhelperbackend.model.SkillGem;
import ftn.sbzn.PoEhelperbackend.service.SequenceGeneratorService;
import ftn.sbzn.PoEhelperbackend.service.SkillGemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/api/data")
public class DataCollectController {

    @Autowired
    SkillGemService skillGemService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    @GetMapping("/skill-gems")
    public ResponseEntity<?> getSkillGemData() {
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://pathofexile.fandom.com/api.php?action=cargoquery&tables=items,skill_gems&join_on=items._pageID=skill_gems._pageID&fields=items.name,items.class_id,skill_gems.gem_tags&where=items.frame_type=%22gem%22&limit=max&format=json"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            SkillGemsDataDTO data = mapper.readerFor(SkillGemsDataDTO.class).readValue(response.body());
            for (SkillGemDataWrapper gemWrapper: data.getAllGemData()) {
                String[] tags = gemWrapper.getGemDataDTO().getGemTags().split(",");
                SkillGem gem = new SkillGem(
                        sequenceGeneratorService.generateSequence(SkillGem.SEQUENCE_NAME),
                        gemWrapper.getGemDataDTO().getName(),
                        gemWrapper.getGemDataDTO().getClassId(),
                        Arrays.asList(tags));
                skillGemService.save(gem);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
