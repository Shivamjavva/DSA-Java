import java.util.Scanner;
public class palindrome {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=input.nextInt();
        boolean max=palin(n);
        if(max){
            System.out.println("number is palindrome");

        }
        else{
            System.out.println("number is not palindrome");
        }


    }
    private  static boolean palin(int n){
        if(n<0){
            return false;
        }
        int temp=n;
        int rev=0;
        while(temp>0){
            int rem=temp%10;
            rev=rev*10+rem;
            temp/=10;
        }
        return n==rev;

    }
}
