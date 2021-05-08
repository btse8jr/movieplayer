package com.xander.movieplayer.dao;

import com.xander.movieplayer.entity.Episode;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Xander on 2018-08-13.
 */
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    Episode findByEpisodeId(Long episodeId);

    Episode findByFilmIdAndAndEpisodeNumber(Long filmId,int episodeNumber);

    List<Episode> findByFilmIdOrderByEpisodeNumber(Long filmId);

    @Transactional
    Episode deleteByEpisodeId(Long episodeId);

    int countByFilmId(Long filmId);
}
