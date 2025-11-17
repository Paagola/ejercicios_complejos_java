public class prueba_randoms {
    public static void main(String[] args) {
        
        int numero = Integer.parseInt(System.console().readLine("Ejercicio: "));
        
        switch (numero) {
            case 1://EJERCICIO 1 
                int dad1 = (int)(Math.random()*7);
                int dad2 = (int)(Math.random()*7);
                int dad3 = (int)(Math.random()*7);

                System.out.println("Tirada de tres dados: "+dad1 +" "+ dad2 +" "+ dad3);
                break;

            case 2: //EJERCICIO 2

            for (int i = 0; i < 20; i++) {
                int num1 = (int)(Math.random()*3)-1;
                System.out.print(num1 + " ");
            }
                
            
            default:
                break;
        }
    }
}
