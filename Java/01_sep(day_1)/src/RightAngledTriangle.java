
import java.util.Scanner;

class RightAngledTriangle {

    public static void main(String[] args) {
        Scanner my_Scanner = new Scanner(System.in);
        System.out.print("Enter Number of rows: ");
        int row = my_Scanner.nextInt();
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");

        }

    }
}
