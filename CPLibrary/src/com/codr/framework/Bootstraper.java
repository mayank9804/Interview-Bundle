package com.codr.framework;

/**
 * Bootstraps the essential files.
 */
public class Bootstraper {
    public static String LC_QUESTIONS_BASE_PATH = "/Users/%s/Desktop/LowBattery/CPLibrary/src/com/codr/leetcodequestions/%s/%s/%s";

    public static void main(String...args) {
        String questionName = args[0];
        String tag = args[1];
        String level = args[2];

        String questionDirectoryName = String.format(LC_QUESTIONS_BASE_PATH, System.getProperty("user.name"), tag, level, questionName);
        FileUtils.createDirectory(questionDirectoryName);

        String dataModelDirectoryName = String.format(LC_QUESTIONS_BASE_PATH + "/data", System.getProperty("user.name"), tag, level, questionName);
        FileUtils.createDirectory(dataModelDirectoryName);

        String inputDataFile = String.format(LC_QUESTIONS_BASE_PATH + "/data/%s", System.getProperty("user.name"), tag, level, questionName, questionName + "Input.java");
        FileUtils.createFile(inputDataFile);

        String outputDataFile = String.format(LC_QUESTIONS_BASE_PATH + "/data/%s", System.getProperty("user.name"), tag, level, questionName, questionName + "Output.java");
        FileUtils.createFile(outputDataFile);

        String questionFile = String.format(LC_QUESTIONS_BASE_PATH + "/%s", System.getProperty("user.name"), tag, level, questionName, questionName + ".java");
        FileUtils.createFile(questionFile);
    }


}
