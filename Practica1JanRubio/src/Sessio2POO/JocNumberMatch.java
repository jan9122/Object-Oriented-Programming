package Sessio2POO;

import Keyboard.*;

public class JocNumberMatch {

	private static boolean esParella(Taulell taulell, int fil1, int col1, int fil2, int col2) {
		if ((taulell.getCellValue(fil1, col1) + taulell.getCellValue(fil2, col2) == 10)
				|| (taulell.getCellValue(fil1, col1) == taulell.getCellValue(fil2, col2))) {
			if (fil1 - col1 == fil2 - col2) {
				return taulell.parellaDiagonal(fil1, col1, fil2, col2);
			} else if (col1 == col2) {
				return taulell.parellaVertical(fil1, col1, fil2, col2);
			} else {
				return taulell.parellaHoritzontal(fil1, col1, fil2, col2);
			}
		}
		return false;

	}

	private static int llegirValor(int minim, int maxim, String text) {
		int valor;
		do {
			valor = Keyboard.readInt();
			if (valor < minim || valor > maxim) {
				System.out.println(text);
			}
		} while (valor < minim || valor > maxim);
		return valor;
	}

	private static char llegirChar() {
		char valor;

		do {
			valor = Keyboard.readChar();
			if (valor != 's' && valor != 'n') {
				System.out.println("Digues 's' per dir que Si y 'n' per dir que No. ");
			}
		} while (valor != 's' && valor != 'n');
		return valor;
	}

	public static void main(String[] args) {
		Taulell taulell = new Taulell(12, 9, 36);

		Taulell copia = taulell.copia();
		int numFiles = 4;
		int plus = 0;
		boolean end = false;
		System.out.println("NUMBER MATCH. Comença la partida");
		System.out.println("********************************");
		System.out.println("Estat inicial: Taulell creat");
		while (!taulell.isBuit() && !end) {
			taulell.visualitzar();
			System.out.println("Que vols fer");
			System.out.println("************");
			System.out.println("1.- Aparellar");
			System.out.println("2.- Posar més números -màxim 2 cops");
			System.out.println("3.- Acabar");
			int preg = llegirValor(1, 3, "Indica un numero dins de las opcions.");
			if (preg == 1) {
				System.out.println("INDICA ELS ÍNDEXS DE LES COMPONENTS QUE VOLS APARELLAR");
				System.out.println("ENTRAR PRIMER LA COMPONENT QUE ESTÀ MÉS AMUNT I ESQUERRA. FEM CONFIANÇA");
				// Demana les dades a l'usuari
				System.out.println("Indica la fila de la primera component");
				int fil1 = llegirValor(0, numFiles - 1, "Indica un numero dins de las opcions.");
				System.out.println("Indica la columna de la primera component");
				int col1 = llegirValor(0, 9, "Indica un numero dins de las opcions.");
				System.out.println("Indica la fila de la segon component");
				int fil2 = llegirValor(0, numFiles - 1, "Indica un numero dins de las opcions.");
				System.out.println("Indica la columna de la segon component");
				int col2 = llegirValor(0, 9, "Indica un numero dins de las opcions.");
				if (taulell.getCellValue(fil1, col1) == 0 || taulell.getCellValue(fil2, col2) == 0) {
					System.out.println(
							"Alguna de les caselles seleccionades és buida. Torna a seleccionar una parella vàlida.");
					System.out.println();
					continue;
				}
				if (fil1 == fil2 && col1 == col2) {
					System.out.println(
							"Les dues caselles seleccionades han de ser diferents. Torna a seleccionar una parella vàlida.");
					System.out.println();
					continue;
				}
				if (!esParella(taulell, fil1, col1, fil2, col2)) {
					System.out.println(
							"Les componentes seleccionades no formen una parella. Torna a seleccionar una parella vàlida.");
					System.out.println();
					continue;
				}
				System.out.println("Fan Parella.");
				taulell.buidaComponent(fil1, col1);
				taulell.buidaComponent(fil2, col2);
				if (taulell.isBuida(fil1)) {
					System.out.println("Eliminada fila de índice " + fil1);
					taulell.eliminarFila(fil1);
					numFiles--;
				}
				if (taulell.isBuida(fil2) && fil1 != fil2) {
					System.out.println("Eliminada fila de índice " + fil2);
					taulell.eliminarFila(fil2);
					numFiles--;
				}
			} else if (preg == 2 && plus < 2) {
				taulell.afegir();
				numFiles += 4;
				plus++;
			} else if (preg == 2 && plus >= 2) {
				System.out.println();
				System.out.println("Ja has fet el maxim de ampliacions.");
				System.out.println();
			} else {
				System.out.print("Vols fer una nova partida (s/n)? ");
				char rep = llegirChar();
				if (rep == 's') {
					System.out.print("Vols repetir l mateix taulell? (s/n)? ");
					char taul = llegirChar();
					if (taul == 's') {
						taulell = copia.copia();
					} else {
						taulell = new Taulell(12, 9, 36);
					}
				} else {
					System.out.println();
					System.out.println("**************");
					System.out.println("**** Adeu ****");
					System.out.println("**************");
					end = true;
				}
			}
		}
		if (taulell.isBuit()) {
			System.out.println("¡Felicidades! Has vaciado el tablero.");
		}
	}
}
