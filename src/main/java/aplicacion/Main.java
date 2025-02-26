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

package aplicacion;

import dominio.Tablero;
import mates.Matematicas;
import pr2.Graph;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args){
		if(args.length == 0){
			System.err.println("Error: El programa necesita por lo menos un parámetro numérico (1, 2 o 3) para escoger la practica que ejecutar.");
			System.exit(1);
		}

		switch(args[0]) {
			case "1":
				if(args.length >= 2) {
					System.out.println("El número PI es " + Matematicas.
							generarNumeroPi(Long.parseLong(args[1])));
				}else {
					System.out.println("Necesitas aportar un número de pasos como segundo argumento.");
				}
				break;
			case "2":
				hacerConway();
				break;
			case "3":
				if(args.length >= 3) {
					hacerGrafo(args[1], args[2]);
				}else {
					System.out.println("Necestas aportar el nodo inicio y el nodo final como argumentos.");
				}
				break;
			default:
				break;
		}
	}

	public static void hacerConway() {
		try {
			Tablero tablero = new Tablero();
			System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
			if(!tablero.leerEstadoActual()) {
				System.err.println("El fichero 'matriz' no existe o está malformado, revise que el fichero exista y esté en el formato correcto.");
				System.exit(1);
			}
			System.out.println(tablero);
			for(int i = 0; i <= 5; i++) {
				TimeUnit.SECONDS.sleep(1);
				tablero.transitarAlEstadoSiguiente();
				System.out.println(tablero);
			}
			System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
			tablero.generarEstadoActualPorMontecarlo();
			System.out.println(tablero);
			for(int i = 0; i <= 15; i++) {
				TimeUnit.SECONDS.sleep(1);
				tablero.transitarAlEstadoSiguiente();
				System.out.println(tablero);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void hacerGrafo(String nodoInicial, String nodoFinal) {
		// TODO: Preguntar si las conexiones entre vertices tienen direccion.
		// Por ahora asumimos que no tienen
		Graph<String> g = Graph.leerDeArchivo("graph");
		if(g == null) {
			System.err.println("No se ha podido leer el archivo 'graph', revise si existe y si está en el formato correcto.");
			System.exit(1);
		}

		System.out.println("Grafo:");
		System.out.println(g);
		System.out.println("\nPath:");
		List<String> path = g.onePath(nodoInicial, nodoFinal);
		if(path != null) path.forEach(System.out::println);
		else System.out.println("NO hay camino entre los nodos " + nodoInicial + " y " + nodoFinal);
	}
}
