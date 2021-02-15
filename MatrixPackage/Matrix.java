package MatrixPackage;

import ExeptionPackage.*;

public class Matrix{
    protected int row;
    protected int col;
    protected int[][] matrix;

    public Matrix(int rows, int columns){
        if (rows < 1 || columns < 1) {
            throw new MatrixSizeExeption("MatrixSizeExeption: Invalid Index!");
        }
        row = rows;
        col = columns;
        this.matrix  = new int[row][col];
    }
    final public void setElement(int rows, int columns, int value)
    {
        if(row <= rows || col <= columns || rows < 0 || columns < 0) {
            throw new MatrixSizeExeption("MatrixSizeExeption: No such index available");
        }
        matrix[rows][columns] = value;
    }
    final public int getElement(int rows, int columns)
    {
        if(row <= rows || col <= columns || rows < 0 || columns < 0) {
            throw new MatrixSizeExeption("MatrixSizeExeption: No such index available");
        }
        return matrix[rows][columns];
    }
    public Matrix sum(Matrix OtherMatrix)
    {
        if (this.row != OtherMatrix.row || this.col != OtherMatrix.col) {
            throw new MatrixSizeExeption("MatrixSizeExeption: Different sizes of matrices!");
        }
        int ThisMatrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ThisMatrix[i][j] = this.matrix[i][j] + OtherMatrix.matrix[i][j];
            }
        }
        Matrix OutMatrix = new Matrix(row, col);
        OutMatrix.matrix = ThisMatrix;
        return OutMatrix;
    }
    public Matrix multiply(Matrix OtherMatrix)
    {
        if (this.col != OtherMatrix.row) {
            throw new MatrixSizeExeption("MatrixSizeExeption: Multiplication for these matrices is not allowed!");
        }
        int length = this.col;
        int ThisMatrix[][] = new int[this.row][OtherMatrix.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < OtherMatrix.col; j++) {
                for (int k = 0; k < length; k++) {
                    ThisMatrix[i][j] += this.matrix[i][k] * OtherMatrix.matrix[k][j];
                }
            }
        }
        Matrix OutMatrix = new Matrix(this.row, OtherMatrix.col);
        OutMatrix.matrix = ThisMatrix;
        return OutMatrix;
    }
    public boolean equals (Matrix OtherMatrix)
    {
        if (!(this.row == OtherMatrix.row && this.col == OtherMatrix.col)){
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (this.matrix[i][j] != OtherMatrix.matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public String toString()
    {
        String out = new String();
        for (int i = 0; i < row; i++)
        {
            out += "[";
            for (int j = 0; j < col; j++)
            {
                out += (" " + matrix[i][j] + " ");
            }
            out += "]\n";
        }
        return out;
    }
}