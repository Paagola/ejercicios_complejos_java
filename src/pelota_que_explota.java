public class pelota_que_explota {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        int alto = Integer.parseInt(System.console().readLine("Altura: "));
        int ancho = Integer.parseInt(System.console().readLine("Ancho: "));

        int x = ancho;
        int y = alto;
        boolean correcto = true;
        int vx = 0;
        int vy = 0;
        int resy = y;
        int resx = x;

        while (true) {
            // RECUADRO Y PINTAR PELOTA
            for (int i = 1; i <= alto * 2; i++) {
                for (int j = 1; j <= ancho * 2; j++) {

                    if (i == y && j == x) {
                        System.out.print("O");
                    } else if (resx == j && resy == i) {
                        System.out.print(GREEN + "▓" + RESET);
                    }

                    else if (i == 1 || i == alto * 2 || j == 1 || j == ancho * 2) {
                        System.out.print("▓");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println(" ");
            }

            // VALORES PARA QUE LA PELOTA EMPIEZE A MOVERSE EN
            // UNA DIRECCIÓN.
            while (correcto) {
                vx = ((int) (Math.random() * 3) - 1) * 2;
                vy = ((int) (Math.random() * 3) - 1) * 2;
                correcto = (vx == 0 || vy == 0) ? true : false;
            }

            x += vx;
            y += vy;

            if (y >= alto * 2 || y <= 1) {
                resy = (y >= alto * 2) ? alto * 2 : 1;
                resx = x;
                vy *= -1;
                y += vy;

            } else if (x >= ancho * 2 - 1 || x <= 1 ) {
                resx = (x >= ancho * 2 - 1) ? ancho * 2 : 1;
                resy = y;
                vx *= -1;
                x += vx;
            }

            Thread.sleep(200);
            System.out.print(CLEAN_SCREEN);
        }

    }
}
