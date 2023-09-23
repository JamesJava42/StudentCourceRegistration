package Assignment_algo.DAA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// created a student node with basic data 

class Student extends AVLTree{
    int studentId;
    String name;
    List<String> cources;

    Student(int id, String name){
        this.studentId = id;
        this.name = name;
        this.cources = new ArrayList<>();
    }
    Student(){}

    void add(int coursecode,int studentid){

        // AVLTree obj = new AVLTree();
       
        boolean isCourceExists = isCource(coursecode,studentid);
        if(isCourceExists){
            Timing data =  isTiming(studentid);
            System.out.println(data.date + " -  - - - - - "+ data.time);

            
        }
       }
    static void drop(){

    }
    // drop 

}

public class AssignmentStudent extends Student {

    


    public static void main(String[] args) {

        HashMap<Integer,List<String>> hm = new HashMap<>();  




        Student obj = new Student(1, "Rakesh");
        obj.add(100,obj.studentId);
        obj.add(101, obj.studentId);
                hm.put(obj.studentId, obj.cources);

        Student obj1 = new Student(2, "Rakesh");
        obj.add(103,obj.studentId);
        obj.add(105,obj1.studentId);
        hm.put(obj1.studentId, obj1.cources);
        
        for(int idx : hm.keySet()){
            System.out.println(idx);
        }

        
        
    }
    
}
