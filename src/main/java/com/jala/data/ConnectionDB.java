/**
 * @(#)ConnectionDB.java Copyright (c) 2019 Jala Foundation.
2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
All rights reserved.
 *
 * This software is the confidential and proprietary information of
Jala Foundation, ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Jala Foundation.
 */
package com.jala.data;

/**
 * @Version
 * @author by Cristian Lujan
 *
 */
public class ConnectionDB {

    public static ConnectionDB instance = null;

    /**
     * Constructor
     */
    private ConnectionDB(){
    }

    /**
     *
     */
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }
}
