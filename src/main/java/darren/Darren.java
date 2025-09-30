package darren;

import darren.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class Darren {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Darren(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DarrenException e) {
            ui.showLoadingError();
            tasks = new TaskList(new ArrayList<Task>());
        }
    }


    public void run() {
        this.ui.displayWelcome();

        boolean isExit = false;

        while (!isExit) {
            try {
                String input = this.ui.nextLine();

                Parser.command(input, this.tasks, this.ui, this.storage);

                isExit = Parser.exit(input);
            } catch (DarrenException e) {
                this.ui.displayError("Uh oh! " + e.getMessage());
            } catch (IOException e) {
                this.ui.displayError("A serious file error occurred: " + e.getMessage());
                isExit = true;
            }
        }

        this.ui.displayBye();
        this.ui.close();
    }

    public static void main(String[] args) {
        new Darren("data/tasks.txt").run();
    }
}
