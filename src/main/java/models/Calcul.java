package models;


/**
 * Class which represent a calcul in the format : value1 operation value2 = result, ex: 12 + 8 = 20
 */
public class Calcul {

    private double value1;
    private double value2;

    private double result;

    public String operation;

    public Calcul(double a, double b, String operation){
        this.value1 = a;
        this.value2 = b;
        this.operation = operation;
    }

    public void add(){
        this.result = value1 + value2;
    }

    public void sub(){
        this.result = value1 - value2;
    }
    public void mul(){
        this.result = value1 * value2;
    }
    public void div(){
        if(this.value2==0){
            throw new ArithmeticException("Cannot divide by 0");
        }
        this.result = value1 / value2;
    }

    @Override
    public String toString() {
        return value1 + " " + operation + " " + value2 + " = " + result;
    }


}
