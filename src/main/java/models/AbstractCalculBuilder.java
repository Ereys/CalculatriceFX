package models;

interface AbstractCalculBuilder {

    public void addToFirstValue(String a);

    public void subToFirstValue();

    public void setOperation(String op);
    public void addToSecondValue(String b);

    public void subToSecondValue();

    public Calcul build();



}
