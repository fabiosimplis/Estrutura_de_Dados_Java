package br.com.dio.arvore.model;

import java.util.Objects;

public class Obj extends ObjArvore<Obj> {

    Integer valor;

    public Obj(Integer valor){
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obj obj = (Obj) o;
        return Objects.equals(valor, obj.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
    @Override
    public int compareTo(Obj outro){

        if (this.valor > outro.valor)
            return 1;
        else if (this.valor < outro.valor) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.valor.toString();
    }
}