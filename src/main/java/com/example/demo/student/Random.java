package com.example.demo.student;


interface RandInterface{
    void run();
}
public class Random{
    public static void main(String []args){
        RandomImp ri = new RandomImp();
        ri.run();
        ri.run2();
    }
}

class RandomImp implements RandInterface{
    int i=5;
    String name = "Shrey";


    public void run(){
        System.out.println("running interface method");
    }

    public void run2(){
        System.out.println("Runnin one more method");
    }

}
