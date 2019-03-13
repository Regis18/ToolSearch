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

import com.jala.utils.FileExtractMetaData;
import com.jala.utils.Logs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jala.utils.AssetFactory;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * SearchFile class.
 *
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class SearchFile implements ISearchable {

    /**
     * It creates to follow up the instruction of the class
     */
    private Logger log = Logs.getInstance().getLog();

    /**
     * This method return a IAsset list by attributes of criteria.
     *
     * @param criteria to do the search with the path is required and other attributes are optional.
     * @return a list of the files that content the folder set in the path of criteria.
     */
    @Override
    public List<Asset> search(CriteriaSearch criteria) {
        log.info("Searching on " + criteria.getPath());
        FileExtractMetaData extractMetaData = new FileExtractMetaData();
        List<Asset> result = new ArrayList<>();
        File folder = new File(criteria.getPath());
        if (folder.exists()) {
            List<File> files = new ArrayList<File>();

            GetAllFiles(folder, files);
            try {
                for (int i = 0; i < files.size(); i++) {
                    File file = files.get(i);
                    if (file.isFile()) {

                        String nameCriteria = criteria.getFileName();
                        String extensionCriteria = criteria.getExtension();
                        String sizeCriteria = criteria.getSize();
                        String ownerCriteria = criteria.getOwner();

                        // var aux.

                        if ((criteria.getHidden() == TernaryBooleanEnum.OnlyTrue) && !(file.isHidden())) {
                            continue;
                        }
                        if (criteria.getHidden() == TernaryBooleanEnum.OnlyFalse && (file.isHidden())) {
                            continue;
                        }
                        if ((!criteria.getCreationDateFrom().isEmpty()) && !criteria.getCreationDateTo().isEmpty()) {
                            if ((Date.valueOf(extractMetaData.fileCreationDate(file.getPath())).before(Date.valueOf(criteria.getCreationDateFrom())))
                                    || (Date.valueOf(extractMetaData.fileCreationDate(file.getPath())).after(Date.valueOf(criteria.getCreationDateTo()))))
                                continue;
                        }
                        if ((!criteria.getModificationDateFrom().isEmpty()) && !criteria.getModificationDateTo().isEmpty()) {
                            if ((Date.valueOf(extractMetaData.fileLastModifiedDate(file.getPath())).before(Date.valueOf(criteria.getModificationDateFrom())))
                                    || (Date.valueOf(extractMetaData.fileLastModifiedDate(file.getPath())).after(Date.valueOf(criteria.getModificationDateTo()))))
                                continue;
                        }
                        if ((!criteria.getLastDateFrom().isEmpty()) && !criteria.getLastDateTo().isEmpty()) {
                            if ((Date.valueOf(extractMetaData.fileLastAccessDate(file.getPath())).before(Date.valueOf(criteria.getLastDateFrom())))
                                    || (Date.valueOf(extractMetaData.fileLastAccessDate(file.getPath())).after(Date.valueOf(criteria.getLastDateTo()))))
                                continue;
                        }
                        if ((!ownerCriteria.isEmpty()) && (!extractMetaData.fileOwner(file.getPath()).contains(ownerCriteria))) {
                            continue;
                        }
                        if ((!sizeCriteria.isEmpty())) {
                            if (criteria.isSizeCompareOption() && !(Double.parseDouble(sizeCriteria) > file.length()))
                                continue;
                            if (!criteria.isSizeCompareOption() && !(Double.parseDouble(sizeCriteria) <= file.length()))
                                continue;
                        }
                        if ((!nameCriteria.isEmpty()) && (!file.getName().contains(nameCriteria))) {
                            continue;
                        }
                        if ((!extensionCriteria.isEmpty()) && (!FilenameUtils.getExtension(file.getName()).equals(extensionCriteria))) {
                            continue;
                        }
                        if ((criteria.getReadonly() == TernaryBooleanEnum.OnlyTrue) && !(!file.canWrite())) {
                            continue;
                        }
                        if ((criteria.getReadonly() == TernaryBooleanEnum.OnlyFalse) && (!file.canWrite())) {
                            continue;
                        }
                        //video.
                        if (criteria.getType() == "Video") {
                            //TODO verify video extension.
                        }

                        Asset asset = extractMetaData.getAsset(criteria, file);
                        result.add(asset);
                    }
                }
            } catch (NullPointerException e) {
                log.error("The criteria values shouldn't be null", e);
            }
        }
        return result;
    }

    /**
     * Search files recursively.
     *
     * @param currentFile the starting file.
     * @param result      list of files.
     */
    private void GetAllFiles(File currentFile, List<File> result) {
        if (currentFile.isFile()) {
            result.add(currentFile);
        } else {
            File[] findFiles = currentFile.listFiles();
            List<File> files = Arrays.asList(findFiles);
            for (int i = 0; i < files.size(); i++) {
                GetAllFiles(files.get(i), result);
            }
        }
    }
}
