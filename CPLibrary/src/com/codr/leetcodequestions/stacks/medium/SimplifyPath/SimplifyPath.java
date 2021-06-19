package com.codr.leetcodequestions.stacks.medium.SimplifyPath;

import com.codr.framework.Question;
import com.codr.leetcodequestions.stacks.medium.SimplifyPath.data.SimplifyPathInput;
import com.codr.leetcodequestions.stacks.medium.SimplifyPath.data.SimplifyPathOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 */
public class SimplifyPath extends Question<SimplifyPathOutput, SimplifyPathInput> {

    //TODO: Replace with Reader.
    private Scanner scanner = new Scanner(System.in);

    @Override
    public SimplifyPathOutput solve(SimplifyPathInput input) {
        String canonicalPath = "/";

        String[] pathParts = input.getPathComponents();
        if (pathParts.length >= 1) {
            Stack<String> partsStack = new Stack<>();
            for (String part: pathParts) {
                if (part.equalsIgnoreCase("..")) {
                    if (!partsStack.empty()) partsStack.pop();
                } else if (!part.isEmpty() && !part.equalsIgnoreCase(".")) {
                    partsStack.add(part);
                }
            }
            List<String> newParts = new ArrayList<>();
            while (!partsStack.empty()) {
                newParts.add(partsStack.peek());
                partsStack.pop();
            }
            Collections.reverse(newParts);
            canonicalPath += String.join( "/", newParts);
        }

        SimplifyPathOutput output = new SimplifyPathOutput(canonicalPath);
        return output;
    }

    @Override
    public SimplifyPathInput takeInput() {
        String absolutePath = scanner.nextLine();
        SimplifyPathInput input = new SimplifyPathInput(absolutePath);
        input.setPathComponents(absolutePath.split("/"));
        return input;
    }

    @Override
    public void display(SimplifyPathOutput content) {
        System.out.println(content.getCanonicalPath());
    }
}
