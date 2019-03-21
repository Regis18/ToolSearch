/*
 * @(#) MusicActual.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.view.player;

/**
 * Class MusicActual
 * @version 0.0.3
 * @author Luis Guardia
 */
public class MusicActual {

    private int playerMusic;

    /**
     * method that returns the position of the list of the element that is reproducing.
     */
    public int getPlayerMusic() {
        return playerMusic;
    }

    /**
     * method that establishes the position of the list of the element being reproduced.
     */
    public void setPlayerMusic(int playerMusic) {
        this.playerMusic = playerMusic;
    }
}