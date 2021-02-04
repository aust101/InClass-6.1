package com.overaitis.inclass_6_1;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Rock, Paper Scissors, Tape, and Lighter!\nPlease enter \"EXIT\" at anytime to stop the program, and view your results!\n");
        boolean running = true;
        Game game = new Game();
        while(running) {
            System.out.println("\nPlease pick your choice:");
            outputChoices();
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")) {
                running = false;
            }
            else {
                try {
                    HandChoices player = HandChoices.getFromAnyRelation(input);
                    HandChoices computer = game.getRandomChoice();
                    Game.Results result = game.getResult(player, computer);
                    System.out.println("You picked " +player.getReadableName() + " and "+ result.getPastTense().toUpperCase() + " against the Computer's " + computer.getReadableName() + "!");
                } catch (IllegalArgumentException e) {
                    System.out.println("You selected an invalid choice! Please try again by entering the name or id.");
                }
            }
        }

        System.out.println("Good bye. Here are your game results:");
        System.out.println(game.toString());
    }

    private static void outputChoices() {
        for (int i = 0; i < HandChoices.values().length; i++) {
            System.out.println("[" + i + "] - " + HandChoices.values()[i].getReadableName());
        }
        System.out.println("");
    }
}
