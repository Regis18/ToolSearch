/*
 * @(#) SearchVideo.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;


import com.jala.utils.AssetFactory;
import com.jala.utils.Logs;
import net.bramp.ffmpeg.FFprobe;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SearchVideo implements ISearchable{

    private Logger log = Logs.getInstance().getLog();

    @Override
    public List<Asset> search(CriteriaSearch criteria) {

        log.info("Searching on " + criteria.getPath());
        List<Asset> result = new ArrayList<>();
        File folder = new File(criteria.getPath());
        if (folder.exists()) {
            List<File> files = new ArrayList<File>();
            SearchFile.GetAllFiles(folder, files);
            try {
                for (int i = 0; i < files.size(); i++) {
                    File file = files.get(i);

                    Asset asset = (Asset) AssetFactory.getAsset(file, criteria.getPath(), criteria.getFileName(),
                            criteria.getExtension(), criteria.getHidden(), criteria.getOwner(), criteria.getSize(), criteria.getReadonly(),
                            criteria.getCreationDateFrom(), criteria.getModificationDateFrom(), criteria.getLastDateFrom());

                   // String videoCodec = ((AssetVideo) asset).getVideoCodec();
                    //String videoCriteria = criteria.getVideoCodec();
                    String extension = ((AssetVideo)asset).getExtension();
                    String extensionCriteria = criteria.getExtension();

                    boolean addVideoToResults = true;
                    if (!extension.equals("mp4")) {
                        addVideoToResults = false;
                    }
                    if (addVideoToResults) {
                        result.add(asset);
                    }
                }

            } catch (NullPointerException e) {
                log.error("The video values shouldn't be null", e);
            }
        }
        return result;
    }
}
