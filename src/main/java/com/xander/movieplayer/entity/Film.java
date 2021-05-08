package com.xander.movieplayer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Xander on 2018-08-12.
 */
@Entity
@Table(name = "film", schema = "movieplayer")
@JsonIgnoreProperties({"handler", "javassistProxyFactory"})
public class Film {
    private long filmId;
    private String filmName;
    private String director;
    private String screenwriter;
    private String actor;
    private Catlog catlog;
    private String cover;
    private Integer length;
    private Date releaseDate;
    private String location;
    private String status;
    private Double doubanStar;
    private Integer vip;
    private Set<Type> types;
    private Set<Episode> episodes;
    private Date gmtCreate;
    private Date gmtModified;

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "film_name")
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Basic
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "screenwriter")
    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    @Basic
    @Column(name = "actor")
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @ManyToOne
    @JoinColumn(name = "catlog_id")
    public Catlog getCatlog() {
        return catlog;
    }

    public void setCatlog(Catlog catlog) {
        this.catlog = catlog;
    }

    @Basic
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "length")
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Basic
    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "douban_star")
    public Double getDoubanStar() {
        return doubanStar;
    }

    public void setDoubanStar(Double doubanStar) {
        this.doubanStar = doubanStar;
    }

    @Basic
    @Column(name = "vip")
    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_type", joinColumns = { @JoinColumn(name = "film_id") }, inverseJoinColumns = {
            @JoinColumn(name = "type_id") })
    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @Basic
    @Column(name = "gmt_create")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
