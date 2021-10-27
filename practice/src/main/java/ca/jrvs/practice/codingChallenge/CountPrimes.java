package ca.jrvs.practice.codingChallenge;

public class CountPrimes {

    //O(n^2) solution. there is a nested for-loop
    public int countPrimes(int n){
        int count = 0;

        if(n==0||n==1)
            return 0;

        for(int i=n-1; i>0; i--){
            if(checkPrime(i)==true)
                count++;
        }
        return count;
    }

    public boolean checkPrime(int n){
        int half = (int) (n/2)+1;

        if(n==2)
            return true;
        else if(n==1)
            return false;

        for(int i=2; i<=half; i++){ //skips 0 as 1/0 is undefined & skips 1 because everything is divisible by 1
            if(n%i==0)
                return false;
        }
        return true;
    }

}