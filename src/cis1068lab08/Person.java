/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis1068lab08;

import java.util.ArrayList;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class Person {
    private String name;
    private Person mother, father;
    private ArrayList<Person> children;
    
    public String getName(){
        return name;
    }
    public void setNmae(String name){
        this.name = name;
    }
    public Person getMother(){
        return mother;
    }
    public void setMother(Person mother){
        this.mother= mother;
    }
    public Person getFather(){
        return father;
    }
    public void setFather(Person mother){
        this.father= father;
    }
    
    public Person(String name){
        this.name = name;
        children = new ArrayList<Person>();
        
    }
    public Person(String name, Person father, Person mother, ArrayList<Person> children){
        this.name = name;
        this.father=father;
        this.mother=mother;
        this.children = children;
    }
    
    @Override
    public String toString(){
        String str = "Maternal Line:\n\t"+this.name+"\n\t\t" +mother.getName()+"\n";
        str+="Paternal Line:\n\t"+this.name + "\n\t\t"+father.getName()+"\n";
        str+="Chilren:";
        for(Person person : children){
            str+= "\t"+person.getName()+"\n";
        }
        return str;
    }
}
