package com.jala;

import com.jala.seacrh.models.SearchFile;
import com.jala.seacrh.models.Searchable;

public class main {
    public static void main(String[] args) {
        Searchable files = new SearchFile();
        System.out.println(files.searchByPath("C:\\").length);
    }
}
