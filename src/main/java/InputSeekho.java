import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputSeekho {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] input = bf.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            System.out.println(Integer.parseInt(input[i]));
        }
    }


}
