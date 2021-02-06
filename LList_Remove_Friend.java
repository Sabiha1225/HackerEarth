/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.Scanner;

class FriendNode {
    int priority;
    FriendNode next;
    public FriendNode(int d)
    {
        priority = d;
        next = null;
    }
}

public class LList_Remove_Friend {
    FriendNode front, tail;
    //FriendNode nextNode = null, frontEven =  null, tailEven = null;
    
    void initialize()
    {
        front = null;
        tail = null;
    }
    
    void insertNode(int d)
    {
        FriendNode temp = new FriendNode(d);
        if(front ==  null)
        {
            front = tail = temp;
        }
        else
        {
            tail.next = temp;
            tail = temp;
        }
    }
    
    void deleteFriend()
    {
        boolean delFriend = false;
        FriendNode temp = front;
        FriendNode prev = front;
        while(temp.next != null)
        {
            if(temp.next != null && temp.priority < temp.next.priority)
            {
                if(temp == front) front = temp.next;
                else
                    prev.next = temp.next;
                delFriend = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if(!delFriend)
        {
            if(prev != null && temp != null)
                prev.next = temp.next;
        }
            
    }
    
    void print()
    {
        FriendNode temp = front;
        while(temp != null)
        {
            System.out.print(temp.priority + " ");
            temp = temp.next;
        }
        
        System.out.println();
    }
    
    public static void main(String args[] )
    {
        int T, N, K;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        s.nextLine();
        LList_Remove_Friend list = new LList_Remove_Friend();
        for(int i=0; i<T; ++i)
        {
            N = s.nextInt();
            K = s.nextInt();
            s.nextLine();
            list.initialize();
            for(int j=0; j<N; ++j)
            {
                int temp = s.nextInt();
                list.insertNode(temp);
            }
            //s.nextLine();
            //list.print();
            for(int j=0; j<K; ++j)
            {
                list.deleteFriend();
            }
            list.print();
        }
    }
}
