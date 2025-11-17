public class ejercicio26 {
    public static void main(String[] args) throws Exception {

    int numero = 0;
    int digito = 0;
    boolean correcto = true;

    do {
        try {
            numero = Integer.parseInt(System.console().readLine("Numero -> "));
            digito = Integer.parseInt(System.console().readLine("Digito -> "));
            correcto = false;
        } catch (NumberFormatException e) {
            System.out.println("\nERROR: INTRODUCE UN NÚMERO!!!\n");
        }catch (Exception e) {
            System.out.println("\nERROR INESPERADO!!!\n");
        }
    } while (correcto);
    
    int aux = numero * 10 + 1;
    int numeroReves = 0;
    int contador = 0;

    while (aux > 0) {
        numeroReves = numeroReves * 10 + (aux % 10);
        aux /= 10;
        contador++;
    }

    for  (int i = 1; i <= contador-1; i++){
        if (numeroReves % 10 == digito) {
            System.out.print(i + " ");
            
        } numeroReves /= 10;
    }

    }
}