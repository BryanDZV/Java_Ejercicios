package enumPractica;

import java.util.ArrayList;
import java.util.List;

public class Coches implements Comparable<Coches> {
	//atributos
	private String marca;
	private String modelo;
	private Tipo tipoCoches;
	private double precio;
	
	//constructores
	
	public Coches(String marca,String modelo, Tipo tipoCoches, double precio) {
		this.marca=marca;
		this.modelo=modelo;
		this.tipoCoches=tipoCoches;
		this.precio=precio;
		
		
	}

	// Método para imprimir los atributos
    @Override
    public String toString() {
        return  marca+ "-"+modelo+ "-" + tipoCoches+ "-" +precio+"\n";
    };

//metodo para ordenar	
	/*
	 * Retorna un número negativo (this < otro) → Este objeto es menor.
	 * Retorna 0 (this == otro) → Son iguales.
	 * Retorna un número positivo (this > otro) → Este objeto es mayor.*/
@Override
public int compareTo(Coches o) {
	//logica para ordenar que sera llamda por el sort 
	// DEPENDE DEL OBJETO A TRATAR PRIMITO STRING OBJETOS
	
	
	/*CASO PRIMITVO DOUBLE*/
	
	//de mayor a menor OJO NO SIRVE PARA PRIMITIVOS usa O DOUBLE.COMPARE 
	
	int ordenacion=Double.compare(this.precio,o.precio);
	/*mtodo 1 orden asc por defecto si quiero desce=Double.compare(this.precio,-o.precio);
	*/
	
	//en orden alfabetico si son iguales Y AQUI USO STRING siempre por defecto asc
	
	if (ordenacion==0) {
		//ordeno por marca String SI TIENE COMPARE TO
		/*NOTA AL COMPRAR POR STRING LO QUE MIRA ES EL NUMERO UNICODE QUE TIENE */
		
		ordenacion=this.marca.compareTo(o.marca);
		
	}
	

	
	return ordenacion;
};


	//metodo pruebas de la clase

public static void main(String[] args) {
	//crear un objeto y guardo en lista
	//para acceder es mediante indice con el get de la clase List
	
	List<Coches> coche=new ArrayList<Coches>();
	
	coche.add( new Coches("toyota","k5",Tipo.Coche,1000));
	coche.add(new Coches("suzuki","ninja",Tipo.Moto,1310));
	coche.add( new Coches("toyota","k5",Tipo.Coche,900));
	coche.add(new Coches("suzuki","ninja",Tipo.Moto,700));
	coche.add( new Coches("suzuki","k5",Tipo.Coche,1000));
	coche.add(new Coches("suzuki","ninja",Tipo.Moto,500));
	
	//ordenar mediante sort y aplica la logica en compare to
	
	coche.sort(null);
	//imprimir la lista 
	//System.out.println("impresion sin logica----<<< "+coche);
	System.out.println("impresion con logica----<<< "+coche);
	

}
	
	

	

}



