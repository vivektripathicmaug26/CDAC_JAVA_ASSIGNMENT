public class ForLoopEx8 {
    public static void main(String[] args) {

        for (int iTemp = 6; iTemp >= 1; iTemp--) {
            for (int jTemp = 1; jTemp <= iTemp; jTemp++) {
                System.out.print(jTemp + " ");
            }

            System.out.println();
        }
    }
}