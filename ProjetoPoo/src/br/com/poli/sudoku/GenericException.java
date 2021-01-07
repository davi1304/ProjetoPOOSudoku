package br.com.poli.sudoku;

public class GenericException extends RuntimeException {
	
	public GenericException () {
		super("Número inválido");
	}
}
