package com.corndel.exercises;

public class Counter {

    private int count;
    String name = "Not Named";

    public Counter(){
        this.count = 0;
    }
    public Counter(String name){
        this.count = 0;
        this.name = name;
    }

    public void increment(){
        this.count += 1;
    }

    public void reset(){
        this.count = 0;
    }

    public int getCount(){
        return this.count;
    }

    public static void main(String[] args) {
        Counter game1 = new Counter();
        game1.count = 10;
        System.out.println(game1.getCount());

        Counter game2 = new Counter("Jumanji");
        System.out.println(String.format("Game 2 is called %s",game2.name));

    }
}




