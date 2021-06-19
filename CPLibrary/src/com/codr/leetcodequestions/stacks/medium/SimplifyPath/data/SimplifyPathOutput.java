package com.codr.leetcodequestions.stacks.medium.SimplifyPath.data;

/**
 * Output model for {@link com.codr.leetcodequestions.stacks.medium.SimplifyPath.SimplifyPath}.
 */
public class SimplifyPathOutput {
    private String canonicalPath;

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public void setCanonicalPath(String canonicalPath) {
        this.canonicalPath = canonicalPath;
    }

    public SimplifyPathOutput(String canonicalPath) {
        this.canonicalPath = canonicalPath;
    }
}
