package model.entities;

import java.util.NoSuchElementException;
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
		
		for (int i = 0; i < rounds; i++) {
			int userChoice = userChoice();
			
			if (userChoice < 1 || userChoice > 3) {
				System.out.println("\nJOGADA INVÁLIDA! (1, 2 OU 3): ");
				System.out.println("\tPONTO PARA " + IA.getName() + "\n");
				IA.incrementScore(); // Contabiliza o score do player
			}
		}
		
	}
	
	// Método responsável pela escolha da jogada do player (Não consigo resolver a exceção)
	private int userChoice () {
		try {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("1 - PEDR A");
		System.out.println("2 - PAPEL ");
		System.out.println("3 - TESOURA ");
		System.out.print("Informe sua jogada: ");
		int userChoice = sc.nextInt();
		
		sc.close();
		
		return userChoice;
		}
		catch (NoSuchElementException exceptionInLine38) {
			System.out.println("Help me");
			exceptionInLine38.printStackTrace();
			return 0;
		}

	}
}
