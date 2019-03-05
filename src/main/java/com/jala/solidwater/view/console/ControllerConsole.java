/*
 * @(#)CriteriaSearch.java
 *
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.solidwater.view.console;

import com.jala.search.models.Asset;

import java.util.List;

/**
 * ControllerConsole class will manage the ModelConsole, ViewConsole and InputParameter
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ControllerConsole {

    /**
     * Criteria for show the result of find
     */
    private ViewConsole viewConsole;

    /**
     * Criteria for search of Asset
     */
    private ModelConsole modelConsole;

    /**
     * Criteria for validate the input parameter
     */
    private InputParameter inputParameter;

    /**
     * This method is the constructor of ControllerConsole to create an instance
     * @param parameters are data to find Asset
     */
    public ControllerConsole(String[] parameters) {
        viewConsole = new ViewConsole();
        modelConsole = new ModelConsole();
        inputParameter = new InputParameter();
        searchAsset(parameters);
    }
    private void searchAsset(String[] parameters) {

        if (inputParameter.validateCommands(parameters)) {
            List<Asset> assets = modelConsole.getSearch(parameters);
           // viewConsole.showAssets(assets);
        } else {
            viewConsole.errorPrint(inputParameter.notValidCommands);
        }
    }
}
