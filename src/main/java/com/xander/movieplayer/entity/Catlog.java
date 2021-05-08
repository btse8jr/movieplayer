package com.xander.movieplayer.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Xander on 2018-08-12.
 */
@Entity
@Table(name = "catlog", schema = "movieplayer", catalog = "")
public class Catlog {
    private long catlogId;
    private String catlogName;
    private Integer vip;

    @Id
    @Column(name = "catlog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCatlogId() {
        return catlogId;
    }

    public void setCatlogId(long catlogId) {
        this.catlogId = catlogId;
    }

    @Basic
    @Column(name = "catlog_name")
    public String getCatlogName() {
        return catlogName;
    }

    public void setCatlogName(String catlogName) {
        this.catlogName = catlogName;
    }

    @Basic
    @Column(name = "vip")
    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catlog that = (Catlog) o;
        return catlogId == that.catlogId &&
                Objects.equals(catlogName, that.catlogName) &&
                Objects.equals(vip, that.vip);
    }

    @Override
    public int hashCode() {

        return Objects.hash(catlogId, catlogName, vip);
    }
}
