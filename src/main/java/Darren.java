import java.util.Scanner;

public class Darren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logo = "Darren";
        String line = "_____________________________________________";

        System.out.println(line);
        System.out.println("Hello! I'm " + logo);
        System.out.println("How can I help you?");
        System.out.println(line);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Goodbye! Have a nice day :)");
                System.out.println(line);
                break;
            }
            System.out.println(line);
            System.out.println(input);
            System.out.println(line);
        }
    }
}
