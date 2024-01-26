package br.com.dio.fila;

import br.com.dio.no.No;

public class Fila {

    private No referecniaNoFila;

    public Fila(){
        this.referecniaNoFila = null;

    }

    public boolean isEmpity(){
        return (referecniaNoFila == null);
    }

    public No first(){
        if (!isEmpity()){

            No primeiroNo = referecniaNoFila;

            while (primeiroNo.getProximoNo() != null){
                primeiroNo = primeiroNo.getProximoNo();
            }
            return primeiroNo;
        }

        return null;
    }

    //Enfilerar
    public void enqueue(No novoNo){
        novoNo.setProximoNo(referecniaNoFila) ;
        referecniaNoFila = novoNo;
    }

    public No dequeue(){
        if (!isEmpity()){
            No primeiroNo = referecniaNoFila;
            No noAuxiliar = referecniaNoFila;
            while (primeiroNo.getProximoNo() != null){
                noAuxiliar = primeiroNo;
                primeiroNo = primeiroNo.getProximoNo();
            }
            noAuxiliar.setProximoNo(null);
            return primeiroNo;
        }

        return null;
    }

    @Override
    public String toString() {

        String returnString = "------ Fila -------\n";

        No noAuxiliar = referecniaNoFila;

        while (noAuxiliar != null){
            returnString += "[No{dado=" + noAuxiliar.getConteudo() + "}]\n";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return returnString + "====== Final ======\n";
    }

}
