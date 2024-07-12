package org.example.Connexion1ALINF7.TestSingleton;

public class Test {
    public static void main(String[] args) {
        B b1=new B();
        B b2=new B();
        System.out.println(b1);
        System.out.println(b2);

        A a1=A.getInstance();
        A a2=A.getInstance();

        System.out.println(a1);
        System.out.println(a2);

        a1.setX(5);
        System.out.println(a1.getX());
        a2.setX(7);
        System.out.println(a1.getX());

    }
}
