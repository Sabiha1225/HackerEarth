/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frustratedcoder;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
class Student{
    int roll;
    int schoolId;
    Student next;
    Student prev;
    
    public Student(int s, int r, Student n, Student p)
    {
        schoolId = s; 
        roll = r;
        next = n;
        prev = p;
    }
}

public class Que_Little_Monk_and_Goblet_of_Fire {
    Student frontStudent = null, rearStudent = null;
    Student schoolOne = null, schoolTwo = null, schoolThree = null, schoolFour = null;
    int count = 0;
    
    private void assignSchoolPointer(Student student)
    {
        switch(student.schoolId)
        {
            case 1: 
                schoolOne = student;
                break;
            case 2:
                schoolTwo = student;
                break;
            case 3:
                schoolThree = student;
                break;
            case 4:
                schoolFour = student;
                break;
        }
    }
    
    public void enQueue(int s, int r)
    {
        //
        Student temp = new Student(s, r, null, null);
        if(frontStudent == null)
        {
            frontStudent = rearStudent = temp;
        }
        else
        {
            switch(temp.schoolId)
            {
                case 1:
                    if(schoolOne == null || schoolOne == rearStudent)
                    {
                        rearStudent.next = temp;
                        temp.prev = rearStudent;
                        rearStudent = temp;
                    }
                    else
                    {
                        Student nextStudent = schoolOne.next;
                        schoolOne.next = temp;
                        temp.prev = schoolOne;
                        temp.next = nextStudent;
                        nextStudent.prev = temp;
                    }
                    break;
                case 2:
                    if(schoolTwo == null || schoolTwo == rearStudent)
                    {
                        rearStudent.next = temp;
                        temp.prev = rearStudent;
                        rearStudent = temp;
                    }
                    else
                    {
                        Student nextStudent = schoolTwo.next;
                        schoolTwo.next = temp;
                        temp.prev = schoolTwo;
                        temp.next = nextStudent;
                        nextStudent.prev = temp;
                    }
                    break;
                case 3:
                    if(schoolThree == null || schoolThree == rearStudent)
                    {
                        rearStudent.next = temp;
                        temp.prev = rearStudent;
                        rearStudent = temp;
                    }
                    else
                    {
                        Student nextStudent = schoolThree.next;
                        schoolThree.next = temp;
                        temp.prev = schoolThree;
                        temp.next = nextStudent;
                        nextStudent.prev = temp;
                    }
                    break;
                case 4:
                    if(schoolFour == null || schoolFour == rearStudent)
                    {
                        rearStudent.next = temp;
                        temp.prev = rearStudent;
                        rearStudent = temp;
                    }
                    else
                    {
                        Student nextStudent = schoolFour.next;
                        schoolFour.next = temp;
                        temp.prev = schoolFour;
                        temp.next = nextStudent;
                        nextStudent.prev = temp;
                    }
                    break;
            }
        }
        assignSchoolPointer(temp);
        count++;
    }
    
    private Student updateSearch(int id)
    {
        Student temp = rearStudent;
        while(temp != null)
        {
            if(temp.schoolId == id)
            {
                return temp;
            }
            temp = temp.prev;
        }
        
        return null;
        
    }
    
    public void deQueue()
    {
        if(frontStudent == null)
        {
            System.out.println("0 0");
        }
        
        else
        {
            Student temp = frontStudent;
            frontStudent = frontStudent.next;
            
            if(frontStudent != null)
                frontStudent.prev = null;
                
            if(frontStudent == null)
            {
                rearStudent = null;
            }
            
            if(temp == schoolOne)
            {
                schoolOne = updateSearch(schoolOne.schoolId);
            }
            else if(temp == schoolTwo)
            {
                schoolTwo = updateSearch(schoolTwo.schoolId);
            }
            else if(temp == schoolThree)
            {
                schoolThree = updateSearch(schoolThree.schoolId);
            }
            else if(temp == schoolFour)
            {
                schoolFour = updateSearch(schoolFour.schoolId);
            }
            count--;
            System.out.println(temp.schoolId + " " + temp.roll);
        }
    }
    
    public int size()
    {
        return count;
    }

    @Override
    public String toString() {
        Student temp = frontStudent;
        String s = "";
        while(temp != null)
        {
            s = s.concat("( "+ temp.schoolId + " " + temp.roll + " ) -- ");
            temp = temp.next;
        }
        return s; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public static void main(String args[] )
    {
        int Q, sId, roll;
        char operation;
        Que_Little_Monk_and_Goblet_of_Fire queue = new Que_Little_Monk_and_Goblet_of_Fire();
        Scanner s = new Scanner(System.in);
        Q = s.nextInt();
        s.nextLine();
        for(int i=0; i<Q; ++i)
        {
            operation = s.next().charAt(0);
            if(operation == 'E')
            {
                sId = s.nextInt();
                roll = s.nextInt();
                queue.enQueue(sId, roll);
            }
            else
                queue.deQueue();
            //s.nextLine();
//            String s1 = s.nextLine();
//            s1 = s1.trim();
//            String[] tokens = s1.split(" ");
//            operation = tokens[0].charAt(0);
//            sId = Integer.valueOf(tokens[1]);
//            roll = Integer.valueOf(tokens[2]);
        }
//        queue.enQueue(1, 1);
//        System.out.println(queue.toString());
//        queue.enQueue(2, 1);
//        System.out.println(queue.toString());
//        queue.enQueue(1, 2);
//        System.out.println(queue.toString());
//        
//        queue.deQueue();
//        System.out.println(queue.toString());
//        queue.enQueue(3, 1);
//        System.out.println(queue.toString());
//        queue.enQueue(2, 2);
//        System.out.println(queue.toString());
//        queue.enQueue(4, 1);
//        System.out.println(queue.toString());
//        queue.enQueue(3, 2);
//        System.out.println(queue.toString());
//        queue.enQueue(1, 3);
//        System.out.println(queue.toString());
//        queue.enQueue(2, 3);
//        System.out.println(queue.toString());
//        queue.enQueue(4, 2);
//        System.out.println(queue.toString());
//        queue.deQueue();
//        System.out.println(queue.toString());
//        queue.deQueue();
//        System.out.println(queue.toString());
//        queue.deQueue();
//        System.out.println(queue.toString());
    }
}
