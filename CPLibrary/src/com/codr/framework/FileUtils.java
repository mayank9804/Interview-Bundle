package com.codr.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static String readFile(final String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder fileContent = new StringBuilder();
            String thisLine;
            if (reader.ready()) {
                while ((thisLine = reader.readLine()) != null) {
                    fileContent.append(thisLine);
                    fileContent.append("\n");
                }
            }
            reader.close();
            return fileContent.toString();
        } catch (Exception e) {
            System.out.println("Exception occurred while reading file named " + filePath + " : " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    public static String writeFile(final String filePath, final String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception occurred while writing to file named " + filePath + " : " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
