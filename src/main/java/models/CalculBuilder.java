package models;

import java.util.Arrays;
import java.util.List;

public class CalculBuilder implements AbstractCalculBuilder{

    private double value1;
    private double value2;
    private String operator;

    List<String> operatorAllowed = Arrays.asList("+", "-", "/", "*");

    private CalculBuilder(){};

    public static CalculBuilder builde(){
        return new CalculBuilder();
    }

    @Override
    public void setFirstValue(double a) {
        this.value1 = a;
    }

    @Override
    public void setOperation(String op) {
        if(operatorAllowed.contains(op)){
            this.operator = op;
        }
        throw new IllegalArgumentException("Wrong operator");
    }

    @Override
    public void setSecondValue(double b) {
        this.value2 = b;
    }

    @Override
    public Calcul build() {
        return new Calcul(this.value1, this.value2, this.operator);
    }
}
