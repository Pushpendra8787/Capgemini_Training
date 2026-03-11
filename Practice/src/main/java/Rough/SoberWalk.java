package Rough;
import java.util.*;
/* Q : A Sober Walk
India's ancient culture has produced many great scholars since time immemorial. Among them were the nine gems (Navaratnas) in the court of King Vikramaditya. Two of these scholars were Varahamihira, a renowned astrologer and author of Brihat Jataka, and Amarasimha, the author of the Sanskrit thesaurus Amarakosha.
During a discussion, Amarasimha asked Varahamihira to determine the final position of a person who starts walking from the origin point (0,0) and moves according to a specific pattern.
Movement Pattern
The person starts at (0,0).
He moves in the following sequence of directions:
Right for 10 units
Up for 20 units
Left for 30 units
Down for 40 units
Right for 50 units
The direction sequence repeats cyclically:
Right → Up → Left → Down → Right → Up → ...
The distance traveled increases by 10 units after every move.
Task
Given an integer n, representing the number of moves, determine the final coordinates (x, y) of the person after completing all moves.*/

public class SoberWalk {
    static int sober(int n){
        int x=0,y=0,count=0;
        for(int i=0;i<n;i++){
            count+=10;
            if(i%2==0){
                x=count-x;
            }
            else{
                y=count-y;
            }        }
        System.out.println("x= "+x+" Y= "+y);
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your value");
        int n= sc.nextInt();
        sober(n);
    }
}
