public class ejercicio33 {
    public static void main(String[] args) {
        
        
        int altura = 0;
        boolean correcto = true;
        
        do {
            try {
                altura = Integer.parseInt(System.console().readLine("Introduce altura -> "));
                correcto = false;
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: INTRODUCE UN NÚMERO!!!\n");
            } catch (Exception e) {
                System.out.println("\nERROR INESPERADO!!!\n");
            }

        } while (correcto);

        for (int i = 1; i <= altura; i++ ) {
            System.out.print(" ");
            if (i == altura) {
                for (int j = 1; j <= (int)Math.ceil(altura/2.0); j++) {
                    System.out.print(" *");
                }
            } else {
                System.out.printf("*%"+ (altura % 2 == 0 ? altura -1: altura) + "s*%n", " ");
            }
        }
    } 
}
