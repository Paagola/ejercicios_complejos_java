public class ejercicio24 {
    public static void main(String[] args) {
        int altura = Integer.parseInt(System.console().readLine("Introduce la altura -> "));

        int contador = 1;
        int numero2 = 0;
        
        for (int i = altura; i > 0; i--) {
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(" ");
            }
            
            int numero = 0;
            for (int j = 0; j < contador; j++ ) {
                if (numero < (int)Math.ceil(contador/2.0)){
                    numero += 1;
                    System.out.print(numero);
                    numero2 = numero;
                } else {
                    numero2 -= 1;
                    System.out.print(numero2);
                }
                    
            } contador+= 2;
        System.out.println("");
        }

        

    }
}
