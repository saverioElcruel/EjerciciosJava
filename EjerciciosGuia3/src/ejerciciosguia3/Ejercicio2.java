/*
Crear un programa que pida una frase y si esa frase es igual a “eureka” el
programa pondrá un mensaje de Correcto, sino mostrará un mensaje de
Incorrecto. Nota: investigar la función equals()
 */
package ejerciciosguia3;

import java.util.Scanner;

public class Ejercicio2 {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un frase");
        String respuesta = sc.nextLine();
        if ("eureka".equals(respuesta)) {
            System.out.println("Correcto");
        } else {
            System.out.println("Incorrecto");
        }
        
}
}
