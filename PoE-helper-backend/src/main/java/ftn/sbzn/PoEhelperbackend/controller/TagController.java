package ftn.sbzn.PoEhelperbackend.controller;

import ftn.sbzn.PoEhelperbackend.model.Tag;
import ftn.sbzn.PoEhelperbackend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/tags")
public class TagController {


    @Autowired
    public TagService tagService;

    @PostMapping(value = "/{name}")
    public ResponseEntity<Tag> insertTag(@PathVariable String name) {
        Tag tag = tagService.insertNewTag(name);

        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

}
