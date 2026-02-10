public class IsPowerOFThreeSum {

    public static boolean checkPowersOfThree(int n) {

        String ternaryRepresentation = Integer.toString(n, 3);

        return ternaryRepresentation.contains("2");
    }


    /*
        This question has a straight away approach but thinking about
        that particular approach was difficult
     */

    public static void main(String[] args) {

        System.out.println(checkPowersOfThree(21));
    }
}
