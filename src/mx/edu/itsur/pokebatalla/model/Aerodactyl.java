package mx.edu.itsur.pokebatalla.model;

import java.util.ArrayList;

/**
 Sra. Evelyn
 * s22120162
 */
public class Aerodactyl extends Pokemon {
    public  Aerodactyl()
    {
                this.tipo = ("ROCA");
                this.ataque = 105;
                this.defensa = 65;
                this.hp = 80;
                this.nivel = 1;
                this.precision = 2;
                   this.habilidades  = new ArrayList<>();
                this.habilidades.add("MORDISCO");
                this.habilidades.add("MALICIOSO");
    }
   public Aerodactyl(String nombre)
   {
       this();
       this.nombre = nombre;
   }
    public void atacar(Pokemon oponente, String habilidad)
    {
        if(habilidad.equals("MORDISCO"))
        {
            System.out.println(this.nombre + "USO MORDISCO " +"Y  ATACO A "+ oponente );
        }
        else if(habilidad.equals("MALICIOSO"))
                {
                    System.out.println(this.nombre + "USO MALICIOSO " +"Y  ATACO A "+ oponente );
                }
    }
    
}
