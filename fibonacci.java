import java.util.*;
public class fibonacci{
    //recursive
    static int fibrecursive(int n){
        //stoping condition
        if(n<=1){
            return n;
        }
        return fibrecursive(n-1) + fibrecursive(n-2);
    }

    //non recursive
    static void fibnonrecursive(int n){
        int a=0, b=1,c;
        System.out.print("fibonnaci series non recursive:");

        for(int i=0;i<n;i++){
            System.out.print(a+" ");
            c=a+b;
            a=b;
            b=c;

        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number:");
        int n = sc.nextInt();

        System.out.println("Recursive:");
        for(int i=0;i<n;i++){
            System.out.println(fibrecursive(i)+" ");
        }

        System.out.println();

        fibnonrecursive(n);
        sc.close();
    }
}

/*
Approach: Recursion and Iteration

1. Recursive Method:
   Time Complexity: O(2^n)
   Space Complexity: O(n)
  - Each function call makes two more recursive calls:
     fib(n-1) and fib(n-2).
   - This creates an exponential number of calls.
   - Maximum recursion depth is n, so stack space is O(n).

2. Iterative Method:
   Time Complexity: O(n)
   Space Complexity: O(1)
   A loop runs n times to calculate Fibonacci numbers.
   - Each iteration takes constant time.
   - Only a fixed number of variables are used.

Explanation:
- Recursive method calls itself to calculate Fibonacci numbers.
- Iterative method uses a loop to calculate Fibonacci numbers.
- Iterative method is more efficient in terms of time and space.
*/