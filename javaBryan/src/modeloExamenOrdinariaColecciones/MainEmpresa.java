package modeloExamenOrdinariaColecciones;


import java.util.List;
import java.util.Set;

public class MainEmpresa {
    public static void main(String[] args) {
        Empresa emp = new Empresa();
        emp.añadirEmpleado(new Empleado(1, "Ana", "Ventas", 950));
        emp.añadirEmpleado(new Empleado(2, "Luis", "IT",     2200));
        emp.añadirEmpleado(new Empleado(3, "María","Ventas", 1800));
        emp.añadirEmpleado(new Empleado(4, "Pedro","IT",     1200));
        emp.añadirEmpleado(new Empleado(5, "Eva",  "RRHH",   1500));

        System.out.println("Departamentos: " + emp.departamentos());

        for (String d : emp.departamentos()) {
            List<Empleado> list = emp.listarPorDepto(d);
            System.out.println("→ " + d + ": " + list);
        }

        System.out.println("Total empleados: " + emp.totalEmpleados());

        System.out.println("\nEmpleados por tramo salarial:");
        for (int tramo = 0; tramo <= 3; tramo++) {
            List<Empleado> t = emp.tramoSalario(tramo);
            System.out.println(" Tramo " + tramo + " ("
                + tramo*1000 + "–" + ((tramo+1)*1000-1) + "): " + t);
        }
    }
}

