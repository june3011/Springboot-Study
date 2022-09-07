package org.example;

// java -> class -> jar

import org.example.components.B;
import org.example.myclass.C;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        AnnotationConfigApplicationContext acac =
                new AnnotationConfigApplicationContext(AppCtx.class);

        A a = acac.getBean(A.class);
        a.doA();

        B b = acac.getBean(B.class);
        b.doB();

        C c = acac.getBean(C.class);
        c.doC();

        acac.close();

    }
}