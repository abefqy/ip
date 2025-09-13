package darren;

import darren.task.Deadline;
import darren.task.Event;
import darren.task.Task;
import darren.task.Todo;

import java.util.Scanner;

public class Darren {

    public static Integer getInt(String input) {
        //get integer for mark and unmark
        String[] words = input.split(" ");
        if (words.length != 2) {
            return null;
        }
        try {
            return Integer.parseInt(words[1]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final int TODO_COMMAND_LENGTH = "todo ".length();
    private static final int DEADLINE_COMMAND_LENGTH = "deadline ".length();
    private static final int EVENT_COMMAND_LENGTH = "event ".length();


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
            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    continue;
                }
                // get first word of input as command
                String[] words = input.split(" ");
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
                            System.out.println((i + 1) + ". " + tasks[i]);
                        }
                        System.out.println(line);
                        break;

                    case "mark":
                        Integer markIndex = getInt(input);
                        if (markIndex == null || markIndex > taskCount || markIndex <= 0) {
                            throw new DarrenException("Please enter a valid task number to mark as done.");
                        }
                        tasks[markIndex - 1].markAsDone();
                        System.out.println(line);
                        System.out.println("Good work! This task has been complete:");
                        System.out.println(tasks[markIndex - 1]);
                        System.out.println(line);
                        break;

                    case "unmark":
                        Integer unmarkIndex = getInt(input);
                        if (unmarkIndex == null || unmarkIndex > taskCount || unmarkIndex <= 0) {
                            throw new DarrenException("Please enter a valid task number to unmark as done.");
                        }
                        tasks[unmarkIndex - 1].markAsNotDone();
                        System.out.println(line);
                        System.out.println("Got it, I've marked this task as incomplete");
                        System.out.println(tasks[unmarkIndex - 1]);
                        System.out.println(line);
                        break;

                    case "todo":
                        if (input.length() <= TODO_COMMAND_LENGTH) {
                            throw new DarrenException("You forgot to specify your task");
                        }
                        String todoDescription = input.substring(TODO_COMMAND_LENGTH).trim();
                        tasks[taskCount] = new Todo(todoDescription);
                        taskCount++;
                        System.out.println(line);
                        System.out.println("Got it. I've added this todo:");
                        System.out.println(" " + tasks[taskCount - 1]);
                        System.out.println("Now you have " + taskCount + " tasks in your list.");
                        System.out.println(line);
                        break;

                    case "deadline":
                        if (input.length() <= DEADLINE_COMMAND_LENGTH) {
                            throw new DarrenException("You are missing a description!");
                        }
                        String removeDeadline = input.substring(DEADLINE_COMMAND_LENGTH).trim();
                        String[] remaining = removeDeadline.split("/by");
                        //check for successful split
                        if (remaining.length < 2 || remaining[0].trim().isEmpty() || remaining[1].trim().isEmpty()) {
                            throw new DarrenException("Please use the correct format: deadline <description> /by <date/time>");
                        }
                        tasks[taskCount] = new Deadline(remaining[0].trim(), remaining[1].trim());
                        taskCount++;
                        System.out.println(line);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(" " + tasks[taskCount - 1]);
                        System.out.println("Now you have " + taskCount + " tasks in your list.");
                        System.out.println(line);
                        break;

                    case "event":
                        if (input.length() <= EVENT_COMMAND_LENGTH) {
                            throw new DarrenException("You are missing a description!");
                        }
                        String removeEvent = input.substring(EVENT_COMMAND_LENGTH).trim();
                        String[] remainingEvent = removeEvent.split("/from");
                        if (remainingEvent.length < 2) {
                            throw new DarrenException("Please use the correct format: Event <description> /from <date/time> /to <date/time>");
                        }
                        String description = remainingEvent[0].trim();
                        String[] remainingEvent2 = remainingEvent[1].split("/to");
                        if (remainingEvent2.length < 2) {
                            throw new DarrenException("Please use the correct format: Event <description> /from <date/time> /to <date/time>");
                        }
                        String from = remainingEvent2[0].trim();
                        String to = remainingEvent2[1].trim();

                        if (description.isEmpty() || from.isEmpty() || to.isEmpty()) {
                            throw new DarrenException("Remember to fill up the description, start and end time of you event!");
                        }

                        tasks[taskCount] = new Event(description, from, to);
                        taskCount++;
                        System.out.println(line);
                        System.out.println("Got it. I've added this event:");
                        System.out.println(" " + tasks[taskCount - 1]);
                        System.out.println("Now you have " + taskCount + " tasks in your list.");
                        System.out.println(line);
                        break;

                    default:
                        throw new DarrenException("I'm sorry, I don't recognise that command. Please try again.");
                }
            } catch (DarrenException e) {
                System.out.println(line);
                System.out.println("Uh oh! " + e.getMessage());
                System.out.println(line);
            }
        }
    }
}