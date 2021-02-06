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

public class Que_HE_Mok_Pow_Tim {
    public static void main(String args[] )
    {
        
        int time = 0;
        queue q, q1;
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        int[] callOrder = new int[200];
        int[] idealOrder = new int[200];
        
        for(int i=0; i<N; ++i)
        {
            callOrder[i] = s.nextInt();
        }
        s.nextLine();
        //s.next();
        for(int i=0; i<N; ++i)
        {
            idealOrder[i] = s.nextInt();
        }
        s.nextLine();
        //s.next();
        q = new queue(N, 0, N);
        q1 = new queue(N, 0, N);
        
        /*for(int i=0; i<N; ++i)
        {
            System.out.print(callOrder[i] + " ");
        }
        System.out.println();
        for(int i=0; i<N; ++i)
        {
            System.out.print(idealOrder[i] + " ");
        }
        System.out.println();*/
        
        while(q.size() != 0)
        {
            if(q.front(callOrder) == q1.front(idealOrder))
            {
                q.deQueue(callOrder);
                q1.deQueue(idealOrder);
                time++;
            }
            else
            {
                int t = q.front(callOrder);
                q.deQueue(callOrder);
                q.enQueue(t, callOrder);
                time++;
            }
        }
        
        System.out.println(time);
        
    }
    
    static class queue {
        int count = 0, front = 0, tail = 0;

        public queue(int c, int f, int t)
        {
            count = c;
            front = f;
            tail = t;
        }

        public void enQueue(int value, int array[])
        {
            if(count == array.length)
            {
                System.out.println("Queue overflow");
            }
            else
            {
                array[tail] = value;
                tail = (tail + 1)%array.length;
                count++;
            }
        }

        public void deQueue( int array[])
        {
            if(count == 0)
            {
                System.out.println("Queue underflow");
            }
            else
            {
                array[front] = 0;
                front = (front + 1)%array.length;
                count--;
            }
        }

        public int front(int array[])
        {
            return array[front];
        }

        public int size()
        {
            return count;
        }
    }
}
