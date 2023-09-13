package com.app.test.app.services.interfaces;

import com.app.test.app.entities.Film;
import com.app.test.dto.FilmRequest;

import java.util.List;

public interface MovieService {
    public Film findById(Long id);
    public Film Save(FilmRequest film);
    public Film Update(Long id,FilmRequest film);
    public Film Delete(Long id);
    public List<Film> list();
}
