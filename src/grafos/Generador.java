package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Generador {
	
	private int aristas;
	private int nodos;
	private double porAdy;
	private double[] vecGrado;
	private double[][] mat;
	private double gradoMax;
	private double gradoMin;
	
	public Generador(int nodos){
		this.nodos = nodos;
		vecGrado = new double[(int) this.nodos];
		mat = new double[(int) this.nodos][(int) this.nodos];
	}
	
	public abstract void generar();

	public double getNodos() {
		return nodos;
	}

	public void setNodos(int nodos) {
		this.nodos = nodos;
	}

	public double getPorAdy() {
		return porAdy;
	}

	public void setPorAdy(double porAdy) {
		this.porAdy = porAdy;
	}

	public double getVecGrado(int i) {
		return vecGrado[i];
	}

	public void setVecGrado(int i) {
		this.vecGrado[i]++;
	}

	public double getMat(int i, int j) {
		return mat[i][j];
	}

	public void setMat(int i, int j, double valor) {
		this.mat[i][j] = valor;
		this.mat[j][i] = valor;
	}

	public double getAristas() {
		return aristas;
	}

	
	
	public void calcularDatos() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.getNodos()-1; i++){
			for(int j = 0; j < this.getNodos()-1; j++){
				if(this.getMat(i, j) == 1){
					this.aristas++;
					this.vecGrado[i]++;
				}
			}
		}
		
		this.aristas /= 2;
		
		buscarGradoMax();
		
		double aristasMaximas = (this.nodos*(this.nodos-1))/2 ;
		this.setPorAdy(this.aristas/aristasMaximas);
		
		System.out.println(aristasMaximas + " " +  this.aristas);
	}
	

	public void escribirArchivo(String path) throws FileNotFoundException {
		// TODO Auto-generated method stub
		/*en honor a lucho*/

		PrintWriter salida = new PrintWriter(new File(path));
		salida.println(this.nodos + " " + this.aristas + " " + this.porAdy + " " + this.gradoMax + " " + this.gradoMin);

		for(int i = 0; i < this.nodos-1; i++)
			for(int j = 0; j < this.nodos-1; j++)
				if(this.mat[i][j] == 1)
					salida.println(i + " " + j);

		salida.close();
	}

	private void buscarGradoMax() {
		// TODO Auto-generated method stub
		this.gradoMax = this.vecGrado[0];
		this.gradoMin = this.vecGrado[0];
		for (int i = 1; i < this.nodos-1; i++) {
			if(this.gradoMax < this.vecGrado[i])
				this.gradoMax = this.vecGrado[i];
			if(this.gradoMin > this.vecGrado[i])
				this.gradoMin = this.vecGrado[i];
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		GrafoPorProbabilidad nuevo = new GrafoPorProbabilidad(100, 0.7);
		
	}
}
