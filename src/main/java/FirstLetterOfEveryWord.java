public class FirstLetterOfEveryWord {

    public static void firstLetterOfEveryWord(String str) {

        String [] words = str.split(" ");
        for(String word : words ) {
            System.out.println(word.charAt(0));
        }
    }

    public static void main(String[] args) {
        firstLetterOfEveryWord("My name is Rishabh Dubey");
    }
}
