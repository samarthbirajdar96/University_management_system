package com.geekster.University.Event.Controller;

import com.geekster.University.Event.Model.Department;
import com.geekster.University.Event.Model.Event;
import com.geekster.University.Event.Model.Student;
import com.geekster.University.Event.Service.EventService;
import com.geekster.University.Event.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class ApiController {

    @Autowired
    StudentService studentService;


    @Autowired
    EventService eventService;

    @PostMapping("students")
    public String addstudents(@RequestBody @Valid List<Student> student){
        return studentService.addstudents(student);
    }

    @GetMapping("students")
    public List<Student> getallstudents(){
        return studentService.getallstudents();
    }

    @DeleteMapping("student/id/{id}")
    public String removestudent(@PathVariable Integer id){
        return studentService.removestudent(id);
    }

    @GetMapping("student/id/{id}")
    public Student getstudentbyid(@PathVariable Integer id){
        return studentService.getstudentbyid(id);
    }

    @PutMapping("student/id/{id}/department")
    public String updatestudent(@PathVariable Integer id, @RequestParam Department department){
        return studentService.updatestudent(id,department);
    }

    //events

    @PostMapping("events")
    public String addevents(@RequestBody  List<Event> event){
        return eventService.addevents(event);
    }

    @GetMapping("events/date/{date}")
    public List<Event> getallevents(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        return eventService.getallevents(date);
    }

    @DeleteMapping("event/id/{id}")
    public String removeevent(@PathVariable Integer id){
        return eventService.removeevent(id);
    }

    @PutMapping("event/id/{id}/name")
    public String updateevent(@PathVariable Integer id, @RequestParam String name){
        return eventService.updateevent(id,name);
    }


}
