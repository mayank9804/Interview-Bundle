package com.codr.framework;

import java.util.Scanner;

/**
 * Bootstraps the essential files.
 */
public class Bootstraper {
    private static String CURRENT_DIRECTORY = System.getProperty("user.dir");
    private static String LC_QUESTIONS_BASE_PATH = CURRENT_DIRECTORY + "/CPLibrary/src/com/codr/leetcodequestions/%s/%s/%s";
    static Scanner inputScanner = new Scanner(System.in);
    public static void main(String...args) {
        String questionName = inputScanner.nextLine();
        String tag = inputScanner.nextLine();
        String level = inputScanner.nextLine();

        System.out.println(LC_QUESTIONS_BASE_PATH);
        String questionDirectoryName = String.format(LC_QUESTIONS_BASE_PATH, tag, level, questionName);
        FileUtils.createDirectory(questionDirectoryName);

        String dataModelDirectoryName = String.format(LC_QUESTIONS_BASE_PATH + "/data", tag, level, questionName);
        FileUtils.createDirectory(dataModelDirectoryName);

        String inputDataFile = String.format(LC_QUESTIONS_BASE_PATH + "/data/%s", tag, level, questionName, questionName + "Input.java");
        FileUtils.createFile(inputDataFile);

        String outputDataFile = String.format(LC_QUESTIONS_BASE_PATH + "/data/%s", tag, level, questionName, questionName + "Output.java");
        FileUtils.createFile(outputDataFile);

        String questionFile = String.format(LC_QUESTIONS_BASE_PATH + "/%s", tag, level, questionName, questionName + ".java");
        FileUtils.createFile(questionFile);
    }


}
