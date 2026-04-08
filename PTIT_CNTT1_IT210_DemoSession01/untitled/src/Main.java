//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] number1 = new int[]{1,2,3,4,5,2,4};
        int[] number2 = new int[]{2,3,4,2,7};

        int[] number3 = new int[number1.length + number2.length];
        int size3 = 0;
        for (int n : number1){
            if (isExisted(number2, n) && !isExisted(number3, n)){
                number3[size3++] = n;
            }
        }

        for (int i = 0; i < size3; i++) {
            System.out.print(number3[i] + " ");
        }

    }

    public static boolean isExisted(int[] arr, int number){
        for (int n : arr){
            if(n == number){
                return true;
            }
        }
        return false;
    }
}