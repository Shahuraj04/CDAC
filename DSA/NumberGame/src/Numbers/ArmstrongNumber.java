package Numbers;

import java.util.Scanner;

class ArmstrongNumber{
	public static void main(String[] arhs) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number:");
		int num = sc.nextInt();
		
		int originalNumber = num;
		int digits = String.valueOf(num).length();
		int sum = 0;
		while(num>0) {
			int digit = num%10;
			sum += Math.pow(digit,digits);
			num /= 10;
			
		}
		if(sum==originalNumber) {
			System.out.println("is armstrong");
		}
		else
			System.out.println(" not a armstrong");	
		sc.close();
	}
	
}