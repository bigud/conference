package com.testtask.conference.controller;

import com.testtask.conference.dao.LectureRepository;
import com.testtask.conference.dao.SceduleRepository;
import com.testtask.conference.model.Lecture;
import com.testtask.conference.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SceduleRepository sceduleRepository;

    @GetMapping("/schedule")
    public Iterable<Schedule> getVisits() {
        return sceduleRepository.findAll();
    }
}