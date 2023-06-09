/*
Una obra social tiene tres clases de socios:
○ Los socios tipo ‘A’ abonan una cuota mayor, pero tienen un 50% de
descuento en todos los tipos de tratamientos.
○ Los socios tipo ‘B’ abonan una cuota moderada y tienen un 35% de
descuento para los mismos tratamientos que los socios del tipo A.
○ Los socios que menos aportan, los de tipo ‘C’, no reciben
descuentos sobre dichos tratamientos.
○ Solicite una letra (carácter) que representa la clase de un socio, y
luego un valor real que represente el costo del tratamiento (previo
al descuento) y determine el importe en efectivo a pagar por dicho
socio.
 */
package ejercicios;

import java.util.Scanner;

public class Ex05_DescuentoXmembresia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String socioTipo = "A";
        do{
        System.out.println("Ingrese tipo de socio A/B/C:");
        socioTipo = sc.next();
        System.out.println("Valor del tratamiento:");
        double bruto = sc.nextInt();
        if("A".equalsIgnoreCase(socioTipo)){
            System.out.println("El costo del tratamiento es: "+bruto*0.5+" chelines");
        }else if("B".equalsIgnoreCase(socioTipo)){
            System.out.println("El costo del tratamiento es: "+bruto*0.65+" chelines");
        }else if("C".equalsIgnoreCase(socioTipo)){
            System.out.println("No hay descuento para tu categoría de aportante. Vas a tener que abonar: "+bruto);
        }else{
            System.out.println("El tipo de socio no existe");
        }
        
    }while("A".equalsIgnoreCase(socioTipo)||"B".equalsIgnoreCase(socioTipo)||"C".equalsIgnoreCase(socioTipo));
    
}
}
