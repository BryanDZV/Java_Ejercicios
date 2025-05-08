package ejercicios1;

class Animal {
    public void sonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    @Override
    public void sonido() {
        System.out.println("El perro ladra");
    }
}

public class Extra4_HerenciaMetodo {
    public static void main(String[] args) {
        Animal miAnimal = new Perro();
        miAnimal.sonido(); // muestra el del perro
    }
}