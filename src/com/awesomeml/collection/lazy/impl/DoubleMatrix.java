package com.awesomeml.collection.lazy.impl;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import com.awesomeml.collection.lazy.factory.LazyDoubleFactory;
import com.awesomeml.collection.lazy.util.DoubleArrayUtil;


public class DoubleMatrix implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int rows, columns, length;
	private LazyDoubleCollection data;
	private static final Pattern COMMA = Pattern.compile(",");
	
	public DoubleMatrix(){
		
	}
	
	public DoubleMatrix(int newRows, int newColumns, double... newData) {
        rows = newRows;
        columns = newColumns;
        length = rows * columns;

        if (newData != null && newData.length != newRows * newColumns) {
            throw new IllegalArgumentException(
                    "Passed data must match matrix dimensions.");
        }
        data = LazyDoubleFactory.doubleSequence(newData);        
    }
	
	public DoubleMatrix(int len) {
        this(len, 1, new double[len]);
    }
	
	public int getRows(){
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}
	
	public LazyDoubleCollection getData(){
		return data;
	}
	
	public int getLength(){
		return length;
	}
	
	public int index(int rowIndex, int columnIndex) {
	    return rowIndex + rows * columnIndex;
	}
	
	public void putRow(final int index, final DoubleMatrix row){
		DoubleArrayUtil.rcopy(columns, row.data.doubleStream().toArray(), 0, 1, data.doubleStream().toArray(), index(index, 0), rows);
	}
	
	public static DoubleMatrix loadCSVFile(final String filename) throws IOException {
		BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

        List<DoubleMatrix> rows = new LinkedList<DoubleMatrix>();
        String line;
        int columns = -1;
        while ((line = is.readLine()) != null) {
            String[] elements = COMMA.split(line);
            int numElements = elements.length;
            if (elements[0].length() == 0) {
                numElements--;
            }
            if (elements[elements.length - 1].length() == 0) {
                numElements--;
            }

            if (columns == -1) {
                columns = numElements;
            } else {
                if (columns != numElements) {
                    throw new IOException("Number of elements changes in line " + line + ".");
                }
            }

            DoubleMatrix row = new DoubleMatrix(columns);
            for (int c = 0; c < columns; c++) {
                row.put(c, Double.valueOf(elements[c]));
            }
            rows.add(row);
        }
        is.close();

        System.out.println("Done reading file");

        DoubleMatrix result = new DoubleMatrix(rows.size(), columns);
        int r = 0;
        Iterator<DoubleMatrix> ri = rows.iterator();
        while (ri.hasNext()) {
            result.putRow(r, ri.next());
            r++;
        }
        return result;
    
	}

}
