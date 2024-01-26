package br.com.dio.testes;

import br.com.dio.no.No;
import br.com.dio.pilha.Pilha;

public class TestaPilha {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(new No("1"));
        pilha.push(new No("2"));
        pilha.push(new No("3"));
        pilha.push(new No("4"));
        pilha.push(new No("5"));
        pilha.push(new No("6"));

        System.out.println(pilha);

        System.out.println(pilha.top());

        System.out.println(pilha.pop().getConteudo());

        System.out.println(pilha);
    }
}
