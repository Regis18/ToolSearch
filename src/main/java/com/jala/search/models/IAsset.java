/*
 * @(#) IAsset.java Copyright (c) 2019 Jala Foundation.
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

import java.io.File;

/**
 * IAsset interface.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public interface IAsset {
    /**
     * Method for load the file properties.     *
     * @param file as File type.
     */
    public void loadFile(File file);
}
