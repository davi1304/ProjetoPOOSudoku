package br.com.poli.sudoku;

public class Player {
	private String namePlayer;

	public Player(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public String getName() // pega o nome
	{
		return this.namePlayer;
	}

	public void setName(String namePlayer) // altera o nome
	{
		this.namePlayer = namePlayer;

	}
}
