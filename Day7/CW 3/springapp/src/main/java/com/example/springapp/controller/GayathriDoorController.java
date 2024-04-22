package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.GayathriDoor;
import com.example.springapp.service.GayathriDoorService;

@RestController
public class GayathriDoorController {
    @Autowired
    private GayathriDoorService ser;
    
    @PostMapping("/api/door")
    public ResponseEntity<GayathriDoor> post(@RequestBody GayathriDoor door)
    {
        if(ser.post(door))
        {
            return new ResponseEntity<>(door,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/door")
    public ResponseEntity<List<GayathriDoor>> getAll()
    {
        List<GayathriDoor> li = ser.getAll();
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<List<GayathriDoor>> getbyId(@PathVariable int doorId)
    {
        List<GayathriDoor> li = ser.getbyDoorId(doorId);
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/api/door/accessType/{accessType}")
    public ResponseEntity<List<GayathriDoor>> getbyType(@PathVariable String accessType)
    {
        List<GayathriDoor> li = ser.getbyType(accessType);
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
