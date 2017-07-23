package com.testtask.conference.dao;
import org.springframework.data.repository.CrudRepository;
import com.testtask.conference.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
}
