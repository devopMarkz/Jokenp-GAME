package model.entities;

// Classe que contém os jogadores e suas características
public class Player {
	
	// Atributos da classe
	private String name;
	private Integer score;
	
	//Construtores da classe
	public Player () {
	}
	
	public Player (String name) {
		this.name = name;
		this.score = 0; // Quando instanciado, o jogador começa com score 0
	}

	// Métodos getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}
	
}
