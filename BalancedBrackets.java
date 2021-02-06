/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        boolean balanced;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        String yes = "YES";
        String no = "NO";
        String pattern = "";
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        
        input.nextLine();
        
        for(int j=0; j<N; ++j)
        {
            stack.clear();
            balanced = true;
            pattern = input.nextLine();
            for(int i=0; i<pattern.length(); ++i)
            {
                char c = pattern.charAt(i);
                if(c == '{' || c == '[' || c == '(')
                {
                    stack.push(c);
                    //System.out.println(stack.toString());
                }
                else
                {
                    if(stack.empty())
                    {
                        balanced = false;
                        break;
                    }
                    char c1 = stack.pop();
                    //System.out.println(stack.toString());
                    if(c1 != (char) map.get(c))
                    {
                        balanced = false;
                        break;
                    }
                }
            }
            
            if(stack.empty() && balanced)
                System.out.println(yes);
            else
                System.out.println(no);
        }
    }
}
