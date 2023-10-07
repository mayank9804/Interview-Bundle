package com.codr.leetcodequestions.dp.MCM.medium.BooleanParenthesis;

import com.codr.framework.Question;
import com.codr.leetcodequestions.dp.MCM.medium.BooleanParenthesis.data.BooleanParenthesisInput;
import com.codr.leetcodequestions.dp.MCM.medium.BooleanParenthesis.data.BooleanParenthesisOutput;

public class BooleanParenthesis extends Question<BooleanParenthesisOutput, BooleanParenthesisInput> {

    @Override
    public BooleanParenthesisOutput solve(BooleanParenthesisInput input) {
        String expression = input.expression;
        int n = expression.length();
        long totalWays = 0;
        SubTaskResponse[][] dp = new SubTaskResponse[n+5][n+5];
        if (n == 1 && expression.charAt(0) == 'T') {
            totalWays = 1;
        } else {
            totalWays = recurse(expression, 0, n - 1, dp).trueCount;
        }
        return new BooleanParenthesisOutput(totalWays);
    }

    @Override
    public BooleanParenthesisInput takeInput() {
        System.out.println("Enter valid expression");
        String expression = scanner.nextLine();
        return new BooleanParenthesisInput(expression);
    }

    @Override
    public void display(BooleanParenthesisOutput content) {
        System.out.println("Total number of ways in which this expression can be evaluated to true is " + content.totalWaysForTrueEvaluation);
    }

    private SubTaskResponse recurse(String s, int i, int j, SubTaskResponse[][] dp) {
        if (i > j) {
            return new SubTaskResponse(0, 0);
        }

        if (i == j) {
            boolean isTrueChar = (s.charAt(i) == 'T');
            return new SubTaskResponse(isTrueChar ? 1 : 0, isTrueChar ? 0 : 1);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        SubTaskResponse response = new SubTaskResponse(0, 0);
        for (int idx = i + 1; idx < j; idx += 2) {
            SubTaskResponse temp = new SubTaskResponse();
            SubTaskResponse left = dp[i][idx - 1] != null ? dp[i][idx - 1] : recurse(s, i, idx - 1, dp);
            SubTaskResponse right = dp[idx + 1][j] != null ? dp[idx + 1][j] : recurse(s, idx + 1, j, dp);
            temp.trueCount = evaluateTrueCount(left, right, s.charAt(idx));
            temp.falseCount = evaluateFalseCount(left, right, s.charAt(idx));
            response.trueCount += temp.trueCount;
            response.falseCount += temp.falseCount;
        }

        return dp[i][j] = response;
    }

    private long evaluateTrueCount(SubTaskResponse a, SubTaskResponse b, char operator) {
        long totalWays = 0;
        switch (operator) {
            case '|':
                totalWays += multiply(a.trueCount, b.trueCount);
                totalWays += multiply(a.trueCount, b.falseCount);
                totalWays += multiply(a.falseCount, b.trueCount);
                break;
            case '&':
                totalWays += multiply(a.trueCount, b.trueCount);
                break;
            case '^':
                totalWays += multiply(a.trueCount, b.falseCount);
                totalWays += multiply(a.falseCount, b.trueCount);
                break;
            default:
                break;
        }
        return totalWays;
    }

    private long evaluateFalseCount(SubTaskResponse a, SubTaskResponse b, char operator) {
        long totalWays = 0;
        switch (operator) {
            case '|':
                totalWays += multiply(a.falseCount, b.falseCount);
                break;
            case '&':
                totalWays += multiply(a.trueCount, b.falseCount);
                totalWays += multiply(a.falseCount, b.trueCount);
                totalWays += multiply(a.falseCount, b.falseCount);
                break;
            case '^':
                totalWays += multiply(a.trueCount, b.trueCount);
                totalWays += multiply(a.falseCount, b.falseCount);
                break;
            default:
                break;
        }
        return totalWays;
    }

    private long multiply(long a, long b) {
        return (a*b);
    }

    class SubTaskResponse {
        public long trueCount;
        public long falseCount;

        public SubTaskResponse(long trueCount, long falseCount) {
            this.trueCount = trueCount;
            this.falseCount = falseCount;
        }

        public SubTaskResponse() { }
    }
}

