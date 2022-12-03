package application;

import java.util.Scanner;

import model.entities.JoKenPo;
import model.entities.Player;

public class Main {
	
	public static JoKenPo startGame () {
		System.out.println("*******  Jo-Ken-Pô Game  *******\n");
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Informe seu nome: ");
		String playerName = sc.next().toUpperCase();
		
		Player user = new Player(playerName);
		Player IA = new Player("IA");
		
		System.out.print(playerName + ", informe quantos rounds deseja jogar: ");
		int rounds = sc.nextInt();
		
		sc.close();
		
		return new JoKenPo(user, IA, rounds);
	}

	public static void main(String[] args) {
		
		JoKenPo jokenpo = startGame(); // Chamou o objeto responsável por conter a lógica do jogo
		jokenpo.toPlay();
		
		
	}

}
