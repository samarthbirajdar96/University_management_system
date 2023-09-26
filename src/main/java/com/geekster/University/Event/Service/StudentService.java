package com.geekster.University.Event.Service;

import com.geekster.University.Event.Model.Department;
import com.geekster.University.Event.Model.Event;
import com.geekster.University.Event.Model.Student;
import com.geekster.University.Event.Repo.RepoStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    RepoStudent repoStudent;

    public String addstudents(List<Student> student) {
        repoStudent.saveAll(student);
        return "added";
    }

    public List<Student> getallstudents() {
        return (List<Student>) repoStudent.findAll();
    }

    public String removestudent(Integer id) {
         repoStudent.deleteById(id);
         return "deleted";
    }

    public Student getstudentbyid(Integer id) {
       return repoStudent.findById(id).get();

    }

    public String updatestudent(Integer id, Department department) {
            Student student= repoStudent.findById(id).orElse(null);
            if (student!= null) {
                student.setDepartment(department);
                repoStudent.save(student);
                return "updated";
            } else {
                return "id not found";
            }

        }

}

