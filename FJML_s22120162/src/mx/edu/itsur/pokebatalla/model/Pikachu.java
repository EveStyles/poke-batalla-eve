package mx.edu.itsur.pokebatalla.model;
import java.util.ArrayList;
/**
Sra. Evelyn
 */
public class Pikachu  extends Pokemon
{
    public Pikachu() {
        this.tipo = "ELECTRICO";
        this.hp = 35;
        this.ataque = 55;
        this.defensa = 30;
        this.nivel = 1;
        this.precision = 4;
        this.habilidades = new ArrayList<>();
        this.habilidades.add("ATACKTRUENO");
        this.habilidades.add("BOLAVOLTIO");
    }    
    public Pikachu(String nombre){
        this(); 
        this.nombre = nombre;
    }
    public void atacar(Pokemon oponente, String habilidad){
        if(habilidad.equals("ATACKTRUENO")){
            System.out.println("REALIZANDO EL ATAQUE DE ATACKTRUENO");
            
        }else if(habilidad.equals("BOLAVOLTIO")){
            System.out.println("REALIZANDO EL ATAQUE DE BOLAVOLTIO");            
        }
    }
   
}
