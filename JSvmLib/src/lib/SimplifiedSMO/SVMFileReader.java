package lib.SimplifiedSMO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SVMFileReader {
	String filename;
	BufferedReader br;
	
	public SVMFileReader(String filename) {
		super();
		File file = new File(filename);
		try {
			file = new File(file.getCanonicalPath());
			//System.out.println();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			 br = new BufferedReader(new InputStreamReader(fis));
			
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	private SVMDataLine getSVMDataLine() {
		String strs[];
		double[] curX = null;
		int y = 0;
		try {
			strs = br.readLine().split(" ");
			curX = new double[10];
			
			if (strs[0].equals("+1")) {
				y = 1;
			} else {
				y = -1;
			}
			for (int i = 1; i < 11; i++) {
				String s[] = strs[i].split(":");
				curX[i - 1] = Double.parseDouble(s[1]);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new SVMDataLine(curX, y);
	}
	
	
	public static void printData(SVMData svmData) {
		int len = svmData.getY().length;
		int y[] = svmData.getY();
		double x[][] = svmData.getX();
		for (int i = 0; i < len; i++) {
			System.out.print((i + 1) + ": " + y[i] + " " );
			for (int j = 0; j < y.length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printDataLen(SVMData svmData) {
		int len = svmData.getY().length;
		int y[] = svmData.getY();
		double x[][] = svmData.getX();
		for (int i = 0; i < len; i++) {
			System.out.print(x[i].length);
		}
		
		
	}
	
	
	public SVMData getSVMData(int lines) {
		double x[][] = new double[lines][];
		int y[] = new int[lines];
		for (int i = 0; i < lines; i++) {
			SVMDataLine svmDataLine = getSVMDataLine();
			x[i] = svmDataLine.x;
			y[i] = svmDataLine.y;
		}
		
		return new SVMData(x, y);
	}
	
	public static void main(String[] args) {
		SVMFileReader reader = new SVMFileReader("D:\\寒假事情\\研究生项目\\研究室\\SVM\\代码\\libsvm-3.0\\heart_scale");
		SVMData svmData = reader.getSVMData(10);
		printData(svmData);
		//printDataLen(svmData);
	}
	
}
