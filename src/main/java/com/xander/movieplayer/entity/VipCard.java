package com.xander.movieplayer.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Xander on 2018-08-12.
 */
@Entity
@Table(name = "vip_card", schema = "movieplayer", catalog = "")
public class VipCard {
    private long vipCardId;
    private String vipCardNumber;
    private Integer use;

    @Id
    @Column(name = "vip_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getVipCardId() {
        return vipCardId;
    }

    public void setVipCardId(long vipCardId) {
        this.vipCardId = vipCardId;
    }

    @Basic
    @Column(name = "vip_card_number")
    public String getVipCardNumber() {
        return vipCardNumber;
    }

    public void setVipCardNumber(String vipCardNumber) {
        this.vipCardNumber = vipCardNumber;
    }

    @Basic
    @Column(name = "use")
    public Integer getUse() {
        return use;
    }

    public void setUse(Integer use) {
        this.use = use;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VipCard that = (VipCard) o;
        return vipCardId == that.vipCardId &&
                Objects.equals(vipCardNumber, that.vipCardNumber) &&
                Objects.equals(use, that.use);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vipCardId, vipCardNumber, use);
    }
}
