/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Arr_Pairs_Having_Similar_Elements {
    
    public static void main(String args[] )
    {
        int N;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(reader.readLine().trim());
            int arr[] = new int[N];
            String[] tokens = reader.readLine().split(" ");
            int arr1[] = new int[1000000000];
            //HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<N; ++i)
            {
                arr[i] = Integer.parseInt(tokens[i]);
                /*int t = Integer.parseInt(tokens[i]);
                if(map.get(t) == null)
                    map.put(t, 1);
                else
                    map.put(t, map.get(t)+1);*/
            }
            
            /*long pairs = 0;
            long count = 0;
            long it = 0;
            int temp = 0;
            boolean nextIncrement = false;
            for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                //System.out.println(entry.getKey() + " : " +entry.getValue());
                if(it == 0)
                {
                    temp = entry.getKey();
                    count = entry.getValue();
                    it++;
                    continue;
                }
                if(entry.getKey() == temp + 1)
                {
                    count += entry.getValue();
                    nextIncrement = true;
                }
                else
                {
                    if(count > 1 && nextIncrement)
                    {
                        long a = count / 2;
                        long b = count%2 == 0 ? count-1 : count;
                        pairs += (a*b);
                    }
                    count = entry.getValue();
                    nextIncrement = false;
                }
                temp = entry.getKey();
            }
            if(count > 1 && nextIncrement)
            {
                long a = count / 2;
                long b = count%2 == 0 ? count-1 : count;
                pairs += (a*b);
            }
            System.out.println(pairs);*/
            
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            long count = 1;
            //int temp = arr[0];
            long pairs = 0;
            boolean nextIncrement = false;
            //System.out.println((3/2) + "");
            
            for(int i=1; i<N; ++i)
            {
                if((arr[i] == arr[i-1]))
                {
                    count++;
                    //System.out.println(arr[i] + "  " + count);
                }
                else if(arr[i] == arr[i-1]+1)
                {
                    count++;
                    nextIncrement = true;
                    //System.out.println(arr[i] + "  " + count);
                }
                else
                {
                    if(count > 1 && nextIncrement)
                    {
                        //if(count == 2) pairs += 1; 
                        //long a = count / 2;
                        //long b = count%2 == 0 ? count-1 : count;
                        //pairs += (a*b);
                        pairs += (count*(count-1)/2);
                    }
                    count = 1;
                    nextIncrement = false;
                }
            }
            
            if(count > 1 && nextIncrement)
            {
                //long a = count / 2;
                //long b = count%2 == 0 ? count-1 : count;
                //pairs += (a*b);
                pairs += (count*(count-1)/2);
            }
            System.out.println(pairs);
            
            /*for(int i=0; i<N; ++i)
            {
                System.out.print(arr[i] + "  ");
            }*/
        } catch (IOException ex) {
            Logger.getLogger(Arr_Pairs_Having_Similar_Elements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
