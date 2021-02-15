package ExeptionPackage;

public class MatrixSizeExeption extends RuntimeException{
    public MatrixSizeExeption(String message){
        super(message);
    }
    public String getMessage() {
        return super.getMessage();
    }
}