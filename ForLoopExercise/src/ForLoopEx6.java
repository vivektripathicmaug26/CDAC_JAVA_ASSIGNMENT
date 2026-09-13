public class ForLoopEx6 {
    public static void main(String[] args) {

        int num = 1;

        for (int iTemp = 1; iTemp <= 4; iTemp++) {
            for (int jTemp = 1; jTemp <= iTemp; jTemp++) {
                System.out.print(num + " ");
                num++;
            }

            System.out.println();
        }
    }
}