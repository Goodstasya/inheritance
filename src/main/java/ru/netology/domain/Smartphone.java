package ru.netology.domain;

public class Smartphone extends Product {
    private String producer;

    public Smartphone(){
        super();
    }

    public Smartphone(int Id, String Name, int Price, String Producer) {
        super(Id, Name, Price);
        this.producer = Producer;
    }


    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
