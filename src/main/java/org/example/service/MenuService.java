package org.example.service;

public class MenuService {

    public static void printMainMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. Edit league");
        System.out.println("\t 2. Edit team");
        System.out.println("\t 3. create match");
        System.out.println("\t 4. Show table");
        System.out.println("\t 5. Quit");
    }
    public static void printTeamMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. Delete team");
        System.out.println("\t 2. quit");
    }
    public static void printMatchMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. quit");
        System.out.println("\t 2. create match");
    }
    public static void printTableMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. quit");
        System.out.println("\t 2. Show table");
    }
}
