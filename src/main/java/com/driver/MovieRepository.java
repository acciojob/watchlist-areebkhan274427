package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    List<Movie> movieDb=new ArrayList<>();
    List<Director> directorDb=new ArrayList<>();
    HashMap<String,List<String>> movieDirectorPair=new HashMap<>();



    public String addMovieToDb(Movie movie){

        movieDb.add(movie);

        return "success";
    }

    public String addDirectorToDb(Director director){

        directorDb.add(director);
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
        for(Movie movie:movieDb){
            if(movie.getName().equals(name)){
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorFromDb(String name){
        for(Director director:directorDb){
            if(director.getName().equals(name)){
                return director;
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorNameFromDb(String name){

        return movieDirectorPair.getOrDefault(name,null);
    }

    public List<String> findAllMoviesFromDb(){
        List<String> result=new ArrayList<>();
        for(Movie movie:movieDb){
            result.add(movie.getName());
        }
        return result;
    }

    public String deleteDirectorByNameFromDb(String name){

        List<String> list=movieDirectorPair.get(name);
        movieDirectorPair.remove(name);

        HashSet<String> hs=new HashSet<>();

        for(String s:list){
            hs.add(s);
        }

        for(Movie movie:movieDb){
            if(hs.contains(movie.getName())){
                movieDb.remove(movie);
            }
        }

        for(Director director:directorDb){
            if(director.getName().equals(name)){
                directorDb.remove(director);
            }
        }

//        for(String s:directorDb.keySet()) {
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
//        }


        return "success";
    }

    public String deleteAllDirectorsFromDb(){
        HashSet<String> hs=new HashSet<>();

        for(List<String> list:movieDirectorPair.values()){
            for(String s:list){
                hs.add(s);
            }
        }

        for(Movie movie:movieDb){
            if(hs.contains(movie.getName())){
                movieDb.remove(movie);
            }
        }
        directorDb.clear();
        movieDirectorPair.clear();

//        for(String s:directorDb.keySet()) {
//
//
//                List<String> list=movieDirectorPair.get(s);
//                for(String m:list)
//                {
//                    movieDb.remove(m);
//                }
//
//
//            }
//        movieDirectorPair.clear();
//        directorDb.clear();
        return "success";
    }








}
