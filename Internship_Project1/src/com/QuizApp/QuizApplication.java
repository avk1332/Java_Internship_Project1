package com.QuizApp;
public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        
        String[] options1 = {"Java", "Python", "C++", "JavaScript"};
        quiz.addQuestion(new Question("Which programming language is known as the 'Write Once, Run Anywhere' language?", options1, 0));
        
        String[] options2 = {"1995", "1990", "1985", "2000"};
        quiz.addQuestion(new Question("In which year was Java first released?", options2, 0));
        
        String[] options3 = {"Oracle", "Microsoft", "Apple", "Google"};
        quiz.addQuestion(new Question("Which company developed Java?", options3, 0));
        
        quiz.start();
    }
}
