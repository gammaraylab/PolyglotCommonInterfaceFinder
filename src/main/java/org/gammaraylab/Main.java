 package org.gammaraylab;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Locale;

 public class Main {
    public static void main(String[] args) {
        System.out.println(loop());
    }

    static long loop(){
        TestCases tc= new TestCases();
        long i=10000L;
        long res=0;
        tc.addComplexLoop(i);
        return res;
    }
 }
