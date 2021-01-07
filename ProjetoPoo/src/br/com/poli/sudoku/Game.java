package br.com.poli.sudoku;

import java.util.Calendar; //Usando Calendar no lugar de DateTime
//Calendar é uma classe abstrata do próprio Java e não tem construtores, somente métodos

public class Game {
	private Player player;
	private Difficulty difficulty;
	private Calendar startTime;
	private Calendar endTime;
	
	public Game(){
		
	}

	public void startGame(Player player, Difficulty difficulty, Calendar startTime) // Armazena o nome do jogador e o horário de início do
																					// jogo.
	{
		this.difficulty = difficulty;
		this.player.setName(player.getName());
		this.startTime = startTime;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public void setStartTime() {
		this.startTime = Calendar.getInstance();
	}

	public void setEndTime() {
		this.endTime = Calendar.getInstance();
	}

	public void endGame(Calendar endTime) // Armazena o horário do término do jogo
	{
		this.endTime = endTime;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void initializeSudoku(int m, int n, int w, int c, int q, Cell[][] gridPlayer, Difficulty d)
			throws CellsFixedException {
		// TODO Auto-generated method stub
		
	}

}