package com.example;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BeerBottles21 {
	
	 private Scanner scanner;
	 private PrintStream printStream;
	 private int num;

	 static int bottles = 21;
	 static String player1;
	 static String player2;
	
	 public BeerBottles21(InputStream inputStream, PrintStream printStream) {
	      this.scanner = new Scanner(inputStream);
	      this.printStream = printStream;
	 }
	
	 
	 public int isInputNumberValid()  {
		 
			//1. Write the Java Code to accept the valid number of bottles user wants to pick.
			//2. Use the Instance variable "scanner" to accept the input from the user.
			//3. In case of valid input, return back the number.
			//4. To print on console, use this.printStream.print() and NOT the System.out.println()
			//5. In case of invalid input, print on console exactly as below :- 
			//   "As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive".
			//   and return back -1
			 
			//Write code here - begin
				try {
					int num = this.scanner.nextInt();
					
					if(num >= 1 && num <= 4) {
						return num;
					 }
					else {
						//throw new InputMismatchException();
						this.printStream.print("As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive");
					}
					
				}catch(Exception e) {
					//throw new InputMismatchException();
					this.printStream.print("As per the Game Rules, please pick up bottles between 1 and 4 only, both inclusive");
				}
				return -1;
			//Write code here - end			
	 }
 
	 
	public int pickAfterUser(int pick1) {
		//Write code here - begin 
		return 5-pick1;
		//Write code here - end
	}
	 
	 
	public void startGamePlayer1() {
		int remaining = 21;
		
		/*if(player1.equals("computer")) {
			Random rn = new Random();
			initialpick = rn.nextInt(4) + 1;
			System.out.println("The computer has picked "+initialpick);
		}*/
		while(remaining > 1) {
			
			
			System.out.println("How many you would like to pick up? ");
			//Scanner input = new Scanner(System.in);
			
			int pick1 = isInputNumberValid();
			//int pick1 = input.nextInt();
			while( pick1 == -1) {
				pick1 = isInputNumberValid();
			}
			
			int pick2 = pickAfterUser(pick1);
			System.out.println("Computer has picked " + pick2);
			remaining = remaining - pick1 - pick2;
			System.out.println("The bottles remaining are : " + remaining);
		}
		
		if(remaining == 1) {
			System.out.println("You will have to pick up the last..you are loser");
		}
	}
	
	public void printGameRules() {
		//To print on console, use this.printStream.print() and NOT the System.out.println()
		//and using the this.printStream.print(), print below contents on console exactly as below
		/*
		 System.out.println("There are 21 beer bottles");
		 System.out.println("Computer and yourself, there are 2 players");
		 System.out.println("At a time, each one can pick up any no. of bottles between 1 and 4 (inclusive)");
		 System.out.println("Please play first");
		 */
		this.printStream.print("There are 21 beer bottles\n");
		this.printStream.print("Computer and yourself, there are 2 players\n");
		this.printStream.print("At a time, each one can pick up any no. of bottles between 1 and 4 (inclusive)\n");
		this.printStream.print("The one who will have to pick up the last is looser\n");
		this.printStream.print("Please play first\n");
	}
	
	public static void main(String[] args) {
				
		BeerBottles21 bb = new BeerBottles21(System.in,System.out);
		bb.printGameRules();
		
		player1 = "you";
		bb.startGamePlayer1();
			
       
	}

}