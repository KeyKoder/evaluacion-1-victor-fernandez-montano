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

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args){
		if(args.length == 0){
			System.err.println("Error: El programa necesita por lo menos un parámetro para escoger la practica que ejecutar.");
			System.exit(1);
		}

		switch(args[0]) {
			case "1":
				System.out.println("El número PI es " + Matematicas.
					generarNumeroPi(Long.parseLong(args[1])));
				break;
			case "2":
				hacerConway();
				break;
			case "3":
				Graph<Integer> g = new Graph<>();
				g.addEdge(1, 2);
				g.addEdge(3, 4);
				g.addEdge(1, 5);
				g.addEdge(5, 6);
				g.addEdge(6, 4);
				g.onePath(1, 4).forEach(System.out::println);
				break;
			default:
				break;
		}
	}

	public static void hacerConway() {
		try {
			Tablero tablero = new Tablero();
			System.out.println("SIMULACIÓN CON TABLERO LEÍDO");
			tablero.leerEstadoActual();
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
}
