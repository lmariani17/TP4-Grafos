package grafos;

import java.io.FileNotFoundException;


public class GrafoPorProbabilidad extends Generador{
	
	private double probabilidad;
	
	public GrafoPorProbabilidad( int nodos, double prob) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(nodos);
		this.probabilidad = prob;
		generar();
		calcularDatos();
		escribirArchivo("grafo.in");
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.getNodos()-2; i++)
			for(int j = i+1; j < this.getNodos()-1; j++)
				if(Math.random() <= this.probabilidad)
					this.setMat(i,j,1);
	}
}
