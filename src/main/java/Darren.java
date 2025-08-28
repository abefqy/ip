import java.util.Scanner;

public class Darren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskCount = 0;
        String[] tasks = new String[100];

        String logo = "Darren";
        String line = "_____________________________________________";

        //greeting
        System.out.println(line);
        System.out.println("Hello! I'm " + logo);
        System.out.println("How can I help you?");
        System.out.println(line);

        while (true) {
            String input = scanner.nextLine();
            //exit feature
            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Goodbye! Have a nice day :)");
                System.out.println(line);
                break;
            } else if (input.equals("list")) {
                //list feature
                System.out.println(line);
                for (int i = 0; i < taskCount; i++) {
                    System.out.println( (i+1) + ". " + tasks[i]);
                }
                System.out.println(line);
            } else {
                tasks[taskCount] = input;
                taskCount++;
                System.out.println(line);
                System.out.println("added: " + input);
                System.out.println(line);
            }
        }
    }
}
