package mx.edu.itsur.pokebatalla.model;

import java.util.ArrayList;

/**
 Sra. Evelyn
 * s22120162
 */
public class Dratini extends Pokemon{
    public Dratini()
            {
                this.tipo = ("DRAGON");
                this.ataque = 64;
                this.defensa = 45;
                this.hp = 41;
                this.nivel = 1;
                this.precision = 3;
                   this.habilidades  = new ArrayList<>();
                this.habilidades.add("CONTRICCION");
                this.habilidades.add("MALICIOSO");
            }
     public Dratini(String nombre)
   {
       this();
       this.nombre = nombre;
   }
      public void atacar(Pokemon oponente, String habilidad)
    {
        if(habilidad.equals("CONTRICCION"))
        {
            System.out.println(this.nombre +  "Uso  EL ATAQUE DE CONTRICCION  y ataco a " + oponente  );
        }
        else if(habilidad.equals("MALICIOSO"))
                {
                    System.out.println(this.nombre + "REALIZANDO EL ATAQUE DE MALICIOSO y ataco a " + oponente );
                }
    }
}
