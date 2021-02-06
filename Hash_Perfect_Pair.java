/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class Hash_Perfect_Pair {
    public static void main(String args[] )
    {
        int T, N;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            T = Integer.parseInt(reader.readLine().trim());
            for(int k=1; k<=T; ++k)
            {
                N = Integer.parseInt(reader.readLine().trim());
                int arr[] = new int[1000];
                int hash[] = new int[1005];
                int index = 0;
                String[] tokens = reader.readLine().split(" ");
                //HashMap<Integer, Integer> map = new HashMap<>();
                for(int i=0; i<1005; ++i)
                {
                    hash[i] = 0;
                }
                for(int i=0; i<N; ++i)
                {
                    //arr[i] = Integer.parseInt(tokens[i]);
                    int t = Integer.parseInt(tokens[i]);
                    if(hash[t] == 0)
                    {
                        arr[index] = t;
                        index++;
                    }
                    hash[t]++;
                }
                
                long pairs = 0;
                
                Arrays.sort(arr, 0, index);
                //System.out.println(Arrays.toString(arr));
                //System.out.println(Arrays.toString(hash));
                
                for(int i=0; i<index; ++i)
                {
                    if( hash[arr[i]] > 1 && (perfectSquare(arr[i]+arr[i]) || perfectCube(arr[i]+arr[i])))
                    {
                        pairs += (hash[arr[i]]*(hash[arr[i]]-1))/2;
                        //System.out.println(arr[i]);
                    }
                    for(int j=i+1; j<index; ++j)
                    {
                        
                        if(perfectSquare(arr[i]+arr[j]) || perfectCube(arr[i]+arr[j]))
                        {
                            pairs += hash[arr[i]]*hash[arr[j]];
                            //System.out.println(arr[i] + " , " + arr[j]);
                        }
                    }
                }
                
                System.out.println(pairs);
            }
        }
        catch(Exception e)
        {
            //
        }   
    }
    
    private static boolean perfectSquare(int a)
    {
        int t = (int) Math.sqrt(a);
        return t*t == a ? true : false;
    }
    
    private static boolean perfectCube(int a)
    {
        int t = (int) Math.cbrt(a);
        return t*t*t == a ? true : false;
    }
}
