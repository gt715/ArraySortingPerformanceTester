import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Choose what kind of sorting you want
                    1.Count sorting :
                    2.Bubble Sorting :
                    3.Quick Sorting :
                    0.Exit :
                    """
            );
            System.out.print("Enter your option: ");
            int option = input.nextInt();
            switch (option) {
                case 1 -> Test.testCountSort();
                case 2 -> Test.testBubbleSort();
                case 3 -> Test.testQuickSort();
                default -> System.exit(0);
            }



        }


    }



}