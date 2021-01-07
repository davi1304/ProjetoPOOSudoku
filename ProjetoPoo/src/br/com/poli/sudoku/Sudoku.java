package br.com.poli.sudoku;

import java.util.Random;

public abstract class Sudoku extends Game {

	int z = 0;// GLOBAL PARA A CONTAGEM DO METODO LOOP()
	private long totalTime;
	private Cell[][] gridPlayer = new Cell[9][9];// USADA PARA A NOVA MATRIZ
	private Cell[][] gridPlayer1 = new Cell[9][9];// USADA PARA A MATRIZ SOLUÇÃO

	public Sudoku() {// DECLARANDO OS VALORES DA MATRIZ SOLUÇÃO
		super();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.gridPlayer1[i][j] = new Cell(0, true, false);
			}
		}
		gridPlayer1[0][0].setValue(3);
		gridPlayer1[0][1].setValue(2);
		gridPlayer1[0][2].setValue(4);
		gridPlayer1[0][3].setValue(1);
		gridPlayer1[0][4].setValue(5);
		gridPlayer1[0][5].setValue(8);
		gridPlayer1[0][6].setValue(7);
		gridPlayer1[0][7].setValue(9);
		gridPlayer1[0][8].setValue(6);

		gridPlayer1[1][0].setValue(5);
		gridPlayer1[1][1].setValue(8);
		gridPlayer1[1][2].setValue(7);
		gridPlayer1[1][3].setValue(9);
		gridPlayer1[1][4].setValue(6);
		gridPlayer1[1][5].setValue(3);
		gridPlayer1[1][6].setValue(4);
		gridPlayer1[1][7].setValue(1);
		gridPlayer1[1][8].setValue(2);

		gridPlayer1[2][0].setValue(6);
		gridPlayer1[2][1].setValue(1);
		gridPlayer1[2][2].setValue(9);
		gridPlayer1[2][3].setValue(7);
		gridPlayer1[2][4].setValue(4);
		gridPlayer1[2][5].setValue(2);
		gridPlayer1[2][6].setValue(3);
		gridPlayer1[2][7].setValue(8);
		gridPlayer1[2][8].setValue(5);

		gridPlayer1[3][0].setValue(7);
		gridPlayer1[3][1].setValue(4);
		gridPlayer1[3][2].setValue(3);
		gridPlayer1[3][3].setValue(2);
		gridPlayer1[3][4].setValue(1);
		gridPlayer1[3][5].setValue(5);
		gridPlayer1[3][6].setValue(9);
		gridPlayer1[3][7].setValue(6);
		gridPlayer1[3][8].setValue(8);

		gridPlayer1[4][0].setValue(1);
		gridPlayer1[4][1].setValue(9);
		gridPlayer1[4][2].setValue(2);
		gridPlayer1[4][3].setValue(8);
		gridPlayer1[4][4].setValue(7);
		gridPlayer1[4][5].setValue(6);
		gridPlayer1[4][6].setValue(5);
		gridPlayer1[4][7].setValue(4);
		gridPlayer1[4][8].setValue(3);

		gridPlayer1[5][0].setValue(8);
		gridPlayer1[5][1].setValue(6);
		gridPlayer1[5][2].setValue(5);
		gridPlayer1[5][3].setValue(4);
		gridPlayer1[5][4].setValue(3);
		gridPlayer1[5][5].setValue(9);
		gridPlayer1[5][6].setValue(1);
		gridPlayer1[5][7].setValue(2);
		gridPlayer1[5][8].setValue(7);

		gridPlayer1[6][0].setValue(2);
		gridPlayer1[6][1].setValue(7);
		gridPlayer1[6][2].setValue(6);
		gridPlayer1[6][3].setValue(5);
		gridPlayer1[6][4].setValue(9);
		gridPlayer1[6][5].setValue(4);
		gridPlayer1[6][6].setValue(8);
		gridPlayer1[6][7].setValue(3);
		gridPlayer1[6][8].setValue(1);

		gridPlayer1[7][0].setValue(4);
		gridPlayer1[7][1].setValue(5);
		gridPlayer1[7][2].setValue(8);
		gridPlayer1[7][3].setValue(3);
		gridPlayer1[7][4].setValue(2);
		gridPlayer1[7][5].setValue(1);
		gridPlayer1[7][6].setValue(6);
		gridPlayer1[7][7].setValue(7);
		gridPlayer1[7][8].setValue(9);

		gridPlayer1[8][0].setValue(9);
		gridPlayer1[8][1].setValue(3);
		gridPlayer1[8][2].setValue(1);
		gridPlayer1[8][3].setValue(6);
		gridPlayer1[8][4].setValue(8);
		gridPlayer1[8][5].setValue(7);
		gridPlayer1[8][6].setValue(2);
		gridPlayer1[8][7].setValue(5);
		gridPlayer1[8][8].setValue(4);

	}

	public void setValueGrid(int x, int y, int value) throws CellValueException, CellsFixedException, GenericException {// SE VAI MUDAR OU
																										                // NÃO A MATRIZ
		try {																								            // SUDOKU
		int anterior = this.gridPlayer[x][y].getValue();
		this.gridPlayer[x][y].setValue(value);
		if (value > 0 && value < 10) {
			this.gridPlayer[x][y].setValid(true);

			if (this.checkValidation(this.gridPlayer[x][y]) == true) {
				System.out.println("Numero valido");
				this.gridPlayer[x][y].setValue(value);
			} 
			else
				this.gridPlayer[x][y].setValue(anterior);
		} 
		else {
			throw new GenericException();		
		}
			} catch (IllegalArgumentException e) {
				System.out.println("Valor Inválido");
			}
	}

	public boolean checkValidation(Cell cell) throws CellValueException, CellsFixedException {
		if (cell.isFixed()) { // VER SE O NUMERO É FIXO
			System.out.println("Numero fixo");
			return false;
		} else {

			int i = 0;
			int j = 0;

			for (int x = 0; x < 9; x++) {// MONTAR A MATRIZ
				for (int y = 0; y < 9; y++) {
					if (cell.toString().equals(gridPlayer[x][y].toString())) {
						i = x;
						j = y;
						x = 9;
						y = 9;
					}
				}
			}

			try {
				for (int k = 0; k < 9; k++) {// CHECAR A COLUNA
					if (cell.getValue() == gridPlayer[k][j].getValue() && k != i) {
						throw new CellValueException();
					}
				}
			} catch (Exception e) {
				System.out.println("Numero igual na mesma coluna");
			}
			try {
				for (int k = 0; k < 9; k++) {// CHECAR A LINHA
					if (cell.getValue() == gridPlayer[i][k].getValue() && k != j) {
						throw new CellValueException();
					}
				}
			} catch (Exception e2) {
				System.out.println("Numero igual na mesma linha");
			}
			// CHECAR A VALIDEZ DAS MATRIZES, BLOCO POR BLOCO 3x3
			try {
				if ((i / 3 == 0) && (j / 3 == 0)) {// CHECAR A PRIMEIRA MATRIZ 3X3
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 0 && j / 3 == 1) {// CHECAR A SEGUNDA MATRIZ 3X3
					for (int k = 0; k < 3; k++) {
						for (int l = 3; l < 6; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 0 && j / 3 == 2) {// CHECAR A TERCEIRA MATRIZ 3X3
					for (int k = 0; k < 3; k++) {
						for (int l = 6; l < 9; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 1 && j / 3 == 0) {// CHECAR A QUARTA MATRIZ 3X3
					for (int k = 3; k < 6; k++) {
						for (int l = 0; l < 3; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 1 && j / 3 == 1) {// CHECAR A QUINTA MATRIZ 3X3
					for (int k = 3; k < 6; k++) {
						for (int l = 3; l < 6; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 1 && j / 3 == 2) {// CHECAR A SEXTA MATRIZ 3X3
					for (int k = 3; k < 6; k++) {
						for (int l = 6; l < 9; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 2 && j / 3 == 0) {// CHECAR A SÉTIMA MATRIZ 3X3
					for (int k = 6; k < 9; k++) {
						for (int l = 0; l < 3; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 2 && j / 3 == 1) {// CHECAR A OITAVA MATRIZ 3X3
					for (int k = 6; k < 9; k++) {
						for (int l = 3; l < 6; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
				if (i / 3 == 2 && j / 3 == 2) {// CHECAR A NONA MATRIZ 3X3
					for (int k = 6; k < 9; k++) {
						for (int l = 6; l < 9; l++) {
							if (cell.getValue() == gridPlayer[k][l].getValue() && k != i && l != j) {
								throw new CellValueException();
							}
						}
					}
				}
			} catch (Exception e3) {
				System.out.println("Numero igual na mesma matriz 3x3");
			}

		}
			return true;// SE RETORNAR TRUE, MODIFICA O VALOR DA CELULA
		}

	public abstract void initializeSudoku (int m, int n, int w, int c, int q, Cell[][] gridPlayer,Cell[][] gridPlayer1) throws CellsFixedException ;// RESPONSAVEL POR GERAR UMA NOVA MATRIZ

	

	public void loop(int m, int n, int w, int c, int q) {// LOOP RESPONSAVEL POR GERAR ZEROS ALEATORIOS NA MATRIZ
														// SOLUÇÃO
		Random gera = new Random();
		while (z < q) {
		for (int k = m; k < n; k++) {
			for (int l = w; l < c; l++) {
				if (z < q) {
					if ((gera.nextInt(10)) == 8 && this.gridPlayer[k][l].getValue() != 0) {
						this.gridPlayer[k][l].setValue(0);
						z++;
						}
					}
				}
			}
		}
	}

		
	
	public Cell getCell(int x, int y) {
		return gridPlayer[x][y];
	}

	public long getTotalTime() {
		return this.totalTime = getEndTime().getTimeInMillis() - getStartTime().getTimeInMillis();
	}

	public Cell[][] getGridPlayer() {
		return this.gridPlayer;
	}

	public Cell[][] getGridPlayer1() {
		return this.gridPlayer1;
	}

}