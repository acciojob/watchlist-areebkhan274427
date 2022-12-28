package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb=new HashMap<>();
    HashMap<String,Director> directorDb=new HashMap<>();
    HashMap<String,List<String>> movieDirectorPair=new HashMap<>();



    public String addMovieToDb(Movie movie){
        String name=movie.getName();
        movieDb.put(name,movie);

        return "success";
    }

    public String addDirectorToDb(Director director){
        String name=director.getName();
        directorDb.put(name,director);
        return "success";
    }

    public String addMovieDirectorPairToDb(String directorName,String movieName){

        if(movieDirectorPair.containsKey(directorName)){
            movieDirectorPair.get(directorName).add(movieName);
        }
        else {
            List<String> result=new ArrayList<>();
            result.add(movieName);
            movieDirectorPair.put(directorName,result);
        }

        return "success";
    }

    public Movie getMovieFromDb(String name){
        //System.out.println(movieDb.size());
        return movieDb.getOrDefault(name,null);
    }

    public Director getDirectorFromDb(String name){
        return directorDb.getOrDefault(name,null);
    }

    public List<String> getMoviesByDirectorNameFromDb(String name){

        return movieDirectorPair.getOrDefault(name,null);
    }

    public List<String> findAllMoviesFromDb(){
        List<String> result=new ArrayList<>();
        for(String name:movieDb.keySet()){
            result.add(name);
        }
        return result;
    }

    public String deleteDirectorByNameFromDb(String name){
//        for(String s:movieDirectorPair.keySet()) {
//            if (s.equals(name)) {
//
//                List<String> list=movieDirectorPair.get(s);
//                for(String m:list)
//                {
//                    movieDb.remove(m);
//                }
//
//                directorDb.remove(name);
//                movieDirectorPair.remove(name);
//            }

        for(String s:directorDb.keySet()) {
            if (s.equals(name)) {

                List<String> list=movieDirectorPair.get(s);
                for(String m:list)
                {
                    movieDb.remove(m);
                }

                directorDb.remove(name);
                movieDirectorPair.remove(name);
            }
        }


        return "success";
    }

    public String deleteAllDirectorsFromDb(){
//        for(String s:movieDirectorPair.keySet()) {
//
//
//            List<String> list=movieDirectorPair.get(s);
//            for(String m:list)
//            {
//                movieDb.remove(m);
//            }
//
//        }
        for(String s:directorDb.keySet()) {


                List<String> list=movieDirectorPair.get(s);
                for(String m:list)
                {
                    movieDb.remove(m);
                }


            }
        movieDirectorPair.clear();
        directorDb.clear();
        return "success";
    }








}
