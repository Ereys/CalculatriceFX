package models;

import utils.StringManipulation;

public class CalculBuilder implements AbstractCalculBuilder{

    private String  value1 = "";
    private String value2 = "";
    private String operator= "";


    /**
     * Allow to build calcul
     */
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
    public void subToFirstValue() {
        this.value1  = StringManipulation.removeLastChar(this.value1);
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
    public void subToSecondValue() {
       this.value2 =  StringManipulation.removeLastChar(this.value2);
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
        if(value1 != null) sb.append(value1);
        if(operator != null) sb.append(operator);
        if(value2 != null)sb.append(value2);
        sb.append("=");
        return sb.toString();
    }

    public String toStringWithSpecialOperation(){
        return switch(this.operator){
            case "1/x" ->  "1/" + this.value1;
            case "x^2" ->  "sqr(" +this.value1 + ")";
            case "2√x" ->  "√(" + this.value1 + ")";
            default -> "";
        };
    }

    public String getValue1() {
        return value1;
    }
    public String getValue2() {
        return value2;
    }

}
