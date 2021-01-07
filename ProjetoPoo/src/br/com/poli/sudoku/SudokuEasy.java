package br.com.poli.sudoku;

public class SudokuEasy extends Sudoku {

	@Override
	public void initializeSudoku(int m, int n, int w, int c, int q, Cell[][] gridPlayer,Cell[][] gridPlayer1) throws CellsFixedException{
		gridPlayer = gridPlayer1;// PEGANDO OS VALORES INICIAIS
		
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					gridPlayer[i][j].getValue();
					loop(0, 3, 0, 3, 4);
					loop(0, 3, 3, 6, 8);
					loop(0, 3, 6, 9, 12);
					loop(3, 6, 0, 3, 16);
					loop(3, 6, 3, 6, 20);
					loop(3, 6, 6, 9, 24);
					loop(6, 9, 0, 3, 28);
					loop(6, 9, 3, 6, 32);
					loop(6, 9, 6, 9, 36);
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
