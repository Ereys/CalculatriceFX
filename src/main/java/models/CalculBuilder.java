package models;

import java.util.Arrays;
import java.util.List;

public class CalculBuilder implements AbstractCalculBuilder{

    private String  value1 = "";
    private String value2 = "";
    private String operator= "";

    List<String> operatorAllowed = Arrays.asList("+", "-", "/", "x");

    private CalculBuilder(){};

    public static CalculBuilder builde(){
        return new CalculBuilder();
    }

    @Override
    public void addToFirstValue(String a) {
        if(a.equals(".")){
            System.out.println("a = .");
            if(!this.value1.contains(".") && !this.value1.isEmpty()) {
                System.out.println("first .");
                this.value1 = value1 + a;
            }
        }else{
            this.value1 = value1 + a;
        }
    }

    @Override
    public void addToSecondValue(String b) {
        if(b.equals(".")){
            if(!this.value2.contains(".") && !this.value2.isEmpty()) {
                this.value2 = value2 + b;
            }
        }else{
            this.value2 = value2 + b;
        }
    }

    @Override
    public void setOperation(String op) {
        if(this.operator.isEmpty()){
            this.operator = op;
        }
    }

    @Override
    public Calcul build() {
        return new Calcul(
                Double.parseDouble(this.value1),
                Double.parseDouble(this.value2),
                this.operator);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if(value2 != null)sb.append(value2);
        if(operator != null) sb.append(operator);
        if(value1 != null) sb.append(value1);
        sb.append("=");
        return sb.toString();
    }
    public String getValue1() {
        return value1;
    }
    public String getValue2() {
        return value2;
    }

}
