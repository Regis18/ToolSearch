package com.jala.seacrh.models;

import java.io.File;

public interface Searchable {

    File[] searchByPath(String path);
}
