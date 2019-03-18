/**
 * @(#)SearchFile.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;

import com.jala.utils.Logs;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * SearchFile class.
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class SearchFile {
    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();
    public List<Asset> search(CriteriaSearch criteria) {
        SearchCommon searchCommon = new SearchCommon(criteria);
        return searchCommon.search();
    }
    public List<Asset> search(CriteriaSearchMultimedia criteria, boolean isSearchVideo) {
        if (isSearchVideo) {
            SearchVideo searchVideo = new SearchVideo(criteria);
            return searchVideo.search();
        } else {
            SearchAudio searchAudio = new SearchAudio(criteria);
            return searchAudio.search();
        }
    }
}
