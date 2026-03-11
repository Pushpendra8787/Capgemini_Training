package Rough;
import  java.util.*;
public class Aray1 {
    public static void main(String[] args) {

        int arr[]={20,15,26,2,98,6};
        int n=arr.length;
        int ans[]= new int[n];
        for(int i=0;i<n;i++){
            int position=1;
            for(int j=0;j<n;j++){
                if(arr[j]<arr[i]){
                    position++;
                }
            }
            ans[i]=position;
        }
        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }


    }
}
