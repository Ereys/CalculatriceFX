package models;

interface AbstractCalculBuilder {

    public void setFirstValue(double a);
    public void setOperation(String op);
    public void setSecondValue(double b);

    public Calcul build();



}
