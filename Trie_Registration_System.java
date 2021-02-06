/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Trie_Registration_System {

    static HashMap<String, Integer> map; 
    
    public static void main(String[] args) {
        int N;
         
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            map = new HashMap<>();
            N = Integer.parseInt(reader.readLine().trim());
            String token;
            for(int i=0; i<N; ++i)
            {
                token = reader.readLine();
                if(!map.containsKey(token))
                {
                    map.put(token, 0);
                    System.out.println(token);
                }
                else
                {
                    int temp = map.get(token);
                    String s = token + temp;
                    while(map.containsKey(s))
                    {
                        temp++;
                        s = token + temp;
                    }
                    map.put(s, 0);
                    System.out.println(s);
                    map.put(token, temp+1);
                }
            }
        }
        catch(Exception e)
        {
            //
        }
    }   
}
