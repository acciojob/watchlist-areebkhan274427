package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String result=movieService.addMovieService(movie);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String result=movieService.addDirectorService(director);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String directorName,@RequestParam String movieName){
        String result=movieService.addMovieDirectorPairService(directorName,movieName);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie movie=movieService.getMovieByNameService(name);
        if(movie!=null)
        {
            return new ResponseEntity<>(movie,HttpStatus.FOUND);
        }
        else return new ResponseEntity<>(movie,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        Director director=movieService.getDirectorByNameService(name);
        if(director!=null)
        {
            return new ResponseEntity<>(director,HttpStatus.FOUND);
        }
        else return new ResponseEntity<>(director,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorNameService(name),HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMoviesService(),HttpStatus.FOUND);
    }


    @DeleteMapping("movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        return new ResponseEntity<>(movieService.deleteDirectorByNameService(name),HttpStatus.GONE);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectorsService(),HttpStatus.GONE);
    }














}
