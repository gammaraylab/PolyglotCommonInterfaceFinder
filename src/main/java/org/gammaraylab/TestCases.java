package org.gammaraylab;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCases {

    void pythonLoop(long n) {

        String pythonCode = "def loop(n):\n" +
                "   sum=1\n" +
                "   for i in range(n):\n" +
                "       sum+=i\n";
        try (Context ctx = Context.create()) {
            ctx.eval("python", pythonCode);

            Value pyLoop = ctx.getBindings("python").getMember("loop");
            pyLoop.execute(n);
        }
    }

    void javaLoop(long n) {
        while (n > 10) {
            n--;
        }
    }

    void passingJavaObj(ComplexNum c1) {
        long n = 100_00L;
        while (n > 11) {
            c1.r += (double) n / 153;
            n--;
        }
    }

    long addAndDivide(long a, long b) {
        long sum = a + b;
        long result = sum / 33;
        return result;
    }

    ArrayList<ComplexNum> useJavaObj(long n) {

        ArrayList<ComplexNum> list = new ArrayList<>();
        ComplexNum tmp;
        ComplexNum c1 = new ComplexNum(142, 3143);
        ComplexNum c2 = new ComplexNum(26, 16);

        while (n > 10) {
            ComplexNum c3 = new ComplexNum(912, 31);
            ComplexNum c4 = new ComplexNum(712, 21);
            passingJavaObj(c1);
            passingJavaObj(c4);
            tmp = new ComplexNum(n + 3, n - 22);
            tmp = new ComplexNum(95 - c3.r, c1.i + 300);
            tmp = c1.add(c2);
            list.add(tmp);
            n--;
        }
        return list;
    }

    ComplexNum returnJavaObj(long n) {
        ComplexNum c1 = new ComplexNum(12, 31);
        ComplexNum c2 = new ComplexNum(12, 31);
        ComplexNum res = null;

        while (n > 10) {
            res = c1.add(c2);
            n -= 2;
        }
        return res;
    }

    void addComplexLoop(long n) {
        String programFile = "./src/main/polyglot/pythonTestCases.py";

        try (Context ctx = Context.create()) {
            File file = new File(programFile);
            Source src = Source.newBuilder("python", file).build();
            ctx.eval(src);
            Value pyLoop = ctx.getBindings("python")
                    .getMember("addComplexLoop");   //find the method
            while (n-- > 0)
                pyLoop.execute(100);  //call the python loop

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void run_js_in_python(){

    }
    @FunctionalInterface interface MapFunction { Map printObjects(Map input); }
    public void javaMapInPython (Map<String, Object> javaMap ) {
        Context context = Context.newBuilder().allowHostAccess(true).build();

        Value function = context.eval("python",
                "def printObjects(map):\n"+
                        "   print(map.get(\"college\"))\n"+
                        "   print(map.get(\"location\"))\n"+
                        "   print(map.get(\"pin\"))\n"
        );

        function.as(MapFunction.class).printObjects(javaMap);
    }
}
class ComplexNum {
    double r;
    double i;

    ComplexNum() {
        r = 0;
        i = 0;
    }

    ComplexNum(double r, double i) {
        this.r = r;
        this.i = i;
    }

    ComplexNum add(ComplexNum other) {
        return new ComplexNum(this.r + other.r, this.i + other.r + other.i);
    }
}
