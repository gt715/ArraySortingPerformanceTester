import java.util.Arrays;

public class Sorting {

    private static int comparisonsForQuickSort;
    private static int interchangesForQuickSort;


    private static void swap(int[] array, int firstIndex, int secondIndex) {
        // Store the value at the first index in a temporary variable
        int temp = array[firstIndex];

        // Assign the value at the second index to the first index
        array[firstIndex] = array[secondIndex];

        // Assign the value stored in the temporary variable to the second index
        array[secondIndex] = temp;
    }


    public static void bubbleSort(int[] arr) {
        // Get the length of the array
        int n = arr.length,
                // Initialize counters for the number of interchanges and comparisons
                interchanges = 0,
                comparisons = 0;

        // Print a message indicating the start of the simulation
        System.out.println("simulation for array: ");

        // Outer loop: iterate over each element in the array
        for (int i = 0; i < n - 1; i++) {
            // Initialize a flag to check if any elements were swapped in this pass
            boolean swapped = false;

            // Inner loop: iterate over each pair of elements in the unsorted part of the array
            for (int j = 0; j < n - i - 1; j++) {
                // Increment the comparisons counter
                comparisons++;

                // If the current element is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap the current element and the next element
                    swap(arr, j, ++j);

                    // Increment the interchanges counter
                    interchanges++;

                    // Set the swapped flag to true
                    swapped = true;
                }

                // Display the current state of the array
                displayArray(arr);
            }

            // If no elements were swapped in this pass, the array is already sorted
            if (!swapped)
                break;
        }
        System.out.println("=".repeat(30));
        System.out.print("Sorted ");
        displayArray(arr);
        System.out.println(">> Number of interchanges in this array = " + interchanges);
        System.out.println(">> Number of comparisons in this array = " + comparisons);
    }


    public static void countSort(int[] arr) {
        // Get the length of the array
        int n = arr.length,
                // Initialize counters for the number of interchanges and comparisons
                interchanges = 0,
                comparisons = 0;

        // Get the count array for the input array
        int[] countArray = getCountArray(arr);

        // Accumulate the counts
        for (int i = 1; i < countArray.length; ++i)
            countArray[i] += countArray[i - 1];

        // Print a message indicating the start of the simulation
        System.out.println("simulation for array: ");

        // Generate the output array based on the count array
        int[] outputArray = generateOutputArray(arr, countArray);

        // Copy the sorted elements from the output array back to the original array
        System.arraycopy(outputArray, 0, arr, 0, n);

        // Print the sorted array
        System.out.print("Sorted ");
        displayArray(arr);

        // Print the number of interchanges and comparisons
        System.out.println(">> Number of interchanges in this array = " + interchanges);
        System.out.println(">> Number of comparisons in this array = " + comparisons);
    }


    private static int[] generateOutputArray(int[] arr, int[] countArray) {
        // Get the length of the input array
        int n = arr.length;

        // Initialize the output array with the same length as the input array
        int[] outputArray = new int[n];

        // Display the initial state of the output array
        displayArray(outputArray);

        // Display the count array
        System.out.print("count ");
        displayArray(countArray);

        // Iterate over the input array from end to start
        for (int i = n - 1; i >= 0; i--) {
            // Place each element in the input array to its correct position in the output array
            // The correct position is determined by the count array
            outputArray[countArray[arr[i]] - 1] = arr[i];

            // Decrement the count for the current element
            countArray[arr[i]]--;

            // Display the current state of the output array
            displayArray(outputArray);

            // Display the current state of the count array
            System.out.print("count ");
            displayArray(countArray);
        }

        // Return the sorted output array
        return outputArray;
    }


    private static int[] getCountArray(int[] array) {
        // Find the maximum value in the input array
        int max = findMax(array);

        // Initialize the count array with a size of max + 1
        int[] count = new int[max + 1];

        // Iterate over each number in the input array
        for (int number : array)
            // Increment the count for each number
            count[number]++;

        // Return the count array
        return count;
    }


    private static int findMax(int[] arr) {
        // Get the length of the array
        int n = arr.length;

        // Initialize the maximum value to the first element in the array
        int max = arr[0];

        // Iterate over the rest of the array
        for (int i = 1; i < n; i++)
            // Update the maximum value if the current element is greater
            max = Math.max(max, arr[i]);

        // Return the maximum value
        return max;
    }


    public static void quickSort(int[] array) {
        // Call the recursive QuickSort function on the entire array
        quickSort(array, 0, array.length - 1);

        // Print a message indicating the sorted array
        System.out.print("Sorted ");
        displayArray(array);

        // Print the number of interchanges and comparisons made during the sort
        System.out.println(">> Number of interchanges in this array = " + interchangesForQuickSort);
        System.out.println(">> Number of comparisons in this array = " + comparisonsForQuickSort);
    }


    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        // Check if the lower index is less than the higher index
        if (lowIndex < highIndex) {
            // Print a message indicating the current subarray being sorted
            System.out.print("> simulation for subArray: ");
            displayArray(Arrays.copyOfRange(array, lowIndex, highIndex + 1));

            // Partition the array and get the pivot index
            int pivotIndex = partition(array, lowIndex, highIndex);

            // Recursively sort the elements to the left of the pivot
            quickSort(array, lowIndex, pivotIndex - 1);

            // Recursively sort the elements to the right of the pivot
            quickSort(array, pivotIndex + 1, highIndex);
        }
    }


    private static int partition(int[] array, int lowIndex, int highIndex) {
        // Display the current subarray being partitioned
        displayArray(Arrays.copyOfRange(array, lowIndex, highIndex + 1));

        // Choose the pivot to be the element at the high index
        int pivot = array[highIndex],
                // Initialize the index of the smaller element
                i = lowIndex - 1;

        // Iterate over the elements in the subarray
        for (int j = lowIndex; j < highIndex; j++) {
            // If the current element is less than the pivot
            if (array[j] < pivot) {
                // Increment the index of the smaller element
                i++;

                // Swap the current element with the element at the index of the smaller element
                swap(array, i, j);

                // Increment the interchanges counter
                interchangesForQuickSort++;
            }

            // Display the current state of the subarray
            displayArray(Arrays.copyOfRange(array, lowIndex, highIndex + 1));

            // Increment the comparisons counter
            comparisonsForQuickSort++;
        }

        // Swap the pivot with the element at the index of the smaller element plus one
        swap(array, i + 1, highIndex);

        // Display the current state of the subarray
        displayArray(Arrays.copyOfRange(array, lowIndex, highIndex + 1));

        // Increment the interchanges counter
        interchangesForQuickSort++;

        // Return the index of the smaller element plus one
        return i + 1;
    }


    public static void displayArray(int[] arr) {
        // Print the opening brace of the array
        System.out.print("Array is : {");

        // Iterate over each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Print the current element
            System.out.print(arr[i]);

            // If this is not the last element, print a comma and a space
            if (i < arr.length - 1)
                System.out.print(", ");
        }

        // Print the closing
    }
}