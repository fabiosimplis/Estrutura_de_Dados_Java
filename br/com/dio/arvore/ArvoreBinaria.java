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

    public void exibirInOrder(){
        System.out.println("\n Exibindo InOrdem");

        exibirInOrder(this.raiz);
    }
    private void exibirInOrder(BinNo<T> atual) {

        if(atual != null){
            exibirInOrder(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            exibirInOrder(atual.getNoDir());
        }
    }

    public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrdem");

        exibirInOrder(this.raiz);
    }
    private void exibirPosOdem(BinNo<T> atual) {

        if(atual != null){
            exibirInOrder(atual.getNoEsq());
            exibirInOrder(atual.getNoDir());
            System.out.println(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem(){
        System.out.println("\n Exibindo PreOrdem");

        exibirInOrder(this.raiz);
    }
    private void exibirPreOdem(BinNo<T> atual) {

        if(atual != null){
            System.out.println(atual.getConteudo() + ", ");
            exibirInOrder(atual.getNoEsq());
            exibirInOrder(atual.getNoDir());
        }
    }

    public void remover(T conteudo){

        try{
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && atual.getConteudo().equals(conteudo)){

                pai = atual;

                if (conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }

                if (atual == null){
                    System.out.println("Conteudo não encontrado");
                }

                if (pai == null){
                    if (atual.getNoDir() == null){
                        this.raiz = atual.getNoEsq();
                    }else if (atual.getNoEsq() == null){
                        this.raiz = atual.getNoDir();
                    } else {
                        for (temp = atual, filho = atual.getNoEsq();
                            filho.getNoDir() != null;
                            temp = filho, filho = filho.getNoEsq()
                        ){
                            if(filho != atual.getNoEsq()){
                                temp.setNoDir(filho.getNoEsq());
                                filho.setNoEsq(raiz.getNoEsq());
                            }
                        }

                        filho.setNoDir(raiz.getNoDir());
                        raiz = filho;
                    }
                } else if (atual.getNoDir() == null){
                    if (pai.getNoEsq() == atual){
                        pai.setNoEsq(atual.getNoEsq());
                    } else {
                        pai.setNoDir(atual.getNoEsq());
                    }
                } else if (atual.getNoEsq() == null) {
                    if (pai.getNoEsq() == atual){
                        pai.setNoEsq(atual.getNoDir());
                    } else {
                        pai.setNoDir(atual.getNoDir());
                    }
                } else {

                    for (
                          temp = atual, filho = atual.getNoEsq();
                          filho.getNoDir() != null;
                          temp = filho, filho = filho.getNoDir()
                    ){
                        if (filho != atual.getNoEsq()) {
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(atual.getNoEsq());
                        }
                        filho.setNoDir(atual.getNoDir());

                        if (pai.getNoEsq() == atual){
                            pai.setNoEsq(filho);
                        } else {
                            pai.setNoDir(filho);
                        }
                    }
                }
            }

        } catch (NullPointerException erro){
            System.out.println("Conteudo não encontrado:");
        }
    }

}
