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
import com.jala.search.models.CriteriaSearch;
import com.jala.search.models.IAsset;

import java.io.File;

/**
 * AssetFactory class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetFactory {
    /**
     * Asset Factory.
     * @param criteria of search.
     * @param file class abstract.
     * @return an asset object.
     */
    public static IAsset GetAsset(CriteriaSearch criteria, File file) {
        if (criteria.getType() == 0) {
            Asset newAsset = new Asset();
            newAsset.loadFile(file);
            return newAsset;
        } else if (criteria.getType() == 1) {
            AssetVideo newAsset = new AssetVideo();
            newAsset.loadFile(file);
            return newAsset;
        } else
            return new Asset();

    }
}
