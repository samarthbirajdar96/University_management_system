package com.geekster.University.Event.Service;

import com.geekster.University.Event.Model.Event;
import com.geekster.University.Event.Repo.RepoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    RepoEvent repoEvent;


    public String addevents(List<Event> event) {
        repoEvent.saveAll(event);
        return "added";
    }

    public List<Event> getallevents(LocalDate date) {
        return  repoEvent.findByEventDate(date);
    }




    public String removeevent(Integer id) {
        repoEvent.deleteById(id);
        return "deleted";
    }

    public String updateevent(Integer id, String name) {
        Event event=repoEvent.findById(id).orElse(null);
        if(event!=null){
            event.setEventName(name);
            repoEvent.save(event);
            return "updated";
        }else{
            return  "id not found";
        }

    }

}
