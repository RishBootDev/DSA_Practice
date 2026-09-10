public class SolvingQuestionsWithBrainPower {

    // this is a accepted recursion
    public long mostPoints(int[][] questions) {
       return helper(questions, 0);
    }

    public long helper(int [][] ques, int i) {
        if(i == ques.length) return 0;

        // take
        long take = helper(ques, i + ques[i][1]) + ques[i][0];

        // not take
        long not = helper(ques, i + 1);

        return Math.max(take, not);
    }
}
