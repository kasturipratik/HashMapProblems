package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.replace;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String question;
        int  count = 0;
//welcome message
        System.out.println("Welcome to the Eliza Program \n::::::::::::::::::::::::::::::::::::::::");
        Scanner scan = new Scanner(System.in);
//hashmap for answers and replacement strings
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
//user input
        System.out.println("Good day. What is your problem? Enter your response here or 'q' or  'quit' to exit the program: my teacher hates me");
        question = scan.nextLine();
//loop to run the program
       while(!question.equals("quit") && count <=10 && !question.equals("Q")){

           //method changesFromHashMap set to a string
           String changedQuestion =changesFromHashMap(question,replacements,hedges,qualify);
           //method to change the result to upper letter
           String allCaps = allCaps(changedQuestion);

           //method pigLatin to change the result to pig latin
           String pigLatin =pigLatin(changedQuestion);
           //condition to print the result as per user input
           //run all caps if user inputs caps
           if(question.equals("caps")) {
               System.out.println(allCaps);
           }
           //run pigLatin if user inputs pig
           else if(question.equals("pig"))
           {
               System.out.println(pigLatin);
           }
           //run the MITCHELL'S TINY ADVENTURE! game
           else if(question.equals("play game")){
               playGame();
           }
           else if(question.equals("red")){
                    //printing red
                   System.out.println("\033[31;1m"+changedQuestion+"\033[0m");
               }

           //print the result of the program
           else{
               System.out.println(changedQuestion);
           }
           //if the user inputs more than 10 times the program will end
            count ++;
           //user input required
           System.out.println("Good day. What is your problem? Enter your response here or q or quit to exit the program: my teacher hates me");
           question = scan.nextLine();

       }
    }
   //-------------------------------------------------------------------------------
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
        //spliting the final string of the project
        String [] pigChange = response.split(" ");
        //declaring a array variable
        String[] rejoin = new String[pigChange.length];
        String singleString="";
        //for loop to change the string value of each letter to pig lating
        for(int i =0; i<pigChange.length;i++)
        {
            // storing the changed values of pig latin in an array
            rejoin[i] = pigChange[i].substring(1)+pigChange[i].substring(0,1)+"py";

        }
        // for loop to join all the array to a string
        for(int i =0; i <rejoin.length;i++)
        {
            singleString += rejoin[i]+" ";
        }
       // returning the chhanged single string
return singleString;

 }
//adventure game -------------------------------------
    public static void playGame(){
        Scanner input = new Scanner(System.in);
        String firstLevel,secondLevel,thirdLevel,fourthLevel;
        System.out.println("WELCOME TO MITCHELL'S TINY ADVENTURE!");
        System.out.println("You are in a creepy house!  Would you like to go \"upstairs\" or into the \"kitchen\"?");
        firstLevel = input.nextLine();

        if(firstLevel.equals("kitchen")){
            System.out.println("There is a long countertop with dirty dishes everywhere.  Off to one side\n" +
                    "there is, as you'd expect, a refrigerator. You may open the \"refrigerator\"\n" +
                    "or look in a \"cabinet\".");
            secondLevel = input.nextLine();

            if(secondLevel.equals("refrigerator")){
                System.out.println("Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n" +
                        "Would you like to eat some of the food? (\"yes\" or \"no\")");
                thirdLevel = input.nextLine();

                if(thirdLevel.equals("no")){
                    System.out.println("You die of starvation... eventually.");
                }
                else if(thirdLevel.equals("yes")){
                    System.out.println("Enjoy the pizza inside the refrigerator. It is fresh. I was kidding earlier.");
                }
            }
            else if(secondLevel.equals("cabinet")){
                System.out.println("You are in the cabinet. There is a pandora box. Do you want to open it?(\"yes\" or \"no\")");
                thirdLevel=input.nextLine();
                if(thirdLevel.equals("yes"))
                {
                    System.out.println("You got trapped in the pandora box");
                }
                else{
                    System.out.println("You chose to be lucky. Good Job!!");
                }
            }
        }
        else if(firstLevel.equals("upstairs"))
        {
            System.out.println("Upstairs you see a hallway.  At the end of the hallway is the master\n" +
                    "\"bedroom\".  There is also a \"bathroom\" off the hallway.  Where would you like\n" +
                    "to go?");
            secondLevel=input.nextLine();
            if(secondLevel.equals("bedroom")){
                System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n" +
                        "bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n" +
                        "like to open the door? (\"yes\" or \"no\")");
                thirdLevel=input.nextLine();
                if(thirdLevel.equals("no"))
                {
                    System.out.println("Well, then I guess you'll never know what was in there.  Thanks for playing,\n" +
                            "I'm tired of making nested if statements.");
                }
                else if(thirdLevel.equals("yes"))
                {
                    System.out.println("Haha, you won the game. ");
                }
            }
            else if(secondLevel.equals("bathroom"))
            {
                System.out.println("Welcome to the bathroom level. Do you want to use the sink? (yes/no)");
                thirdLevel=input.nextLine();
                if(thirdLevel.equals("yes")){
                    System.out.println("The water is not working huhhahahahahah");
                }
                else if(thirdLevel.equals("no"))
                {
                    System.out.println("won the game hahahahahahahahahahahahah");
                }
            }
        }
    }
}
//end of the program