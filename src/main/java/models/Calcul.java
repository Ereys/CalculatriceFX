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

        switch(this.operation){
            case "+" -> add();
            case "-" -> sub();
            case "x" -> mul();
            case "/" -> div();
            case "%" -> mod();
        }
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

    public void mod(){
        this.result = this.value1%this.value2;
    }

    public double getResult(){
        return this.result;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return value1 + " " + operation + " " + value2 + " = " + result;
    }


}
