/*
 * @(#) SearchFile.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.search;

import com.jala.model.criteria.CriteriaSearch;
import com.jala.model.criteria.CriteriaSearchMultimedia;
import com.jala.model.search.asset.Asset;
import com.jala.utils.Logs;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * SearchFile.
 *
 * @author Areliez Vargas.
 * @version 0.0.1
 */
public class SearchFile {

    /** It creates to follow up the instruction of the class. */
    private Logger log = Logs.getInstance().getLog();

    /**
     * Searching for commons files, it calls to SearchCommons.
     *
     * @param criteria
     * @return List<Asset> result.
     */
    public List<Asset> search(CriteriaSearch criteria) {
        log.info("Searching for Commons");
        SearchCommon searchCommon = new SearchCommon(criteria);
        return searchCommon.search();
    }

    /**
     * Searching for special files, like video and audio.
     * @param criteria criteria of Multimedia of searching.
     * @param isSearchVideo set if the searching is SearchVideo or Audio.
     * @return List<Asset> result.
     */
    public List<Asset> search(CriteriaSearchMultimedia criteria, boolean isSearchVideo) {
        log.info("Search is initialize");
        if (isSearchVideo) {
            log.info("Searching for Video");
            SearchVideo searchVideo = new SearchVideo(criteria);
            return searchVideo.search();
        } else {
            log.info("Searching for Audio");
            SearchAudio searchAudio = new SearchAudio(criteria);
            return searchAudio.search();
        }
    }
}
