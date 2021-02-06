/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.*;
import javafx.util.Pair;

/**
 *
 * @author Administrator
 */
public class FrustratedCoder {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Pair<Integer, Integer>> stack = new  Stack<>();
        int N;
        Scanner input = new Scanner(System.in);
        
        N = input.nextInt();
        for(int i=0; i<N; ++i)
        {
            int t = input.nextInt();
            //System.out.println(t);
            if(!map.containsKey(t))
            {
                map.put(t, 1);
            }
            else
            {
                map.replace(t, map.get(t)+1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            //System.out.println(entry.getKey() + "  " + entry.getValue());
            int key = entry.getKey();
            int val = entry.getValue();
            if(stack.empty())
            {
                stack.push(new Pair<Integer, Integer>(key, val));
            }
            else
            {
                int temp = val;
                while(!stack.empty() && stack.peek().getValue() <= temp)
                {
                    temp -= stack.peek().getValue();
                    stack.pop();
                }
                if(!stack.empty() && stack.peek().getValue() > temp)
                {
                    Pair<Integer, Integer> pair = stack.pop();
                    stack.push(new Pair<Integer, Integer>(pair.getKey(), pair.getValue()-temp));
                }
                
                stack.push(new Pair<Integer, Integer>(key, val));
            }
        }
        
        int sum = 0;
        while(!stack.empty())
        {
            Pair<Integer, Integer> pair = stack.pop();
            sum += (pair.getKey()* pair.getValue());
        }
        
        System.out.println(sum);
        //sort();

    }
    
}
