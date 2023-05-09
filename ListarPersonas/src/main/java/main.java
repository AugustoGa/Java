
//1ª Deberán crear la clase persona que tiene como atributos nombre y apellido, ambos de tipo String;
// la clase tiene sus métodos getters y setters para cada atributo.

//2ª Deberán crear una segunda clase donde estará el método main como lo conocemos.
// Creen 5 objetos: Personas con nombres y apellidos aleatorios, es importante que sean nombres y apellidos en español.

//3ª Teniendo los 5 objetos, agregarlos a una lista.

//4ª Crear la lógica para ordenar alfabéticamente la lista y mostrar en consola de acuerdo al siguiente criterio:
//     - Ordenado por nombre.
//     - Ordenado por apellido.
//     - Ordenado inversamente por apellido.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class main {
    public static void main (String[] args){
        Personas personas1 = new Personas();
        Personas personas2 = new Personas();
        Personas personas3 = new Personas();
        Personas personas4 = new Personas();
        Personas personas5 = new Personas();


        ArrayList<Personas> Listado = new ArrayList<>();
        Listado.add(personas1);
        Listado.add(personas2);
        Listado.add(personas3);
        Listado.add(personas4);
        Listado.add(personas5);

        System.out.println(
                        Listado.get(0).getNombre() + " _ " +
                        Listado.get(1).getNombre() + " _ " +
                        Listado.get(2).getNombre() + " _ " +
                        Listado.get(3).getNombre() + " _ " +
                        Listado.get(4).getNombre() + " _ "
        );

        ArrayList<Personas> ListaNombre = Personas.sortPersona(Listado, "nombre" );

        System.out.println(
                        ListaNombre.get(0).getNombre() + " _ " +
                        ListaNombre.get(1).getNombre() + " _ " +
                        ListaNombre.get(2).getNombre() + " _ " +
                        ListaNombre.get(3).getNombre() + " _ " +
                        ListaNombre.get(4).getNombre() + " _ "
                //ORDENAR POR NOMBRE
        );

        ArrayList<Personas> ListaApellido = Personas.sortPersona(Listado, "apellido" );
        System.out.println(
                        ListaApellido.get(0).getApellido() + " _ " +
                        ListaApellido.get(1).getApellido() + " _ " +
                        ListaApellido.get(2).getApellido() + " _ " +
                        ListaApellido.get(3).getApellido() + " _ " +
                        ListaApellido.get(4).getApellido() + " _ "
                //ORDENAR POR APELLIDO
        );

        ArrayList<Personas> ListaApellidoInvertido = Personas.sortPersona(Listado, "apellido" );

        Collections. reverse(ListaApellidoInvertido);

        System.out.println(
                        ListaApellidoInvertido.get(0).getApellido() + " _ " +
                        ListaApellidoInvertido.get(1).getApellido() + " _ " +
                        ListaApellidoInvertido.get(2).getApellido() + " _ " +
                        ListaApellidoInvertido.get(3).getApellido() + " _ " +
                        ListaApellidoInvertido.get(4).getApellido() + " _ "
                //ORDENAR POR INVERTIDO
        );

    }


}
