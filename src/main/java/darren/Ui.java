package darren;

import darren.task.Task;
import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);
    public static final String LINE = "____________________________________________________________";
    public static final String LOGO = "Darren";

    public void displayWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm " + LOGO);
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void displayError(String message) {
        System.out.println(LINE);
        System.out.println(message);
        System.out.println(LINE);
    }

    public void showLoadingError() {
        displayError("Error loading tasks from file. Starting with an empty list.");
    }

    public void displayList(TaskList tasks) {
        System.out.println(LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.println(LINE);
    }

    public void displayMark(Task t) {
        System.out.println(LINE);
        System.out.println("Good work! This task has been complete:");
        System.out.println(t);
        System.out.println(LINE);
    }

    public void displayUnmark(Task t) {
        System.out.println(LINE);
        System.out.println("Got it, I've marked this task as incomplete");
        System.out.println(t);
        System.out.println(LINE);
    }

    public void displayAdd(Task t, TaskList tasks) {
        System.out.println(LINE);
        System.out.println("Got it. I've added this task:");
        System.out.println("    " + t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    public void displayDelete(Task t, TaskList tasks) {
        System.out.println(LINE);
        System.out.println("Noted. I've removed this task:");
        System.out.println("    " + t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    public void displayFind(TaskList matchingTasks) {
        System.out.println(LINE);
        if (matchingTasks.size() == 0) {
            System.out.println("Sorry! No matching tasks were found in your list.");
            return;
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + matchingTasks.get(i).toString());
            }
        }
        System.out.println(LINE);
    }

    public void displayBye() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void close() {
        scanner.close();
    }
}