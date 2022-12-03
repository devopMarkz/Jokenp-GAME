package model.entities;

import java.util.Random;
import java.util.Scanner;

// Classe que contém a lógica do jogo
public record JoKenPo(
		Player user,
		Player IA,
		int rounds
) {
	
	// Método que executa as jogadas
	public void toPlay() {
		System.out.println("\n*******  SEJA BEM VINDO(A), " + user.getName() + "  *******\n");
		
		for (int i = 1; i <= rounds; i++) {
			int userChoice = userChoice();
			
			if (userChoice < 1 || userChoice > 3) {
				System.out.println("\nJOGADA INVÁLIDA! (1, 2 OU 3): ");
				System.out.println("\tPONTO PARA " + IA.getName() + "\n");
				IA.incrementScore(); // Contabiliza o score do player
				continue;
			}
			
			int iaChoice = iaChoice();
			
			System.out.print("\n" + userChoice + " X " + iaChoice + "\n");
			
			int result = userChoice - iaChoice;
			
			winnerRound(result);
		}
		
	}
	
	// Método que exibe o vencedor do jogo
	public void showFinalResult () {
		System.out.println("\n*****************************************************\n");
		
		int finalScoreUser = user.getScore();
		int finalScoreIA = IA.getScore();
	
		System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getScore()
		+ " X " + IA.getScore() + " " + IA.getName());
		
		if (finalScoreUser == finalScoreIA) {
			System.out.println("\t\tEMPATE!");
		}
		else {
			String finalWinner = (finalScoreUser > finalScoreIA)? user.getName() :IA.getName();
			System.out.println("\t\tCAMPEÃO: " + finalWinner.toUpperCase());
		}
		
		System.out.println("\n*****************************************************\n");
	}
	
	
	// Lógica de pontuação de jogador por rodada
	private void winnerRound (int result) {
		String winnerRound;
		if (result == 0) {
			winnerRound = "EMPATE!";
		}
		else if (result == -1 || result == 2) {
			IA.incrementScore();
			winnerRound = IA().getName();
		}
		else {
			user.incrementScore();
			winnerRound = user().getName();
		}
		System.out.println("\nVencedor do round: " + winnerRound + "\n");
	}
	
	// Método responsável pela escolha da jogada do Player IA (Máquina)
	private int iaChoice () {
		Random jogada = new Random();
		return jogada.nextInt(3) + 1;
	}
	
	// Método responsável pela escolha da jogada do Player user
	private int userChoice () {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("1 - PEDRA");
		System.out.println("2 - PAPEL");
		System.out.println("3 - TESOURA");
		System.out.print("Informe sua jogada: ");
		int userChoice = sc.nextInt();
		
		return userChoice;
	}
}
