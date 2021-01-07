package br.com.poli.sudoku;

public class Cell {
	private int value;
	private boolean valid;
	private boolean fixed;
	private int x;
	private int y;

	public Cell(int value, boolean valid, boolean fixed) {
		this.value = value;
		this.valid = valid;
		this.fixed = fixed;

	}

	public Cell(int x, int y, int value) {

		this.x = x;
		this.y = y;
		this.value = value;

	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {

		this.value = value;
	}

	public boolean isValid() {
		return this.valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isFixed() {
		return this.fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
}
