package com.nttdata.calculadora;

public class Calculadora {




    public static void main(String[] args) {

        Sum obj = new Sum();
        Rset obj2= new Rset();
        Mult obj3 = new Mult();

        obj.operacion(1,2);
        obj2.operacion(1,2);
        System.out.println(obj3.operacion(1,2));


    }


}


