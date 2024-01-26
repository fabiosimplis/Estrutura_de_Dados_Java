package br.com.dio.fila;

import br.com.dio.no.No;

public class Fila<T> {

    private No<T> referecniaNoFila;

    public Fila(){
        this.referecniaNoFila = null;

    }

    public boolean isEmpity(){
        return (referecniaNoFila == null);
    }

    public T first(){
        if (!isEmpity()){
            No primeiroNo = referecniaNoFila;
            while (primeiroNo.getProximoNo() != null){
                primeiroNo = primeiroNo.getProximoNo();
            }
            return (T) primeiroNo.getConteudo();
        }

        return null;
    }

    //Enfilerar
    public void enqueue(T obj){
        No novoNo = new No(obj);
        novoNo.setProximoNo(referecniaNoFila) ;
        referecniaNoFila = novoNo;
    }

    public T dequeue(){
        if (!isEmpity()){
            No primeiroNo = referecniaNoFila;
            No noAuxiliar = referecniaNoFila;
            while (primeiroNo.getProximoNo() != null){
                noAuxiliar = primeiroNo;
                primeiroNo = primeiroNo.getProximoNo();
            }
            noAuxiliar.setProximoNo(null);
            return (T) primeiroNo.getConteudo();
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
