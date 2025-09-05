import java.util.Scanner;

public class Darren {

    public static Integer getInt(String input) {
        //get integer for mark and unmark
        String[] words = input.split(" ");
        return Integer.parseInt(words[1]);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskCount = 0;
        Task[] tasks = new Task[100];

        String logo = "Darren";
        String line = "_____________________________________________";

        //greeting
        System.out.println(line);
        System.out.println("Hello! I'm " + logo);
        System.out.println("How can I help you?");
        System.out.println(line);

        while (true) {
            String input = scanner.nextLine();
            // get first word of input as command
            String [] words = input.split(" ");
            String command = words[0];

            switch (command) {
                case "bye":
                    System.out.println(line);
                    System.out.println("Goodbye! Have a nice day :)");
                    System.out.println(line);
                    scanner.close();
                    return;

                case "list":
                System.out.println("Here's your to-do list:");
                System.out.println(line);
                for (int i = 0; i < taskCount; i++) {
                    System.out.println( (i+1) + ". " + tasks[i]);
                }
                System.out.println(line);
                break;

                case "mark":
                Integer markIndex = getInt(input);
                if (markIndex != null && markIndex <= taskCount && markIndex > 0) {
                    tasks[markIndex - 1].markAsDone();
                    System.out.println(line);
                    System.out.println("Good work! This task has been complete:");
                    System.out.println(tasks[markIndex - 1]);
                    System.out.println(line);
                } else {
                    System.out.println("Please enter a valid task number");
                }
                break;

                case "unmark":
                Integer unmarkIndex = getInt(input);
                if (unmarkIndex != null && unmarkIndex <= taskCount && unmarkIndex > 0) {
                    tasks[unmarkIndex - 1].markAsNotDone();
                    System.out.println(line);
                    System.out.println("Got it, I've marked this task as incomplete");
                    System.out.println(tasks[unmarkIndex - 1]);
                    System.out.println(line);
                } else {
                    System.out.println("Please enter a valid task number");
                }
                break;

                default:
                // add task feature
                tasks[taskCount] = new Task(input);
                taskCount++;
                System.out.println(line);
                System.out.println("added: " + input);
                System.out.println(line);
            }
        }
    }
}
