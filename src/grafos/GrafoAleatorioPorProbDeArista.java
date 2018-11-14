package grafos;

import java.io.FileNotFoundException;

public class GrafoAleatorioPorProbDeArista extends Generador{
	
	private double probDeArista;

	public GrafoAleatorioPorProbDeArista(int nodos, double probParaArista) throws FileNotFoundException {
		super(nodos);
		// TODO Auto-generated constructor stub
		
		this.probDeArista = probParaArista;
		
		generar();
		calcularDatos();
		escribirArchivo("grafo3.in");
		
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < this.getNodos()-1; i++)
			for(int j = i+1; j < this.getNodos(); j++)
				if(Math.random() <= this.probDeArista)
					this.setMat(i,j,1);
		
	}

}
