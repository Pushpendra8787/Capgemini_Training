package Rough;

public class rough {
    public static void main(String[] args) {
        System.out.println("hello");
        int arr[]={4,5,0,1,9,0,5,0};
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                count++;
            }
        }
        for(int i=0;i<n-1;i++){
            if(arr[i]==0){
            for(int j=i+1;j<n-1;j++){
                if(arr[j]!=0){
                    arr[i]=arr[j];
                    arr[j]=0;
                    break;
                }
            }
            }
        }
        for(int i=n-1;i<n-count;i--){
            arr[i]=0;
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
