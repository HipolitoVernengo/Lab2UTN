package TPractico;
import java.util.ArrayList;
import java.util.Scanner;

// Paso 1: Clase abstracta Empleado
abstract class Empleado {
    protected String nombreEmpleado;
    protected int idEmpleado;
    protected double sueldoBaseEmpleado;

    public Empleado(String nombreEmpleado, int idEmpleado, double
            sueldoBaseEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.idEmpleado = idEmpleado;
        this.sueldoBaseEmpleado = sueldoBaseEmpleado;
    }

    // Paso 1: Método abstracto calcularSueldo
    public abstract double calcularSueldo();

    // Método para calcular impuestos (en cada clase concreta)
    public abstract double calcularImpuesto();
}

// Paso 2: Clase concreta EmpleadoPorHoras
class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadasEmpleado;

    public EmpleadoPorHoras(String nombreEmpleado, int idEmpleado,
                            double sueldoBaseEmpleado, int horasTrabajadasEmpleado) {
        super(nombreEmpleado, idEmpleado, sueldoBaseEmpleado);
        this.horasTrabajadasEmpleado = horasTrabajadasEmpleado;
    }

    // Paso 2: Implementación de calcularSueldo para EmpleadoPorHoras
    @Override
    public double calcularSueldo() {
        return sueldoBaseEmpleado * horasTrabajadasEmpleado;
    }

    // Implementación de calcularImpuesto para EmpleadoPorHoras
    @Override
    public double calcularImpuesto() {
        return calcularSueldo() * 0.1; // Ejemplo de impuesto del 10%
    }
}

// Paso 2: Clase concreta EmpleadoAsalariado
class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombreEmpleado, int idEmpleado,
                              double sueldoBaseEmpleado) {
        super(nombreEmpleado, idEmpleado, sueldoBaseEmpleado);
    }

    // Paso 2: Implementación de calcularSueldo para EmpleadoAsalariado
    @Override
    public double calcularSueldo() {
        return sueldoBaseEmpleado;
    }

    // Implementación de calcularImpuesto para EmpleadoAsalariado
    @Override
    public double calcularImpuesto() {
        return calcularSueldo() * 0.15; // Ejemplo de impuesto del 15%
    }
}

// Paso 2: Clase concreta EmpleadoComision
class EmpleadoComision extends Empleado {
    private double ventasRealizadasEmpleado;

    public EmpleadoComision(String nombreEmpleado, int idEmpleado,
                            double sueldoBaseEmpleado, double ventasRealizadasEmpleado) {
        super(nombreEmpleado, idEmpleado, sueldoBaseEmpleado);
        this.ventasRealizadasEmpleado = ventasRealizadasEmpleado;
    }

    // Paso 2: Implementación de calcularSueldo para EmpleadoComision
    @Override
    public double calcularSueldo() {
        return sueldoBaseEmpleado + (ventasRealizadasEmpleado * 0.1);
// Ejemplo de comisión del 10%
    }

    // Implementación de calcularImpuesto para EmpleadoComision
    @Override
    public double calcularImpuesto() {
        return calcularSueldo() * 0.12; // Ejemplo de impuesto del 12%
    }
}

// Paso 4: Clase GestorEmpleados
class GestorEmpleados {
    public ArrayList<Empleado> empleados = new ArrayList<>();

    // Paso 5: Métodos para agregar, modificar y eliminar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void modificarEmpleado(int indice, Empleado empleado) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.set(indice, empleado);
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            empleados.remove(indice);
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    // Método para calcular sueldos e impuestos
    public void calcularSueldosEImpuestos() {
        for (Empleado empleado : empleados) {
            double sueldo = empleado.calcularSueldo();
            double impuesto = empleado.calcularImpuesto();
            System.out.println("Nombre: " + empleado.nombreEmpleado);
            System.out.println("Sueldo: " + sueldo);
            System.out.println("Impuesto: " + impuesto);
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            System.out.println("1. Agregar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Calcular sueldos e impuestos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarEmpleado(scanner, gestor);
                    break;
                case 2:
                    modificarEmpleado(scanner, gestor);
                    break;
                case 3:
                    eliminarEmpleado(scanner, gestor);
                    break;
                case 4:
                    gestor.calcularSueldosEImpuestos();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void agregarEmpleado(Scanner scanner,
                                        GestorEmpleados gestor) {
        System.out.print("Nombre del empleado: ");
        String nombreEmpleado = scanner.next();

        System.out.print("ID del empleado: ");
        int idEmpleado = scanner.nextInt();

        System.out.print("Sueldo base del empleado: ");
        double sueldoBaseEmpleado = scanner.nextDouble();

        System.out.println("Seleccione el tipo de empleado:");
        System.out.println("1. Empleado por horas");
        System.out.println("2. Empleado asalariado");
        System.out.println("3. Empleado comisión");
        int tipo = scanner.nextInt();

        Empleado empleado = null;

        switch (tipo) {
            case 1:
                System.out.print("Horas trabajadas: ");
                int horasTrabajadasEmpleado = scanner.nextInt();
                empleado = new EmpleadoPorHoras(nombreEmpleado,
                        idEmpleado, sueldoBaseEmpleado, horasTrabajadasEmpleado);
                break;
            case 2:
                empleado = new EmpleadoAsalariado(nombreEmpleado,
                        idEmpleado, sueldoBaseEmpleado);
                break;
            case 3:
                System.out.print("Ventas realizadas: ");
                double ventasRealizadasEmpleado = scanner.nextDouble();
                empleado = new EmpleadoComision(nombreEmpleado,
                        idEmpleado, sueldoBaseEmpleado, ventasRealizadasEmpleado);
                break;
            default:
                System.out.println("Tipo de empleado no válido.");
                return;
        }

        gestor.agregarEmpleado(empleado);
        System.out.println("Empleado agregado con éxito.");
    }

    private static void modificarEmpleado(Scanner scanner,
                                          GestorEmpleados gestor) {
        System.out.print("Índice del empleado a modificar: ");
        int indice = scanner.nextInt();

        if (indice >= 0 && indice < gestor.empleados.size()) {
            Empleado empleadoActual = gestor.empleados.get(indice);
            System.out.println("Empleado actual:");
            System.out.println("Nombre: " + empleadoActual.nombreEmpleado);
            System.out.println("ID: " + empleadoActual.idEmpleado);
            System.out.println("Sueldo base: " +
                    empleadoActual.sueldoBaseEmpleado);

            System.out.println("Seleccione el tipo de empleado:");
            System.out.println("1. Empleado por horas");
            System.out.println("2. Empleado asalariado");
            System.out.println("3. Empleado comisión");
            int tipo = scanner.nextInt();

            Empleado empleadoModificado = null;

            switch (tipo) {
                case 1:
                    System.out.print("Horas trabajadas: ");
                    int horasTrabajadasEmpleado = scanner.nextInt();
                    empleadoModificado = new
                            EmpleadoPorHoras(empleadoActual.nombreEmpleado,
                            empleadoActual.idEmpleado, empleadoActual.sueldoBaseEmpleado,
                            horasTrabajadasEmpleado);
                    break;
                case 2:
                    empleadoModificado = new
                            EmpleadoAsalariado(empleadoActual.nombreEmpleado,
                            empleadoActual.idEmpleado, empleadoActual.sueldoBaseEmpleado);
                    break;
                case 3:
                    System.out.print("Ventas realizadas: ");
                    double ventasRealizadasEmpleado = scanner.nextDouble();
                    empleadoModificado = new
                            EmpleadoComision(empleadoActual.nombreEmpleado,
                            empleadoActual.idEmpleado, empleadoActual.sueldoBaseEmpleado,
                            ventasRealizadasEmpleado);
                    break;
                default:
                    System.out.println("Tipo de empleado no válido.");
                    return;
            }

            gestor.modificarEmpleado(indice, empleadoModificado);
            System.out.println("Empleado modificado con éxito.");
        } else {
            System.out.println("Índice de empleado no válido.");
        }
    }

    private static void eliminarEmpleado(Scanner scanner,
                                         GestorEmpleados gestor) {
        System.out.print("Índice del empleado a eliminar: ");
        int indice = scanner.nextInt();
        gestor.eliminarEmpleado(indice);
        System.out.println("Empleado eliminado con éxito.");
    }
}