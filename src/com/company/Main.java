package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String question;
        System.out.println("Welcome to the Eliza Program \n::::::::::::::::::::::::::::::::::::::::");
        Scanner scan = new Scanner(System.in);

        System.out.println("Good day. What is your problem? Enter your response here or Q to quit: my teacher hates me");
        question =scan.nextLine();

    }

    public static void pigLatin(){


    }

    public static void hedgesHashMap(String response){

        HashMap<Integer, String> hedges = new HashMap<Integer, String>();
        hedges.put(1,"Please tell me more");
        hedges.put(2,"Many of my patients tell me the same thing");
        hedges.put(3,"It is getting late, maybe we had better quit");


    }

    public static void qualifiers(String response){
        HashMap<Integer, String> qualify = new HashMap<Integer, String>();
        qualify.put(1,"Why do you say that");
        qualify.put(2,"You seem to think that");
        qualify.put(3,"So, you are concerned that");

    }

    public static void allCaps(String response){


    }
    public static void playGame(String response){

    }
    public static void red(String response){}

}
