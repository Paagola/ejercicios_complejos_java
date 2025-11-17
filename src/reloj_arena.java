public class reloj_arena {
    public static void main(String[] args) {
        int altura = Integer.parseInt(System.console().readLine("Altura -> "));
        
        int mitad = altura / 2;

        for (int i = 0; i < altura; i++) {
            
            int distanciacentro;
            if (i <= mitad) {
                distanciacentro = i;
            } else {
                distanciacentro = altura - 1 - i; 
            }
        
            for (int j = 0; j < distanciacentro; j++) {
                System.out.print(" ");
            }

            int numeros = altura - 2 * distanciacentro;
            int numero = 1;
            for (int j = 0; j < numeros; j++) {
                System.out.print(numero);
                numero++;
            }
            System.out.println();
        }
    
    }
}
