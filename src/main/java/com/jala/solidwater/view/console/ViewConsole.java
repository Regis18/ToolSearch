package com.jala.solidwater.view.console;

/**
 * ViewConsole class
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ViewConsole {

    /*public void testShow (List<File> files){

        for (int i = 0; i < files.size() ; i++) {

            String path = files.get(i).getAbsolutePath();
            String name = files.get(i).getName();
            String extension = FilenameUtils.getExtension(files.get(i).getAbsolutePath());

            System.out.format("%d | %s | %s | %s%n", i, path, name, extension);

        }
    }*/
    public void testShow () {
        for (int i = 0; i < 10 ; i++) {
            System.out.format("%d | %s | %s | %s%n", i, "path", "name", "extension");
        }
    }
}
