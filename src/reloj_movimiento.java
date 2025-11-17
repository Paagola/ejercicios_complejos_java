public class reloj_movimiento {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\033[0;35m";

    public static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");

            if (sistemaOperativo.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int altura = 21;
        int mitad = (int) Math.ceil(altura / 2);
        int asteriscos1 = altura - 2;
        int espacios1 = 0;
        int izq = 1;
        int der = asteriscos1 - 3;
        int fila = 2;
        int contador = 0;
        int der2 = -5;
        int izq2 = -5;
        int fila2 = altura - 3;
        int resta = asteriscos1 - 1;

        while (true) {
            for (int i = 1; i < altura - 1; i++) {
                System.out.printf((espacios1 > 0) ? "%" + espacios1 + "s" : "", " ");
                for (int j = 0; j < asteriscos1; j++) {
                    if (j == 0 || i == 1 || j == asteriscos1 - 1 || i == altura - 2) {
                        System.out.print("*");
                    } else if (i < fila && j != 0 && j != asteriscos1 - 1 && i != 1) {
                        System.out.print(" ");
                    } else if (i <= fila2 && i > mitad) {
                        if ((j <= der2 && j >= izq2 && i == fila2) || (j == i - 10 && i - 10 <= contador)) {
                            System.out.print(GREEN + "*" + RESET);
                        } else {
                            System.out.print(" ");
                        }
                    }

                    else if (((i <= fila && i != 1) && ((j <= izq && j != 0)
                            || (j >= der && j != asteriscos1 - 1 && i != 1)))) {
                        System.out.print(" ");
                    }

                    else {
                        if (i > mitad) {
                            System.out.print(GREEN + "*" + RESET);
                        } else {
                            System.out.print(PURPLE + "*" + RESET);
                        }
                        
                    }

                }

                if (i == altura - 2) {
                    asteriscos1 = altura - 2;
                } else if (i >= mitad) {
                    asteriscos1 += 2;
                    espacios1--;
                } else {
                    espacios1++;
                    asteriscos1 -= 2;
                }
                System.out.println("");
            }
            contador++;
            if (contador == 8) {
                der2 = mitad-1;
                izq2 = mitad-2;
            }

            if (der == izq) {
                fila++;
                der = asteriscos1 - fila * 2;
                izq = 1;
            } else if (der2 >= resta - 5 && izq2 <= 1) {
                resta = resta - 2;
                izq2 = (int) Math.ceil(resta / 2) - 1;
                der2 = (int) Math.ceil(resta / 2) - 2;
                fila2--;
            }

            else if (contador % 2 == 0) {
                der--;
                der2++;
            }

            else {
                izq++;
                izq2--;
            }
            Thread.sleep(400);
            limpiarPantalla();
        }

    }
}
