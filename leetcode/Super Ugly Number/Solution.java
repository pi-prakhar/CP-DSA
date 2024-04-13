import java.util.PriorityQueue;

class Solution {
    
    public static int nthSuperUglyNumber(int n, int[] primes) {  
        int[] ugly = new int[n];
        ugly[0] = 1;     
        int[] idx = new int[primes.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> ((primes[i]*ugly[idx[i]]) - (primes[j]*ugly[idx[j]])));

        for(int i= 0; i < primes.length; i++)
            pq.add(i);
        
        int count  = 1;  
        while(count < n){
            int curr = pq.poll();          
            if((primes[curr] * ugly[idx[curr]]) == ugly[count - 1])
                idx[curr]++;
            else
                ugly[count++] = ugly[idx[curr]]*primes[curr];
            pq.add(curr);
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = new int[]{2,7,13,19};
        int n = 12;
        System.out.println(nthSuperUglyNumber(n,primes));
    }
}