package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String question;
        int  count = 0;

        System.out.println("Welcome to the Eliza Program \n::::::::::::::::::::::::::::::::::::::::");
        Scanner scan = new Scanner(System.in);

        HashMap<Integer, String> hedges = new HashMap<Integer, String>();
        hedges.put(1,"Please tell me more");
        hedges.put(2,"Many of my patients tell me the same thing");
        hedges.put(3,"It is getting late, maybe we had better quit");

        HashMap<Integer, String> qualify = new HashMap<Integer, String>();
        qualify.put(1,"Why do you say that");
        qualify.put(2,"You seem to think that");
        qualify.put(3,"So, you are concerned that");

        HashMap<String, String> replacements = new HashMap<String, String>();
        replacements.put( "I","you");
        replacements.put( "my","your");
        replacements.put( "me","you");
        replacements.put( "am","are");

        System.out.println("Good day. What is your problem? Enter your response here or Q to quit: my teacher hates me");
        question = scan.nextLine();

       while(!question.equals("q") && count <=10){

           String changedQuestion =changesFromHashMap(question,replacements,hedges,qualify);
           String allCaps = allCaps(changedQuestion);
           if(question.equals("caps")) {
               System.out.println(allCaps);
           }
           else{
               System.out.println(changedQuestion);
           }
            count ++;
           System.out.println("Good day. What is your problem? Enter your response here or Q to quit: my teacher hates me");
           question = scan.nextLine();

       }
    }
    // String change from the user input and answers to it
public static  String changesFromHashMap(String question, HashMap<String, String> replacement , HashMap<Integer, String> hedges,HashMap<Integer, String> qualify){
        // string variable to split the user input and put it into array
    String[] userInput = question.split(" ");
    //string to concat all the user input after the changes
    String reorder = "";
    // check if the user inputs has the values for the replacement hashmap
    Boolean check = false;
    //random number generator for hedges and qualify. randomNumber method is called
    int hedgesRandom = randomNumber(hedges);
    int qualifyRandom = randomNumber(qualify);
    // string to set the changes and answers to diplay to the user
   String answer ="" ;
   //for loop to replace the user input words if the words exist in the replacement hashmap
    for(int i =0;i <userInput.length;i++){
        if(replacement.containsKey(userInput[i])){
            //this code replaces the userinput to the value from the hash key
            userInput[i] =replacement.get(userInput[i]);
            check =true;
        }
    }
    //for loop to reorder the text user input after it has been changed
    for(int i =0;i<userInput.length;i++){
        reorder += userInput[i] +" ";

    }
    //condition to check if the user input is present in the replacement or not
    if(check){
        answer = randomAnswerGenerator(qualify,qualifyRandom)+ " "+ reorder;
    }
    else
    {
        answer = randomAnswerGenerator(hedges,hedgesRandom);
    }
    //returns answer
    return answer;
}


//random answer generator
    public static String randomAnswerGenerator( HashMap<Integer, String> random,int ran){
        int i =0;
        //array with the size of the hashmap
        String []elem = new String[random.size()];
        //for loop to iterate through all the values in the hashmap and setting it into an array elem
        for (String a : random.values()){
            elem[i] =a;
            i++;
        }
        //setting the string to the random element of the hashmap
        String answer = elem[ran];

        return answer;

    }
//random number generator
    public static int randomNumber(HashMap<Integer, String> countSize){
        Random r = new Random();
        int num = 0+r.nextInt(countSize.size());

        return num;
    }
//all caps method to set all the answers of the Uppercase

    public static String allCaps(String response){
            String uppercase = toUpperCase(response);
            return uppercase;

    }

 //pig latin method

 public static String pigLatin(String response){
        String [] pigChange = response.split(" ");
        for(int i =0; i<pigChange.length;i++)
        {

        }



 }
    public static void playGame(String response){

    }
    public static void red(String response){}

}
