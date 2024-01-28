package br.com.dio.testes;

import br.com.dio.lista.ListaCircular;

public class TestaListaCircular {

    public static void main(String[] args) {

        ListaCircular<Integer> listaCircular = new ListaCircular<>();

        listaCircular.add(0);
        listaCircular.add(1);
        System.out.println(listaCircular.toString());
        //System.out.println(listaCircular.get(0));
        //System.out.println(listaCircular.get(1));
    }
}
