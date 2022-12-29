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

        if(movieDb.containsKey(movieName) && directorDb.containsKey(directorName)) {
            if (movieDirectorPair.containsKey(directorName)) {
                movieDirectorPair.get(directorName).add(movieName);
            } else {
                List<String> result = new ArrayList<>();
                result.add(movieName);
                movieDirectorPair.put(directorName, result);
            }
        }

            return "success";

    }

    public Movie getMovieFromDb(String name){
        //System.out.println(movieDb.size());
        return movieDb.get(name);
    }

    public Director getDirectorFromDb(String name){
        return directorDb.get(name);
    }

    public List<String> getMoviesByDirectorNameFromDb(String name){

//        return movieDirectorPair.getOrDefault(name,null);
        List<String> movieNames=new ArrayList<>();
        if(movieDirectorPair.containsKey(name)){

            movieNames=(movieDirectorPair.get(name));
        }
        return movieNames;
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


//
//        for(String s:directorDb.keySet()) {
//            if (s.equals(name)) {
//
//                List<String> list=movieDirectorPair.getOrDefault(s,null);
//                for(String m:list)
//                {
//                    //if(movieDb.get(m).getName().equals(m))
//                      movieDb.remove(m);
//                }
//
//                directorDb.remove(name);
//                movieDirectorPair.remove(name);
//            }
//        }


            if(directorDb.containsKey(name)) {

                if(movieDirectorPair.containsKey(name)) {
                    List<String> movie=movieDirectorPair.get(name);
                    for(String m:movie) {
                        movieDb.remove(m);
                    }
                    movieDirectorPair.remove(name);
                }
                directorDb.remove(name);
                return "success";
            }
            return null;

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

//        for(String s:directorDb.keySet()) {
//
//
//                List<String> list=movieDirectorPair.getOrDefault(s,null);
//                for(String m:list)
//                {
//                    movieDb.remove(m);
//                }
//
//            }
//        movieDirectorPair.clear();
//        directorDb.clear();


//        for(String d:directorDb.keySet()){
//            if(movieDirectorPair.containsKey(d)){
//                List<String> list=movieDirectorPair.get(d);
//                for(String s:list){
//                    movieDb.remove(s);
//                }
//                movieDirectorPair.remove(d);
//            }
//            directorDb.remove(d);
//        }
        List<String> list=new ArrayList<>();

        for(String s:movieDirectorPair.keySet()){
            for(String p:movieDirectorPair.get(s)){
                list.add(p);
            }
        }
        for(String s:list){
            movieDb.remove(s);
        }
        directorDb.clear();
        movieDirectorPair.clear();
        return "success";
    }








}
