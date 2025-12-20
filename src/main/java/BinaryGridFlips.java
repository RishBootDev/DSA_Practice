public class BinaryGridFlips {

    public int minFlips(int[][] grid) {

        int countRow=0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]);
            }
            countRow+=getFlips(sb.toString());
        }


        int countColumn=0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[j][i]);
            }

            countColumn+=getFlips(sb.toString());
        }

        return Math.min(countColumn,countRow);
    }

    public int getFlips(String str){

            int count=0;
            int i=0;
            int j=str.length()-1;
            while(i<j){
                if(str.charAt(i)!=str.charAt(j)) count++;
                i++;
                j--;
            }

            return count;
    }
}
