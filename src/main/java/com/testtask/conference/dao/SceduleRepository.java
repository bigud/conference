package com.testtask.conference.dao;

import com.testtask.conference.model.Lecture;
import com.testtask.conference.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SceduleRepository extends CrudRepository<Schedule, Integer> {
}