import java.math.BigDecimal;

public class test {
    public static void main(String[] args) {
       /* BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal);

        Object s = 0.50651;

        Double s1 = (Double) s;
        System.out.println(s1);

        int round = (int) Math.round((Double) s);
//        long round = Math.round((Double) s);
        System.out.println(round);

*/
        int num = 6000;
        int count = 0;
        for (int i = 0; i <= 180; i++) {
            System.out.println();
            count += num;
            num -= 13;
        }
        System.out.println(count);



    }
}
