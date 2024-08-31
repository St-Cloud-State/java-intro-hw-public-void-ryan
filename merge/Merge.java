package merge;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Merge {
	public static void main(String[] args) throws FileNotFoundException {
		int item1 = 0, item2 = 0;
		String fileName1, fileName2, outFileName;
		File dataFile1, dataFile2, outFile;
		boolean hasNext1 = false, hasNext2 = false;
		// System.out.println("Jframe not created");
		/*
		 * JFrame myframe = new JFrame(); // the lines that creates trouble
		 * myframe.setSize(300, 300);
		 * System.out.println("Jframe created");
		 * JPanel buttonPanel = new JPanel();
		 * Container contentpane = myframe.getContentPane();
		 * contentpane.add(buttonPanel, "North");
		 * buttonPanel.add(new JButton("mybutton"));
		 * myframe.setVisible(true); // goes with line above
		 * myframe.repaint();
		 */
		LinkedList l1 = new LinkedList(); // just a dummy
		l1.add(new Integer(5)); // test
		Integer i1 = (Integer) l1.getFirst();
		System.out.println(i1);
		Scanner keyScanner = new Scanner(System.in);
		System.out.println("Please enter the first file name: ");
		fileName1 = keyScanner.nextLine();
		System.out.println("Please enter the second file name: ");
		fileName2 = keyScanner.nextLine();
		System.out.println("Please enter the output file name: ");
		outFileName = keyScanner.nextLine();
		dataFile1 = new File(fileName1);
		dataFile2 = new File(fileName2);
		outFile = new File(outFileName);
		Scanner fileScanner1 = new Scanner(dataFile1);
		Scanner fileScanner2 = new Scanner(dataFile2);
		PrintWriter printer = new PrintWriter(outFile);
		if (fileScanner1.hasNext()) {
			hasNext1 = true;
			item1 = fileScanner1.nextInt();
		}
		if (fileScanner2.hasNext()) {
			hasNext2 = true;
			item2 = fileScanner2.nextInt();
		}
		while (hasNext1 && hasNext2) {
			if (item1 < item2) {
				printer.print(item1);
				printer.print(' ');
				if (fileScanner1.hasNext()) {
					item1 = fileScanner1.nextInt();
				} else {
					hasNext1 = false;
				}
			} else {
				printer.print(item2);
				printer.print(' ');
				if (fileScanner2.hasNext()) {
					item2 = fileScanner2.nextInt();
				} else {
					hasNext2 = false;
				}
			}
		}
		while (hasNext1) {
			printer.print(item1);
			printer.print(' ');
			if (fileScanner1.hasNext()) {
				item1 = fileScanner1.nextInt();
			} else {
				hasNext1 = false;
			}
		}
		while (hasNext2) {
			printer.print(item2);
			printer.print(' ');
			if (fileScanner2.hasNext()) {
				item2 = fileScanner2.nextInt();
			} else {
				hasNext2 = false;
			}
		}
		printer.close();
		fileScanner1.close();
		fileScanner2.close();
		keyScanner.close();

	}
}
