package org.lessons.best_of_the_year.controller;

import java.util.ArrayList;

import org.lessons.best_of_the_year.classes.Movie;
import org.lessons.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class homeController {

    private ArrayList<Movie> getBestMovies() {
        ArrayList<Movie> bestMovies = new ArrayList<>();
        Movie signoreDegliAnelli = new Movie(1, "Il signore degli anelli");
        Movie ilPadrino = new Movie(2, "Il padrino");
        Movie casablanca = new Movie(3, "Casablanca");

        bestMovies.add(signoreDegliAnelli);
        bestMovies.add(ilPadrino);
        bestMovies.add(casablanca);
        return bestMovies;
    }

    private ArrayList<Song> getBestSongs() {
        ArrayList<Song> bestSongs = new ArrayList<>();
        Song allStars = new Song(1, "All Stars");
        Song song2 = new Song(2, "Song 2");
        Song dragonballGt = new Song(3, "Dragonball GT");

        bestSongs.add(allStars);
        bestSongs.add(song2);
        bestSongs.add(dragonballGt);

        return bestSongs;
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
    public String movie(@RequestParam int id, Model model) {
        model.addAttribute("name", "Andrea");
        return "movieCard";
    }

    @GetMapping("/songs/{id}")
    public String song(@RequestParam int id, Model model) {
        model.addAttribute("name", "Andrea");
        return "songCard";
    }

}
