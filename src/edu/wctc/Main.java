package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) throws IOException {

        printMenu();

    }
    private static void printMenu() throws IOException {
        System.out.print("\n1. Add room\n2. Write rooms to file\n3. Read rooms from file\n4. View Rooms\n5. Exit\n\nEnter selection: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": createRoom(); printMenu();
            case "2": writeFile(); printMenu();
            case "3": readFile(); printMenu();
            case "4": System.out.println(paintCalculator); printMenu();
            case "5": System.out.println("Exiting program...\nGoodbye."); System.exit(0);
            default: System.out.println("Enter valid response."); printMenu();
        }
    }

    private static double promptForDimension(String dimensionS) {
        double dimensionD;
        try {
            dimensionD = Double.parseDouble(dimensionS);
        } catch (NumberFormatException e) {
            dimensionD = 10;
            System.out.printf("Invalid response. Returning value %s instead.\n", dimensionD);
        }
        return dimensionD;
    }

    private static void createRoom() {
        System.out.print("Enter the room's width: ");
        double width = promptForDimension(scanner.next());
        System.out.print("Enter the room's length: ");
        double length = promptForDimension(scanner.next());
        System.out.print("Enter the room's height: ");
        double height = promptForDimension(scanner.next());
        paintCalculator.addRoom(width, length, height);
    }

    private static void writeFile() throws IOException {
        FileWriter fw = new FileWriter("rooms.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        for (Room r : paintCalculator.roomList) pw.println(r.getArea());
        pw.flush();
        pw.close();
        System.out.println("File written successfully");
    }

    private static void readFile() throws FileNotFoundException {
        File file = new File ("rooms.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
