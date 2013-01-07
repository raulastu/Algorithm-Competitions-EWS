package listas;

import java.util.ArrayList;


public class Lista {

    Nodo primero,ultimo;

    void ingresar(int numero){
        Nodo actual = new Nodo(numero,null);
        if(primero==null){
            primero=ultimo=actual;
        }else{
            ultimo.sig=actual;
            ultimo=actual;
        }
    }
    void mostrar(){
        Nodo p = primero;
        while(p!=null){
            System.err.print(p.valor+" ");
            p=p.sig;
        }
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;

        Integer c = a+b;
        Object s = new Integer(1);
        Object s2 = "asdsad";
        Object s3=new Integer(3);
        System.err.println((Integer)s+(Integer)s3);

        Lista l = new Lista();
        l.ingresar(1);
        l.ingresar(12);
        l.ingresar(12);
        l.ingresar(13);
        l.ingresar(12);
        l.ingresar(12);
        l.mostrar();
    }
}
