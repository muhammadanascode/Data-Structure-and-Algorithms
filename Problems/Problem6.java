package Problems;

public class Problem6 {

    // M=Max min problem : first number should be larget second should be smallest
    // then third should be second largest
    // and fourth should be second smallest and so on ...

    static void minMax(int[] arr) {

        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int max = arr[maxIdx] + 1;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                maxIdx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max;
        }

    }

    public static void main(String[] args) {

    }
}
