package grafos;

public class GrafoPorGrado extends Generador{

	private double grado;
	
	public GrafoPorGrado(int nodos, double grado) {
		super(nodos);
		
		this.grado = grado;
		
		if(nodos%2 == 1 && grado%2 == 1) {
			System.out.println("No se puede generar un grafo con " + nodos + " y " + grado);
		}else {
			generar();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
