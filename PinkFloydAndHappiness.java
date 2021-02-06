/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class PinkFloydAndHappiness {
    public static void main(String[] args) {
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        input.nextLine();
        
        Stack<Integer> record = new Stack<>();
        //Stack<Integer> playList = new Stack<>();
        int init = 1;
        for(int i=0; i<N; ++i)
        {
            int t = input.nextInt();
            while(!record.empty() && record.peek() == init)
            {
                record.pop();
                //int val = record.pop();
                //playList.push(val);
                //System.out.println(playList.toString());
                init++;
            }
            if(init == t)
            {
                //playList.push(t);
                //System.out.println(playList.toString());
                init++;
            }
            else
            {
                record.push(t);
                System.out.println(record.toString());
            }
        }
        while(!record.empty())
        {
//            if(playList.empty())
//            {
//                if(record.peek() != 1)
//                    break;
//                else
//                {
//                    int val = record.pop();
//                    playList.push(val);
//                    System.out.println(playList.toString());
//                }
//            }
            //if(!playList.empty() && (playList.peek() + 1 == record.peek()))
            if(init == record.peek())
            {
                record.pop();
                init++;
                //int val = record.pop();
                //playList.push(val);
                //System.out.println(playList.toString());
            }
            else 
                break;
        }
        
        //if(!playList.empty() && playList.size() == N && record.empty())
        if(init == N+1 && record.empty())
        {
            System.out.println("Happy");
        }
        else
            System.out.println("Sad");
    }
}
