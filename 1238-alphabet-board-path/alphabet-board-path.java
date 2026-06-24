class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb=new StringBuilder();
        int x=0;
        int y=0;
        for(char c:target.toCharArray()){
            int x1=(c-'a')/5;
            int y1=(c-'a')%5;
            while(x>x1){
                sb.append('U');
                x--;
            }
            while(y<y1){
                sb.append('R');
                y++;
            }
            while(y>y1){
                sb.append('L');
                y--;
            }
            while(x<x1){
                sb.append('D');
                x++;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}