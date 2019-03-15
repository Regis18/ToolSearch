/*
 * @(#) AssetCommon.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.model.search.assetFile;

/**
 * AssetCommon class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class AssetCommon extends Asset {
    private boolean isDirectory;

    /**
     * Constructor of AssetCommon class.
     */
    public void AssetCommon() {
        isDirectory = false;
    }

    /**
     * @return isDirectory as boolean value.
     */
    public boolean isDirectory() {
        return isDirectory;
    }

    /**
     * @param directory as boolean value for know if the file is directory.
     */
    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }
}
