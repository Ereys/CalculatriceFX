package models;

interface AbstractCalculBuilder {

    public void addToFirstValue(String a);
    public void setOperation(String op);
    public void addToSecondValue(String b);

    public Calcul build();



}
