package Assignment_algo.DAA;


import java.util.ArrayList;
import java.util.List;

public class Assignment2{


    String value;
    List<Assignment2> childrens;

    Assignment2(String value){
        this.value = value;
        this.childrens = new ArrayList<>();
    }

    public void addChild(Assignment2 node){
            childrens.add(node);
    }

    // displaying 
    public static  void display(Assignment2 root, String prefix){

        if(  root == null ){
            // System.out.println(" ******** " +root.value);
            return ;
        }
        
         System.out.println(prefix + root.value);
        //  System.out.println("curr Node  : "+ root.value + "  childres : "+ root.childrens.size());
        for(int i=0;i<=root.childrens.size()-1; i++){

            Assignment2 childnode = root.childrens.get(i);
            if(i == childnode.childrens.size()-1){
                display(childnode, prefix+ "|-- ");
            }
            else{
                display(childnode, prefix+ "|__ ");
            }
            
        }   
        
    }


   
    public static void main(String[] args) {

         Assignment2 root = new Assignment2("Root");

    Assignment2 child1 = new Assignment2("Child1");

    Assignment2 child2 = new Assignment2("Child2");

        Assignment2 child3 = new Assignment2("Child3");


    // adding root childerns to it 

    root.addChild(child1);
    root.addChild(child2);
    root.addChild(child3);

    //  adding the files to the each folder 
    child1.addChild(new Assignment2("child1.1"));
    child2.addChild(new Assignment2("child2.2"));

    // Printing them in order
    System.out.println(root.value);
    display(root, "");

    

        
    }
}