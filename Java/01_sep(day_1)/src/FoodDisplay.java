import java.util.Scanner;

class FoodDisplay {

    public static void main(String[] args) {
        Scanner myscan = new Scanner(System.in);
        boolean exit = false;
        double total = 0.0;

        // Quantities of each item
        int dosaQty = 0, samosaQty = 0, idliQty = 0, poheQty = 0;

        System.out.println("\n=======================================");
        System.out.println("        WELCOME TO CDAC CAFETERIA  ");
        System.out.println("=======================================\n");

        while (!exit) {
            System.out.println("============== MENU ==============");
            System.out.printf("%-5s %-15s %s\n", "No.", "Item", "Price (Rs.)");
            System.out.println("---------------------------------");
            System.out.printf("%-5s %-15s %s\n", "1.", "Dosa", "50");
            System.out.printf("%-5s %-15s %s\n", "2.", "Samosa", "25");
            System.out.printf("%-5s %-15s %s\n", "3.", "Idli", "45");
            System.out.printf("%-5s %-15s %s\n", "4.", "Pohe", "20");
            System.out.println("---------------------------------");
            System.out.println("0. Generate Bill");
            System.out.println("=================================\n");

            System.out.print("Enter Choice: ");
            int choice = myscan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Quantity of Dosa: ");
                    int qty1 = myscan.nextInt();
                    dosaQty += qty1;
                    total += 50 * qty1;
                    break;

                case 2:
                    System.out.print("Enter Quantity of Samosa: ");
                    int qty2 = myscan.nextInt();
                    samosaQty += qty2;
                    total += 25 * qty2;
                    break;

                case 3:
                    System.out.print("Enter Quantity of Idli: ");
                    int qty3 = myscan.nextInt();
                    idliQty += qty3;
                    total += 45 * qty3;
                    break;

                case 4:
                    System.out.print("Enter Quantity of Pohe: ");
                    int qty4 = myscan.nextInt();
                    poheQty += qty4;
                    total += 20 * qty4;
                    break;

                case 0:
                    System.out.println("\n============= BILL =============");
                    System.out.printf("%-15s %-10s %-10s %s\n", "Item", "Qty", "Price", "Subtotal");
                    System.out.println("-----------------------------------------------");

                    if(dosaQty > 0)   System.out.printf("%-15s %-10d %-10d %-10.2f\n", "Dosa", dosaQty, 50, (dosaQty * 50.0));
                    if(samosaQty > 0) System.out.printf("%-15s %-10d %-10d %-10.2f\n", "Samosa", samosaQty, 25, (samosaQty * 25.0));
                    if(idliQty > 0)   System.out.printf("%-15s %-10d %-10d %-10.2f\n", "Idli", idliQty, 45, (idliQty * 45.0));
                    if(poheQty > 0)   System.out.printf("%-15s %-10d %-10d %-10.2f\n", "Pohe", poheQty, 20, (poheQty * 20.0));

                    System.out.println("-----------------------------------------------");
                    System.out.printf("%-37s Rs. %.2f\n", "TOTAL:", total);
                    System.out.println("===============================================\n");
                    System.out.println("   Thank you! Visit Again ");
                    System.out.println("===============================================\n");

                    exit = true;
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }

        myscan.close();
    }
}
