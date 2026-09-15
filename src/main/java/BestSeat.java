import java.util.Scanner;

public class BestSeat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int arr[] = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = arr.length - 1;
        int center = (arr[left] + arr[right]) / 2;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == center) {
                System.out.println(center);
                System.exit(0);
            } else if (arr[mid] < center) {
                ans = arr[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int first = ans;

        left = 0;
        right = arr.length - 1;
        int second = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == center) {
                System.out.println(center);
                System.exit(0);
            } else if (arr[mid] < center) {
                left = mid + 1;
            } else {
                second = arr[mid];
                right = mid - 1;
            }
        }

        if (first == -1) {
            System.out.println(second);
        } else if (second == -1) {
            System.out.println(first);
        } else {
            int d1 = Math.abs(first - center);
            int d2 = Math.abs(second - center);
            if (d1 <= d2) {
                System.out.println(first);
            } else {
                System.out.println(second);
            }
        }
    }
}