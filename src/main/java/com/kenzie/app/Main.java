package com.kenzie.app;

// import necessary libraries
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    public static void main(String[] args) {
        //Write main execution code here
        try {
            final String GET_URL = "https://jservice.kenzie.academy/api/clues";
            Scanner scan = new Scanner(System.in);
            Random rand = new Random();
            CustomHttpClient CluesHttpClient = new CustomHttpClient();

            Integer[] cluesIDsArray = generateRandomCluesIDs(rand);
            startGame(cluesIDsArray, CluesHttpClient, GET_URL, scan);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Integer[] generateRandomCluesIDs(Random random) {
        ArrayList<Integer> clueIDList = new ArrayList<>();
        Integer[] clueIDArray = new Integer[10];

        for (int i = 0; i < 10; i++) {
            int newID = random.nextInt(355237) + 1;
            while (clueIDList.contains(newID)) {
                newID = random.nextInt(355237) + 1;
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

    public static void startGame(Integer[] clueIDArray, CustomHttpClient CluesHttpClient, String URL,
                                 Scanner scanner) throws JsonProcessingException {
        String[] cluesArray = new String[10];
        String[] cluesQuestionsArray = new String[10];
        String[] cluesAnswersArray = new String[10];
        String[] cluesCategoryNamesArray = new String[10];
        int totalScore = 0;

        fillInData(clueIDArray, CluesHttpClient, URL, cluesArray, cluesQuestionsArray, cluesAnswersArray,
                cluesCategoryNamesArray);

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Question " + (i + 1));
                System.out.println(cluesCategoryNamesArray[i]);
                System.out.println(cluesQuestionsArray[i]);
                System.out.print("Your Answer: ");

                String response = scanner.nextLine();
                System.out.println();
                if (response.trim().equalsIgnoreCase(cluesAnswersArray[i].trim())) {
                    System.out.println("CORRECT! You have earned one point!");
                    totalScore++;
                } else {
                    System.out.println("INCORRECT! Too bad. The correct answer is:");
                    System.out.println(cluesAnswersArray[i]);
                }

                System.out.println("Your Current Score: " + totalScore);
                System.out.println();
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Congratulations, you have finished the quiz.");
        System.out.println("Your final score is: " + totalScore);
    }

    public static void fillInData(Integer[] clueIDArray, CustomHttpClient CluesHttpClient, String URL,
                                  String[] cluesArray, String[] cluesQuestionsArray, String[] cluesAnswersArray,
                                  String[] cluesCategoryNamesArray) throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            cluesArray[i] = CustomHttpClient.sendGET(URL + "/" + clueIDArray[i]);
        }

        for (int i = 0; i < 10; i++) {
            cluesQuestionsArray[i] = CluesHttpClient.getClueQuestion(cluesArray[i]);
            cluesAnswersArray[i] = CluesHttpClient.getClueAnswer(cluesArray[i]);
            cluesCategoryNamesArray[i] = CluesHttpClient.getClueCategoryName(cluesArray[i]);
        }
    }
}
