public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch) return reverseString(word.substring(0,i+1),i)+word.substring(i+1);
        }

        return word;
    }
    public String reverseString(String str, int k){
        char [] arr = str.toCharArray();

        int i = 0;
        int j = k;
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }
}
