class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        int idx = 0;
        for(int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            char bh = str2.charAt(idx);

            if(ch == 'z' && bh == 'a') {
                idx ++;
            }else if(ch == bh ) idx ++;
            else if(bh == ch + 1) idx ++;

            if(idx == str2.length()) return true;

        }

        return idx == str2.length();
    }
}