package com.hcorupe.contentcalender.controller;

import com.hcorupe.contentcalender.model.Content;
import com.hcorupe.contentcalender.repo.ContentCollectionRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentCollectionRepo repo;


    public ContentController(ContentCollectionRepo repo) {
        this.repo = repo;
    }


    //make a request and find all the pieces of content in this sytem
    @GetMapping("")
    public List<Content> findAll(){
        return repo.findAll();
    }

    //Create, read, update, delete,       filtering , sorting

    @GetMapping("/{id}")  //dynamic looking up for ID
    public Content findById(@PathVariable Integer id){
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conent not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repo.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conent not found");
        }
        repo.save(content);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repo.delete(id);
    }



}
