package com.QuizApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            int userAnswer = getUserAnswer(scanner, options.length);
            if (question.isCorrect(userAnswer - 1)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong. The correct answer was: " + options[question.getCorrectAnswerIndex()]);
            }
            System.out.println();
        }
        System.out.println("Your final score is: " + score + " out of " + questions.size());
        scanner.close();
    }

    private int getUserAnswer(Scanner scanner, int numOptions) {
        int answer = -1;
        while (answer < 1 || answer > numOptions) {
            System.out.print("Your answer: ");
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (answer < 1 || answer > numOptions) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + numOptions);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return answer;
    }
}
