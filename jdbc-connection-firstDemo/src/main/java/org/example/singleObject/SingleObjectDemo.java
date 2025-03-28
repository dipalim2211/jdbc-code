package org.example.singleObject;
//Singleton Design Pattern
//Singleton Class : Class That can have only one object(instance of class) at a time

class SingleObject{

    static SingleObject instance = null;

    private SingleObject(){

        System.out.println("SingleObject Constructor called");

    }

    static SingleObject getInstance()
    {
        if(instance==null){
            instance = new SingleObject(); //First Create object and store in instance
        }
        return instance; //next time return instance
    }

}

public class SingleObjectDemo {

    public static void main(String[] args) {

        SingleObject o1 = SingleObject.getInstance();
        SingleObject o2 = SingleObject.getInstance();
        SingleObject o3 = SingleObject.getInstance();
        System.out.println(o1);
        System.out.println(o1);
        System.out.println(o1);

    }

}
