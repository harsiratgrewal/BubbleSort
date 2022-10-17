import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BubSort {

public static int[] createRandomArray(int arrayLength){
    int[] array = new int[arrayLength];
    Random random = new Random();
    for (int i = 0; i < arrayLength; i++){
        array[i] = random.nextInt(100);
    }
    return array;
}
    public static void writeArrayToFile(int[] array, String outputFile){
        try{
        FileWriter fileWriter = new FileWriter(outputFile);
        for (int a: array){
            fileWriter.write(a + "\n");
        }
        fileWriter.close(); 
        }
        catch (IOException e){
            System.out.println("Encountered an IOException");
            e.printStackTrace();
        }

    }
    public static void printArray(int[] array){
    for (int a : array ){
        System.out.print(a + " ");
    }
    System.out.println();
}
public static void bubbleSort(int[] array){
    for (int i = array.length - 1; i > 0; i--){
        for (int j = 0; j < i; j++){
            if (array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
        printArray(array);
    }
}
public static int[] readArrayFromFile(String inputFile){
    File file = new File(inputFile);
    try{
    Scanner scnr = new Scanner(file);
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (scnr.hasNextLine()){
        String str = scnr.nextLine();
        int a = Integer.parseInt(str);
        arrayList.add(a);
    }
    int[] array = new int[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++){
        array[i] = arrayList.get(i);
    }
    scnr.close();
    return array;
} catch (FileNotFoundException e ){
    System.out.println("No file found with that name, please try again!");
    e.printStackTrace();
}
    return null;
}
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true){
        System.out.println("Do you want to read input from file? [y/n]: ");
        String answer = scanner.next();
        if (!answer.equals("y") && !answer.equals("n")){
            System.out.println("Invalid Input!");
            continue;
        }
        if (answer.equals("y")){
            String inputFile;
            System.out.print("Enter the input file name: ");
            inputFile = scanner.next();
            int[] array = readArrayFromFile(inputFile);
            printArray(array);
            bubbleSort(array);
            System.out.print("Enter the output file name: ");
            String outputFile = scanner.next();
            writeArrayToFile(array, outputFile);
            scanner.close();
            return;
        }
        if (answer.equals("n")){
            System.out.println("Enter the length of random integers to be generated: ");
            int arrayLength = scanner.nextInt();
            int[] array = createRandomArray(arrayLength);
            printArray(array);
            bubbleSort(array);
            System.out.print("Enter the output file name: ");
            String outputFile = scanner.next();
            writeArrayToFile(array, outputFile);
            scanner.close();
            return;
        } 
        }
        
    }
}
