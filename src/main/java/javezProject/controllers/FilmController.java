package javezProject.controllers;
import javezProject.model.Films;
import javezProject.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FilmController {

    private int page;

    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allFilms(@RequestParam(defaultValue = "1") int page) {
        List<Films> films = filmService.allFilms(page);
        int filmsCount = filmService.filmsCount();
        int pagesCount = (filmsCount + 9)/10;

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("films");
        modelAndView.addObject("page", page);
        modelAndView.addObject("filmsList", films);
        modelAndView.addObject("filmsCount", filmsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;
        return modelAndView;
    }
/*    TTTTTT     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        Films film = new Films();
        modelAndView.setViewName("editPage");
        modelAndView.addObject(film);
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Films film = filmService.getById(id);
        ModelAndView view = new ModelAndView();
        view.addObject("film", film);
        view.setViewName("editPage");
        return view;
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Films film) {
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/");
        filmService.saveOrUpdate(film, film.getId());
        return model;
    }
/* TTTTTTTTT */
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        int filmsCount = filmService.filmsCount();
        int page = ((filmsCount - 1) % 10 == 0 && filmsCount > 10 && this.page == (filmsCount + 9)/10) ?
                this.page - 1 : this.page;
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        Films films = filmService.getById(id);
        filmService.delete(films);
        return modelAndView;
    }
}
