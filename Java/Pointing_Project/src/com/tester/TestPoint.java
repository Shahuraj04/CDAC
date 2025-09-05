package com.tester;

import java.util.Scanner;
import com.developers.geometry.Point2D;

public class TestPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.print("How many points do you want to add: ");
      Point2D[] pts = new Point2D[sc.nextInt()];  
        while(!exit) {
        	System.out.println("\n1. Add point ");
        	System.out.println("2.Show Points");
        	System.out.println("0.Exit");
        	System.out.print("Enter your choice: ");
        	switch(sc.nextInt()) {
        	case 1:
        		System.out.println("Enter Index you want to add co-ords: ");
        		int index= sc.nextInt();
        		if(index<0 || index>=pts.length) {
        			System.out.println("Index out of boundaries enter index between ( 0 & "+(pts.length)+" )");
        			
        		}
        		else if (pts[index] != null) {
                    System.out.println("Point already exists at index " + index);
                }
        		else {
        			System.out.print("Enter x and y coordinates: ");
        			pts[index] = new Point2D(sc.nextInt(), sc.nextInt());
        			System.out.print("Points added");
        		}
        		break;
        	
        	case 2:
        		System.out.println("\nPlotted points:");
                boolean found = false;
                for (Point2D point : pts) {
                    if (point != null) {
                        System.out.println(point.show());
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println(" No points plotted yet.");
                }
                break;
              case 0 :
        		System.out.println("Terminating");
        		exit=true;
        		break;
        	default:
                System.out.println(" Invalid choice! Please try again.");
        		
        		
        	
        	
        	
        	}
        	
        	
        	
        }
        
        
        

//        System.out.print("How many points do you want to add: ");
//        Point2D[] pts = new Point2D[sc.nextInt()]; // ✅ use ()
//
//        for (int i = 0; i < pts.length; i++) {
//            System.out.print("Enter two co-ords for point no." + (i + 1) + ": ");
//            pts[i] = new Point2D(sc.nextInt(), sc.nextInt()); // ✅ create object
//        }
//
//        System.out.println("\nPoints Entered:");
//        for (Point2D point : pts) {
//            System.out.println(point.show());
//        }

        sc.close();
    }
}
