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
public class BST_Monk_Watching_Fight {
   
    private static TreeNode root;
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int d)
        {
            data = d;
            left = right = null;
        }
    }
    
    private static TreeNode createNode(int d)
    {
        TreeNode t = new TreeNode(d);
        return t;
    }
    
    private static TreeNode insert(TreeNode node, int d)
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
    
    private static int height(TreeNode node)
    {
        if(node ==  null) return 0;
        else
        {
            int left = height(node.left);
            int right = height(node.right);
            if(left < right) return right+1;
            else return left+1;
        }
    }
    
    public static void main(String args[] )
    {
        int N;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            N = Integer.parseInt(reader.readLine().trim());
            
            int t;
            String[] tokens = reader.readLine().trim().split(" ");
            for(int i=0; i<tokens.length; ++i)
            {
                t = Integer.parseInt(tokens[i]);
                root = insert(root, t);
            }
            
            System.out.println(height(root));
        }
        catch(Exception e)
        {
            //
        }
    }
     
}
