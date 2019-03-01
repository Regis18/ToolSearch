/**
 * @(#)SearchFile.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.jala.search.models;

import com.jala.utils.Logs;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.jala.utils.AssetFactory;

/**
 * SearchFile class.
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class SearchFile implements ISearchable {
   
    /**
     * This method return a IAsset list by attributes of criteria.
     * @param criteria to do the search with the path is required and other attributes are optional.
     * @return a list of the files that content the folder set in the path of criteria.
     */
    @Override
    public List<Asset> search(CriteriaSearch criteria) {
        List<Asset> result = new ArrayList<>();
        File folder = new File(criteria.getPath());
        if (folder.exists()) {
            File[] findFiles = folder.listFiles();
            List<File> files = Arrays.asList(findFiles);
            try {
                for (int i = 0; i < files.size(); i++) {
                    File file = files.get(i);
                    if (file.isFile()) {
                        //convert of a file to asset.
                        Asset asset = AssetFactory.GetAsset(criteria, file);
                        String nameFile = ((Asset) asset).getFileName();
                        String extensionFile = ((Asset)asset).getExtension();
                        String sizeFile = ((Asset)asset).getSize();
                        String nameCriteria = criteria.getFileName();
                        String extensionCriteria = criteria.getExtension();
                        String sizeCriteria = criteria.getSize();
                        String ownerFile = ((Asset)asset).getOwner();
                        String ownerCriteria = criteria.getOwner();
                        String createDateFile = ((Asset)asset).getCreationDate();
                        String createDateFileCriteria = criteria.getCreationDate();
                        String modificationDateFile = ((Asset)asset).getModificationDate();
                        String modificationDateFileCriteria = criteria.getModificationDate();
                        String lastDateFile = ((Asset)asset).getLastDate();
                        String lastDateFileCriteria = criteria.getLastDate();
                        // var aux.
                        boolean addFileToResults = true;
                        if ((criteria.getHidden() == TernaryBooleanEnum.OnlyTrue) && !((Asset) asset).isHidden()) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!createDateFile.isEmpty()) && (!createDateFile.equals(createDateFileCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!modificationDateFile.isEmpty()) && (!modificationDateFile.equals(modificationDateFileCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!lastDateFile.isEmpty()) && (!lastDateFile.equals(lastDateFileCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!ownerCriteria.isEmpty()) && (!ownerFile.equals(ownerCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!sizeCriteria.isEmpty()) && (!sizeFile.equals(sizeCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && criteria.getHidden() == TernaryBooleanEnum.OnlyFalse && asset.isHidden()) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!nameCriteria.isEmpty()) && (!nameFile.contains(nameCriteria))) {
                            addFileToResults = false;
                        }
                        if (addFileToResults && (!extensionCriteria.isEmpty()) && (!extensionFile.equals(extensionCriteria))) {
                            addFileToResults = false;
                        }
                        if(addFileToResults && (criteria.getReadonly() == TernaryBooleanEnum.OnlyTrue) && !(asset).isReadOnly()) {
                            addFileToResults = false;
                        }
                        if(addFileToResults && (criteria.getReadonly() == TernaryBooleanEnum.OnlyFalse) && (asset).isReadOnly()) {
                            addFileToResults = false;
                        }
                        //video.
                        if (criteria.getType() == 1) {
                            //TODO verify video extension.
                        }
                        if (addFileToResults) {
                            result.add(asset);
                        }
                    } else if (file.isDirectory()) {
                        //TODO recursion to get files of folder.
                    }
                }
            } catch (NullPointerException e) {
                Logs.getInstance().getLog().error("The criteria values shouldn't be null", e);
            }
        }
        return result;
    }
}
