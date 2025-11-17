public class ejercicio34 {
    public static void main(String[] args) {
        long numero1 = Long.parseLong(System.console().readLine("Numero 1 -> "));
        long numero2 = Long.parseLong(System.console().readLine("Numero 2 -> "));
        long aux1 = numero1;
        long aux2 = numero2;
        long aux1Reves = 0;
        long aux2Reves = 0;
        String sumapares = "";
        String sumaimpares = "";
        boolean correcto = true;
        int i = 0;

        while (aux1 > 0) {
            aux1Reves = aux1Reves * 10 + (aux1 % 10);
            aux1 /= 10;
        }

        while (aux2 > 0) {
            aux2Reves = aux2Reves * 10 + (aux2 % 10);
            aux2 /= 10;
        }

        while (correcto) {
            i++;
            if (i % 2 != 0 && aux1Reves > 0) {
                if ((aux1Reves % 10) % 2 == 0) {
                    sumapares += aux1Reves % 10 + "";
                } else {
                    sumaimpares += aux1Reves % 10 + "";
                }
                aux1Reves /= 10;
            } else if (aux2Reves > 0) {
                if ((aux2Reves % 10) % 2 == 0) {
                    sumapares += aux2Reves % 10 + "";
                } else {
                    sumaimpares += aux2Reves % 10 + "";
                }
                aux2Reves /= 10;
            } else if (aux1Reves == 0 && aux2Reves == 0) {
                correcto = false;
            }

        }

        System.out.println("Suma pares -> " + sumapares);
        System.out.println("Suma impares -> " + sumaimpares);

    }
}
