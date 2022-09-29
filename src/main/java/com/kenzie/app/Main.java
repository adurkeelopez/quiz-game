package com.kenzie.app;

// import necessary libraries

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import static com.kenzie.app.ConsoleColors.*;

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!
     */

    //355237 is number of clues according to API website
    static final int NUM_CLUES = 355237;
    //40950 is number of categories according to API website
    static final int NUM_CATEGORIES = 40950;

    public static void main(String[] args) {
        //Write main execution code here
        try {
            final String GET_URL = "https://jservice.kenzie.academy/api/";
            Scanner scan = new Scanner(System.in);
            CustomHttpClient cluesHttpClient = new CustomHttpClient();

            System.out.println("Welcome to the J quiz game!");
            try {
                boolean stop = false;
                while (!stop) {
                    System.out.println("Which type of quiz would you like to play?");
                    System.out.println("Option 1: 10 Questions");
                    System.out.println("Option 2: 30 Question Game Board");
                    System.out.println("Enter 0 to Exit.");
                    int option = Integer.parseInt(scan.nextLine());
                    String anotherGame = "";

                    switch (option) {
                        case 1:
                            startGame(cluesHttpClient, GET_URL, scan);      //10 Question Quiz
                            System.out.println();
                            System.out.println("Would you like to play another Game?");
                            anotherGame = scan.nextLine();
                            if (!anotherGame.equalsIgnoreCase("y")) {
                                System.out.println("You have chosen to not play another game.");
                                System.out.println("Exiting...");
                                return;
                            }
                            break;
                        case 2:
                            String[][] gameGrid = new String[6][6]; //rows x columns
                            startGame(cluesHttpClient, GET_URL, scan, gameGrid);    //GameBoard Style Quiz
                            System.out.println();
                            System.out.println("Would you like to play another Game?");
                            anotherGame = scan.nextLine();
                            if (!anotherGame.equalsIgnoreCase("y")) {
                                System.out.println("You have chosen to not play another game.");
                                System.out.println("Exiting...");
                                return;
                            }
                            break;
                        case 0:
                            System.out.println("Exiting...");
                            stop = true;
                            break;
                        default:
                            System.out.println("That is not a valid option. Please try again.");
                            break;
                    }
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println();
            }

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    //10 Question Quiz
    public static void startGame(CustomHttpClient cluesHttpClient, String URL, Scanner scanner)
            throws JsonProcessingException {
        Random rand = new Random();
        String[] cluesArray = new String[10];
        String[] cluesQuestionsArray = new String[10];
        String[] cluesAnswersArray = new String[10];
        String[] cluesCategoryNamesArray = new String[10];
        int totalScore = 0;

        fillInData(cluesHttpClient, URL, rand, cluesArray, cluesQuestionsArray, cluesAnswersArray,
                cluesCategoryNamesArray);

        try {
            System.out.println("The game will begin now. You have 10 questions to answer.");
            System.out.println();

            for (int i = 0; i < 10; i++) {
                System.out.println("Question " + (i + 1));
                System.out.println("Category: " + YELLOW + cluesCategoryNamesArray[i] + RESET);
                System.out.println("Question: " + cluesQuestionsArray[i]);
                System.out.print("Your Answer: ");

                String response = scanner.nextLine();
                System.out.println();
                if (response.trim().equalsIgnoreCase(cluesAnswersArray[i].trim())) {
                    System.out.println(GREEN + "CORRECT! You have earned one point!" + RESET);
                    totalScore++;
                } else {
                    System.out.println(RED + "INCORRECT! Too bad. The correct answer is:");
                    System.out.println(cluesAnswersArray[i] + RESET);
                }

                System.out.println("Your Current Score: " + PURPLE + totalScore + RESET);
                System.out.println();
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Congratulations, you have finished the quiz.");
        System.out.println("Your final score is: " + PURPLE + totalScore + RESET);
    }

    //GameBoard style Quiz
    public static void startGame(CustomHttpClient cluesHttpClient, String URL, Scanner scanner,
                                 String[][] gameBoard) throws JsonProcessingException {
        Random rand = new Random();
        String[] cluesArray = new String[30];
        String[] cluesQuestionsArray = new String[30];
        String[] cluesAnswersArray = new String[30];
        String[] cluesCategoryNamesArray = new String[6];
        int[] cluesValueArray = new int[30];
        int totalScore = 0;

        fillInData(cluesHttpClient, URL, rand, cluesArray, cluesQuestionsArray, cluesAnswersArray,
                cluesCategoryNamesArray, cluesValueArray, gameBoard);

        int[][] checkedGrid = new int[][]
                {{0, 5, 10, 15, 20, 25},
                        {1, 6, 11, 16, 21, 26},
                        {2, 7, 12, 17, 22, 27},
                        {3, 8, 13, 18, 23, 28},
                        {4, 9, 14, 19, 24, 29}};

        int colPicked = 0, rowPicked = 0;

        try {
            printGameBoard(gameBoard);
            System.out.println();
            System.out.println("Welcome to the game!");
            int numQuestionsAnswered = 0;

            while (numQuestionsAnswered < 30) {
                System.out.println("Please pick the next Question.");

                System.out.println("Select column (1-6). Enter 0 to Quit: ");
                try {
                    colPicked = Integer.parseInt(scanner.nextLine());
                    if (colPicked >= 0 && colPicked < 7) {
                        if (colPicked == 0) {
                            System.out.println();
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Please select a number between 1 and 6, or enter 0 to Quit:");
                }

                System.out.println("Select row (1-5). Enter 0 to Quit: ");
                try {
                    rowPicked = Integer.parseInt(scanner.nextLine());
                    if (rowPicked >= 0 && rowPicked < 6) {
                        if (rowPicked == 0) {
                            System.out.println();
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Please select a number between 1 and 5, or enter 0 to Quit:");
                }
                System.out.println();

                if (checkedGrid[rowPicked - 1][colPicked - 1] == -1) {
                    System.out.println("You have already picked that question.");
                    printGameBoard(gameBoard);
                    //printGameBoard(checkedGrid);  //Debug - check (un)answered clues board
                    System.out.println();
                } else if (checkedGrid[rowPicked - 1][colPicked - 1] != -1) {
                    checkedGrid[rowPicked - 1][colPicked - 1] = -1;
                    gameBoard[rowPicked][colPicked - 1] = BLACK + "XXX" + RESET;
                    System.out.println("Question " + (numQuestionsAnswered + 1));
                    System.out.println("Category: " + cluesCategoryNamesArray[colPicked - 1]);
                    int index = (colPicked - 1) * 5 + (rowPicked - 1);

                    System.out.println("Question: " + cluesQuestionsArray[index]);
                    System.out.println("Value: " + cluesValueArray[index]);
                    //System.out.println("Answer: " + cluesAnswersArray[index]);
                    System.out.print("Your Answer: ");

                    String response = scanner.nextLine();
                    System.out.println();
                    if (response.trim().equalsIgnoreCase(cluesAnswersArray[index].trim())) {
                        System.out.println(GREEN + "CORRECT! You have earned " + PURPLE + cluesValueArray[index]
                                + GREEN + " points!" + RESET);
                        totalScore += cluesValueArray[index];
                    } else {
                        System.out.println(RED + "INCORRECT! Too bad. The correct answer is:");
                        System.out.println(RED_BOLD + cluesAnswersArray[index] + RESET);
                    }
                    System.out.println("Your current score is: " + PURPLE + totalScore + RESET);
                    numQuestionsAnswered++;
                    System.out.println();
                    printGameBoard(gameBoard);
                    System.out.println();
                }
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Congratulations, you have finished the quiz.");
        System.out.println("Your final score is: " + PURPLE + totalScore + RESET);
    }

    //For 10 questions quiz
    public static void fillInData(CustomHttpClient cluesHttpClient, String URL, Random random,
                                  String[] cluesArray, String[] cluesQuestionsArray, String[] cluesAnswersArray,
                                  String[] cluesCategoryNamesArray) throws JsonProcessingException {
        Integer[] clueIDArray = generateRandomCluesIDs(random);
        for (int i = 0; i < 10; i++) {
            cluesArray[i] = CustomHttpClient.sendGET(URL + "clues/" + clueIDArray[i]);
        }

        for (int i = 0; i < 10; i++) {
            cluesQuestionsArray[i] = cluesHttpClient.getClueQuestion(cluesArray[i]);
            cluesAnswersArray[i] = cluesHttpClient.getClueAnswer(cluesArray[i]);
            cluesCategoryNamesArray[i] = cluesHttpClient.getClueCategoryTitle(cluesArray[i]);
        }
    }

    //For GameBoard style quiz
    public static void fillInData(CustomHttpClient cluesHttpClient, String URL, Random random,
                                  String[] cluesArray, String[] cluesQuestionsArray, String[] cluesAnswersArray,
                                  String[] cluesCategoryNamesArray, int[] cluesValueArray,
                                  String[][] gameBoard) throws JsonProcessingException {
        //Integer[] catIDArray = generateRandomCategoryIDs(random, URL, cluesHttpClient);
        Integer[] catIDArray = generateRandomCategoryIDs(random);
        Integer[] clueIDArray = generateRandomCluesIDsForCategoryID(random, catIDArray, URL, cluesHttpClient);

        for (int i = 0; i < 30; i++) {
            cluesArray[i] = CustomHttpClient.sendGET(URL + "clues/" + clueIDArray[i]);
        }

        for (int i = 0; i < 30; i++) {
            if (i % 5 == 0) {
                cluesCategoryNamesArray[i / 5] = "{" + YELLOW + cluesHttpClient.getClueCategoryTitle
                        (cluesArray[i]) + RESET + "}";
            }
            cluesQuestionsArray[i] = cluesHttpClient.getClueQuestion(cluesArray[i]);
            cluesAnswersArray[i] = cluesHttpClient.getClueAnswer(cluesArray[i]);
            cluesValueArray[i] = cluesHttpClient.getClueValue(cluesArray[i]);
        }

        int tracker = 0;
        for (int i = 0; i < 6; i++) {
            gameBoard[0][i] = cluesCategoryNamesArray[i];

            for (int j = 1; j <= 5; j++) {
                gameBoard[j][i] = String.valueOf(cluesValueArray[tracker]);
                tracker++;
            }
        }
    }

    public static Integer[] generateRandomCluesIDs(Random random) {
        ArrayList<Integer> clueIDList = new ArrayList<>();
        Integer[] clueIDArray = new Integer[10];

        for (int i = 0; i < 10; i++) {
            int newID = random.nextInt(NUM_CLUES) + 1;
            while (clueIDList.contains(newID)) {
                newID = random.nextInt(NUM_CLUES) + 1;
                if (!clueIDList.contains(newID)) {
                    clueIDList.add(newID);
                }
            }
            clueIDList.add(newID);
        }

        for (int i = 0; i < 10; i++) {
            clueIDArray[i] = clueIDList.get(i);
        }

        return clueIDArray;
    }

    //Restricts category choice using a pre-filtered selection in TinyCharacters.java
    public static Integer[] generateRandomCategoryIDs(Random random) {
        ArrayList<Integer> catIDList = new ArrayList<>();
        Integer[] catIDArray = new Integer[6];
        ArrayList<Integer> undCatList = new TinyCategories().undesirableCategoriesIDs();

        for (int i = 0; i < 6; i++) {
            int newID = random.nextInt(NUM_CATEGORIES) + 1;

            while (catIDList.contains(newID) || undCatList.contains(newID)) {
                newID = random.nextInt(NUM_CATEGORIES) + 1;
            }
            catIDList.add(newID);
        }

        for (int i = 0; i < 6; i++) {
            catIDArray[i] = catIDList.get(i);
        }

        return catIDArray;
    }

    //Attempt dynamic detection of tiny & empty categories
    public static Integer[] generateRandomCategoryIDs(Random random, String URL, CustomHttpClient
            cluesHttpClient) throws JsonProcessingException {
        ArrayList<Integer> catIDList = new ArrayList<>();
        Integer[] catIDArray = new Integer[6];

        for (int i = 0; i < 6; i++) {
            int newID = random.nextInt(NUM_CATEGORIES) + 1;

            while (catIDList.contains(newID)) {
                newID = random.nextInt(NUM_CATEGORIES) + 1;
            }
            catIDList.add(newID);
        }

        for (int i = 0; i < 6; i++) {
            String tmp = CustomHttpClient.sendGET(URL + "clues?category=" + catIDList.get(i));
            List<CluesDTO> cluesByCatList = CustomHttpClient.getCluesList(cluesHttpClient.formatForList
                    (tmp));

            while (cluesByCatList.size() < 5) {
                int newID = random.nextInt(NUM_CATEGORIES) + 1;
                while (catIDList.contains(newID)) {
                    newID = random.nextInt(NUM_CATEGORIES) + 1;
                }

                tmp = CustomHttpClient.sendGET(URL + "clues?category=" + catIDList.get(i));
                cluesByCatList = CustomHttpClient.getCluesList(cluesHttpClient.formatForList(tmp));
            }
        }

        for (int i = 0; i < 6; i++) {
            catIDArray[i] = catIDList.get(i);
        }

        return catIDArray;
    }

    //Get clues based on the category IDs passed in
    public static Integer[] generateRandomCluesIDsForCategoryID(Random random, Integer[] catIDArray,
                                                                String URL, CustomHttpClient cluesHttpClient)
            throws JsonProcessingException {
        ArrayList<Integer> clueIDList = new ArrayList<>();
        Integer[] clueIDArray = new Integer[30];
        String[] cluesByCatArray = new String[catIDArray.length];

        for (int i = 0; i < catIDArray.length; i++) {
            cluesByCatArray[i] = CustomHttpClient.sendGET(URL + "clues?category=" + catIDArray[i]);
        }

        for (int i = 0; i < catIDArray.length; i++) {
            List<CluesDTO> cluesByCatList = CustomHttpClient.getCluesList(cluesHttpClient.formatForList
                    (cluesByCatArray[i]));

            for (int j = 0; j < 5; j++) {
                if (cluesByCatList.size() > 5) {
                    int newID = random.nextInt(cluesByCatList.size());
                    newID = cluesByCatList.get(newID).getId();

                    while (clueIDList.contains(newID)) {
                        newID = random.nextInt(cluesByCatList.size());
                        newID = cluesByCatList.get(newID).getId();
                    }
                    clueIDList.add(newID);
                } else //if (cluesByCatList.size() == 5)
                {
                    clueIDList.add(cluesByCatList.get(j).getId());
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            clueIDArray[i] = clueIDList.get(i);
        }

        return clueIDArray;
    }

    public static void printGameBoard(String[][] gameBoard) {
        for (String[] strings : gameBoard) {
            System.out.println(Arrays.toString(strings));
        }
    }

    //For debug - prints questions (un)answered tracking board
    public static void printGameBoard(int[][] gameBoard) {
        for (int[] ints : gameBoard) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
