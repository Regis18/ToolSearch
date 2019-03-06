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

import com.jala.search.models.Asset;
import com.jala.solidwater.view.console.ModelConsole;
import com.jala.solidwater.view.console.InputParameter;
import com.jala.solidwater.view.console.ViewConsole;

import java.util.ArrayList;
import java.util.List;

public class App {

    /**
     *
     * Main method in order to execute the SolidWater app
     * @param args are the input parameters send for console.
     */
    public static void main(String[] args) {

        /* Created a validator instance */
        InputParameter validator = new InputParameter();

        /* Use the method validateCommand for validate the input commands. */
        String [] listTest = {"-p", "D:\\Fundacion-Jala", "-ex", "mp3"};
        validator.validateCommands(listTest);
        ViewConsole viewConsole = new ViewConsole();
        ModelConsole modelConsole = new ModelConsole();
        InputParameter inputParameter = new InputParameter();

        if (inputParameter.validateCommands(listTest)) {
            viewConsole.printMessage(inputParameter.getMessage());
            List<Asset> assets = modelConsole.getSearch(listTest);
             //viewConsole.showAssets(assets);
        } else {
            viewConsole.printMessage(inputParameter.getMessage());
        }
        Asset asset = new Asset();
        asset.setPath("c:/test123");
        asset.setFileName("test");
        asset.setExtension("mp3");
        asset.setSize("12MB");
        Asset asset1 = new Asset();
        asset1.setPath("c:/test");
        asset1.setFileName("test1");
        asset1.setExtension("mp3");
        asset1.setSize("12MB");
        Asset asset2 = new Asset();
        asset2.setPath("c:/test");
        asset2.setFileName("test");
        asset2.setExtension("mp31");
        asset2.setSize("12MB");
        List<Asset> assets= new ArrayList<>();
        assets.add(asset);
        assets.add(asset1);
        assets.add(asset2);
        //ViewConsole viewConsole = new ViewConsole();
        viewConsole.showAssets(assets);
        //viewConsole.printHeadTable();

        /*List<String> rowFile = new ArrayList<>();
        rowFile.add("Ctest");
        rowFile.add( "test");
        rowFile.add( ".mp3");
        rowFile.add( "30MB");
        viewConsole.addRow(rowFile);
        List<String> rowFile1 = new ArrayList<>();
        rowFile1.add("C:/test/music");
        rowFile1.add( "test");
        rowFile1.add( ".mp3");
        rowFile1.add( "30MB");
        viewConsole.addRow(rowFile1);
        List<String> rowFile2 = new ArrayList<>();
        rowFile2.add("C:/test/music");
        rowFile2.add( "test");
        rowFile2.add( ".mp3");
        rowFile2.add( "30MB");
        viewConsole.addRow(rowFile2);
        List<String> rowFile3 = new ArrayList<>();
        rowFile3.add("C:/test/music");
        rowFile3.add( "test");
        rowFile3.add( ".mp3");
        rowFile3.add( "30MB");
        viewConsole.addRow(rowFile3);*/
    }
}
