package mx.edu.itsur.pokebatalla;

import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.Pokemons.Aerodactyl;
import mx.edu.itsur.pokebatalla.model.Pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.Pokemons.Dratini;
import mx.edu.itsur.pokebatalla.model.Pokemons.Evee;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pikachu;
import mx.edu.itsur.pokebatalla.model.battles.Batalla;
import mx.edu.itsur.pokebatalla.model.battles.Entrenador;
import mx.edu.itsur.pokebatalla.model.ControladorArchivos.FileManajer;

/**
 * Sra. Evelyn
 */
public class Main implements Serializable{

    public static void main(String[] args) {
        System.out.println("¡BIENVENIDO A LA POKEBATALLA!");

        Batalla v = FileManajer.leerPartida();

        if (v == null) {
            Pikachu pikachuSalvaje = new Pikachu();
            Charmander charmanderSalvaje = new Charmander();

            //PIKACHUSALVAJE
            pikachuSalvaje.setNombre("PIKA");
            //EVEE
            Evee PokemonEve1 = new Evee("EVE");

            //AERODACTYL
            Aerodactyl PokemonAero1 = new Aerodactyl("AERO");

            //DRATINI
            Dratini PokemonDra1 = new Dratini("DRA");
            //CHARMANDER
            Charmander PokemonChar1 = new Charmander("CHAR");

            Entrenador n1 = new Entrenador("HARRY");
            n1.capturarPokemon(PokemonDra1);
            n1.capturarPokemon(PokemonChar1);
            Entrenador n2 = new Entrenador("SAMUEL");
            n2.capturarPokemon(PokemonEve1);
            n2.capturarPokemon(PokemonAero1);

            v = new Batalla(n1, n2);
        }
        v.desarrollarBatalla();

    }

}
