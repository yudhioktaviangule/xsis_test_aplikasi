package com.app.test.app.services.implementations;

import com.app.test.app.entities.Film;
import com.app.test.app.repositories.MovieRepository;
import com.app.test.app.services.interfaces.MovieService;
import com.app.test.dto.FilmRequest;
import com.app.test.exceptions.CustomExceptions;
import com.app.test.util.Messages;
import com.app.test.util.ParamRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieServiceImplementation implements MovieService {
    @Autowired private MovieRepository movieRepository;
    @Override
    public Film findById(Long id) {
        Optional<Film> data = movieRepository.findById(id);
        if(data.isEmpty()){
            throw new CustomExceptions("Movie not found",null, HttpStatus.BAD_REQUEST);
        }
        return data.get();
    }

    @Override
    public Film Save( FilmRequest film) {
        log.info(String.format("title=%s,desc= %s",film.getTitle(),film.getDescription()));
        MovieUtil.checkIfRequestEmpty(film);
        Film data = MovieUtil.setFilm(film);
        data = movieRepository.save(data);
        return data;
    }

    @Override
    public Film Update(Long id,FilmRequest film) {
        Film cek = this.findById(id);
        cek.setTitle(film.getTitle() == null ? cek.getTitle() : film.getTitle());
        cek.setDescription(film.getDescription() == null ? cek.getDescription() : film.getDescription());
        cek.setRating(film.getRating() == null ? cek.getRating() : film.getRating());
        cek.setImage(film.getImage() == null ? cek.getImage() : film.getImage());
        movieRepository.save(cek);
        return cek;
    }

    @Override
    public Film Delete(Long id) {
        Film cek = this.findById(id);
        movieRepository.delete(cek);
        return cek;
    }

    @Override
    public List<Film> list() {
        return movieRepository.findAll();
    }

    private static class MovieUtil{
        public static void checkIfRequestEmpty(FilmRequest request){
            ParamRequest.check("title",request.getTitle());
            ParamRequest.check("description",request.getDescription());
            ParamRequest.check("rating",request.getRating());

        }
        public static Film setFilm(FilmRequest request){
            Film film = Film.builder()
                    .title(request.getTitle())
                    .rating(request.getRating())
                    .description(request.getDescription())
                    .image(request.getImage())
                    .id(request.getId()==null?null:request.getId())
                    .build();
            return film;
        }
    }
}
