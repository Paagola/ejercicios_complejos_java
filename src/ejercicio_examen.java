public class ejercicio_examen {
    public static void main(String[] args) {

        boolean correcto = true;
        int numero = 0;
        do {
            try {
                numero = Integer.parseInt(System.console().readLine("Numero (10 - 99999) -> "));
                if (numero < 10 || numero > 99999) {
                    System.out.println("Introduce un número entre 10 - 99999");
                } else
                    correcto = false;
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: INTRODUCE UN NÚMERO!!!\n");
            } catch (Exception e) {
                System.out.println("\nERROR INESPERADO!!\n");
            }
        } while (correcto);

        // AVERIGUAR SI ES CAPICUO
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int aux = numero;
        int contador = 0;

        while (aux > 0) {
            contador++;
            aux /= 10;
        }

        aux = numero;
        for (int i = 1; i <= contador; i++) {

            switch (i) {
                case 1:
                    a = aux % 10;
                    break;
                case 2:
                    b = aux % 10;
                    break;
                case 3:
                    c = aux % 10;
                    break;
                case 4:
                    d = aux % 10;
                    break;
                case 5:
                    e = aux % 10;
                    break;
            }
            aux /= 10;
        }
        ;

        boolean numcapic = false;

        if (contador == 2 && a == b) {
            numcapic = true;
        } else if (contador == 3 && a == c) {
            numcapic = true;
        } else if (contador == 4 && a == d && b == c) {
            numcapic = true;
        } else if (contador == 5 && a == e && b == d) {
            numcapic = true;
        }

        // AVERIGUAR SI ES PRIMO
        boolean esprimo = true;

        if (numero == 1) {
            esprimo = false;
        }
        aux = (int) Math.sqrt(numero);
        for (int i = 2; i <= aux; i++) {
            if (numero % i == 0) {
                esprimo = false;
                i = aux;
            }
        }
        if (esprimo && numcapic) {
            System.out.println("NUMERO PERFECTO!!!");
        } else if (numcapic && !esprimo) {
            System.out.println("Es capicúa pero no primo");
        }
        // Numeros espejos.
        else if (!numcapic)
        {
            System.out.printf("El número %d no es capicúa%n", numero);
            aux = numero;
            int auxReverse = 0;
            while (aux > 0) {
                auxReverse = auxReverse * 10 + (aux % 10);
                aux /= 10;
            }
            System.out.println("Su número espejo es " + auxReverse);

            int diferencia = (int) (Math.max(auxReverse, numero) - Math.min(auxReverse, numero));
            System.out.printf("Diferencia es %d - %d = %d%n", (int) Math.max(auxReverse, numero),
                    (int) Math.min(auxReverse, numero), diferencia);

            int contreverse = 0;
            aux = diferencia;
            System.out.print("Digitos pares: ");
            for (int i = 0; i < contador; i++) {
                int digit = aux % 10;
                if (digit % 2 == 0) {
                    System.out.print(digit+" ");
                    contreverse++;

                }
                aux /= 10;
            } System.out.println("");

            int contreverse2 = 0;
            aux = diferencia;
            System.out.print("Digitos impares: ");
            for (int i = 0; i < contador; i++) {
                int digit = aux % 10;
                if (digit % 2 != 0) {
                    System.out.print(digit + " ");
                    contreverse2++;
                }
                aux /= 10;
            }System.out.println("");

            if (contreverse == contreverse2) {
                System.out.println("EMPATE");
            } else if (contreverse > contreverse2) {
                System.out.println("Los pares ganan");
            } else
                System.out.println("Los impares ganan");

        }

    }
}
