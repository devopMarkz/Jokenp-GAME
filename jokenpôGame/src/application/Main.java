package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.JoKenPo;
import model.entities.Player;

public class Main {
	
	// Função que realiza a abertura do jogo e criação dos objetos Player
	public static JoKenPo startGame () {
		System.out.println("*******  Jo-Ken-Pô Game  *******\n");	
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Informe seu nome: ");
		String playerName = sc.next().toUpperCase();
		
		Player user = new Player(playerName);
		Player IA = new Player("IA");
		
		try {
			System.out.print(playerName + ", informe quantos rounds deseja jogar: ");
			int rounds = sc.nextInt();
			return new JoKenPo(user, IA, rounds);
		}
		catch (InputMismatchException e) {
			System.out.println("Número inválido. Você jogará três rodadas.");
			return new JoKenPo(user, IA, 3);
		}
	}

	public static void main(String[] args) {
		
		JoKenPo jokenpo = startGame(); // Instanciação do objeto responsável por conter a lógica do jogo
		jokenpo.toPlay(); // Chamada do método responsável por armazenar os comandos do jogo

	}

}
