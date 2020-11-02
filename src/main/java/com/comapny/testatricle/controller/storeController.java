package com.comapny.testatricle.controller;

import com.comapny.testatricle.model.arcticle;
import com.comapny.testatricle.repository.articleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
public class storeController {

    @Autowired
    private articleRepo repo;


   // fetching all the data
    @GetMapping("/getArt")
    public List<arcticle> getArticle(){
        return repo.findAll();
    }


    // fetching the total number of records prsent in the database;
    @GetMapping("/getArtCount")
    public String getArtCount(){
        ArrayList<arcticle> list = new ArrayList<>();
        list.addAll(repo.findAll());
        return  "Total number of the articles downloaded are: "+list.size();

    }

    // fetching the articles with source name
    @GetMapping("/getSource/{source}")
    public  Object getSourceName( @PathVariable String source){
        ArrayList<arcticle> list = new ArrayList<>();
        list.addAll(repo.findAll());

        ArrayList<arcticle> list1 = new ArrayList<>();
       list.forEach(name ->{
        if (
        name.getSource().contains(source))
            list1.add(name);});

         return  list1;

    }

    // fetching the articles with author name
    @GetMapping("/author/{author}")
    public  Object getbyAurthorName( @PathVariable String author){
        ArrayList<arcticle> list = new ArrayList<>();
        list.addAll(repo.findAll());

        ArrayList<arcticle> list1 = new ArrayList<>();
        list.forEach(name ->{
            if (name.getAuthor().equals(author)){
                list1.add(name);
            }

                });

        return  list1;

    }


    // fetchigh the list of the source
    @GetMapping("/totalArt/{sourceName}")
    public  String getListSource( @PathVariable String sourceName){
        ArrayList<arcticle> list = new ArrayList<>();
        list.addAll(repo.findAll());

        ArrayList<arcticle> list1 = new ArrayList<>();
        list.forEach(name ->{
            if (name.getSource().contains(sourceName)){
                list1.add(name);

            }
                });

        return  "The no of the article in the database with the source name + "+sourceName+" :"+list1.size();

    }

 // fetching the unique author list
    @GetMapping("/listofaurthor")
    public  String getListofAurthor(){
        ArrayList<arcticle> list = new ArrayList<>();
        list.addAll(repo.findAll());

        HashSet<String> list1 = new HashSet<>();
        list.forEach(name -> {
            if(name.getAuthor()!=null){
                list1.add(name.getAuthor());
            }
        });

        return  "List of aurthor: "+list1;

    }




}
