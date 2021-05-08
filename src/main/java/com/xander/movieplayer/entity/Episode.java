package com.xander.movieplayer.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Xander on 2018-08-12.
 */
@Entity
@Table(name = "episode", schema = "movieplayer", catalog = "")
public class Episode {
    private long episodeId;
    private Long filmId;
    private Integer episodeNumber;
    private String link;

    @Id
    @Column(name = "episode_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(long episodeId) {
        this.episodeId = episodeId;
    }

    @Basic
    @Column(name = "film_id")
    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "episode_number")
    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode that = (Episode) o;
        return episodeId == that.episodeId &&
                Objects.equals(filmId, that.filmId) &&
                Objects.equals(episodeNumber, that.episodeNumber) &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(episodeId, filmId, episodeNumber, link);
    }
}
