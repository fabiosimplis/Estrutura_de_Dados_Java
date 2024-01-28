package br.com.dio.testes;

import br.com.dio.lista.ListaDuplamenteEncadeada;

public class TestaListaDupla {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada<Integer> listadupla = new ListaDuplamenteEncadeada<>();
        listadupla.add(1);
        listadupla.add(2);
        listadupla.add(3);
        //System.out.println(listadupla.toString());

        listadupla.remove(1);
        //System.out.println(listadupla.toString());

        ListaDuplamenteEncadeada<Integer> listadupla2 = new ListaDuplamenteEncadeada<>();
        listadupla2.add(0,3);
        //listadupla2.add(0,1);
        //listadupla2.add(1,2);
        //listadupla2.add(5,5);
        //listadupla2.add(1,99);
        //listadupla2.add(1,2);
        //listadupla2.add(1,99);
        System.out.println(listadupla2.toString());

        //listadupla2.remove(1);
        //listadupla2.remove(9);
        listadupla2.remove(0);
        System.out.println(listadupla2.toString());
    }
}
