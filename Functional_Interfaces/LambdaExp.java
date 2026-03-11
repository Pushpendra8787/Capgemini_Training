package Functional_Interfaces;
import java.util.*;
public class LambdaExp {
    public static void main(String[] args) {
        MathOperation add=(a,b)->a+b;
        System.out.println(
        add.opr(2,3));

    }
    @FunctionalInterface
    interface MathOperation{

        int opr(int a,int b);
    }
}
