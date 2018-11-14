package grafos;

import java.io.FileNotFoundException;

public class GrafoPorGrado extends Generador{

	private int grado;
	
	public GrafoPorGrado(int nodos, int grado) throws FileNotFoundException {
		super(nodos);
		
		this.grado = grado;
		
		if(nodos%2 == 1 && grado%2 == 1) 
			System.out.println("No se puede generar un grafo con " + nodos + " y " + grado);

		
		generar();
		calcularDatos();
		escribirArchivo("grafo2.in");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		if(this.grado %2 == 1) {		//si el grado es impar, conecto los nodos con sus opuestos 
			this.grado--;
			int hastaAca = this.getNodos()/2;
			for (int i = 0; i < hastaAca; i++) {
				this.setMat(i, i+hastaAca, 1);
			}
		}
		generarGrafoGradoPar();
	}

	private void generarGrafoGradoPar() {			//cuando el grado es par, se conectan en secuencia  
		// TODO Auto-generated method stub
		int nuevoLimite = this.grado/2;				//el primer ciclo de conecxion es grado/2 
		
		for (int i = 0; i < nuevoLimite; i++) {
			for (int j = 0; j < this.getNodos(); j++) {			//el
				if(j + i + 1 < this.getNodos()) {
					this.setMat(j, j + i + 1, 1);
				}else {
					this.setMat(j, j + i + 1 - this.getNodos(), 1);
				}
			}
		}
	}
	
	
}
