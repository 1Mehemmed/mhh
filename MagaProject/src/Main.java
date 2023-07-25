public class Main {

    public static int getTotal(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 6;
        Main myobj = new Main();
        in result = getTotal(num1, num2);
        System.out.println("Sum" + result);
    }

}
