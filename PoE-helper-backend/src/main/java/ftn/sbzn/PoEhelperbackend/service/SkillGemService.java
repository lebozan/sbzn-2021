package ftn.sbzn.PoEhelperbackend.service;

import ftn.sbzn.PoEhelperbackend.model.SkillGem;
import ftn.sbzn.PoEhelperbackend.repository.SkillGemRepository;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillGemService {

//    @Autowired
//    private KieContainer kieContainer;

    @Autowired
    SkillGemRepository skillGemRepository;


    public Optional<SkillGem> getByName(String name) {
        return skillGemRepository.findByName(name);
    }

    public Optional<SkillGem> getById(Long id) {
        return skillGemRepository.findById(id);
    }

    public List<SkillGem> getAll() {
        return skillGemRepository.findAll();
    }

    public SkillGem save(SkillGem skillGem) {
        return  skillGemRepository.save(skillGem);
    }

    public void delete(SkillGem skillGem) {
        skillGemRepository.delete(skillGem);
    }
}
