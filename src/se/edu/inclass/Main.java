package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        System.out.println("Welcome to Task (stream) manager\n");
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();


        System.out.println();
//        System.out.println("Printing deadlines");
//        printDeadlines(tasksData);
//
//        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
//        printData(tasksData);
        printDataUsingStreams(tasksData);
    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStreams(ArrayList<Task> tasks) {
        int count = (int)tasks.stream()
                .filter(t -> t instanceof Deadline)
                .count();
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        System.out.println("Printing data using iteration");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }
    public static void printDataUsingStreams(ArrayList<Task> tasks) {
        System.out.println("Printing data using streams");
        tasks.stream() // convert to stream
                // can also replace stream() with parallelStream() -> will be faster in large data
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Printing deadline using iteration:");
        for (Task t : tasksData) { // so dont need variable i to iterate
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesUsingStream(ArrayList<Task> tasks) {
        System.out.println("Printing deadline using streams:");
        tasks.stream()
                .filter(t -> t instanceof Deadline) // filter taks a predicate
                // predicate: may or may not take an input and returns a boolean: true or false
                .forEach(System.out::println);
    }
}
