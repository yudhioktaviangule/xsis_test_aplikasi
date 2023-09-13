package com.app.test.www.controllers;

import com.app.test.app.entities.Film;
import com.app.test.app.services.interfaces.MovieService;
import com.app.test.dto.FilmRequest;
import com.app.test.dto.Responses;
import com.app.test.util.Messages;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/master/movies")
public class MovieController {
    @Autowired
    MovieService service;
    @GetMapping
    public ResponseEntity<Responses> list(HttpServletRequest httpReq){
        List<Film> data = service.list();
        Responses response = Responses.builder()
                .message(Messages.SUCCESS)
                .data(data)
                .response_code(200)
                .build();
        return new ResponseEntity<Responses>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Responses> show(@PathVariable("id") Long id){
        Film data = service.findById(id);
        Responses response = Responses.builder()
                .message(Messages.SUCCESS)
                .data(data)
                .response_code(200)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Responses> save(@RequestBody FilmRequest request){

        Film data = service.Save(request);
        Responses response = Responses.builder()
                .message(Messages.SUCCESS)
                .data(data)
                .response_code(200)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responses> update(@PathVariable("id") Long id, @RequestBody  FilmRequest request){
        Film data = service.Update(id,request);
        Responses response = Responses.builder()
                .message(Messages.SUCCESS)
                .data(data)
                .response_code(200)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Responses> delete(@PathVariable("id") Long id){
        Film data = service.Delete(id);
        Responses response = Responses.builder()
                .message(Messages.SUCCESS)
                .data(data)
                .response_code(200)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
