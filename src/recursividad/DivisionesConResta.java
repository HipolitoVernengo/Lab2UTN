package recursividad;

public class DivisionesConResta {
    public static void main(String[] args) {
        DivConRestaIterativa(35, 5);
        DivConRestaIterativa(70, 8);
        System.out.println("");

        System.out.println("El resultado es: " + DivConRestaRecursiva(35L, 5L));
        System.out.println("El resultado es: " + DivConRestaRecursiva(70L, 8L));
    }

    public static void DivConRestaIterativa(int n, int x) {
        int i;
        int div = n;
        for (i = 0; n >= x; i++) {
            n -= x;
        }
        System.out.println(div + " divido " + x + " es " + i + " y el resto es " + n);
    }

    public static int DivConRestaRecursiva(long n, long x) {
        if (n < x) {
            return 0;
        } else {
            return 1 + DivConRestaRecursiva(n - x, x);
        }
    }
}
