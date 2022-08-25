package com.jrd.repository;

import com.jrd.entity.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial,Long> {
    List<Tutorial> findByPublished(boolean published);
}
