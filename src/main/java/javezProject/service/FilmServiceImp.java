package javezProject.service;

import javezProject.dao.FilmDAO;
import javezProject.model.Films;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImp implements FilmService {
    private FilmDAO filmDAO;

    @Autowired
    public void setFilmDAO(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Override
    @Transactional
    public List<Films> allFilms(int page) {
        return filmDAO.allFilms(page);
    }

    @Override
    @Transactional
    public void add(Films films) {
        filmDAO.add(films);
    }

    @Override
    @Transactional
    public void delete(Films films) {
        filmDAO.delete(films);
    }

    @Override
    @Transactional
    public void edit(Films films) {
        filmDAO.edit(films);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Films newFilm, int oldFilmId) {
        filmDAO.saveOrUpdate(newFilm, oldFilmId);
    }

    @Override
    @Transactional
    public Films getById(int id) {
        return filmDAO.getById(id);
    }

    @Override
    @Transactional
    public int filmsCount() {
        return filmDAO.filmsCount();
    }

    @Override
    @Transactional
    public boolean checkTitle(String title) {
        return filmDAO.checkTitle(title);
    }
}
