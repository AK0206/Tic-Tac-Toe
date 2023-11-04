package tictactoe;

import java.util.*;
import java.io.*;
class name{
	String name="",value="";
}
public class TicTacToe {
	static Scanner sc=new Scanner(System.in);
	static String[][] board= {{" ","|"," ","|"," "},
			 {"-","+","-","+","-"},
			 {" ","|"," ","|"," "},
			 {"-","+","-","+","-"},
			 {" ","|"," ","|"," "}};
	static int c=1;
	
	
	public static void print(String[][] a) {
		for(String[] row: a) {
			for(String c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void decor() {
		System.out.println("\n\t*************************************************\n\n\t\t\t"
				+ "***Tic-TAC-TOE***\n\n\t**************************************************\n\t\t\t"
				+ "     |     |     \n\t\t\t"
				+ "     |     |     \n\t\t\t"
				+ "- - -+- - -+- - -\n\t\t\t"
				+ "     |     |     \n\t\t\t"
				+ "     |     |     \n\t\t\t"
				+ "- - -+- - -+- - -\n\t\t\t"
				+ "     |     |     \n\t\t\t"
				+ "     |     |     \n\t\t\t");
		
	}
	
	public static void placeCpu(int x,String p) {
		switch(x) {
		case 1:{
			if(board[0][0].equals(" "))board[0][0]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 2:{
			if(board[0][2].equals(" "))board[0][2]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 3:{
			if(board[0][4].equals(" "))board[0][4]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 4:{
			if(board[2][0].equals(" "))board[2][0]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 5:{
			if(board[2][2].equals(" "))board[2][2]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 6:{
			if(board[2][4].equals(" "))board[2][4]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 7:{
			if(board[4][0].equals(" "))board[4][0]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 8:{
			if(board[4][2].equals(" "))board[4][2]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		case 9:{
			if(board[4][4].equals(" "))board[4][4]=p;
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				placeCpu(x,p);
			}
			break;
		}
		default:System.out.println("Cpu is having a problem !");System.exit(0);
		}
		print(board);
		if(win()) {
			System.out.println("\n\n\t\t*** CPU WINS ***");
			System.exit(0);
		}
	}
	
	public static void SinglePlayer() {
		name p=new name();
		System.out.print("Enter the Players's name:");
		p.name=sc.next().toUpperCase();
		System.out.print("\n"+p.name+", Which value do you choose, X or O:");
		p.value=sc.next().toUpperCase();
		name cpu=new name();
		cpu.name="System";
		if(p.value.equals("X"))cpu.value="O";
		else if(p.value.equals("O"))cpu.value="X";
		else {
			System.out.println(p.name+" you have entered an invalid choice so the program terminates!");
			System.exit(0);
		}
		int x=0;
		while(c<10) {
			if(c%2!=0) {
				System.out.print("\n"+p.name+", enter the position(1-9) you wanna place your value at:");
				x=sc.nextInt();
				placeTheValue(x,p.value);
			}
			else {
				Random rand = new Random();
				x = rand.nextInt(9)+1;
				System.out.println(cpu.name+" Plays");
				placeCpu(x,cpu.value);
			}
			c++;	
		}
		System.out.println("\n\n\t\t*** TIE ***");
	}
	
	public static void MultiPlayer() {
		name p1=new name();
		name p2=new name();
		System.out.print("Enter Player 1's name(without spaces):");
		p1.name=sc.next().toUpperCase();
		System.out.print("\nEnter Player 2's name(without spaces):");
		p2.name=sc.next().toUpperCase();
		System.out.print("\nWhat will you choose "+p1.name+", X or O? :");
		p1.value=sc.next().toUpperCase();
		if(p1.value.equals("X"))p2.value="O";
		else if(p1.value.equals("O"))p2.value="X";
		else {
			System.out.println(p1.name+" entered an invalid choice so the program terminates!");
			System.exit(0);
		}
		System.out.println(p2.name+", you are left with only one option so you will be the choice that's left ;) \"No Offense\" ");
		
		System.out.println("\n\nLets Start The Game!\n\nYou have to enter the position in order to place your value. The order goes from left to right.\n");
		int x=0;
		while(c<10) {
			 if(c%2!=0) {
				 System.out.print(p1.name+", enter the position(1-9) you wanna place your value at:");
				 x=sc.nextInt();
				 placeTheValue(x,p1.value);
			 }
			 else {
				 System.out.print(p2.name+", enter the position(1-9) you wanna place your value at:");
				 x=sc.nextInt();
				 placeTheValue(x,p2.value);
			 }
			 c++;
		}
		System.out.println("\n\n\t\t*** TIE ***");
		
	}
	
	public static void placeTheValue(int x,String p) { //passing position and value(X|O)
		switch(x) {
		case 1:{
			if(board[0][0].equals(" "))board[0][0]=p;
			else {
				
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 2:{
			if(board[0][2].equals(" "))board[0][2]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 3:{
			if(board[0][4].equals(" "))board[0][4]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 4:{
			if(board[2][0].equals(" "))board[2][0]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 5:{
			if(board[2][2].equals(" "))board[2][2]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 6:{
			if(board[2][4].equals(" "))board[2][4]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 7:{
			if(board[4][0].equals(" "))board[4][0]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 8:{
			if(board[4][2].equals(" "))board[4][2]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		case 9:{
			if(board[4][4].equals(" "))board[4][4]=p;
			else {
				System.out.print("Already done, so choose wisely and give your position again:");
				x=sc.nextInt();
				placeTheValue(x,p);
				break;
			}
			break;
		}
		default:System.out.println("Invalid input");System.exit(0);
		}
		print(board);
		if(win()) {
			System.out.println("\n\n\t\t*** Congrats you won!! ***");
			System.exit(0);
		}
	}
	
	public static boolean win() {
		
			if((board[0][0].equals(board[0][2]) && board[0][0].equals(board[0][4]) && !(board[0][0].equals(" "))) 
					|| (board[2][0].equals(board[2][2]) && board[2][0].equals(board[2][4]) && !(board[2][0].equals(" ")))
					|| (board[4][0].equals(board[4][2]) && board[4][0].equals(board[4][4]) && !(board[4][0].equals(" ")))
					|| (board[0][0].equals(board[2][0]) && board[0][0].equals(board[4][0]) && !(board[0][0].equals(" "))) 
					|| (board[0][2].equals(board[2][2]) && board[0][2].equals(board[4][2]) && !(board[0][2].equals(" ")))
					|| (board[0][4].equals(board[2][4]) && board[0][4].equals(board[4][4]) && !(board[0][4].equals(" ")))
					|| (board[0][0].equals(board[2][2]) && board[0][0].equals(board[4][4]) && !(board[0][0].equals(" ")))
					|| (board[0][4].equals(board[2][2]) && board[0][4].equals(board[4][0]) && !(board[0][4].equals(" "))))return true;
			else return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		decor();
		//print(board);
		
		System.out.print("Select/Enter your mode of playing: \n\n\t\t1. Single Player\n\n\t\t2. Two Players\n:::>>");
		
		int mode=sc.nextInt();
		if(mode==1) {
			SinglePlayer();
		}
		else if(mode==2) {
			MultiPlayer();
		}
		else {
			System.out.println("Wrong Input. . . Run The Program Again ! ! ! ;)");
		}
		
	}

}
