package com.jrd.service;

import com.jrd.entity.Tutorial;

import java.util.List;

public interface TutorialService {
    public Tutorial create(Tutorial tutorial);
    public List<Tutorial> findAll();
    public Tutorial findById(Long id);
    public Tutorial update(Long id, Tutorial tutorial);
    public void delete(Long id);
}
