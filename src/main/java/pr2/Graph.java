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

package pr2;

import java.util.*;

public class Graph<V> {
	private Map<V, Set<V>> adjacencyList = new HashMap<>();

	/**
	 * Añade el vértice ‘v‘ al grafo.
	 *
	 * @param v vértice a añadir.
	 * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso
	 * contrario.
	 */
	public boolean addVertex(V v) {
		if(this.adjacencyList.containsKey(v)) {
			return false;
		}
		this.adjacencyList.put(v, new HashSet<V>());
		return true;
	}

	/**
	 * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo. En
	 * caso de que no exista alguno de los vértices, lo añade
	 * también.
	 *
	 * @param v1 el origen del arco.
	 * @param v2 el destino del arco.
	 * @return ‘true‘ si no existía el arco y ‘false‘ en caso
	contrario.
	 */
	public boolean addEdge(V v1, V v2) {
		this.addVertex(v1);
		this.addVertex(v2);
		this.adjacencyList.get(v1).add(v2);
		this.adjacencyList.get(v2).add(v1);
		return true;
	}

	/**
	 * Obtiene el conjunto de vértices adyacentes a ‘v‘.
	 *
	 * @param v vértice del que se obtienen los adyacentes.
	 * @return conjunto de vértices adyacentes.
	 */
	public Set<V> obtainAdjacents(V v) throws Exception {
		return this.adjacencyList.get(v);
	}

	/**
	 * Comprueba si el grafo contiene el vértice dado.
	 *
	 * @param v vértice para el que se realiza la comprobación.
	 * @return ‘true‘ si ‘v‘ es un vértice del grafo.
	 */
	public boolean containsVertex(V v) {
		return this.adjacencyList.containsKey(v);
	}

	/**
	 * Metodo ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
	 * @return una cadena de caracteres con la lista de
	 * adyacencia.
	 */
	@Override
	public String toString() {
		return ""; //Este código hay que modificarlo.
	}

	/**
	 * Obtiene, en caso de que exista, un camino entre ‘v1‘ y
	 * ‘v2‘. En caso contrario, devuelve ‘null‘.
	 *
	 * @param v1 el vértice origen.
	 * @param v2 el vértice destino.
	 * @return lista con la secuencia de vértices desde ‘v1‘ hasta
	 * ‘v2‘ * pasando por arcos del grafo.
	 */
	public List<V> onePath(V v1, V v2) {
		return null; //Este código hay que modificarlo.
	}
}
