package com.codr.leetcodequestions.stacks.easy.ValidParantheses;

import com.codr.leetcodequestions.framework.Visualizer;
import com.codr.leetcodequestions.stacks.easy.ValidParantheses.data.ValidParenthesesOutputModel;

public class ValidParenthesesSolutionVisualizer implements Visualizer<ValidParenthesesOutputModel> {

    @Override
    public void display(ValidParenthesesOutputModel content) {
        System.out.println(content.isValid());
    }
}
