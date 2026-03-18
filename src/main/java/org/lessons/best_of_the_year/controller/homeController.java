package org.lessons.best_of_the_year.controller;

import java.util.ArrayList;

import org.lessons.best_of_the_year.classes.Movie;
import org.lessons.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class homeController {
    Movie signoreDegliAnelli = new Movie(1, "Il signore degli anelli");
    Movie ilPadrino = new Movie(2, "Il padrino");
    Movie casablanca = new Movie(3, "Casablanca");

    Song allStars = new Song(1, "All Stars");
    Song song2 = new Song(2, "Song 2");
    Song dragonballGt = new Song(3, "Dragonball GT");

    private ArrayList<Movie> getBestMovies() {
        ArrayList<Movie> bestMovies = new ArrayList<>();

        bestMovies.add(signoreDegliAnelli);
        bestMovies.add(ilPadrino);
        bestMovies.add(casablanca);
        return bestMovies;
    }

    private ArrayList<Song> getBestSongs() {
        ArrayList<Song> bestSongs = new ArrayList<>();

        bestSongs.add(allStars);
        bestSongs.add(song2);
        bestSongs.add(dragonballGt);

        return bestSongs;
    }

    private Song getSongById(int id) {
        ArrayList<Song> bestSongs = getBestSongs();
        Song selectedSong = new Song();
        // System.out.println(selectedSong);
        for (Song song : bestSongs) {
            if (song.getId() == id) {
                selectedSong.setId(song.getId());
                selectedSong.setTitle(song.getTitle());
                // System.out.println(selectedSong);
            }

        }
        return selectedSong;
    }

    private Movie getMovieById(int id) {
        ArrayList<Movie> bestMovie = getBestMovies();
        Movie selectedMovie = new Movie();
        // System.out.println(selectedMovie);
        for (Movie movie : bestMovie) {
            if (movie.getId() == id) {
                selectedMovie.setId(movie.getId());
                selectedMovie.setTitle(movie.getTitle());
                // System.out.println(selectedMovie);
            }

        }
        return selectedMovie;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Andrea");

        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {

        model.addAttribute("name", "Andrea");
        model.addAttribute("movieList", getBestMovies());

        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("name", "Andrea");
        model.addAttribute("songList", getBestSongs());
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movie(Model model, @PathVariable("id") int idContent) {

        Movie movie = getMovieById(idContent);

        if (movie.getId() == 0) {
            return "err404";
        }

        model.addAttribute("name", "Andrea");
        model.addAttribute("movie", movie);
        return "movieById";
    }

    @GetMapping("/songs/{id}")
    public String song(Model model, @PathVariable("id") int idContent) {

        Song song = getSongById(idContent);

        if (song.getId() == 0) {
            return "err404";
        }

        model.addAttribute("name", "Andrea");
        model.addAttribute("song", song);

        return "songById";
    }

}
