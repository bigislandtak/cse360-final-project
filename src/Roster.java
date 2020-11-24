import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Roster extends Observable {
	private ArrayList<ArrayList<String>> table;
	private ArrayList<String> columnNames;

	/**
	* This method asks the user to choose a csv roster file to read from
	* It reads the csv and stores it in a 2D array list
	*
	* @param  None
	* @return 2D array list of strings containing data from csv
	*/
	public ArrayList<ArrayList<String>> readCSV() {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		try {
			JFileChooser fc = new JFileChooser();
    		File file = null;
    		int returnVal = fc.showOpenDialog(null);
    		if (returnVal == JFileChooser.APPROVE_OPTION) {
		        file = fc.getSelectedFile();  
		    } 
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null) {
				ArrayList<String> row = new ArrayList<>();
				for (String s : line.split(",")) {
					row.add(s);
				}
				data.add(row);
			}
			br.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
        }
        return data;
	}

	/**
	* This method initializes table to the return value of readCSV()
	* and columnNames to its default list of names
	*
	* @param  None
	* @return None
	*/
	public void loadRoster() {
		table = readCSV();
        columnNames = new ArrayList<String>(Arrays.asList("ID", "First Name", "Last Name", "Program and Plan", "Academic Level", "ASURITE"));
		setChanged();
		notifyObservers();
	}

	/**
	* This method adds attendance data read from user selected file to
	* current roster table
	*
	* @param  None
	* @return None
	*/
	public void addAttendance() {
		ArrayList<ArrayList<String>> attendance = readCSV();

		// STEP 0: Ask for a date using Date Picker.
        // STEP 1: Combine student attendance times to one
        // STEP 2: Sort attendance rows corresponding to order of appearance in roster
        // STEP 3: Merge attendance with roster

		setChanged();
		notifyObservers();
	}

	public void save() {
		// pass
	}

	public void plotData() {
		// pass
	}

	/**
	* This method returns current table after converting
	* it into 2D array.
	*
	* @param  None
	* @return 2D array of strings representing current roster table
	*/
	public String[][] getTable() {
		String[][] data = new String[table.size()][];
		for (int i = 0; i < table.size(); i++) {
			ArrayList<String> row = table.get(i);
			data[i] = row.toArray(new String[row.size()]);
		}
		return data;
	}

	/**
	* This method returns current header after converting
	* it into an array.
	*
	* @param  None
	* @return array of strings representing current header
	*/
	public String[] getColumnNames() {
		String[] names = columnNames.toArray(new String[columnNames.size()]);
		return names;
	}
}