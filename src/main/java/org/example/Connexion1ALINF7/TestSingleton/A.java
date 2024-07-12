package org.example.Connexion1ALINF7.TestSingleton;

public class A {

    private int x;
    private static A a;
    private A(){
        System.out.println("je suis TestSingleton.org.example.A");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static A getInstance()
    {
        if(a==null)
            a=new A();
        return a;
    }
}
