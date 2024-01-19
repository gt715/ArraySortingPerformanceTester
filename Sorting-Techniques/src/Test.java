import java.util.Scanner;

public class Test {

    public static void testBubbleSort() {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the sorted array, reversely sorted array, and random array from user input
        int[] sortedArray = getSortedArray(scanner);
        int[] reverselySortedArray = getReverselySortedArray(scanner);
        int[] randomArray = getRandomArray(scanner);

        // Record the current time
        long start = System.currentTimeMillis();

        // Perform Bubble Sort on the random array
        Sorting.bubbleSort(randomArray);

        // Record the current time
        long end = System.currentTimeMillis();

        // Print the time taken to sort the random array
        System.out.println(">> Time taken by bubble sort to sort random array: " + (end - start) + " ms");

        // Repeat the process for the sorted array
        start = System.currentTimeMillis();
        Sorting.bubbleSort(sortedArray);
        end = System.currentTimeMillis();
        System.out.println(">> Time taken by bubble sort to sort sorted array: " + (end - start) + " ms");

        // Repeat the process for the reversely sorted array
        start = System.currentTimeMillis();
        Sorting.bubbleSort(reverselySortedArray);
        end = System.currentTimeMillis();
        System.out.println(">> Time taken by bubble sort to sort reversely sorted array: " + (end - start) + " ms");
    }


    public static void testCountSort() {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the sorted array, reversely sorted array, and random array from user input
        int[] sortedArray = getSortedArray(scanner);
        int[] reverselySortedArray = getReverselySortedArray(scanner);
        int[] randomArray = getRandomArray(scanner);

        // Record the current time
        long start = System.currentTimeMillis();

        // Perform Count Sort on the random array
        Sorting.countSort(randomArray);

        // Record the current time
        long end = System.currentTimeMillis();

        // Print the time taken to sort the random array
        System.out.println(">> Time taken by count sort to sort random array: " + (end - start)+ " ms");

        // Repeat the process for the sorted array
        start = System.currentTimeMillis();
        Sorting.countSort(sortedArray);
        end = System.currentTimeMillis();
        System.out.println(">> Time taken by count sort to sort sorted array: " + (end - start) + " ms");

        // Repeat the process for the reversely sorted array
        start = System.currentTimeMillis();
        Sorting.countSort(reverselySortedArray);
        end = System.currentTimeMillis();
        System.out.println(">> Time taken by count sort to sort reversely sorted array: " + (end - start) + " ms");
    }

    public static void testQuickSort() {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the sorted array, reversely sorted array, and random array from user input
        int[] sortedArray = getSortedArray(scanner);
        int[] reverselySortedArray = getReverselySortedArray(scanner);
        int[] randomArray = getRandomArray(scanner);

        // Record the current time
        long start = System.currentTimeMillis();

        // Perform QuickSort on the random array
        Sorting.quickSort(randomArray);

        // Record the current time
        long end = System.currentTimeMillis();

        // Print the time taken to sort the random array
        System.out.println(">> Time taken by quick sort to sort random array: " + (end - start) + " ms");

        // Repeat the process for the sorted array
        start = System.currentTimeMillis();
        Sorting.quickSort(sortedArray);
        end = System.currentTimeMillis();
        System.out.println(">> Time taken by quick sort to sort sorted array: " + (end - start) + " ms");

        // Repeat the process for the reversely sorted array
        start = System.currentTimeMillis();
        Sorting.quickSort(reverselySortedArray);
        end = System.currentTimeMillis();
        System.out.println(">> Time taken by quick sort to sort reversely sorted array: " + (end - start) + " ms");
    }


    private static int[] getRandomArray(Scanner scanner) {
        // Initialize an array
        int[] array = null;

        // Prompt the user to enter a random array
        System.out.println("Enter a random array: ");

        // Display the options to the user
        displayOptions();

        // Prompt the user to enter their option
        System.out.print("Enter your option: ");

        // Get the user's option
        int option = scanner.nextInt();

        // If the user's option is 1
        if(option == 1) {
            // Prompt the user to enter the array size
            System.out.print("Enter the array size: ");

            // Get the array size from the user
            int size = scanner.nextInt();

            // Move the scanner to the next line
            scanner.nextLine();

            // Generate a random array of the specified size
            array = Array.generateRandomArray(size);
        } else if (option == 2) {
            // Prompt the user to enter the file path
            System.out.print("Enter the file path: ");

            // Move the scanner to the next line
            scanner.nextLine();

            // Get the file path from the user
            String filePath = scanner.nextLine();

            // Read the array from the file at the specified path
            array = Array.readArray(filePath);
        }

        // Display the array
        Sorting.displayArray(array);

        // Print a separator
        System.out.println("-".repeat(20));

        // Return the array
        return array;
    }


    private static int[] getSortedArray(Scanner scanner) {
        // Initialize an array
        int[] array = null;

        // Prompt the user to enter a sorted array
        System.out.println("Enter a sorted array: ");

        // Display the options to the user
        displayOptions();

        // Prompt the user to enter their option
        System.out.print("Enter your option: ");

        // Get the user's option
        int option = scanner.nextInt();

        // If the user's option is 1
        if(option == 1) {
            // Prompt the user to enter the array size
            System.out.print("Enter the array size: ");

            // Get the array size from the user
            int size = scanner.nextInt();

            // Move the scanner to the next line
            scanner.nextLine();

            // Generate a sorted array of the specified size
            array = Array.generateSortedArray(size);
        } else if (option == 2) {
            // Prompt the user to enter the file path
            System.out.print("Enter the file path: ");

            // Move the scanner to the next line
            scanner.nextLine();

            // Get the file path from the user
            String filePath = scanner.nextLine();

            // Read the array from the file at the specified path
            array = Array.readArray(filePath);
        }

        // Display the array
        Sorting.displayArray(array);

        // Print a separator
        System.out.println("-".repeat(20));

        // Return the array
        return array;
    }


    private static int[] getReverselySortedArray(Scanner scanner) {
        // Initialize an array
        int[] array = null;

        // Prompt the user to enter a reversely sorted array
        System.out.println("Enter a reversely sorted array: ");

        // Display the options to the user
        displayOptions();

        // Prompt the user to enter their option
        System.out.print("Enter your option: ");

        // Get the user's option
        int option = scanner.nextInt();

        // If the user's option is 1
        if(option == 1) {
            // Prompt the user to enter the array size
            System.out.print("Enter the array size: ");

            // Get the array size from the user
            int size = scanner.nextInt();

            // Move the scanner to the next line
            scanner.nextLine();

            // Generate a reversely sorted array of the specified size
            array = Array.generateReverselySortedArray(size);
        } else if (option == 2) {
            // Prompt the user to enter the file path
            System.out.print("Enter the file path: ");

            // Move the scanner to the next line
            scanner.nextLine();

            // Get the file path from the user
            String filePath = scanner.nextLine();

            // Read the array from the file at the specified path
            array = Array.readArray(filePath);
        }

        // Display the array
        Sorting.displayArray(array);

        // Print a separator
        System.out.println("-".repeat(20));

        // Return the array
        return array;
    }


    // This is a private static method named 'displayOptions'
    private static void displayOptions() {
        // The method prints out a menu with two options to the console
        System.out.println("""
            1.generate automatically  // Option 1: The program will generate something automatically
            2.enter a file path       // Option 2: The user will provide a file path
            """
        );
    }

}
