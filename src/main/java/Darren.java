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
            //exit feature
            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Goodbye! Have a nice day :)");
                System.out.println(line);
                break;


            } else if (input.equals("list")) {
                //list feature
                System.out.println("Here's your to-do list:");
                System.out.println(line);
                for (int i = 0; i < taskCount; i++) {
                    System.out.println( (i+1) + ". " + tasks[i]);
                }
                System.out.println(line);


            } else if (input.startsWith("mark")) {
                //mark feature
                Integer index = getInt(input);
                if (index != null && index <= taskCount && index > 0) {
                    tasks[index - 1].markAsDone();
                    System.out.println(line);
                    System.out.println("Good work! This task has been complete:");
                    System.out.println(tasks[index - 1]);
                    System.out.println(line);
                }

            } else if (input.startsWith("unmark")) {
                //unmark feature
                Integer index = getInt(input);
                if (index != null && index <= taskCount && index > 0) {
                    tasks[index - 1].markAsNotDone();
                    System.out.println(line);
                    System.out.println("Got it, I've marked this task as incomplete");
                    System.out.println(tasks[index - 1]);
                    System.out.println(line);
                }
            } else {
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
