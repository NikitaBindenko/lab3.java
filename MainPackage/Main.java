package MainPackage;

import MatrixPackage.*;
import ExeptionPackage.*;

public class Main {

    public static void main(String[] args) {
        try {
            Matrix M = new Matrix(3, 3);

            M.setElement(0, 1, 1);
            M.setElement(1, 0, 4);
            M.setElement(2, 1, 2);
            M.setElement(2, 2, 3);

            Matrix N = new Matrix(2, 3);

            N.setElement(0, 1, 5);
            N.setElement(1, 2, 3);

            Matrix RES = N.multiply(M);
            System.out.println(RES.toString());
        }
        catch(MatrixSizeExeption Ex){
            System.out.println(Ex.getMessage());
        }
	}
}