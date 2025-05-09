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

public class RandomUtils {

	/**
	 * Genera un double aleatorio en el rango especificado.
	 * @param min El valor minimo del double a generar (inclusivo)
	 * @param max El valor minimo del double a generar (exclusivo)
	 * @return Un numero aleatorio en el rango [min, max)
	 */
	public static double randomDouble(double min, double max) {
		return (Math.random() * (max - min)) + min;
	}
}
