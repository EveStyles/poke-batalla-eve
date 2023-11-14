package mx.edu.itsur.pokebatalla;

import mx.edu.itsur.pokebatalla.model.Pokemons.Aerodactyl;
import mx.edu.itsur.pokebatalla.model.Pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.Pokemons.Dratini;
import mx.edu.itsur.pokebatalla.model.Pokemons.Evee;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pikachu;
import mx.edu.itsur.pokebatalla.model.battles.Batalla;
import mx.edu.itsur.pokebatalla.model.battles.Entrenador;

/**
 * Sra. Evelyn Michelle Caro Pérez s22120162
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("¡BIENVENIDO A LA POKEBATALLA!");

        Pikachu a = new Pikachu("PIKACHUU");
        Evee b = new Evee("EVEEE");
        Dratini c = new Dratini("DRATINII");
        Aerodactyl d = new Aerodactyl("AEROO");
        Charmander e = new Charmander("ROJOO");

        Entrenador en1 = new Entrenador("SAMUEL");
        en1.capturarPokemon(a);
        en1.capturarPokemon(e);

        Entrenador en2 = new Entrenador("HARRY");
        en2.capturarPokemon(b);
        en2.capturarPokemon(c);

        Batalla x = new Batalla(en1, en2);
        x.desarrollarBatalla();

        /**
         * Evee e = new Evee ("EVEE"); Dratini d = new Dratini("DATRINI");
         * Aerodactyl a = new Aerodactyl("AERODACTYL"); Pikachu p = new
         * Pikachu("PIKACHUUU");
         *
         *
         * a.atacar(e, Aerodactyl.Movimientos.ATAQUEARENA);
         * System.out.println("---------------------"); a.atacar(d,
         * Aerodactyl.Movimientos.ATAQUERAPIDO);
         * System.out.println("---------------------"); a.atacar(p,
         * Aerodactyl.Movimientos.AVALANCHA);
         * System.out.println("---------------------"); e.atacar(d,
         * Evee.Movimientos.BOMBASONICA);
         * System.out.println("---------------------"); e.atacar(a,
         * Evee.Movimientos.BOMBAHUEVO);
         * System.out.println("---------------------"); e.atacar(p,
         * Evee.Movimientos.BOMBASONICA);
         * System.out.println("---------------------"); p.atacar(e,
         * Pikachu.Movimientos.IMPACTRUENO);
         * System.out.println("---------------------"); p.atacar(d,
         * Pikachu.Movimientos.ATAQUE_RAPIDO);
         * System.out.println("---------------------"); p.atacar(a,
         * Pikachu.Movimientos.LATIGO);
         * System.out.println("---------------------"); d.atacar(e,
         * Dratini.Movimientos.FURIADRAGON);
         * System.out.println("---------------------"); d.atacar(a,
         * Dratini.Movimientos.COLADRAGON);
         * System.out.println("---------------------"); d.atacar(p,
         * Dratini.Movimientos.DANZADRAGON);
        System.out.println("---------------------");*
         */
    }

}
