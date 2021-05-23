package com.xander.movieplayer.vo;

/**
 * Created by Xander on 2018-08-29.
 */
public class FilmVO {
    private Long filmId;
    private String filmName;
    private String cover;
    private Double doubanStar;
    private String actor;
    private String status;

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Double getDoubanStar() {
        return doubanStar;
    }

    public void setDoubanStar(Double doubanStar) {
        this.doubanStar = doubanStar;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
