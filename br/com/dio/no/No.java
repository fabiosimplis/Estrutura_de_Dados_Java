package br.com.dio.no;

public class No<T> {

    private T conteudo;
    private No<T> proximoNo;

    public No (T conteudo){
        this.conteudo = conteudo;
        this.proximoNo = null;
    }

    public Object getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximoNo(){
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }




    @Override
    public String toString() {
        return "No{" +
                "conteudo='" + conteudo + '\'' +
                '}';
    }
}
