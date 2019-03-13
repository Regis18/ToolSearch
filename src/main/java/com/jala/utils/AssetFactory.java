/*
 * @(#) AssetFactory.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.utils;

import com.jala.search.models.Asset;
import com.jala.search.models.AssetVideo;
import com.jala.search.models.AssetCommon;
import com.jala.search.models.AssetText;
import com.jala.search.models.CriteriaSearch;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

/**
 * AssetFactory class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {

    /**
     * Asset Factory.
     *
     * @param criteria criteria of the search.
     * @return the file to convert to asset.
     */
    public static Asset getAsset(CriteriaSearch criteria) {
        if (criteria.getType() == "Common") {
            return new Asset();
        } else if (criteria.getType() == "Video") {
            return new AssetVideo();
        } else {
            return new Asset();
        }
    }
}
