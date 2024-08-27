 package org.gammaraylab;

 public class Main {
    public static void main(String[] args) {
        longIteration(1000_000_0L);
    }

    static void longIteration(long n){
        while(n>0){
            n--;
        }
    }
}
