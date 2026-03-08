/*Accept 5 doubles from user (scanner)
Print it's average.

After creating PrintAverage.java (under day1_lab\src)
Open cmd prompt from the same src folder
To compile
javac -d ..\bin PrintAverage.java
cd ..\bin
To run 
java PrintAverage
 */

import java.util.Scanner;


class PrintAverage{

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of double elements you want average:  ");
            int n = sc.nextInt();
            double sum = 0.0;
            for(int i =0;i<n;i++){
                System.out.print("Enter Num "+ (i) +" : ");
                double a = sc.nextDouble();
                sum+=a;
            }
            double avg = sum/n;
            System.out.println("Average of given numbers is ");
            System.out.print(avg);

            sc.close();
        }
}