package com.jala.seacrh.models;

import java.io.File;

public class SearchFile implements Searchable{
    
    @Override
    public File[] searchByPath(String path) {
        File folder = new File(path);
        String file;
            File[] findFiles = folder.listFiles();
            for (int i = 0; i < findFiles.length; i++) {
                if (findFiles[i].isDirectory()) {
                    file = findFiles[i].getName();
                    System.out.println(file);
                } else if (findFiles[i].isFile()) {
                    file = findFiles[i].getName();
                    System.out.println(file);
                }
            }
        return findFiles;
    }
}
