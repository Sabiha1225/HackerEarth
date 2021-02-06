/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.Scanner;
import java.util.Stack;
import javafx.util.Pair;

/**
 *
 * @author Administrator
 */
public class MonkPrisonerOfAjkaban {
    
    public static void main(String[] args) {
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        input.nextLine();
        long arr[] = new long[N+5];
        int left[] = new int[N+5];
        int right[] = new int[N+5];
        
        for(int i=0; i<N; ++i)
        {
            arr[i] = input.nextLong();
        }
        
        calculateNextGreatestRight(arr, right, 0, N);
        calculateNextGreatestLeft(arr, left, 0, N);
        
        for(int i=0; i<N; ++i)
        {
            long sum = right[i] + left[i];
            System.out.print(sum + " ");
        }
        
    }
    
    public static void calculateNextGreatestRight(long arr[], int right[],int startInd, int N)
    {
        //Stack<Pair<Long, Integer>> stack = new  Stack<>();
        Stack<Integer> stack = new  Stack<>();        
        //stack.push(new Pair<Long, Integer>(arr[0], 0));
        stack.push(0);
        
        for(int i=1; i<N; ++i)
        {
//            while(!stack.empty() && stack.peek().getKey() < arr[i] )
            while(!stack.empty() && arr[stack.peek()] < arr[i] )
            {
                //Pair p = stack.pop();
                int p = stack.pop();
                //right[(int)p.getValue()] = i + 1;
                right[p] = i + 1;
            }
            //stack.push(new Pair<Long, Integer>(arr[i], i));
            stack.push(i);
        }
        
        while(!stack.empty())
        {
            //Pair p = stack.pop();
            int p = stack.pop();
            right[p] = -1;
        }
    }
    
    public static void calculateNextGreatestLeft(long arr[], int left[],int startInd, int N)
    {
        //Stack<Pair<Long, Integer>> stack = new  Stack<>();
        Stack<Integer> stack = new  Stack<>();
        
        //stack.push(new Pair<Long, Integer>(arr[N-1], N-1));
        stack.push(N-1);
        for(int i=N-2; i>=0; --i)
        {
            //while(!stack.empty() && stack.peek().getKey() < arr[i] )
            while(!stack.empty() && arr[stack.peek()] < arr[i] )
            {
                //Pair p = stack.pop();
                int p = stack.pop();
                //left[(int)p.getValue()] = i + 1;
                left[p] = i + 1;
            }
            //stack.push(new Pair<Long, Integer>(arr[i], i));
            stack.push(i);
        }
        
        while(!stack.empty())
        {
            //Pair p = stack.pop();
            int p = stack.pop();
            //left[(int)p.getValue()] = -1;
            left[p] = -1;
        }
    }
}
