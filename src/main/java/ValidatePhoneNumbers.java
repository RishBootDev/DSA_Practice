import java.util.Scanner;

public class ValidatePhoneNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println("the phone number is :");
        if(str.length() != 10) System.out.println("NO");
        else if(str.charAt(0) != '9' && str.charAt(0) != '8' && str.charAt(0) != '7') System.out.println("NO");
        else {
            if(countNum(str) == 10) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static int countNum(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <='9') count++;
        }

        return count;
    }


    // this is the exact same code but it is using the concepts of regex
    public static void validPhoneUsingRegex(String str) {

        if (str.matches("[789][0-9]{9}")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
