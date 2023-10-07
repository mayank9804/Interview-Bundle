package com.codr.framework;

import java.util.Scanner;

/**
 * Bootstraps the essential files.
 */
public class Bootstraper {
    private static String CURRENT_DIRECTORY = System.getProperty("user.dir");
    private static String LC_QUESTIONS_BASE_PATH = CURRENT_DIRECTORY + "/CPLibrary/src/com/codr/leetcodequestions/%s/%s/%s";
    private static String QUESTION_BOILER_PLATE_DIR = CURRENT_DIRECTORY + "/CPLibrary/src/com/codr/framework/boilerplate";
    private static String QUESTION_DATA_MODEL_BOILER_PLATE_FILE = QUESTION_BOILER_PLATE_DIR + "/data.txt";

    private static String QUESTION_DATA_MODEL_PACKAGE_NAMESPACE = "com.codr.leetcodequestions.%s.%s.%s.data";

    private static String QUESTION_IMPL_PACKAGE_NAMESPACE = "com.codr.leetcodequestions.%s.%s.%s";
    private static String QUESTION_IMPLEMENTATION_BOILER_PLATE_FILE = QUESTION_BOILER_PLATE_DIR + "/impl.txt";
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

        String dataModelPackageNamespace = String.format(QUESTION_DATA_MODEL_PACKAGE_NAMESPACE, String.join(".", tag.split("/")), level, questionName);
        String inputDataClassName = questionName + "Input";
        String inputDataFile = String.format(LC_QUESTIONS_BASE_PATH + "/data/%s", tag, level, questionName, questionName + "Input.java");
        FileUtils.createFile(inputDataFile);
        updateDataFile(inputDataFile, dataModelPackageNamespace , inputDataClassName);

        String outputDataClassName = questionName + "Output";
        String outputDataFile = String.format(LC_QUESTIONS_BASE_PATH + "/data/%s", tag, level, questionName, questionName + "Output.java");
        FileUtils.createFile(outputDataFile);
        updateDataFile(outputDataFile, dataModelPackageNamespace, outputDataClassName);

        String implPackageNamespace = String.format(QUESTION_IMPL_PACKAGE_NAMESPACE, String.join(".", tag.split("/")), level, questionName);
        String questionFile = String.format(LC_QUESTIONS_BASE_PATH + "/%s", tag, level, questionName, questionName + ".java");
        FileUtils.createFile(questionFile);
        updateImplementationFile(questionFile, implPackageNamespace, dataModelPackageNamespace, questionName, inputDataClassName, outputDataClassName);
    }

    private static void updateDataFile(final String filePathToWrite,
                                       String packageString,
                                       String className) {
        String boilerPlateContent = FileUtils.readFile(QUESTION_DATA_MODEL_BOILER_PLATE_FILE);
        className = className.substring(0, 1).toUpperCase() + className.substring(1);
        String content = String.format(boilerPlateContent,  packageString, className);
        FileUtils.writeFile(filePathToWrite, content);
    }

    private static void updateImplementationFile(final String filePathToWrite,
                                                 String packageString,
                                                 String dataModelPackageNamespace,
                                                 String className,
                                                 String inputDataClassName,
                                                 String outputDataClassName) {
        String boilerPlateContent = FileUtils.readFile(QUESTION_IMPLEMENTATION_BOILER_PLATE_FILE);
        String inputModelPackageNamespace = dataModelPackageNamespace + "." + inputDataClassName;
        String outputModelPackageNamespace = dataModelPackageNamespace + "." + outputDataClassName;
        className = className.substring(0, 1).toUpperCase() + className.substring(1);
        String content = String.format(
                boilerPlateContent,
                packageString,
                inputModelPackageNamespace,
                outputModelPackageNamespace,
                className,
                outputDataClassName,
                inputDataClassName,
                outputDataClassName,
                inputDataClassName,
                inputDataClassName,
                outputDataClassName
        );
        FileUtils.writeFile(filePathToWrite, content);
    }
}
