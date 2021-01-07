package br.com.poli.sudoku;

public enum Difficulty {
	EASY("facil"), NORMAL("normal"), HARD("dificil");

	private String description;

	public String getDifficulty() {
		return description;
	}

	Difficulty(String description) {
		this.description = description;
	}

}
