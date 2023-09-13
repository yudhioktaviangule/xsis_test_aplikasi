package com.app.test.app.repositories;

import com.app.test.app.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Film,Long> {
}
