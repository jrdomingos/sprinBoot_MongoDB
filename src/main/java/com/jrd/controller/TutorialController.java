package com.jrd.controller;


import com.jrd.entity.Tutorial;
import com.jrd.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus
    public ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial) {
        this.tutorialService.create(tutorial);

        return ResponseEntity.status(HttpStatus.CREATED).body(tutorial);
    }

    @CrossOrigin
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findALl() {
        List<Tutorial> result = this.tutorialService.findAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Tutorial findById(@PathVariable(value = "id") Long id) {
        return this.tutorialService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Tutorial update(@PathVariable(value = "id") Long id, @RequestBody Tutorial tutorial) {
        return this.tutorialService.update(id, tutorial);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id, HttpServletResponse response) {
        this.tutorialService.delete(id);

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
