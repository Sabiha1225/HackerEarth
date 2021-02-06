/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class Hash_Kth_Character {
    public static void main(String args[] )
    {
        int N, Q, L, R, K, SUM, LETTERS = 26;
        String S;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] tokens = reader.readLine().trim().split(" ");
            N = Integer.parseInt(tokens[0]);
            Q = Integer.parseInt(tokens[1]);
            
            S = reader.readLine().trim();
            
            int[][] hash = new int[N+1][LETTERS];
            
            for(int i=1; i<=N; ++i)
            {
                hash[i][S.charAt(i-1)-'a']++;
                
                for(int j=0; j<LETTERS; ++j)
                {
                    hash[i][j] += hash[i-1][j];
                }
            }
            
            for(int i=0; i<Q; ++i)
            {
                String[] tokens1 = reader.readLine().trim().split(" ");
                L = Integer.parseInt(tokens1[0]);
                R = Integer.parseInt(tokens1[1]);
                K = Integer.parseInt(tokens1[2]);
                
                SUM = 0;
                for(int j=0; j<LETTERS; ++j)
                {
                    SUM += hash[R][j] - hash[L-1][j];
                    if(SUM >= K)
                    {
                        System.out.println((char)('a' + j));
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            //
        }   
    }
}
