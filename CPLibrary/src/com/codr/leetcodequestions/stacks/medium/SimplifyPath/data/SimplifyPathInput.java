package com.codr.leetcodequestions.stacks.medium.SimplifyPath.data;

/**
 * Input model for {@link com.codr.leetcodequestions.stacks.medium.SimplifyPath.SimplifyPath}.
 */
public class SimplifyPathInput {
    private String absolutePath;
    private String[] pathComponents;

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public SimplifyPathInput(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String[] getPathComponents() {
        return pathComponents;
    }

    public void setPathComponents(String[] pathComponents) {
        this.pathComponents = pathComponents;
    }
}
