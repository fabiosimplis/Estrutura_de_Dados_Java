package br.com.dio.lista;

import br.com.dio.no.No;

public class ListaEncadeada<T> {

    No<T> referenciaNo;

    public ListaEncadeada(){
        this.referenciaNo = null;
    }

    public boolean isEmpity(){
        return referenciaNo == null;
    }

    public int size(){
        int contador = 0;
        No<T> noAuxiliar = referenciaNo;

        while (noAuxiliar != null){
            contador++;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return contador;
    }

    public void add(T conteudo){

        No<T>  novoNo = new No<>(conteudo);

        if (isEmpity()){
            referenciaNo = novoNo;
        }else{

            No<T> auxiliarNo = referenciaNo;
            for (int i = 0; i < (size()-1); i++)
                auxiliarNo = auxiliarNo.getProximoNo();

            auxiliarNo.setProximoNo(novoNo);
        }
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){

        validaIndice(index);

        No<T> noAuxiliar = referenciaNo;
        No<T> noRetorno = referenciaNo;
        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    private void validaIndice(int index){
        if (size() <= index){
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice: " + index );
        }
    }

    public T remove(int index){

        validaIndice(index);
        No<T>  removeNo = getNo(index);
        if (index == 0){
            referenciaNo = removeNo.getProximoNo();
        } else {
           No<T> noAnterior = getNo(index -1);
           noAnterior.setProximoNo(removeNo.getProximoNo());
        }

        return removeNo.getConteudo();
    }

    @Override
    public String toString() {
        String returnString = "------ Lista Encadeada -------\n";

        No noAuxiliar = referenciaNo;

        while (noAuxiliar != null){
            returnString += "[No{dado=" + noAuxiliar.getConteudo() + "}]\n";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return returnString + "====== Final ======\n";

    }
}
