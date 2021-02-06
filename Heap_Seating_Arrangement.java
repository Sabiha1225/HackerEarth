/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;


import java.io.*;
import java.util.*;


public class Heap_Seating_Arrangement {

    static class SeatInfo{
        long seat_no;
        long min_index;
        long max_index;
        public SeatInfo(long s, long l, long r)
        {
            seat_no = s;
            min_index = l;
            max_index = r;
        }
    }
    
    static class SeatComparator implements Comparator<SeatInfo>{

        @Override
        public int compare(SeatInfo t, SeatInfo t1) {
            if (t.seat_no < t1.seat_no) 
                return 1; 
            else if (t.seat_no > t1.seat_no) 
                return -1;
            else if(t.seat_no == t1.seat_no)
            {
                if(t.min_index < t1.min_index)
                    return -1;
                else if(t.min_index > t1.min_index)
                    return 1;
            }
            return 0; 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String inputString = br.readLine();   
         String input[] = inputString.split("\\s+");
         long n = Long.parseLong(input[0]);
         int k = Integer.parseInt(input[1]);
         String s = br.readLine();
         int q = Integer.parseInt(br.readLine().trim());
         //String[] arr_Q = br.readLine().split(" ");
         long[] Q = new long[q];
         for(int i_Q=0; i_Q<q; i_Q++)
         {
         	Q[i_Q] = Long.parseLong(br.readLine());
         }

         int[] out_ = solve(Q, k, s, n);
         System.out.println(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] solve(long[] Q, int k, String s, long n){
        
        int[] output = new int[Q.length];
        char c;
        Map<Long, Integer> map = new HashMap<>();
        PriorityQueue<SeatInfo> pq = new PriorityQueue<>(new SeatComparator()); 
        pq.add(new SeatInfo(n, 1, n));

        long min1, min2, max1, max2, seatNo1, seatNo2;
        for(int i=1; i<=k; ++i)
        {
            c = s.charAt(i-1);
            SeatInfo seat = pq.poll();
            if(seat.seat_no == 1)
            {
                map.put(seat.min_index, i);
            }
            else
            {
                long mid = (seat.max_index + seat.min_index)/2;
                min1 = seat.min_index;
                max2 = seat.max_index;
                if(seat.seat_no % 2 != 0)
                {
                    map.put(mid, i);
                    max1 = mid - 1;
                    min2 = mid + 1;
                }
                else
                {
                    long t;
                    if(c == 'L')
                    {
                        t  = mid;
                        map.put(t, i);
                    }
                    else
                    {
                        t = mid + 1;
                        map.put(t, i);
                    }
                        
                    max1 = t - 1;
                    min2 = t + 1;
                }
                    
                seatNo1 = max1 - min1 + 1;
                seatNo2 = max2 - min2 + 1;
                    
                if(seatNo1 > 0)
                {
                    SeatInfo leftHalve = new SeatInfo(seatNo1, min1, max1);
                    pq.add(leftHalve);
                }
                if(seatNo2 > 0)
                {
                    SeatInfo rightHalve = new SeatInfo(seatNo2, min2, max2);
                    pq.add(rightHalve);
                }
            }
        }
        System.out.println(map.toString());
        for(int i=0; i<Q.length; ++i)
        {
            long index = Q[i];
            int t = map.containsKey(index) ? map.get(index) : -1;
            output[i] = t;
        }

        return output;
    }
}

/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Administrator
 */
/*public class Heap_Seating_Arrangement {
    
    //static ArrayList<Long> array;
    
    
    static class SeatInfo{
        long seat_no;
        long min_index;
        long max_index;
        public SeatInfo(long s, long l, long r)
        {
            seat_no = s;
            min_index = l;
            max_index = r;
        }
    }
    
    static class SeatComparator implements Comparator<SeatInfo>{

        @Override
        public int compare(SeatInfo t, SeatInfo t1) {
            if (t.seat_no < t1.seat_no) 
                return 1; 
            else if (t.seat_no > t1.seat_no) 
                return -1;
            else if(t.seat_no == t1.seat_no)
            {
                if(t.min_index < t1.min_index)
                    return -1;
                else if(t.min_index > t1.min_index)
                    return 1;
            }
            return 0; 
        }
    }
    
    
    public static void main(String args[] )
    {
        long N;
        int Q, K;
        char c;
        Map<Long, Integer> map;
         
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] tokens = reader.readLine().trim().split(" ");
            N = Long.parseLong(tokens[0]);
            K = Integer.parseInt(tokens[1]);
            //array = new ArrayList<Long>();
            map = new HashMap<>();
            /*for(long i=0; i<=N; ++i)
            {
                array.add((long)(-1));
            }*/
/*            PriorityQueue<SeatInfo> pq = new PriorityQueue<>(new SeatComparator()); 
            pq.add(new SeatInfo(N, 1, N));
            String s = reader.readLine().trim();
            
            long min1, min2, max1, max2, seatNo1, seatNo2;
            for(int i=1; i<=K; ++i)
            {
                c = s.charAt(i-1);
                SeatInfo seat = pq.poll();
                /*System.out.println("No: " + seat.seat_no + " min: " 
                        + seat.min_index + " max: "+ seat.max_index);*/
/*                if(seat.seat_no == 1)
                {
                    //array[seat.min_index] = (long)i;
                    //array.set((int)seat.min_index, (long)i);
                    map.put(seat.min_index, i);
                }
                else
                {
                    long mid = (seat.max_index + seat.min_index)/2;
                    //System.out.println("Mid: "+ mid);
                    min1 = seat.min_index;
                    max2 = seat.max_index;
                    if(seat.seat_no % 2 != 0)
                    {
                        //array[mid] = i;
                        map.put(mid, i);
                        max1 = mid - 1;
                        min2 = mid + 1;
                    }
                    else
                    {
                        long t;
                        if(c == 'L')
                        {
                            t  = mid;
                            //array[t] = i;
                            map.put(t, i);
                        }
                        else
                        {
                            t = mid + 1;
                            //array[t] = i;
                            map.put(t, i);
                        }
                        
                        max1 = t - 1;
                        min2 = t + 1;
                    }
                    
                    seatNo1 = max1 - min1 + 1;
                    seatNo2 = max2 - min2 + 1;
                    
                    if(seatNo1 > 0)
                    {
                        SeatInfo leftHalve = new SeatInfo(seatNo1, min1, max1);
                        pq.add(leftHalve);
                    }
                    if(seatNo2 > 0)
                    {
                        SeatInfo rightHalve = new SeatInfo(seatNo2, min2, max2);
                        pq.add(rightHalve);
                    }
                }
            }
            
            /*for(int i=1; i<=N; ++i)
            {
                System.out.print(array[i] + "  ");
            }
            System.out.println();*/
            
/*            Q = Integer.parseInt(reader.readLine().trim());
            for(int i=1; i<=Q; ++i)
            {
                long index = Long.parseLong(reader.readLine().trim());
                //int t = array[index] > 0 ? array[index] : -1;
                int t = map.containsKey(index) ? map.get(index) : -1;
                System.out.println(t);
            }
        }
        catch(Exception e)
        {
            //
        }
    }
}*/
