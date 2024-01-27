package br.com.dio.testes;

import br.com.dio.lista.ListaEncadeada;

public class TestaListaEncadeada {

    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        System.out.println(lista.size());
        System.out.println(lista);
        System.out.println("Conteudo " + lista.get(3));
        System.out.println("Remove " + lista.remove(1));
        System.out.println("Size: " + lista.size());
        System.out.println(lista);
    }
}
