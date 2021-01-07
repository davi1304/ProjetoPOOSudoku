package br.com.poli.sudoku;

public class CellValueException extends Exception {

	public CellValueException() {
		super("Número inválido");
	}
}
