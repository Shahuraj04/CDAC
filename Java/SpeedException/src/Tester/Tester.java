package Tester;

import static ExceptionHandling.SpeedCheck.process;
import static java.lang.System.out;

import java.util.Scanner;

import ExceptionHandling.SpeedException;

public class Tester {

	public static void main(String[] args) throws SpeedException {

		try (Scanner sc = new Scanner(System.in)) {
			out.println("Enter Speed Here: ");
			process(sc.nextInt());

		} catch (SpeedException e) {
			out.println("Speed Exception: " + e.getMessage());
		}
	}

}