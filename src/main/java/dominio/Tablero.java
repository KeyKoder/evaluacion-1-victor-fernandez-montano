/*
Copyright 2025 Víctor Fernández Montaño
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied. See the License for the specific
language governing permissions and limitations under the
License.
*/

package dominio;

import java.io.*;

/**
 * Esta clase es responsable de leer el tablero de un fichero en forma de ceros y unos, ir transitando de
 * estados e ir mostrando dichos estados.
 */
public class Tablero {
	private static int DIMENSION = 30;
	private int[][] estadoActual; //matriz que representa el estado actual.
	private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];
	private static final String FILENAME = "matriz";


	/**
	 * Lee el estado inicial de un fichero llamado ‘matriz‘.
	 */
	public void leerEstadoActual() {
		int x = 0, y = 0;
		estadoActual = new int[DIMENSION][DIMENSION];
		try (FileReader fr = new FileReader(FILENAME)) {
			int chat = fr.read();
			while(chat != -1) {
				if(chat == '\n') {
					x = 0;
					y++;
					chat = fr.read();
					continue;
				}

				this.estadoActual[y][x] = chat == '0' ? 0 : 1;

				x++;
				chat = fr.read();
			}
		} catch (IOException e) {
			// Ignorar la excepcion y simplemente cargar ceros en la matriz
		}
		// Terminar de rellenar la matriz de ceros
		while(y < DIMENSION) {
			this.estadoActual[y][x] = 0;
			x++;
			if(x == DIMENSION) {
				x = 0;
				y++;
			}
		}
		this.generarEstadoSiguiente();
	}

	public void guardarEstadoActual() {
		try (FileWriter fw = new FileWriter(FILENAME)) {
			for(int y = 0; y < DIMENSION; y++) {
				for(int x = 0; x < DIMENSION; x++) {
					fw.write(String.valueOf(this.estadoActual[y][x]));
				}
				fw.write("\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void transitarAlEstadoSiguiente(){
		this.estadoActual = this.estadoSiguiente;
		this.generarEstadoSiguiente();
	}

	private void generarEstadoSiguiente() {
		int vecinos = 0;
		this.estadoSiguiente = new int[DIMENSION][DIMENSION];
		for(int y = 0; y < DIMENSION; y++) {
			for(int x = 0; x < DIMENSION; x++) {
				vecinos = 0;
				if(x > 0) {
					if(this.estadoActual[y][x-1] == 1) vecinos++;

					if(y > 0) {
						if(this.estadoActual[y-1][x-1] == 1) vecinos++;
					}
					if(y < DIMENSION - 1) {
						if(this.estadoActual[y+1][x-1] == 1) vecinos++;
					}
				}
				if(x < DIMENSION - 1) {
					if(this.estadoActual[y][x+1] == 1) vecinos++;

					if(y > 0) {
						if(this.estadoActual[y-1][x+1] == 1) vecinos++;
					}
					if(y < DIMENSION - 1) {
						if(this.estadoActual[y+1][x+1] == 1) vecinos++;
					}
				}
				if(y > 0) {
					if(this.estadoActual[y-1][x] == 1) vecinos++;
				}
				if(y < DIMENSION - 1) {
					if(this.estadoActual[y+1][x] == 1) vecinos++;
				}

//				System.out.println(x + ", " + y + " -> " + vecinos + " (" + this.estadoActual[y][x] + ")");
				if(this.estadoActual[y][x] == 1 && (vecinos == 2 || vecinos == 3)) {
					this.estadoSiguiente[y][x] = 1;
				} else if(this.estadoActual[y][x] == 0 && vecinos == 3) {
					this.estadoSiguiente[y][x] = 1;
				}else {
					this.estadoSiguiente[y][x] = 0;
				}
			}
		}
	}

	@Override
	public String toString() {
		String out = "";
		for(int y = 0; y < DIMENSION; y++) {
			for(int x = 0; x < DIMENSION; x++) {
				out += estadoActual[y][x] == 1 ? 'x' : ' ';
			}
			out += '\n';
		}
		return out;
	}
}
