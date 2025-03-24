package Sessio2POO;

import java.util.Random;

public class Taulell {

	private int taulell[][];
	private int filesPlenes;
	private int copsAmpliat;

	public Taulell(int fil, int col, int quants) {
		taulell = new int[fil][col];
		Random rand = new Random();
		int comptador = 0;

		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				if (comptador < quants) {
					taulell[i][j] = rand.nextInt(1, 10);
					comptador++;
					filesPlenes = i + 1;
				} else {
					taulell[i][j] = 0;
				}
			}
		}

	}

	public void visualitzar() {
		for (int i = 0; i < filesPlenes; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				if (taulell[i][j] == 0) {
					System.out.print("X ");
				} else {
					System.out.print(taulell[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public int getCopsAmpliat() {
		return copsAmpliat;
	}

	public void buidaComponent(int fila, int col) {
		if (fila >= 0 && fila < taulell.length && col >= 0 && col < taulell[0].length) {
			taulell[fila][col] = 0;
		} else {
			System.out.println("Posició fora dels límits del tauler.");
		}
	}

	public boolean parellaContingut(int fil1, int col1, int fil2, int col2) {
		if (fil1 >= 0 && fil1 < taulell.length && col1 >= 0 && col1 < taulell[0].length && fil2 >= 0
				&& fil2 < taulell.length && col2 >= 0 && col2 < taulell[0].length && (fil1 != fil2 || col1 != col2)
				&& taulell[fil1][col1] != 0 && taulell[fil2][col2] != 0) {
			return taulell[fil1][col1] + taulell[fil2][col2] == 10 || taulell[fil1][col1] == taulell[fil2][col2];
		}
		return false;
	}

	public boolean parellaHoritzontal(int fil1, int col1, int fil2, int col2) {
		int start = Math.min(col1, col2);
		int end = Math.max(col1, col2);

		for (int j = start + 1; j < end; j++) {
			if (taulell[fil1][j] != 0) {
				return false;
			}
		}

		return true;
	}

	public boolean parellaVertical(int fil1, int col1, int fil2, int col2) {
		for (int i = fil1 + 1; i < fil2; i++) {
			if (taulell[i][col1] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean parellaDiagonal(int fil1, int col1, int fil2, int col2) {
		int start = Math.min(col1, col2);
		int end = Math.max(col1, col2);
		for (int i = start + 1; i < end; i++) {
			if (taulell[fil1 + i - start][i] != 0) {
				return false;
			}
		}

		return true;
	}

	public void afegir() {
		int[] vector = new int[filesPlenes * taulell[0].length];
		int index = 0;

		for (int i = 0; i < filesPlenes; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				if (taulell[i][j] != 0) {
					vector[index++] = taulell[i][j];
				}
			}
		}

		for (int i = filesPlenes; i < filesPlenes + 4; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				taulell[i][j] = vector[index];
				index = (index + 1) % (filesPlenes * taulell[0].length);
			}
		}

		filesPlenes += 4;
	}

	public boolean isBuida(int fila) {
		for (int j = 0; j < taulell[fila].length; j++) {
			if (taulell[fila][j] != 0) {
				return false;
			}
		}
		return true;
	}

	public void eliminarFila(int fila) {
		int i = fila;
		int j = 0;
		int cont = 0;

		while (cont < taulell.length - 1 - fila) {
			while (j < taulell[i].length) {
				taulell[i][j] = taulell[i + 1][j];
				j++;
			}
			cont++;
			i++;
			j = 0;
		}

		filesPlenes--;
	}

	public Taulell copia() {
		Taulell taulellCopia = new Taulell(taulell.length, taulell[0].length, 0);

		for (int i = 0; i < taulell.length; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				taulellCopia.taulell[i][j] = taulell[i][j];
			}
		}

		taulellCopia.filesPlenes = filesPlenes;
		taulellCopia.copsAmpliat = copsAmpliat;

		return taulellCopia;
	}

	public boolean isBuit() {
		for (int i = 0; i < filesPlenes; i++) {
			for (int j = 0; j < taulell[i].length; j++) {
				if (taulell[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public int getCellValue(int row, int col) {
		return taulell[row][col];
	}

}
