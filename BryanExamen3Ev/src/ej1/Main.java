package ej1;

//Ejemplo de uso en la clase Main
public class Main {
 public static void main(String[] args) {
     // Creamos el supermercado
     Supermercado supermercado = new Supermercado();

     // Creamos varios productos con nombre, marca, categoría y precio
     Producto p1 = new Producto("Leche entera", "Pascual", "Lácteos", 1.20);
     Producto p2 = new Producto("Yogur natural", "Danone", "Lácteos", 0.90);
     Producto p3 = new Producto("Pan de molde", "Bimbo", "Panadería", 1.50);
     Producto p4 = new Producto("Leche semidesnatada", "Pascual", "Lácteos", 1.10);
     Producto p5 = new Producto("Croissant", "Bimbo", "Panadería", 0.80);

     // Añadimos los productos al supermercado
     supermercado.agregarProducto(p1);
     supermercado.agregarProducto(p2);
     supermercado.agregarProducto(p3);
     supermercado.agregarProducto(p4);
     supermercado.agregarProducto(p5);

     // Mostramos productos por marca "Pascual"
     System.out.println("Productos por marca (Pascual): " +
         supermercado.obtenerProductosPorMarca("Pascual"));

     // Mostramos productos por categoría "Lácteos"
     System.out.println("Productos por categoría (Lácteos): " +
         supermercado.obtenerProductosPorCategoria("Lácteos"));

     // Mostramos todas las marcas
     System.out.println("Todas las marcas: " +
         supermercado.obtenerTodasLasMarcas());

     // Mostramos el producto más barato de cada categoría
     System.out.println("Producto más barato por categoría: " +
         supermercado.obtenerProductoMasBaratoPorCategoria());
 }
}
