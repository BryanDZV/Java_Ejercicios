package enumPractica;

import java.util.ArrayList;
import java.util.List;

import ordenacion.Articulo;

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

/**
 * ORDENACION INVIERTO EL RETURN -1
 *  @Override
    public int compare(Articulo o1, Articulo o2) {
        // Comparación por denominación alfabéticamente
        int comparacionNombre = o1.getDenominacion().compareTo(o2.getDenominacion());

        if (comparacionNombre == 0) { // Si tienen el mismo nombre
            if (o1.getPvp() > o2.getPvp()) {
                return -1; // Primero el más caro (para orden descendente el -1 invierto)
            } else if (o1.getPvp() < o2.getPvp()) {
                return 1;  // Luego el más barato
            }
            return 0; // Si tienen el mismo precio, no cambia el orden
        }

        return comparacionNombre; // Ordenación alfabética por denominación
    }
}*/

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



