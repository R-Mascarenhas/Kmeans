import java.util.ArrayList;

public class Grupo {
	private Amostra centroide, oldcentro;
	private ArrayList<Amostra> elementos;
	private int nEle;
	private Estatistica E = new Estatistica();
	
	public Grupo(Amostra centroide){
		this.centroide = centroide;
		elementos = new ArrayList<Amostra>();
		nEle = -1;
	}
	
	/*
	 * Calcula novo centr�ide para o grupo
	 */
	public void newCentro(int nAtrib){	
		float[] medias = new float[nAtrib];
		Amostra newCentroide = new Amostra(0, nAtrib);
		oldcentro = centroide;
		for(Amostra ele: elementos)
			for(int j = 0; j < nAtrib; j++){
				medias[j] += ele.getVal(j);
			}
		for(int i = 0; i < nAtrib; i++){
			medias[i] /= nAtrib;
		}
		for(int i = 0; i < nAtrib; i ++){
			newCentroide.addVal(medias[nAtrib-1]);
		}
	}
	
	/*
	 * Retorna centr�ide do grupo
	 */
	public Amostra getCentro(){
		return this.centroide;
	}
	
	/*
	 * Adiciona amostra a base de dados. 
	 */
	public void addElemento(Amostra E){
		elementos.add(E);
		nEle++;
	}
	
	/*
	 * Retorna amostra i pertencente ao grupo
	 */
	public Amostra getElemento(int i){
		if(i < nEle && i > -1)
			return elementos.get(i);
		else{
			System.out.println("Posicao fora do intervalo do Array.");
			return null;
		}
	}	
	
	public float distOldNewCent(int nAtrib){
			return E.euclideanDist(centroide, oldcentro, nAtrib);			
	}
	
	public void imprimeGrupo(int k){
		int nAm;
		System.out.println();
		System.out.println("Amostras do grupo " + k + ":");
		for(int i = 0; i < nEle; i++){
			nAm = elementos.get(i).getNumAmos();
			System.out.printf("%d, ", nAm);
			if(i%100 == 0 && i != 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("Numero de elementos do grupo " + k + ": " + nEle);
		System.out.println();
	}
}