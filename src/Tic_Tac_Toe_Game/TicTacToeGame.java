package Tic_Tac_Toe_Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {

		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		printGameBoard(gameBoard);
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose number from 1 to 9:");
			int playerPos = sc.nextInt();
				while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos) ){
					System.out.println("position already taken! Enter a correct position");
					playerPos = sc.nextInt(); 
				}
				
			chooseLetter(gameBoard, playerPos, "player");
			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			Random random = new Random();
			int cpuPos = random.nextInt(9) + 1;
				while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos) ){
					cpuPos = random.nextInt(9) + 1; 
				}
			chooseLetter(gameBoard, cpuPos, "cpu");
			printGameBoard(gameBoard);
			
			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			
		}
		
	}

	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void chooseLetter(char [] [] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if (user.equals("player")) {
			symbol='X';
			playerPositions.add(pos);
		}
		else if (user.equals("cpu")) {
			symbol='O';
			cpuPositions.add(pos);
		}
		
		switch (pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
		
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List topCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List bottomCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> winningCounditions = new ArrayList<List>();
		winningCounditions.add(topRow);
		winningCounditions.add(midRow);
		winningCounditions.add(bottomRow);
		winningCounditions.add(topCol);
		winningCounditions.add(midCol);
		winningCounditions.add(bottomCol);
		winningCounditions.add(cross1);
		winningCounditions.add(cross1);
		
		for (List li : winningCounditions) {
			if (playerPositions.containsAll(li)) {
				return "Congractulation You Win!";
			}
			else if (cpuPositions.containsAll(li)) {
				return "CPU wins this game";
			}
			else if (playerPositions.size() + cpuPositions.size() == 9 ) {
				return "Match Draw ! No one wins !!";
			}
				
		}
		return "";
		
	}
			
}
