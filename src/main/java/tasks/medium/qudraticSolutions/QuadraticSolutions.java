package tasks.medium.qudraticSolutions;

//How many solutions does ax² + bx + c = 0 have?
public class QuadraticSolutions {

    public static int countSolutions(int a, int b, int c) {
        int discriminator = (b * b) - 4 * a * c;
        if (discriminator < 0) {
            return 0;
        }
        return discriminator == 0
                ? 1
                : 2;
    }

}
