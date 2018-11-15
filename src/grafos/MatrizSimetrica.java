package grafos;

import java.util.Vector;

public class MatrizSimetrica {
	
	public Vector<Vector<Integer>> generarMatriz(int cantNodos, int[][] listadoAdyacencia) {
		Vector<Vector<Integer>> vector = new Vector<Vector<Integer>>();
		
		for (int i = 0; i < listadoAdyacencia.length; i++) {
			int origen = listadoAdyacencia[i][0];
			int destino = listadoAdyacencia[i][1];
			vector.get( origen ).addElement(destino);
		}
		return vector;
	}
}