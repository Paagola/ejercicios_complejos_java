public class ejercicio30 {
    public static void main(String[] args) {

        boolean correcto = true;
        String dia1 = "";
        String dia2 = "";
        int horaDia1 = 0;
        int horaDia2 = 0;
        int dia1Int = 0;
        int dia2Int = 0;

        do {
            dia1 = System.console().readLine("Introduce dia 1: ");
            dia1Int = switch (dia1.toLowerCase()) {
                case "1", "lunes" -> 1;
                case "2", "martes" -> 2;
                case "3", "miercoles", "miércoles" -> 3;
                case "4", "jueves" -> 4;
                case "5", "viernes" -> 5;
                case "6", "sabado" -> 6;
                case "7", "domingo" -> 7;
                default -> 8;
            };
            if (dia1Int < 1 || dia1Int > 7) {
                System.out.println("Introduce un día del 1-7 o de Lunes-Domingo");
            } else
                correcto = false;
        } while (correcto);

        do {
            try {
                correcto = true;
                horaDia1 = Integer.parseInt(System.console().readLine("Introduce la hora del día 1 -> "));
                if (horaDia1 < 0 || horaDia1 > 23) {
                    System.out.println("Introduce de 0-23 horas");
                } else {
                    correcto = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: INTRODUCE UN NÚMERO!!!\n");
            } catch (Exception e) {
                System.out.println("\nERROR INESPERADO!!!\n");
            }

        } while (correcto);

        do {
            correcto = true;
            dia2 = System.console().readLine("Introduce dia 2: ");
            dia2Int = switch (dia2.toLowerCase()) {
                case "1", "lunes" -> 1;
                case "2", "martes" -> 2;
                case "3", "miercoles", "miércoles" -> 3;
                case "4", "jueves" -> 4;
                case "5", "viernes" -> 5;
                case "6", "sabado" -> 6;
                case "7", "domingo" -> 7;
                default -> 8;
            };

            if (dia2Int < 1 || dia2Int > 7) {
                System.out.println("Introduce un día del 1-7 o de Lunes-Domingo");
            } else if (dia1Int > dia2Int) {
                System.out.println("El segundo día tiene que ser mayor que el primero.");
            } else {
                correcto = false;
            }

        } while (correcto);

        do {
            try {
                correcto = true;
                horaDia2 = Integer.parseInt(System.console().readLine("Introduce la hora del día 2 -> "));
                if (dia1Int == dia2Int && horaDia1 > horaDia2) {
                    System.out.println("La hora del día 1 tiene que ser mayor o igual que la del dia 2");
                } else if (horaDia1 < 0 || horaDia1 > 23) {
                    System.out.println("Introduce de 0-23 horas");

                } else {
                    correcto = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: INTRODUCE UN NÚMERO!!!\n");
            } catch (Exception e) {
                System.out.println("\nERROR INESPERADO!!!\n");
            }

        } while (correcto);
        System.out.println(dia1 + " " + dia2 + " ");

        // Ya tengo los días y las horas, solo me queda calcular cuanto hay entre una y
        // otras
        int horas_entre_dias = (dia2Int * 24 + horaDia2) - (dia1Int * 24 + horaDia1);

        System.out.println(horas_entre_dias);

    }

}
