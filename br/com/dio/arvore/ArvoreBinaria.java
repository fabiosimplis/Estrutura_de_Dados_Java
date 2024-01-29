package br.com.dio.arvore;

import br.com.dio.no.BinNo;

public class ArvoreBinaria <T extends Comparable<T>>{

    private BinNo<T> raiz;
    public ArvoreBinaria(){
        this.raiz = null;
    }
    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);

        this.raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){

        if (atual == null){
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual, novoNo));
        } else {
            atual.setNoDir(inserir(atual, novoNo));
        }

        return atual;
    }


}
