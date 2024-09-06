 package org.gammaraylab;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Locale;

 public class Main {
    public static void main(String[] args) {
        long n=1000_000L;
        ComplexNum c1= new ComplexNum(23.4, 453.2);
        TestCases tc= new TestCases();

//        tc.passingJavaObj(c1);
        ArrayList<ComplexNum> l=tc.useJavaObj(n);
        System.out.println(l.size());
//        tc.addComplexLoop(5000);
//        tc.pythonLoop(1000000L);
//        tc.rubyLoop();
    }
 }
