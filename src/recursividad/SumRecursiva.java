package recursividad;

public class SumRecursiva {

    public static class SumatoriaRecursiva {
        public static void main(String[] args) {
            int a = 6;
            int b = 9;

            int result1 = calcularSum(a);
            System.out.println("La sumatoria de los números enteros desde 1 hasta " + a + " es: " + result1);

            int result2 = calcularSum(b);
            System.out.println("La sumatoria de los números enteros desde 1 hasta " + b + " es: " + result2);
        }

        public static int calcularSum(int n) {
            if (n == 1) {
                return 1;
            } else {
                return n + calcularSum(n - 1);
            }
        }
    }
}
