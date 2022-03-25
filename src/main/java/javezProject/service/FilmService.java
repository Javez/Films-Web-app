package javezProject.service;

import javezProject.model.Films;

import java.util.List;

public interface FilmService {
    List<Films> allFilms(int page);
    void add(Films films);
    void delete(Films films);
    void edit(Films films);
    Films getById(int id);

    int filmsCount();

    boolean checkTitle(String title);
}
