package br.com.poli.sudoku;

public class SudokuHard extends Sudoku {

	@Override
	public void initializeSudoku(int m, int n, int w, int c, int q, Cell[][] gridPlayer,Cell[][] gridPlayer1) throws CellsFixedException{
		gridPlayer = gridPlayer1;// PEGANDO OS VALORES INICIAIS
	
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					gridPlayer[i][j].getValue();
					loop(0, 3, 0, 3, 6);
					loop(0, 3, 3, 6, 13);
					loop(0, 3, 6, 9, 20);
					loop(3, 6, 0, 3, 26);
					loop(3, 6, 3, 6, 33);
					loop(3, 6, 6, 9, 39);
					loop(6, 9, 0, 3, 46);
					loop(6, 9, 3, 6, 53);
					loop(6, 9, 6, 9, 59);
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
