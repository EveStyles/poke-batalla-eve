package mx.edu.itsur.pokebatalla.model;

import java.util.ArrayList;

/**
 Sra. Evelyn
 * s22120162
 */
public class Evee extends Pokemon{
    public Evee()
            {
                this.tipo = "NORMAL";
                this.ataque = 55;
                this.defensa = 50;
                this.hp = 55;
                this.nivel = 1;
                this.precision = 4;
                this.habilidades  = new ArrayList<>();
                this.habilidades.add("RAPIDEZ");
                this.habilidades.add("METRONOMO");
            }
    public Evee(String nombre)
    {
        this();
        this.nombre = nombre;
    }
    
    public void atacar(Pokemon oponente, String habilidad)
    {
        if(habilidad.equals("RAPIDEZ"))
        {
            System.out.println(this.nombre + " USO RAPIDEZ" +  " Y ATACO A " + oponente) ;
        }
        else if(habilidad.equals("METRONOMO"))
                {
                     System.out.println(this.nombre + " USO METRONOMO" +  " Y ATACO A " + oponente) ;
                }
    }
}
