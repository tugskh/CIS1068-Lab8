/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis1068lab08;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class CIS1068Lab08 {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<String> swapInArrayList(ArrayList<String> arList, int index1, int index2){
        String temp = arList.get(index1);
        
        arList.add(index1,arList.get(index2));
        arList.remove(index1+1);
        arList.add(index2,temp);
        arList.remove(index2+1);
        
        return arList;
    }
    public static ArrayList<String> swapPairs(ArrayList<String> arList){
        if(arList.size()%2==0){
            for(int i =0; i<arList.size()-1; i++){
                swapInArrayList(arList,i,i+1);
                i++;
            }
        }
        else{
            for(int i =0; i<arList.size()-2; i++){
                swapInArrayList(arList,i,i+1);
                i++;
            }
        }
        return arList;
    }
    
    
    public static ArrayList<String> removeDuplicates(ArrayList<String> arList){
        Collections.sort(arList);
        int size = arList.size();
        for(int i = 0; i<size-1;i++){
            if(arList.get(i).equals(arList.get(i+1))){
                arList.remove(i);
                size--;
            }
        }
        return arList;
    }
    
    public static ArrayList<String> stutter(ArrayList<String> arList, int k){
        int size = arList.size();
        ArrayList<String> arList1 = new ArrayList<String>();
        for(int i = 0; i<size;i++){
            for(int j = 0; j<k; j++){
                arList1.add(arList.get(i));
            }
        }
        return arList1;
    }
    
    public static ArrayList<Person> familyDatabase(String name) throws FileNotFoundException{
        ArrayList<Person> personList = new ArrayList<Person>();
        File database = new File("family.txt");
        Scanner sc = new Scanner(database);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals(name)){
                String motherName = sc.nextLine();
                Person mother = new Person(motherName);
                
                String fatherName = sc.nextLine();
                Person father = new Person(fatherName);
                
                int numOfChildren = sc.nextInt();
                ArrayList<Person> childrenList = new ArrayList<Person>();
                while(numOfChildren+1 > 0){
                    String newChildName = sc.nextLine();
                    Person newChild = new Person(newChildName);
                    childrenList.add(newChild);
                    numOfChildren--;
                }
                //System.out.println(""+childrenList);
                Person newPerson = new Person(name, father, mother, childrenList);
                personList.add(newPerson);
                break;
            }
        }
        return personList;
    }
    public static void reverse(String fileName) throws FileNotFoundException, IOException{
        File text = new File(fileName);
        Scanner sc = new Scanner(text);
        ArrayList<String> arList = new ArrayList();
        while(sc.hasNext()){
            String line = sc.nextLine();
            Scanner sc1 = new Scanner(line);
            while(sc1.hasNext()){
                String word = sc1.next();
                arList.add(0,word);
            }
            arList.add(0,"\n");
        }
        System.out.println(""+arList.toString());
        FileWriter fileWriter = new FileWriter(fileName);
        for(String word : arList){
            fileWriter.write(word+" ");
        }
        fileWriter.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Reverse method
        reverse("example.txt");
       
        
        //familyTree
        Scanner sc = new Scanner(System.in);
        System.out.println("Person's name? ");
        String name = sc.nextLine();
        System.out.println(familyDatabase(name));
        
        
        
        
        
        //swapPairs method
        ArrayList arList = new ArrayList();
        arList.add("to");
        arList.add("be");
        arList.add("or");
        arList.add("not");
        arList.add("to");
        arList.add("be");
        arList.add("Hamlet");
        System.out.println(swapPairs(arList));
        

        //removeDuplicates method
        ArrayList arList1 = new ArrayList();
        arList1.add("be");
        arList1.add("be");
        arList1.add("is");
        arList1.add("not");
        arList1.add("or");
        arList1.add("question");
        arList1.add("that");
        arList1.add("the");
        arList1.add("to");
        arList1.add("to");
        System.out.println(removeDuplicates(arList1));
        
        //stutter method
        ArrayList arList2 = new ArrayList();
        arList2.add("how");
        arList2.add("are");
        arList2.add("you?"); 
        System.out.println(stutter(arList2,4));
        
        
    }
    
}
