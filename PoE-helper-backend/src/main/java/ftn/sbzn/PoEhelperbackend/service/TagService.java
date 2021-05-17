package ftn.sbzn.PoEhelperbackend.service;

import ftn.sbzn.PoEhelperbackend.model.Tag;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

//    @Autowired
//    private KieContainer kieContainer;

    public Tag insertNewTag(String name) {
        Tag tag = new Tag(name);
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.insert(tag);
//        kieSession.fireAllRules();
        return tag;
    }
}
