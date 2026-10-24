import java.util.Scanner;

class Question {
    String question;
    String[] options;
    char correctAnswer;

    Question(String q, String[] opt, char ans) {
        question = q;
        options = opt;
        correctAnswer = ans;
    }
}

public class OnlineQuizSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Login System
        System.out.println("===== ONLINE QUIZ SYSTEM =====");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!username.equals("admin") || !password.equals("1234")) {
            System.out.println("Invalid Login! Exiting...");
            sc.close();
            return;
        }

        System.out.println("\nLogin Successful! Welcome " + username);

        // Questions
        Question[] quiz = new Question[5];

        quiz[0] = new Question(
                "1. What is the capital of India?",
                new String[]{"A. Chennai", "B. Delhi", "C. Mumbai", "D. Kolkata"},
                'B'
        );

        quiz[1] = new Question(
                "2. Which language is used for Android development?",
                new String[]{"A. Python", "B. C++", "C. Java", "D. HTML"},
                'C'
        );

        quiz[2] = new Question(
                "3. What is 5 + 3?",
                new String[]{"A. 5", "B. 8", "C. 10", "D. 6"},
                'B'
        );

        quiz[3] = new Question(
                "4. Which is not an OOP concept?", new String[]{"A. Inheritance", "B. Polymorphism", "C. Compilation", "D. Encapsulation"},
                'C'
        );

        quiz[4] = new Question(
                "5. Who invented Java?",
                new String[]{"A. Dennis Ritchie", "B. James Gosling", "C. Bjarne Stroustrup", "D. Guido van Rossum"},
                'B'
        );

        int score = 0;
        char answer;

        // Quiz Execution
        for (int i = 0; i < quiz.length; i++) {

            System.out.println("\n" + quiz[i].question);

            for (String opt : quiz[i].options) {
                System.out.println(opt);
            }

            // Safe input handling
            System.out.print("Enter your answer (A/B/C/D): ");
            String input = sc.nextLine();

            while (input.isEmpty()) {
                System.out.print("Please enter A/B/C/D: ");
                input = sc.nextLine();
            }

            answer = input.toUpperCase().charAt(0);

            if (answer == quiz[i].correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct Answer: " + quiz[i].correctAnswer);
            }
        }

        // Result Evaluation
        System.out.println("\n===== RESULT =====");
        System.out.println("Total Questions: " + quiz.length);
        System.out.println("Correct Answers: " + score);

        double percentage = (score * 100.0) / quiz.length;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        sc.close();
    }
}















