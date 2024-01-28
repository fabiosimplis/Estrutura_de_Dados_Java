package br.com.dio.lista;

import br.com.dio.no.No;
import br.com.dio.no.NoDuplo;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public int size(){
        return tamanhoLista;
    }
    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i = 0 ; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        return noAuxiliar;
    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoAnterior(ultimoNo);

        if (primeiroNo == null){
            primeiroNo = novoNo;
        } else if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;

        tamanhoLista++;
    }

    public void add(int index, T elemento){//TODO adicionar no inicio ou no meio

        NoDuplo<T> alvoNo = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(alvoNo);

        if (tamanhoLista == 0){
            primeiroNo = ultimoNo = novoNo;
        }else if (index == 0){
            alvoNo.setNoAnterior(novoNo);
            primeiroNo = novoNo;
        } else if (novoNo.getNoProximo() != null) {
            //1 3
            novoNo.setNoAnterior(alvoNo.getNoAnterior());
            alvoNo.getNoAnterior().setNoProximo(novoNo);
            alvoNo.setNoAnterior(novoNo);
        } else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo.setNoProximo(novoNo);
            ultimoNo= novoNo;
        }

       /* NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if(novoNo.getNoProximo() != null){
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getNoProximo().setNoAnterior(novoNo);
        }else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }
        if(index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoAnterior().setNoProximo(novoNo);
        }
*/        //System.out.println("Ultimo" + ultimoNo.getConteudo());
        tamanhoLista++;

    }

    public T remove(int index){

        NoDuplo<T> removeNo = getNo(index);

        if (index == 0){
           primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null)
                primeiroNo.setNoAnterior(null);
        } else if (removeNo == null || removeNo.getNoProximo() == null ){
            removeNo = ultimoNo;
            ultimoNo = ultimoNo.getNoAnterior();
            ultimoNo.setNoProximo(null);
        } else {
            NoDuplo<T> noAnterior = getNo(index -1);
            NoDuplo<T> noPosterior = getNo(index +1);

            noAnterior.setNoProximo(noPosterior);
            noPosterior.setNoAnterior(noAnterior);
        }


        tamanhoLista--;
        return removeNo.getConteudo();
    }

    @Override
    public String toString() {
        String returnString = "------ Lista Dupla -------\n";
        if (tamanhoLista != 0) {

            for (int i = 0; i < tamanhoLista; i++) {
                //System.out.println(getNo(i).getNoAnterior() + " <- " + get(i) + " -> " + getNo(i).getNoProximo() + "\n");
                returnString += getNo(i).getNoAnterior() + " <- " + get(i) + " -> " + getNo(i).getNoProximo() + "\n";
            }
        }
        return returnString + "======== Final ========\n";
    }
}
