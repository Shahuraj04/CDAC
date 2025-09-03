package com.tester;
import java.util.Scanner;
import com.developers.geometry.Point2D;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class TestPoint {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("How many points do you want to add: ");
    Point2D[] pts = new Point2D[sc.nextInt];
    
    for(int i=0;i<pts.length;i++) {
    	System.out.print("Enter two co-ords for point no."+(i+1)+": ");
    		pts[i]= new Point2D(sc.nextInt(),sc.nextInt());
    		
    	
    }
    for(Point2D point : pts ) {
    	System.out.print(point.show());
    }
    

//    System.out.print("Enter x and y for point1: ");
//    Point2D p1 = new Point2D(sc.nextInt(), sc.nextInt());
//
//    System.out.print("Enter x and y for point2: ");
//    Point2D p2 = new Point2D(sc.nextInt(), sc.nextInt());
//
//    System.out.println("Point1: " + p1.show());
//    System.out.println("Point2: " + p2.show());
//
//    if (p1.isEqual(p2)) {
//      System.out.println("Equal Co-ords");
//    } else {
//      System.out.println("Diifernt Co-ords");
//      System.out.println("Distance between points : " + p1.calculateDistance(p2));
//    }
    sc.close();
  }
}
