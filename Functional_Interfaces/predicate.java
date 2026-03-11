package Functional_Interfaces;

import java.util.function.Predicate;

public class predicate {

    public static void main(String[] args) {
      Predicate<Integer> isEven =x-> x%2==0;
        System.out.println(isEven.test(4));


    }


}
