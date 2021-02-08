package pl.javastart.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieControler {

    //kontroler który będzie odpowiadał na zapytania
    private MovieRepository movieRepository;

    public MovieControler(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Category category) {

//        Dodaj możliwość filtrowania listy filmów po kategorii
        List<Movie> movieList;
        if(category != null) {
            movieList = movieRepository.findByCategory(category);

        }else{
            //Filmy powinny być wyświetlane w formie listy zawierającej tytuły i kategorie
            movieList = movieRepository.findAll();
        }

        model.addAttribute("movieList", movieList);

        return "home";
    }

    //Naciśnięcie elementu listy powinno wyświetlać stronę zawierającą jego tytuł, datę premiery oraz opis
    @GetMapping("/film/{id}")
    public String showMovie(@PathVariable Long id, Model model) {

        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {

            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);
            return "movie";
        } else {
            return "redirect:/";
        }
    }
}
