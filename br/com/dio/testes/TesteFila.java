package br.com.dio.testes;

import br.com.dio.fila.Fila;
import br.com.dio.no.No;

public class TesteFila {

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.enqueue(new No("1"));
        fila.enqueue(new No("2"));
        fila.enqueue(new No("3"));
        fila.enqueue(new No("4"));
        fila.enqueue(new No("5"));
        System.out.println(fila);
        fila.dequeue();
        System.out.println(fila);

        System.out.println("Primeiro " + fila.first());
    }
}
