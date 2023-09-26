package com.geekster.University.Event.Repo;

import com.geekster.University.Event.Model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepoEvent extends CrudRepository<Event,Integer> {


    List<Event> findByEventDate(LocalDate date);
}
