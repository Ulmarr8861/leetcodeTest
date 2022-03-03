public class Test {
    public static void main(String[] args) {
        double a1 = 2;
        double b1 = 1;
        double c1 = a1 / b1;
        double sum = c1;
        double tmp = 0;
        for (int i = 0; i < 3; i++) {
            tmp = b1;
            b1 = a1;
            a1 += tmp;
            c1 = a1 / b1;
            sum += c1;
        }
        System.out.println(sum);
    }
}
