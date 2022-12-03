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
			}
		}
		
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
