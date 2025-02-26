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

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {


	@Test
	public void testAdjacents() {
		System.out.println("\nTest testAdjacents");
		System.out.println("----------------------");
		// Se construye el grafo.
		Graph<Integer> g = new Graph<Integer>();
		g.addEdge(1, 2);
		g.addEdge(1, 3);

		// Se construye el set de adyacencias esperado
		Set<Integer> expectedAdjacents = new HashSet<Integer>();
		expectedAdjacents.add(2);
		expectedAdjacents.add(3);

		// Se comprueba que los resultados sean los esperados
		assertEquals(expectedAdjacents, g.obtainAdjacents(1));
		assertNull(g.obtainAdjacents(4));
	}


	@Test
	public void testContainsVertex() {
		System.out.println("\nTest testContainsVertex");
		// Se construye el grafo.
		System.out.println("----------------------");
		Graph<Integer> g = new Graph<Integer>();
		g.addEdge(1, 2);
		g.addEdge(1, 3);

		// Se comprueba que los resultados sean los esperados
		assertTrue(g.containsVertex(1));
		assertTrue(g.containsVertex(2));
		assertFalse(g.containsVertex(4));
	}


	/**
	 * Este test comprueba que el metodo 'onePath(V v1, V v2)'
	 * encuentra un camino entre 'v1' y 'v2' cuando existe.
	 */
	@Test
	public void onePathFindsAPath(){
		System.out.println("\nTest onePathFindsAPath");
		System.out.println("----------------------");
		// Se construye el grafo.
		Graph<Integer> g = new Graph<Integer>();
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(1, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		// Se construye el camino esperado.
		List<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(1);
		expectedPath.add(5);
		expectedPath.add(6);
		expectedPath.add(4);
		//Se comprueba si el camino devuelto es igual al esperado.
		assertEquals(expectedPath, g.onePath(1, 4));
	}

	/**
	 * Este test comprueba que el metodo 'onePath(V v1, V v2)'
	 * retorna null cuando no encuentra un camino entre 'v1' y 'v2'.
	 */
	@Test
	public void onePathDoesNotFindAPath(){
		System.out.println("\nTest onePathDoesNotFindAPath");
		System.out.println("----------------------");
		// Se construye el grafo.
		Graph<Integer> g = new Graph<Integer>();
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(1, 5);
		g.addEdge(6, 4);
		//Se comprueba si el camino devuelto es nulo
		assertNull(g.onePath(1, 4));
	}
}