/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

/**
 *
 * @author Administrator
 */
import java.util.*;

class DiskSizeComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer t, Integer t1) {
        if(t < t1) return 1;
        else if(t > t1) return -1;
        else return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class Que_Disk_Tower {
    public static void main(String args[] )
    {
        int N, currentExpected = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new DiskSizeComparator());
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        s.nextLine();
        currentExpected = N;
        
        for(int i=0; i<N; ++i)
        {
            int temp = s.nextInt();
            if(temp == currentExpected)
            {
                System.out.print(temp + " ");
                currentExpected--;
                //System.out.println("Inside If currentExpected: " + currentExpected );
                while(!pq.isEmpty() && (pq.peek() == currentExpected))
                {
                    System.out.print(pq.poll() + " ");
                    currentExpected--;
                    //System.out.println("Inside while currentExpected: " + currentExpected);
                }
                
            }
            else
            {
                pq.add(temp);
                //System.out.println("Inside else currentExpected: " + 
                //        currentExpected + " PQ peek: " + pq.peek());
            }
            System.out.println();
            //System.out.println("PQ:  " + pq.toString());
        }
    }
}
