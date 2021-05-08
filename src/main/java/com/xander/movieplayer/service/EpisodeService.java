package com.xander.movieplayer.service;

import com.xander.movieplayer.entity.Episode;

import java.util.List;

/**
 * Created by Xander on 2018-08-20.
 */
public interface EpisodeService {
    Episode findByEpisodeId(Long episode);

    Episode findByFilmIdAndAndEpisodeNumber(Long filmId,int episodeNumber);

    List<Episode> findByFilmIdOrderByEpisodeNumber(Long filmId);

    int countByFilmId(Long filmId);

    Episode save(Episode episode);
}
