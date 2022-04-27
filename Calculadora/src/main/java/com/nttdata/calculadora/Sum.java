package com.nttdata.calculadora;

public class Sum implements IOperacion {


    @Override
    public double operacion(double a, double b) {
        return a+b;
    }
}
