package grafos;

import java.io.FileNotFoundException;

public class GrafoAleatorioPorPorcDeAdyacencia extends Generador {

	private double porcAdy;
	
	public GrafoAleatorioPorPorcDeAdyacencia(int nodos, double porcDeAdy) throws FileNotFoundException {
		super(nodos);
		// TODO Auto-generated constructor stub
		this.porcAdy = porcDeAdy;
		
		generar();
		calcularDatos();
		escribirArchivo("grafo4.in");
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}

}
