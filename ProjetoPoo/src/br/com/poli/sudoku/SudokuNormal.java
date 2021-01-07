package br.com.poli.sudoku;

import java.util.Random;

public class SudokuNormal extends Sudoku {

	@Override
	public void initializeSudoku(int m, int n, int w, int c, int q, Cell[][] gridPlayer, Cell[][] gridPlayer1) throws CellsFixedException{
		gridPlayer = gridPlayer1;// PEGANDO OS VALORES INICIAIS
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					gridPlayer[i][j].getValue();
					loop(0, 3, 0, 3, 5);
					loop(0, 3, 3, 6, 10);
					loop(0, 3, 6, 9, 15);
					loop(3, 6, 0, 3, 20);
					loop(3, 6, 3, 6, 25);
					loop(3, 6, 6, 9, 30);
					loop(6, 9, 0, 3, 35);
					loop(6, 9, 3, 6, 40);
					loop(6, 9, 6, 9, 45);
				}
			}
		
		for (int i = 0; i < 9; i++) {// DEFINIDO SE O NUMERO É FIXO E VALIDO
			for (int j = 0; j < 9; j++) {
				if (gridPlayer[i][j].getValue() != 0) {
					gridPlayer[i][j].setFixed(true);
					gridPlayer[i][j].setValid(false);
					throw new CellsFixedException();
				}
			}
		}
	}

	

			
		
	}

