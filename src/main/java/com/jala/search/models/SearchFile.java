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
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * SearchFile class.
 * @author Areliez Vargas
 * @version 0.0.1
 */
public class SearchFile implements ISearchable {

    /** It creates to follow up the instruction of the class*/
    private Logger log = Logs.getInstance().getLog();

    private static String FFPROBE_PATH = SearchFile.class.getClassLoader()
            .getResource("ThirdParty/ffmpeg/bin").getPath() + "ffprobe";
    /**
     * This method return a IAsset list by attributes of criteria.
     * @param criteria to do the search with the path is required and other attributes are optional.
     * @return a list of the files that content the folder set in the path of criteria.
     */
    @Override
    public List<Asset> search(CriteriaSearch criteria) {
    log.info("Searching on " + criteria.getPath());
        List<Asset> result = new ArrayList<>();
        File folder = new File(criteria.getPath());
        if (folder.exists()) {
            List<File> files = new ArrayList<File>();
            GetAllFiles(folder,files);
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
                            if(  ( Date.valueOf( fileCreationDate(file.getPath())).before(Date.valueOf(criteria.getCreationDateFrom()) ))
                                    ||  ( Date.valueOf(fileCreationDate(file.getPath())).after(Date.valueOf(criteria.getCreationDateTo()))))
                                continue;
                        }
                        if ((!criteria.getModificationDateFrom().isEmpty()) && !criteria.getModificationDateTo().isEmpty()) {
                            if(  ( Date.valueOf(fileLastModifiedDate(file.getPath())).before(Date.valueOf(criteria.getModificationDateFrom()) ))
                                    ||  ( Date.valueOf(fileLastModifiedDate(file.getPath())).after(Date.valueOf(criteria.getModificationDateTo()) ))                           )
                                continue;
                        }
                        if ((!criteria.getLastDateFrom().isEmpty()) && !criteria.getLastDateTo().isEmpty()) {
                            if(  ( Date.valueOf(fileLastAccessDate(file.getPath())).before(Date.valueOf(criteria.getLastDateFrom()) ))
                                    ||  ( Date.valueOf(fileLastAccessDate(file.getPath())).after(Date.valueOf(criteria.getLastDateTo()) )))
                                continue;
                        }
                        if ((!ownerCriteria.isEmpty()) && (!fileOwner(file.getPath()).contains(ownerCriteria))) {
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
                        if((criteria.getReadonly() == TernaryBooleanEnum.OnlyTrue) && !(!file.canWrite())) {
                            continue;
                        }
                        if((criteria.getReadonly() == TernaryBooleanEnum.OnlyFalse) && (!file.canWrite())) {
                            continue;
                        }

                        //if(criteria.getType() == 0) {
                            Asset asset = (Asset) AssetFactory.getAsset(file.getPath(), file.getName(),
                                    FilenameUtils.getExtension(file.getName()), file.isHidden(), fileOwner(file.getPath()), String.valueOf(file.length()), file.canWrite(),
                                    criteria.getCreationDateFrom(), criteria.getModificationDateFrom(), criteria.getLastDateFrom());
                       //}
                        /*
                        if (criteria.getType() == 1)
                        {


                            try {


                                FFprobe ffprobe = new FFprobe(FFPROBE_PATH);
                                FFmpegProbeResult ffprobeResult;
                                ffprobeResult = ffprobe.probe(file.getPath());
                                if (!criteria.getFrameRate().equALS(ffprobeResult.getStreams().get(0).r_frame_rate.getNumerator()))
                                     CONTINUEW

                                    /* assetVideo.setVideoCodec(ffprobeResult.getStreams().get(0).codec_long_name);
                                assetVideo.setAudioCodec(ffprobeResult.getStreams().get(0).codec_tag_string);
                                assetVideo.setFrameRate(String.valueOf(ffprobeResult.getStreams().get(0).r_frame_rate.getNumerator()));
                                assetVideo.setAspectRatio(ffprobeResult.getStreams().get(0).display_aspect_ratio);
                                assetVideo.setDimentionWidth(String.valueOf(ffprobeResult.getStreams().get(0).width));
                                assetVideo.setDimentionHeight(String.valueOf(ffprobeResult.getStreams().get(0).height));
                                assetVideo.setAudioSampleRate(ffprobeResult.getStreams().get(0).sample_aspect_ratio);
                                assetVideo.setDuration(String.valueOf(ffprobeResult.getStreams().get(0).duration));*/
                           /* } catch (Exception ex) {

                            }
                            Asset asset = (Asset) AssetFactory.getAsset(file.getPath(), file.getName(),
                                    criteria.getExtension(), criteria.getHidden(), fileOwner(file.getPath()), criteria.getSize(), criteria.getReadonly(),
                                    criteria.getCreationDateFrom(), criteria.getModificationDateFrom(), criteria.getLastDateFrom(),ffprobeResult.getStreams().get(0).codec_long_name, );

                        }*/
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
     * Get the file creation date.
     * @param filePath the path of the file.
     * @return the creation date of the file.
     */
    public static String fileCreationDate(String filePath){
        File file = new File( filePath );
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.creationTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get the file last access date.
     * @param filePath the path of the file.
     * @return the file date last access date.
     */
    public static String fileLastAccessDate(String filePath){
        File file = new File( filePath );
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastAccessTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted ;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get the file last modified date.
     * @param filePath the path of the file.
     * @return the date of file the las modified date.
     */
    public static String fileLastModifiedDate(String filePath){
        File file = new File( filePath );
        BasicFileAttributes attrs;
        try {
            attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            FileTime time = attrs.lastModifiedTime();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formatted = simpleDateFormat.format( new java.util.Date( time.toMillis() ) );
            return formatted ;
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * Get file owner.
     * @param filePath the path of the file.
     * @return the owner of the file.
     */
    public static String fileOwner(String filePath) {
        Path path = Paths.get(filePath);
        FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        try{
            UserPrincipal owner = ownerAttributeView.getOwner();
            return owner.getName();
        }catch(java.io.IOException e){
            return "";
        }
    }

    /**
     * Search files recursively.
     * @param currentFile the starting file.
     * @param result list of files.
     */
    static void GetAllFiles(File currentFile, List<File> result) {
        if (currentFile.isFile()) {
            result.add(currentFile);
        }else{
           File[] findFiles = currentFile.listFiles();
            List<File> files = Arrays.asList(findFiles);
            for (int i = 0; i < files.size(); i++) {
                GetAllFiles(files.get(i) , result);
            }
        }
    }
}
