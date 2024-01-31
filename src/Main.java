import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static double calculateWinRate(int wins, int losses) {
        if (wins + losses == 0) {
            // To avoid division by zero if there are no games played
            return 0.0;
        } else {
            return (double) wins / (wins + losses) * 100.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wins;
        int losses;

        // Запрос количества побед
        System.out.println("Enter the number of wins:");
        while (true) {
            if (scanner.hasNextInt()) {
                wins = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        // Запрос количества поражений
        System.out.println("Enter the number of losses:");
        while (true) {
            if (scanner.hasNextInt()) {
                losses = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        char input;
        do {

            //System.out.println("Current Wins: " + wins);
            //System.out.println("Current Losses: " + losses);
            double winRate = calculateWinRate(wins, losses);
            DecimalFormat df = new DecimalFormat("#.##");
            String formattedWinrate = df.format(winRate);

            String emote = "forsenPls"; // SPAM IT MEGALUL

            System.out.println(emote + " WINS: " + wins + " " + emote + " LOSSES: " + losses + " " + emote +
                    " WIN RATE: " + formattedWinrate + "%" + " " + emote + " HIGHEST WIN STREAK: 7 " + emote);
            System.out.println("Enter '+' to increase wins, '-' to increase losses, or 'q' to quit:");

            input = scanner.next().charAt(0);

            switch (input) {
                case '+':
                    wins++;
                    break;
                case '-':
                    losses++;
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (input != 'q');


        System.out.println("Total Wins: " + wins);
        System.out.println("Total Losses: " + losses);


        scanner.close();
    }
}
