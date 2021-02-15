package MatrixPackage;

import ExeptionPackage.*;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int Size){
        super(Size, Size);
        for(int i = 0; i < Size; i++)
        {
            matrix[i][i] = 1;
        }
    }
    public SquareMatrix sum(SquareMatrix OtherMatrix)
    {
        if (!(this.row == OtherMatrix.row || this.col == OtherMatrix.col || this.row == OtherMatrix.col)) {
            throw new MatrixSizeExeption("MatrixSizeExeption: Different sizes of matrices!");
        }
        int ThisMatrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ThisMatrix[i][j] = this.matrix[i][j] + OtherMatrix.matrix[i][j];
            }
        }
        SquareMatrix OutMatrix = new SquareMatrix(row);
        OutMatrix.matrix = ThisMatrix;
        return OutMatrix;
    }
}