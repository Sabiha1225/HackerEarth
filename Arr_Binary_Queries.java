/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.Scanner;

public class Arr_Binary_Queries {
    public static void main(String args[] )
    {
        int N, Q, L, R;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        Q = scanner.nextInt();
        scanner.nextLine();
        int arr[] = new int[N+1];
        for(int i=1; i<=N; ++i)
        {
            arr[i] = scanner.nextInt();
        }
        for(int i=1; i<=Q; ++i)
        {
            int id = scanner.nextInt();
            long prod = 1;
            long num = 0;
            if(id == 0)
            {
                L = scanner.nextInt();
                R = scanner.nextInt();
                /*for(int j=R; j>=L; --j)
                {
                    num += prod*arr[j];
                    prod *= 2;
                }*/
                if(arr[R] == 0) System.out.println("EVEN");
                else System.out.println("ODD");
            }
            else
            {
                int X = scanner.nextInt();
                arr[X] = (arr[X]==1) ? 0: 1;
            }
            //scanner.nextLine();
        }
    }
}
