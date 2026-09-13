import java.util.Scanner;

class Complex {
    int real;
    int imaginary;

    Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    void add(Complex c) {
        int realPart = real + c.real;
        int imaginaryPart = imaginary + c.imaginary;
        System.out.println("Sum = " + realPart + " + " + imaginaryPart + "i");
    }

    void subtract(Complex c) {
        int realPart = real - c.real;
        int imaginaryPart = imaginary - c.imaginary;
        System.out.println("Difference = " + realPart + " + " + imaginaryPart + "i");
    }

    void multiply(Complex c) {
        int realPart = (real * c.real) - (imaginary * c.imaginary);
        int imaginaryPart = (real * c.imaginary) + (imaginary * c.real);
        System.out.println("Product = " + realPart + " + " + imaginaryPart + "i");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter real part of first complex number: ");
        int real1 = sc.nextInt();

        System.out.print("Enter imaginary part of first complex number: ");
        int imaginary1 = sc.nextInt();

        System.out.print("Enter real part of second complex number: ");
        int real2 = sc.nextInt();

        System.out.print("Enter imaginary part of second complex number: ");
        int imaginary2 = sc.nextInt();

        Complex c1 = new Complex(real1, imaginary1);
        Complex c2 = new Complex(real2, imaginary2);

        c1.add(c2);
        c1.subtract(c2);
        c1.multiply(c2);

        sc.close();
    }
}