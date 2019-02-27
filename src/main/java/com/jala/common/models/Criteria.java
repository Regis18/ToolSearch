/*
 * @(#) Criteria.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.common.models;

/**
 * The Criteria class .
 * @version 0.0.1
 * @author Luis Guardia
 */
public abstract class Criteria {

    /**
     * Criteria for the absolute path of the file.
     */
    private String pathOrigin;

    /**
     * Criteria for the new file name.
     */
    private String newFileName;

    /**
     * Constructor that sets the absolute path of the file .
     * @param pathOrigin of the file.
     *
     */
    public Criteria(String pathOrigin) {
        this.pathOrigin = pathOrigin;
    }
}
