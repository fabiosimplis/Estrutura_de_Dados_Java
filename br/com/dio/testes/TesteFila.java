package br.com.dio.testes;

import br.com.dio.fila.Fila;
import br.com.dio.no.No;

public class TesteFila {

    public static void main(String[] args) {

        Fila<String> fila = new Fila<>();

        fila.enqueue("1");
        fila.enqueue("2");
        fila.enqueue("3");
        fila.enqueue("4");
        fila.enqueue("5");
        System.out.println(fila);
        fila.dequeue();
        System.out.println(fila);

        System.out.println("Primeiro " + fila.first());
    }
}
