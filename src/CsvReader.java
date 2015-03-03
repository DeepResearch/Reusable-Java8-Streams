import java.io.IOException;

import com.awesomeml.collection.lazy.impl.DoubleMatrix;


public class CsvReader {
	public static void main(String[] args) throws IOException {
		DoubleMatrix matrix = new DoubleMatrix();
		matrix = matrix.loadCSVFile("Sample.csv");
		System.out.println(matrix.getRows());
		System.out.println(matrix.getColumns());
		System.out.println(matrix.getLength());
	}
}
