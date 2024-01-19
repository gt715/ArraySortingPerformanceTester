import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Array {

    // Method to generate an array of random integers
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];  // Initialize an array of the given size
        Random random = new Random();  // Create a Random object
        for(int i = 0; i < size; i++)  // For each index in the array
            array[i] = random.nextInt(size);  // Assign a random integer

        return array;  // Return the array of random integers
    }

    // Method to generate a sorted array of random integers
    public static int[] generateSortedArray(int size) {
        int[] array = generateRandomArray(size);  // Generate an array of random integers
        Arrays.sort(array);  // Sort the array

        return array;  // Return the sorted array
    }

    // Method to generate a reversely sorted array of random integers
    public static int[] generateReverselySortedArray(int size) {
        int[] array = generateRandomArray(size);  // Generate an array of random integers
        Arrays.sort(array);  // Sort the array
        int[] result = new int[size];  // Initialize a new array of the same size
        for(int i = size - 1, j = 0; i >= 0; i--, j++)  // For each index in the array
            result[j] = array[i];  // Assign the value from the original array in reverse order

        return result;  // Return the reversely sorted array
    }

    // Method to read an array from a file
    public static int[] readArray(String filePath) {
        File file = new File(filePath);  // Create a File object with the given file path
        int size = 0;  // Initialize a counter for the size of the array
        int[] array = null;  // Initialize an array
        try (Scanner scanner = new Scanner(file)) {  // Try to create a Scanner object with the file
            while(scanner.hasNext()) {  // While there are more integers in the file
                scanner.nextInt();  // Read the next integer
                size++;  // Increment the size counter
            }
        } catch (FileNotFoundException e) {  // Catch the exception if the file is not found
            throw new RuntimeException(e);  // Throw a new RuntimeException
        }
        try (Scanner scanner = new Scanner(file)) {  // Try to create a Scanner object with the file
            int index = 0;  // Initialize a counter for the index of the array
            array = new int[size];  // Initialize the array with the determined size
            while(scanner.hasNext()) {  // While there are more integers in the file
                array[index++] = scanner.nextInt();  // Assign the next integer to the current index of the array
            }
        } catch (FileNotFoundException e) {  // Catch the exception if the file is not found
            System.out.println("File not found");  // Print an error message
        }
        return array;  // Return the array
    }

}
