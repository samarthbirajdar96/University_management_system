package com.geekster.University.Event.Repo;

import com.geekster.University.Event.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoStudent extends CrudRepository<Student,Integer> {
}
