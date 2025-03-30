package my;

public class CommonPrimeDivisors {
    public static void main(String[] args) {
        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};
        System.out.println("Number of pairs with common prime divisors: " + solution(A, B));
    }

    // you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");



    // List<Integer> primeList = new ArrayList<Integer>();
    public static int solution(int[] A, int[] B) {
        // Implement your solution here
        // Primes


        int K=B.length;

        int count=0;

        for(int i=0;i<K;i++){
            if(getPrimedivsorCheck(A[i],B[i])){
                count++;
            }
        }
return count;

    }

    

    public static boolean getPrimedivsorCheck(int N, int M){

        
        int A=0;
        int B=0;
        if(M>N){
            A= M;
            B= N;
        }
        else{
            B=M;
            A=N;
        }


        int gcd = gcd(A,B);

     

        return hasOnlyGCDPrime(A,gcd)&&hasOnlyGCDPrime(B,gcd);

    }



public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static boolean hasOnlyGCDPrime(int N , int GCD){

        while (N!=1){
            int newGCD= gcd(N,GCD);
            if(newGCD==1){
                return false;
            }
            N /=newGCD;
        }
        return true;
    }
    
}
