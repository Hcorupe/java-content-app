package com.hcorupe.contentcalender.repo;

import com.hcorupe.contentcalender.model.Content;
import com.hcorupe.contentcalender.model.Status;
import com.hcorupe.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepo {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepo(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content>  findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

//    public void create(Content content){
//        contentList.add(content);
//    }
//
//    public void update(Content content){
//
//    }
    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        Content c = new Content(
                1,
                "First Post title",
                "First Post desc",
                Status.IDEA,
                Type.ARTICAL,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(c);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
