package com.jrd.service;

import com.jrd.entity.Tutorial;
import com.jrd.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TutorialServiceImpl implements TutorialService{

    @Autowired
    private TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Tutorial create(Tutorial tutorial) {
        return this.tutorialRepository.save(tutorial);
    }

    @Override
    public List<Tutorial> findAll() {
        return this.tutorialRepository.findAll();
    }

    @Override
    public  Tutorial findById(Long id) {
        return this.tutorialRepository.findById(id).get();
    }

    @Override
    public Tutorial update(Long id, Tutorial tutorial) {
        Tutorial tutorialExists = this.tutorialRepository.findById(id).get();

        if(tutorialExists != null) {
         //   tutorial.setId(tutorialExists.getId());
            this.tutorialRepository.save(tutorial);
        }

        return tutorial;
    }

    @Override
    public void delete(Long id) {
        Tutorial tutorial = this.tutorialRepository.findById(id).get();

        if(tutorial != null) {
            this.tutorialRepository.delete(tutorial);
        }
    }
}
