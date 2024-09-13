package Problems;

//Print the given matrix in spiral form
public class Problem2 {

    static void spiralPrint(int[][] arr , int r , int c) {
        int i , k = 0  , l=0 ;
        while (k<r && l<c) {
            for(i=l ; i<c ;i++){
             System.out.println(arr[k][i]);
            }
            k++ ;
            for(i=k ; i<r ; i++){
                System.out.println(arr[i][c-1]);
            }
            c-- ;
            if (k<r) {
                for(i=c-1 ; i>=l ; i--){
                    System.out.println(arr[r-1][i]);
                }
                r-- ;
            }
            if (l<c) {
                for(i=r-1 ; i>=k ; i--){
                    System.out.println(arr[i][l]);
                }
                l++ ;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 52 } };
        spiralPrint(arr , arr.length, arr[0].length) ;
    }
}
