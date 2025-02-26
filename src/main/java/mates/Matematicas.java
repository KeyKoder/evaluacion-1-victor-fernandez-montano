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

package mates;

public class Matematicas {
	/**
	 * Genera una aproximacion al número pi mediante el metodo de Montecarlo.
	 *
	 * @param pasos El número de puntos a generar.
	 * @return Una aproximación del número pi.
	 */
	public static double generarNumeroPi(long pasos){
		int aciertos = 0;
		double areaCuadrado = 4;
		double x, y;
		for (long i = 1; i <= pasos; i++) {
			x = RandomUtils.randomDouble(-1, 1);
			y = RandomUtils.randomDouble(-1, 1);
			if (Math.sqrt(x*x + y*y) <= 1) {
				aciertos++;
			}
		}
		return areaCuadrado * (aciertos/(double)pasos);
	}
}

