package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.VipCard;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Xander on 2018-08-14.
 */
public interface VipCardRepository extends CrudRepository<VipCard,Long> {
    VipCard findByVipCardId(Long vipCardId);

    VipCard findByVipCardNumber(String vipCardNumber);

    @Transactional
    int deleteByVipCardId(Long vipCardId);
}
