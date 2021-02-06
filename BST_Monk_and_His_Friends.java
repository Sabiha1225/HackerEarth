/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class BST_Monk_and_His_Friends {
    
    private static TreeNode root;
    static class TreeNode {
        long data;
        TreeNode left, right;
        public TreeNode(long d)
        {
            data = d;
            left = right = null;
        }
    }
    
    private static TreeNode createNode(long d)
    {
        TreeNode t = new TreeNode(d);
        return t;
    }
    
    private static TreeNode insert(TreeNode node, long d)
    {
        if(node == null) return createNode(d);
        else
        {
            if(d <= node.data)
            {
                node.left = insert(node.left, d);
            }
            else
                node.right = insert(node.right, d);
            
            return node;
        }
    }
    
    private static int searchTree(TreeNode node, long d)
    {
        if(node == null) return 0;
        if(node.data == d) return 1;
        else
        {
            int left = searchTree(node.left, d);
            if(left == 1) return 1;
            else
            {
               int right = searchTree(node.right, d);
               return right;
            }
        }
    }
    
    public static void main(String args[] )
    {
        int N, M, T;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            T = Integer.parseInt(reader.readLine().trim());
            
            String[] tokens1 = {" ", " "};
            
            for(int k=1; k<=T; ++k)
            {
                tokens1 = reader.readLine().trim().split(" ");
                N = Integer.parseInt(tokens1[0]);
                M = Integer.parseInt(tokens1[1]);
                int t;
                String[] tokens = reader.readLine().trim().split(" ");
                int i;
                for(i=0; i<N; ++i)
                {
                    t = Integer.parseInt(tokens[i]);
                    root = insert(root, t);
                }
                
                int result;
                for(int j=i; j<N+M; ++j)
                {
                    t = Integer.parseInt(tokens[j]);
                    result = searchTree(root, t);
                    if(result == 0) System.out.println("NO");
                    else System.out.println("YES");
                }
            }
            
            //System.out.println(height(root));
        }
        catch(Exception e)
        {
            //
        }
    }
}
