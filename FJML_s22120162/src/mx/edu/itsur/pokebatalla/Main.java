package mx.edu.itsur.pokebatalla;

import mx.edu.itsur.pokebatalla.model.Bullbasaur;
import mx.edu.itsur.pokebatalla.model.Pikachu;
import mx.edu.itsur.pokebatalla.model.Charmander;
import mx.edu.itsur.pokebatalla.model.Evee;
import mx.edu.itsur.pokebatalla.model.Aerodactyl;
import mx.edu.itsur.pokebatalla.model.Dratini;
/**
Sra. Evelyn
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("¡BIENVENIDO A LA POKEBATALLA!");
      
        Pikachu pikachuSalvaje = new Pikachu();
        Charmander charmanderSalvaje = new Charmander() ;
       
        
        //PIKACHUSALVAJE
        pikachuSalvaje.setNombre("PIKA");        
        Pikachu miPikachu = pikachuSalvaje;
        miPikachu.atacar(charmanderSalvaje);
        miPikachu.atacar(charmanderSalvaje, "ATACKTRUENO");
        
        //EVEE
        Evee PokemonEve1 = new Evee("Eve");
        
        Evee  miEvee = PokemonEve1;
        PokemonEve1.atacar(pikachuSalvaje, "RAPIDEZ");
        

        
        //AERODACTYL
        Aerodactyl PokemonAero1 = new Aerodactyl("Aero");
        Aerodactyl miAero = PokemonAero1;
        PokemonAero1.atacar(PokemonEve1,"MALICIOSO");
        
        //DRATINI
        Dratini PokemonDra1 = new   Dratini("DRA");
        Dratini miDra = PokemonDra1;
        PokemonDra1.atacar(PokemonAero1,"CONTRICCION");
        
        //CHARMANDER
        Charmander PokemonChar1 = new Charmander("Char");
        Charmander miChar = PokemonChar1;
        PokemonChar1.atacar(PokemonDra1,"ARAÑAZO");
        
    }
    
}
