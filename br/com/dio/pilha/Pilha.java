package br.com.dio.pilha;

import br.com.dio.no.No;

public class Pilha {

    private No refNo;

    public Pilha() {
        this.refNo = null;
    }

    public boolean isEmpty(){
        return (refNo == null);
    }

    public No top(){
        return refNo;
    }

    public void push(No novoNo){
        No refAuxiliar = refNo;
        refNo = novoNo;
        refNo.setProximoNo(refAuxiliar);

    }

    public No pop(){

        if (!isEmpty()){
            No refAux = refNo;
            refNo = refNo.getProximoNo();
            return refAux;
        }
        return null;
    }

    @Override
    public String toString() {

        String returnString = "------ Pilha -------\n";

        No noAuxiliar = refNo;

        while (noAuxiliar != null){
            returnString += "[No{dado=" + noAuxiliar.getConteudo() + "}]\n";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return returnString + "====== Final ======\n";
    }
}
