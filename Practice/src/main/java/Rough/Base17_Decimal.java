package Rough;

import java.util.HashMap;

//import java.util.*;
public class Base17_Decimal {
    static double check(char ch,int count){
        HashMap<Character , Integer> values=new HashMap<>();
        values.put('a',10);
        values.put('b',11);
        values.put('c',12);
        values.put('d',13);
        values.put('e',14);
        values.put('f',15);
        values.put('g',16);
        double ans=0;
        int t=ch-'0';
        if(values.containsKey(ch)){
            int temp=values.get(ch);
            System.out.println(temp);
            ans=temp*Math.pow(17,count);
        }else if(t>0&&t<9){

//            System.out.println(t);
//            System.out.println(Math.pow(17,count));
            ans=(double)t*Math.pow(17,count);
        }
        else {
            System.out.println("Invalid character in string");
            return -1;
        }



        return ans;
    }
    public static void main(String[] args) {

        String s="23gf";


        int n=s.length();
        int ans=0;
        int count=1;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            double result=check(ch,count);
            ans=ans*10+(int)result;
            count++;
        }
        System.out.println(ans);
    }
}
