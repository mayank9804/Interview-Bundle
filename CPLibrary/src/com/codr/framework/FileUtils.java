package com.codr.framework;

import java.io.File;
import java.util.Arrays;

/**
 * Utility routes dealing with files.
 */
public class FileUtils {

    private FileUtils() {}

    /**
     * Creates a file.
     * @param fileName Absolute Path.
     */
    public static void createFile(final String fileName) {
        try {
            File file = new File(fileName);
            System.out.println(file.createNewFile() ? "File created successfully : " + fileName : "File already exists");
        } catch (Exception e) {
            System.out.println("Exception occurred while create new file named " + fileName + " : " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Creates a directory.
     * @param directoryName Absolute Path.
     */
    public static void createDirectory(final String directoryName) {
        try {
            File file = new File(directoryName);
            System.out.println(file.mkdirs() ? "Directory created : " + directoryName :  "Directory already exists");
        } catch (Exception e) {
            System.out.println("Exception occurred while create new directory named " + directoryName + " : " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
