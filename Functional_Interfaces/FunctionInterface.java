package Functional_Interfaces;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Integer,Integer>doubleit=x->2*x;
        System.out.println(doubleit.apply(5));
        Function<Integer,Integer>tripple=x->3*x;
        System.out.println(doubleit.andThen(tripple).apply(5));
    }
}
