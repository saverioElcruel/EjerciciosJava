
package Servicios;

import Entidades.Carta;
import Entidades.Malandra;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Logica {
    
        private Scanner sc = new Scanner(System.in).useDelimiter("\n");
        private LinkedList<Carta> baraja = new LinkedList();
            
    public void llenarBaraja() {
        String palo = "";
        int num;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 13; j++) {
                switch (i) {
                    case 1:
                        if (j != 8 & j != 9) {
                            palo = "basto";
                            num = j;
                            baraja.add(new Carta(num, palo));
                        }
                        break;
                    case 2:
                        if (j != 8 & j != 9) {
                            palo = "espada";
                            num = j;
                            baraja.add(new Carta(num, palo));
                        }
                        break;
                    case 3:
                        if (j != 8 & j != 9) {
                            palo = "oro";
                            num = j;
                            baraja.add(new Carta(num, palo));
                        }
                        break;
                    case 4:
                        if (j != 8 & j != 9) {
                            palo = "copa";
                            num = j;
                            baraja.add(new Carta(num, palo));
                        }
                        break;
                }
            }
        }
    }
    
    public void barajar(){
        Collections.shuffle(baraja);
    }
    
    
    public void mostrarMano(Malandra jugador){
        System.out.println("Tus cartas: ");
        int i = 1;
        for (Carta carta : jugador.getMano()) {
            System.out.println(carta+" "+"|"+i+"|");
            i++;
        }
    }
    
        public boolean buscarReyes(){
        barajar();
        boolean result = false;
        System.out.println("Buscando reyes...");
        System.out.println(baraja.element().getNumero()+" de "+baraja.element().getPalo());
            if(baraja.element().getNumero()==12){
                result=true;
                System.out.println("Juega primero el humano. La máquina es mano");
            }else{
            if(buscarReyes()){
                System.out.println("Juega primero la máquina. El humano es mano");
            }else{
                buscarReyes();
            }
            }
        return result;
    }
    
       
    public Malandra crearJugador(){
        Malandra jugador = new Malandra();
        return jugador;
    }
    
    public LinkedList<Carta> reparto(){
        LinkedList<Carta> resultado = new LinkedList();
        barajar();
        for (int i = 0; i < 3; i++) {
            resultado.add(baraja.get(i));
        }
        return resultado;
    }
    
    public void jugarRonda(Malandra jugador, Malandra maquina){
        
        boolean girar = true;
        
        llenarBaraja();
        
        int contadorRonda = 2;
        
        
        jugador.setMano(reparto());
        
        maquina.setMano(reparto());
    
        do{
            if(contadorRonda%2==0){
                mostrarMano(jugador);
//                responder(); Es un método que se pregunta maquina.isCanto==true, maquina.getQueSeQuiere
//                  Actualiza ptos ipa y ptosronda
                System.out.println("JUGAR |1| IRSE |2|");
                int rtaX = sc.nextInt();
                    if (rtaX == 1) {
                        System.out.println("JUGAR |1| CANTAR |2|");
                        int rtaY = sc.nextInt();
                            if (rtaY == 1) {
                                mostrarMano(jugador);
                                int rtaW = sc.nextInt();
                                jugador.setPrimera(jugador.getMano().get(rtaW));
                                jugador.getMano().remove(rtaW);
                            } else {
                                System.out.println("Cantar Envido |1|");
                                System.out.println("Cantar Real Envido |2|");
                                System.out.println("Cantar Falta Envido |3|");
                                System.out.println("Cantar Flor |4|");
                                System.out.println("Cantar Truco |5|");
                                int rtaZ = sc.nextInt();
                                String rtaZstring = "";
                                switch(rtaZ){
                                    case 1:
                                        rtaZstring = "Envido";
                                    
                                    case 2:
                                        rtaZstring = "Real Envido";
                                    
                                    case 3:
                                        rtaZstring = "Falta Envido";
                                    
                                    case 4:
                                        rtaZstring = "Flor";
                                    
                                    case 5:
                                        rtaZstring = "Truco";
                                }
                                
                                jugador.setCanto(true);
                                jugador.setQueSeQuiere(rtaZstring);
                                contadorRonda++;
                                
                        }else {
                            maquina.setPuntaje(+1);
                            girar=false;
                    }
                        
                   
                    break;
                    
                    
                    //Fin del Case 1
                    
                    //No hay Case 3 porque estamos adentro del if PAR
                    
                    case 4:
                        if (maquina.isJugo()==true||maquina.isSeQuiere()==true){
                            
                        }
                        // jugar o cantar
                        // si jugar, función
                        
                        break;
                }
                
                
            }else{
                // Entramos al IF IMPAR
                /*
                Juega la máquina
                Si jugador cantó, activa función quéCantó y evalua condiciones para cada una. 
                Por ejemplo, si queCanto() da como resultado el String "Envido", 
                el método seQuiere() devolverá un booleano si.
                
                
                maquina.getMano().get(0).getPalo().equals(maquina.getMano().get(1).getPalo())||
                maquina.getMano().get(0).getPalo().equals(maquina.getMano().get(2).getPalo())||
                maquina.getMano().get(2).getPalo().equals(maquina.getMano().get(1).getPalo())
                
                if sumar getNumero > 25
                
                sout "Se quiere"
                
                
                */   
                if(jugador.isCanto()){
                    switch(jugador.getQueCanto()){
                        case "Envido":
                            if(maquina.isIpa()){
                                if(maquina.getTantos()<33&&maquina.getTantos()>27){
                                    System.out.println("MÁQUINA: Se quiere");
                                }else if(maquina.getTantos()>31){
                                    System.out.println("Envido");
                                    maquina.setCanto(true);
                                }
                            }
                    }
                }
                if(jugador.isJugo()){
                   switch(jugador.getPrimera().toString()){
                       case "1 de espada":
                       
                   }
                   
                    
                }
                
           
                
            
            
        }
        
        
        }while(girar);
        
        //Mostrar puntaje
        System.out.println("Máquina: "+maquina.getPuntaje());
        System.out.println("Máquina: "+maquina.getPuntaje());
        
    }
    
    


    
    
    
}
