
import java.util.Scanner;

/*
 * 4.1 Write Java program - 
Display food menu to user. User will select items from menu along with the quantity. (eg 1. Dosa 2. Samosa 3. Idli ... 0 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
When user enters 'Generate Bill' option(0) , display total bill & exit.
 */
class FoodDisplay {

    public static void main(String[] args) {
        Scanner myscan = new Scanner(System.in);
        boolean exit = false;
        double total = 0.0;
        int qty_sum = 0;
        int qty = 0;
        int qty1 = 0;
        int qty2 = 0;
        int qty3 = 0;
        int qty4 = 0;
        System.out.println("\n*********WELCOME TO CDAC CAFETERIA*********\n");
        while (!exit) {

            System.out.println("\t1. Dosa          Rs.50");
            System.out.println("\t2. Samosa        Rs.25");
            System.out.println("\t3. Idli          Rs.45");
            System.out.println("\t4. Pohe          Rs.20");
            System.out.println("\t0. GENERATE BILL");
            System.out.print("\t\tEnter Choice: ");
            switch (myscan.nextInt()) {
                case 1:
                    System.out.print("\t\tEnter Quantity: ");
                    qty = myscan.nextInt();
                    qty1 = qty;

                    qty_sum = 50 * qty;
                    total += qty_sum;
                    qty1 += qty1;
                    break;
                case 2:
                    System.out.println("\t\tEnter Quantity: ");
                    qty = myscan.nextInt();
                    qty2 = qty;
                    qty_sum = 25 * qty;
                    total += qty_sum;
                    qty2 += qty2;
                    break;

                case 3:
                    System.out.println("\t\tEnter Quantity: ");
                    qty = myscan.nextInt();
                    qty3 = qty;
                    qty_sum = 45 * qty;
                    total += qty_sum;
                    qty3 += qty3;
                    break;

                case 4:
                    System.out.print("\t\tEnter Quantity: ");
                    qty = myscan.nextInt();
                    qty4 = qty;
                    qty_sum = 45 * qty;
                    total += qty_sum;
                    qty4 += qty4;
                    break;

                case 0:
                    System.out.println("\t\t\t#########################");
                    System.out.println("\t\t\t#Item                Qty#");
                    System.out.println("\t\t\t#########################");
                    System.out.println("\t\t\tDosa               " + qty1);
                    System.out.println("\t\t\tSamosa             " + qty2);
                    System.out.println("\t\t\tIdli               " + qty3);
                    System.out.println("\t\t\tPohe               " + qty4);
                    System.out.println("\n\t\t\t***************Total: " + total + " ***************\n");
                    exit = true;

            }

        }
        myscan.close();
    }
}
