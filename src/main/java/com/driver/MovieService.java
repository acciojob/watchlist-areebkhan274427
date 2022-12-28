package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovieService(Movie movie){
        String result=movieRepository.addMovieToDb(movie);
        return result;
    }

    public String addDirectorService(Director director){
        String result=movieRepository.addDirectorToDb(director);
        return result;
    }

    public String addMovieDirectorPairService(String directorName,String movieName){
        String result=movieRepository.addMovieDirectorPairToDb(directorName,movieName);
        return result;
    }

    public Movie getMovieByNameService(String name){
        Movie movie=movieRepository.getMovieFromDb(name);
        return movie;
    }

    public Director getDirectorByNameService(String name){
        Director director=movieRepository.getDirectorFromDb(name);
        return director;
    }

    public List<String> getMoviesByDirectorNameService(String name){
        return movieRepository.getMoviesByDirectorNameFromDb(name);
    }

    public List<String> findAllMoviesService(){
        return movieRepository.findAllMoviesFromDb();
    }

    public String deleteDirectorByNameService(String name){
        return movieRepository.deleteDirectorByNameFromDb(name);
    }

    public String deleteAllDirectorsService(){
        return movieRepository.deleteAllDirectorsFromDb();
    }


}
