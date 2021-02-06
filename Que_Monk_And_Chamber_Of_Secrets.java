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
class Spider {
    public int power;
    public int index;
    public Spider(int ind, int pow)
    {
        index = ind;
        power = pow;
    }
}

public class Que_Monk_And_Chamber_Of_Secrets {
    public static void main(String args[] )
    {
        Queue<Spider> q1 = new LinkedList<>();
        Queue<Spider> q2 = new LinkedList<>();
        
        int X, N;
        int MAX_POW, MAX_IND;
        
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        X = s.nextInt();
        s.nextLine();
        
        for(int i=0; i<N; ++i)
        {
            int temp = s.nextInt();
            Spider spider = new Spider(i+1, temp);
            q1.add(spider);
            //System.out.print(temp + " ");
        }
        s.nextLine();
        for(int i=0; i<X; ++i)
        {
            MAX_IND = -1;
            MAX_POW = -1;
            Spider tempSpider = null;
            int tempSize = q1.size()> X ? X : q1.size();
            for(int j=0; j<tempSize; ++j)
            {
                tempSpider = q1.remove();
                if(tempSpider.power > MAX_POW)
                {
                    MAX_POW = tempSpider.power;
                    MAX_IND = tempSpider.index;
                }
                if(tempSpider.power > 0)
                    tempSpider.power--;
                q2.add(tempSpider);
                //tempSpider = null;
            }
            System.out.print(MAX_IND + " ");
            
            for(int k=0; k<tempSize; ++k)
            {
                tempSpider = q2.remove();
                if(tempSpider.index != MAX_IND)
                {
                    q1.add(tempSpider);
                }
                //tempSpider = null;
            }
            q2.clear();
        }
        
        System.out.println();
    }
}
