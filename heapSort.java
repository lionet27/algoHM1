import java.util.Random;
import java.util.Scanner;


public class heapSort {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert size of massiv:");
        int n = scanner.nextInt();
        int[] arr = prepareArray(n);
        printArray(arr);
        scanner.close();
        sort(arr);
        printArray(arr);


    }


    private static void heapify(int[]array, int heapsize,int rootindex){
        int largest=rootindex;
        int leftChild=2*rootindex+1;
        int rightChild=2*rootindex+2;

        if(leftChild<heapsize && array[leftChild]>array[largest])
            largest=leftChild;
        if(rightChild<heapsize&&array[rightChild]>array[largest])
            largest=rightChild;
        if(largest!=rootindex){
            int temp= array[rootindex];
            array[rootindex]=array[largest];
            array[largest]=temp;
            heapify(array, heapsize, largest);
        }
    }

    public static void sort(int[]array){
        for (int i=array.length/2-1;i>=0; i--)
            heapify(array, array.length, i);
        for(int i=array.length-1;i>=0;i--){
            int temp =array[0];
            array[0]=array[i];
            array[i]=temp;
            heapify(array,i,0);
        }
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    /**
     * @apiNote формируем массив из рандомных чисел
     * @param length длинна массива
     * @return массив
     */
    private static final Random random = new Random();
    private static int[] prepareArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    
}
