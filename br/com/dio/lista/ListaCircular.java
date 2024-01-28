package br.com.dio.lista;

import br.com.dio.no.No;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular(){
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }
    public int size(){
        return this.tamanhoLista;
    }

    public boolean isEmpity(){
        return this.tamanhoLista == 0;
    }

    private No<T> getNo(int index){

        if (!isEmpity()){
            No<T> noGet = this.cauda;
            No<T> noReturn = this.cauda;
            for(int i = 0; (i <= (index - 1) && noGet != null); i++){
                noReturn = noGet;
                noGet.getProximoNo();
            }
            return noReturn;
        }
        return null;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public void add(T conteudo) {

        No<T> novoNo = new No<>(conteudo);

        if (isEmpity()) {
            this.cabeca = novoNo;
            this.cauda = novoNo;
            this.cabeca.setProximoNo(this.cauda);
        } else {
            novoNo.setProximoNo(this.cauda);
            this.cabeca.setProximoNo(novoNo);
            this.cauda = novoNo;
        }

        this.tamanhoLista++;
    }

    public void remove(int index){
        if (index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("Indice maior que o tamanhho da lista:");

        if (index == 0){
            this.cauda = this.cauda.getProximoNo();
            this.cabeca.setProximoNo(this.cauda);
        } else if (index == 1) {
            this.cauda.setProximoNo(this.cauda.getProximoNo().getProximoNo());
        } else {
            No<T> noAuxiliar = this.cauda;
            for (int i = 0; i< index-1; i++){
                noAuxiliar = noAuxiliar.getProximoNo();
            }

            noAuxiliar.setProximoNo(noAuxiliar.getProximoNo().getProximoNo());
        }
        this.tamanhoLista--;
    }
    @Override
    public String toString() {
        String returnString = "------ Lista Dupla -------\n";
        No<T> noAuxiliar = this.cauda;

        for (int i = 0; i < this.size() ; i++){
            returnString += "[No{conteudo="+ noAuxiliar.getConteudo() + " -->\n";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        returnString += this.size() != 0 ? "(Retorna ao Inicio)\n" : "[]\n";
        return returnString + "======== Final ========\n";
    }



}
