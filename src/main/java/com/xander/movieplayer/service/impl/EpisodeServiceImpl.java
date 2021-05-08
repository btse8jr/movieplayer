package com.xander.movieplayer.service.impl;

import com.xander.movieplayer.dao.EpisodeRepository;
import com.xander.movieplayer.entity.Episode;
import com.xander.movieplayer.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.xander.movieplayer.util.CheckUtil.*;

import java.util.List;

/**
 * Created by Xander on 2018-08-22.
 */
@Service
public class EpisodeServiceImpl implements EpisodeService {
    @Autowired
    private EpisodeRepository episodeRepository;

    @Override
    public Episode findByEpisodeId(Long episodeId) {
        Episode episode=episodeRepository.findByEpisodeId(episodeId);
        check(episode!=null,"片源不存在");
        return episode;
    }

    @Override
    public Episode findByFilmIdAndAndEpisodeNumber(Long filmId, int episodeNumber) {
        Episode episode=episodeRepository.findByFilmIdAndAndEpisodeNumber(filmId,episodeNumber);
        check(episode!=null,"片源不存在");
        return episode;
    }

    @Override
    public List<Episode> findByFilmIdOrderByEpisodeNumber(Long filmId) {
        return episodeRepository.findByFilmIdOrderByEpisodeNumber(filmId);
    }

    @Override
    public int countByFilmId(Long filmId) {
        return episodeRepository.countByFilmId(filmId);
    }

    @Override
    public Episode save(Episode episode) {
        return episodeRepository.save(episode);
    }
}
