package br.com.poli.sudoku;

public class CellsFixedException extends Exception {

	public CellsFixedException() {
		super("Número fixo");
	}
}