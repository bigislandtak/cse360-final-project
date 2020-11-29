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
	 * This method will prompt the user for a date, using a date picker and return that value
	 *
	 *
	 * @return the date the user selected
	 */
	private String getDate() {
		StringBuilder date = new StringBuilder();
		String day, month, finalDate;
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December"};
		String[] days = new String[31];
		for (int i = 0; i < 31; i++) {
			int temp = i + 1;
			days[i] = Integer.toString(temp);
		}
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		month = (String)JOptionPane.showInputDialog(frame, "Select the month for this attendance sheet:",
				"Month Input", JOptionPane.PLAIN_MESSAGE, null, months, "January");
		day = (String)JOptionPane.showInputDialog(frame, "Select the day for this attendance sheet:", "Day Input",
				JOptionPane.PLAIN_MESSAGE, null, days, "1");
		date.append(month);
		date.append(" ");
		date.append(day);
		finalDate = date.toString();
		return finalDate;
	}

	/**
	 * This method adds attendance data read from user selected file to
	 * current roster table
	 *
	 * @param  None
	 * @return None
	 */
	public void addAttendance() {
		String name1, name2, date;
		StringBuilder details;
		int count = 0;
		ArrayList<String> unusedNames = new ArrayList<String>();
		ArrayList<String> unusedTimes = new ArrayList<String>();
		ArrayList<ArrayList<String>> attendance = readCSV();

		// STEP 0: Ask for a date using Date Picker.
		date = getDate();

		// STEP 1: Combine duplicate rows
		for (int i = 0; i < attendance.size(); i++) {
			name1 = attendance.get(i).get(0);
			for (int j = 0; j < attendance.size(); j++) {
				if ((attendance.get(j).contains(name1)) && (j != i)) {
					int temp = Integer.parseInt(attendance.get(i).get(1)) + Integer.parseInt(attendance.get(j).get(1));
					String newby = Integer.toString(temp);
					attendance.get(i).set(1,newby);
					attendance.remove(j);
				}
			}
		}

		// STEP 2: Merge attendance with roster
		// initialize the new column first
		for (int i = 0; i < table.size(); i++) {
			table.get(i).add(null);
		}

		// add a row onto the labels array list using the date the user picked
		columnNames.add(date);

		for(int i = 0; i < attendance.size(); i++) {
			boolean flag = false;
			name1 = attendance.get(i).get(0);
			name2 = attendance.get(i).get(1); // this is attendance time
			for (int j = 0; j < table.size(); j++) {
				if (table.get(j).contains(name1)) {
					table.get(j).set(table.get(0).size()-1, name2);
					count++;
					flag = true;
				}
			}
			if(!flag) {
				unusedNames.add(name1);
				unusedTimes.add(attendance.get(i).get(1));
			}
		}

		// STEP 3: Display JDialog message
		JFrame popup = new JFrame();
		popup.setSize(250,250);

		if (unusedNames.size() > 0) {
			details = new StringBuilder();
			for(int i = 0; i < unusedNames.size(); i++) {
				details.append(unusedNames.get(i));
				details.append(", connected for ");
				details.append(unusedTimes.get(i));
				details.append(" minute(s).\n");
			}
			JOptionPane.showMessageDialog(popup,"Data loaded for " + count + " user(s) in the roster.\n" +
					unusedNames.size() + " additional attendee(s) found:\n" + details);
		}
		else {
			JOptionPane.showMessageDialog(popup,"Data loaded for " + count + " user(s) in the roster.\n");
		}

		setChanged();
		notifyObservers();
	}

	public void save() {
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File(".csv"));
		File file = null;
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
	        file = fc.getSelectedFile();
	        try {
	        	PrintWriter pw = new PrintWriter(file);
	        	pw.println(String.join(",", columnNames));	// print header to csv
	        	for (int i = 0; i < table.size(); i++) {
	        		pw.println(String.join(",", table.get(i)));
	        	}
	        	pw.flush();
	        	pw.close();
	        } catch (IOException ioe) {
	        	ioe.printStackTrace();
	        }
	    } 
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