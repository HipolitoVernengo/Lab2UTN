package recursividad;

public class Factorial {
    public static void main(String[] args) {
        int recursivo1 = factorialRecursivo(5);
        System.out.println("Factorial recursivo1: " + recursivo1);

        int iterativo1 = factorialIterativo(5L);
        System.out.println("Factorial iterativo1: " + iterativo1);
    }

    public static int factorialRecursivo(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursivo(n - 1);
    }

    public static int factorialIterativo(long x) {
        int result = 1;
        for (long i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
