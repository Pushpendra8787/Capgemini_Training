package Functional_Interfaces;

import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<Integer> table=x->{for(int i=1;i<=10;i++) System.out.println(x*i);};
        table.accept(2);
    }
}
