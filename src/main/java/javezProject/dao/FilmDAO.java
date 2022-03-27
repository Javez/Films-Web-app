package javezProject.dao;

import javezProject.model.Films;

import java.util.List;

public interface FilmDAO {
    List<Films> allFilms(int page);
    void add(Films films);
    void delete(Films films);
    void edit(Films films);
    void saveOrUpdate(Films newFilm, int oldFilmId);
    Films getById(int id);

    int filmsCount();

    boolean checkTitle(String title);
}
