package mx.edu.itsur.pokebatalla.model.battles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pokemon;
import mx.edu.itsur.pokebatalla.model.ControladorArchivos.FileManajer;

/**
 * Sra. Evelyn
 */
public class Batalla implements Serializable {

    protected Entrenador entrenador1;
    protected Entrenador entrenador2;
    protected int turno = 1;
    protected boolean batallaFinalizada = false;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public boolean hayGanador() {
        return (entrenador1.estaDerrotado() || entrenador2.estaDerrotado());
    }

    public void guardarProgreso() {
        FileManajer.guardarPartida(this);
    }

    public void desarrollarBatalla() {
        System.out.println(" ******************************************************** LA BATTA  INICIO ********************************************************");
        System.out.println("LOS PELEADORES SON: ");
        System.out.println(entrenador1.getNombre() + "    VS   " + entrenador2.getNombre());

        System.out.println("");
        do {
            try {
                eligirPokemon(entrenador1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("SOLAMENTE CUENTAS CON: "
                        + entrenador1.getPokemonsCapturados().size()
                        + " ¡ELEGI ALGUNOS DE ELLOS! ");
                entrenador1.setPokemonActual(null);
            }
        } while (entrenador1.getPokemonActual() == null);

        do {
            try {
                eligirPokemon(entrenador2);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("SOLAMENTE CUENTAS CON: "
                        + entrenador2.getPokemonsCapturados().size()
                        + "  ¡ELEGI ALGUNOS DE ELLOS! ");
                entrenador2.setPokemonActual(null);
            }
        } while (entrenador2.getPokemonActual() == null);

        while (!batallaFinalizada) {
            Entrenador entrenadorEnTurno = (turno == 1) ? entrenador1 : entrenador2;
            Entrenador oponente = (turno == 1) ? entrenador2 : entrenador1;

            System.out.println("TURNO DEL ENTRENADOR: " + entrenadorEnTurno.getNombre());

            if (oponente.getPokemonActual() == null) {
                System.out.println("NO HAY POKEMON SELECCIONADO...");
                return;
            }
            seleccionarAtaque(entrenadorEnTurno, oponente.getPokemonActual());

            if (entrenadorEnTurno.getPokemonActual() == null || entrenadorEnTurno.getPokemonActual().gethp() <= 0) {
                System.out.println("Tu pokemon ya no puede continuar esta dead ELIGE OTRO");
                cambiarPokemon(entrenadorEnTurno);


                /*
                while (entrenadorEnTurno.getPokemonActual() == null || entrenadorEnTurno.getPokemonActual().gethp() <= 0) {
                    System.out.println("Este entrenador no puede avanzar sin cambiar de Pokémon.");
                    cambiarPokemon(entrenadorEnTurno);
                }
                 */
            }
            if (oponente.estaDerrotado()) {
                System.out.println("¡El entrenador " + oponente.getNombre() + " Fue derrotado");
                System.out.println("LA BATALLA TERMINO");
                batallaFinalizada = true;
            } else {
                turno = (turno == 1) ? 2 : 1;
                guardarProgreso();
            }
        }
    }

    private void eligirPokemon(Entrenador entrenadorEnturno) {
        int idx = 1;
        System.out.println(" ------------------------------------------------------ ");
        for (Pokemon pokemon : entrenadorEnturno.getPokemonsCapturados()) {
            if (pokemon.gethp() <= 0) {
                System.out.println(idx + ".- " + pokemon.getClass().getSimpleName() + " 0");
            } else {
                System.out.println(idx + ".- " + pokemon.getClass().getSimpleName() + " "+ pokemon.gethp());
            }

            idx++;
            System.out.println("------------------------------------------------------");
        }
        System.out.println("");
        System.out.println("Elige  pokemon " + entrenadorEnturno.getNombre());

        char auxLectura = '0';

        try {
            auxLectura = (char) System.in.read();
            System.in.read((new byte[System.in.available()]));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Pokemon pokemonSeleccionado = entrenadorEnturno.getPokemonsCapturados()
                .get(Character.getNumericValue(auxLectura) - 1);
        entrenadorEnturno.setPokemonActual(pokemonSeleccionado);
    }

    private void seleccionarAtaque(Entrenador entrenadorEnturno, Pokemon oponente) {

        Pokemon pokemonActual = entrenadorEnturno.getPokemonActual();

        System.out.println("-----------------------------------------------------");
        System.out.println("Seleccione un ataque para " + pokemonActual.getClass().getSimpleName() + ":");

        int idx = 1;

        for (Enum movimiento : pokemonActual.getMovimientos()) {
            System.out.println(idx + ".- " + movimiento);
            idx++;
        }
        System.out.println("-----------------------------------------------------");

        int opcionAtaque = -1;

        //Si el usuario (tu) No elige un numero de ataque correcto para su pokemon lo que va a hacer es que va a mdar un mensaje de error de movimiento
        //Y se va a repetir hasta que eliga un numero valido y va cambiar de turno cundo eso pase
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String input = br.readLine();

                // Intentar convertir la entrada a un entero
                opcionAtaque = Integer.parseInt(input);

                if (opcionAtaque < 1 || opcionAtaque > pokemonActual.getMovimientos().length) {
                    System.out.println("La opción de ataque no es válida. Inténtalo de nuevo.");
                } else {
                    break;  // Salir del bucle si no hay excepciones y la opción es válida
                }
            } catch (IOException ex) {
                System.out.println("Error al leer la entrada. Inténtalo de nuevo.");
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, ingrese un número válido. Inténtalo de nuevo.");
            }
        }

        //llamar al metodo instruirMovimientoAlPokemonActual
        entrenadorEnturno.IntruirMovimientoActualAlPokemon(oponente, opcionAtaque-1);

    }

    private void cambiarPokemon(Entrenador entrenador) {
        System.out.println("¿Deseas cambiar de Pokémon? (S/N)");
        char respuesta = 'N';
        while (true) {
            try {
                respuesta = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
                break;  
            } catch (IOException ex) {
                System.out.println("Error de entrada o salida al leer la respuesta. Intenta de nuevo.");
                ex.printStackTrace();
            }
        }

        if (respuesta == 'S' || respuesta == 's') {

            System.out.println("Pokémon disponibles:");
            int idx = 1;
            for (Pokemon pokemon : entrenador.getPokemonsCapturados()) {
                System.out.println(idx + ".- " + pokemon.getClass().getSimpleName());
                idx++;
            }

            System.out.println("Elige un nuevo Pokémon:");

            char auxLectura = '0';

            try {
                auxLectura = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            int indicePokemonNuevo = Character.getNumericValue(auxLectura) - 1;

            if (indicePokemonNuevo >= 0 && indicePokemonNuevo < entrenador.getPokemonsCapturados().size()) {
                Pokemon nuevoPokemon = entrenador.getPokemonsCapturados().get(indicePokemonNuevo);
                entrenador.setPokemonActual(nuevoPokemon);
                System.out.println("Has cambiado a " + nuevoPokemon.getClass().getSimpleName() + " en tu equipo.");
            } else {
                System.out.println("La opción de Pokémon no es válida. Intenta de nuevo.");
            }
        }
    }
}
