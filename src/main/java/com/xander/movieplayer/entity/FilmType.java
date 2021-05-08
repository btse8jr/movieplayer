package com.xander.movieplayer.entity;

import javax.persistence.*;

/**
 * Created by Xander on 2018-08-20.
 */
@Entity
@Table(name = "film_type", schema = "movieplayer")
public class FilmType {
    private Long filmTypeId;

    private Film film;

    private Type type;

    @Id
    @Column(name = "film_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getFilmTypeId() {
        return filmTypeId;
    }

    public void setFilmTypeId(Long filmTypeId) {
        this.filmTypeId = filmTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
