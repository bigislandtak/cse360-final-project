import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame{
	private File file;
	public ScatterPlot(File file) {
		//Passing the file from the save function over to plot the data
		this.file = file;
		
	//Call the function to create the dataset that the data points will be added to
	XYDataset dataset = createDataset();
	
	//Create the Scatter chart from the JFreeChart Library that the data will be plotted on
	JFreeChart chart = ChartFactory.createScatterPlot("Attendance Scatter Plot", "Percent  Attendance", "Total Students", dataset);
	
	//Create a new panel to display the Scatter Chart and set the chart on the new panel
	ChartPanel panel = new ChartPanel(chart);
	setContentPane(panel);
	
	}
	
	//Function that takes the data and sorts through it to calculate the students that attended a certain amount of time
	public XYDataset createDataset() {
		
		//Creating the dataset to plot and the series that will be added to the dataset
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		//Create the series to be added to the dataset
		XYSeries series1 = new XYSeries("Jan 1");
		XYSeries series2 = new XYSeries("Feb 31	");
		XYSeries series3 = new XYSeries("Day 3");
		XYSeries series4 = new XYSeries("Day 4");
		XYSeries series5 = new XYSeries("Day 5");
		XYSeries series6 = new XYSeries("Day 6");
		XYSeries series7 = new XYSeries("Day 7");
		XYSeries series8 = new XYSeries("Day 8");
		XYSeries series9 = new XYSeries("Day 9");
		XYSeries series10 = new XYSeries("Day 10");

		//Create an array of strings to temporarily hold the data separated into columns
		//Create variables to track the column length and row length to know how much data is in the file
		String[] columns = null;
		String[] headerRow = null;
		int rowLength = 0;
		int columnLength = 0;
		
		//These variables are to keep track of the number of students attending a certain amount of time. The total time of each student is grouped in intervals of five and kept track of here
		//so five students attending at least 71 minutes or above for the class are counted in the 100%  attendance category
		int five = 0, ten = 0, fifteen = 0, twenty = 0, twentyFive = 0, thirty = 0, thirtyFive = 0, forty = 0, fortyFive = 0, fifty = 0, fiftyFive = 0, sixty = 0, sixtyFive = 0, seventy = 0, seventyFive = 0;
		int five_ = 0, ten_ = 0, fifteen_ = 0, twenty_ = 0, twentyFive_ = 0, thirty_ = 0, thirtyFive_ = 0, forty_ = 0, fortyFive_ = 0, fifty_ = 0, fiftyFive_ = 0, sixty_ = 0, sixtyFive_ = 0, seventy_ = 0, seventyFive_ = 0;

		try {
			
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String header;
			String line;
			header = br.readLine();
			headerRow = header.split(",");
			
			//Use the Buffered Reader to separate the csv file into columns in the array
			line = br.readLine();
			while ((line = br.readLine()) != null){
				columns = line.split(",");
				rowLength = columns.length;
				columnLength = columns[0].length();
				//System.out.println("Columns.length: " + columns[0].length());
				//System.out.println("RowLength.length: " + columns.length);
			
				
				for (int i = 6; i<rowLength; i++) {
						if(columns[i] != null) {
							
				//Convert the string values to integers and count the number of students in each percentage category
				int convert = Integer.parseInt(columns[i]);
				if (convert >= 71) {
					seventyFive++;
				}else if (convert >=66){
					seventy++;
				}else if (convert >=61) {
					sixtyFive++;
				}else if (convert >=56) {
					sixty++;
				}else if (convert >=51) {
					fiftyFive++;
				}else if (convert >=46) {
					fifty++;
				}else if (convert >=41) {
					fortyFive++;
				}else if (convert >=36) {
					forty++;
				}else if (convert >=31) {
					thirtyFive++;
				}else if (convert >=26){
					thirty++;
				}else if (convert >=21) {
					twentyFive++;
				}else if (convert >=16) {
					twenty++;
				}else if (convert >=11) {
					fifteen++;
				}else if (convert >=5) {
					ten++;
				}else if (convert >0) {
					five++;
				}else {
					System.out.println("Error in Number");
				}
					
				}
				}
			
			
		
					
					//five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
				if (7 <rowLength) {
					for (int i = 7; i<rowLength; i++) {
						if(columns[i] != null) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive_++;
						}else if (convert >=66){
							seventy_++;
						}else if (convert >=61) {
							sixtyFive_++;
						}else if (convert >=56) {
							sixty_++;
						}else if (convert >=51) {
							fiftyFive_++;
						}else if (convert >=46) {
							fifty_++;
						}else if (convert >=41) {
							fortyFive_++;
						}else if (convert >=36) {
							forty_++;
						}else if (convert >=31) {
							thirtyFive_++;
						}else if (convert >=26){
							thirty_++;
						}else if (convert >=21) {
							twentyFive_++;
						}else if (convert >=16) {
							twenty_++;
						}else if (convert >=11) {
							fifteen_++;
						}else if (convert >=5) {
							ten_++;
						}else if (convert >0) {
							five_++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					}
				}
			}
			//Convert the counts into percentages and add the category data points to the scatter plot
			series1.add((100*(0)/75), five);
			series1.add((100*(5)/75), ten);
			series1.add((100*(10)/75), fifteen);
			series1.add((100*(15)/75), twenty);
			series1.add(Math.round(100*(0)/75), five);
			series1.add(Math.round(100*(5)/75), ten);
			series1.add(Math.round(100*(10)/75), fifteen);
			series1.add(Math.round(100*(15)/75), twenty);
			series1.add(Math.round(100*(20)/75), twentyFive);
			series1.add(Math.round(100*(25)/75), thirty);
			series1.add(Math.round(100*(30)/75), thirtyFive);
			series1.add(Math.round(100*(35)/75), forty);
			series1.add(Math.round(100*(40)/75), fortyFive);
			series1.add(Math.round(100*(45)/75), fifty);
			series1.add(Math.round(100*(50)/75), fiftyFive);
			series1.add(Math.round(100*(55)/75), sixty);
			series1.add(Math.round(100*(60)/75), sixtyFive);
			series1.add(Math.round(100*(65)/75), seventy);
			series1.add((100*(70)/75), seventyFive);
			
			series2.add((100*(0)/75), five_);
			series2.add((100*(5)/75), ten_);
			series2.add((100*(10)/75), fifteen_);
			series2.add((100*(15)/75), twenty_);
			series2.add(Math.round(100*(0)/75), five_);
			series2.add(Math.round(100*(5)/75), ten_);
			series2.add(Math.round(100*(10)/75), fifteen_);
			series2.add(Math.round(100*(15)/75), twenty_);
			series2.add(Math.round(100*(20)/75), twentyFive_);
			series2.add(Math.round(100*(25)/75), thirty_);
			series2.add(Math.round(100*(30)/75), thirtyFive_);
			series2.add(Math.round(100*(35)/75), forty_);
			series2.add(Math.round(100*(40)/75), fortyFive_);
			series2.add(Math.round(100*(45)/75), fifty_);
			series2.add(Math.round(100*(50)/75), fiftyFive_);
			series2.add(Math.round(100*(55)/75), sixty_);
			series2.add(Math.round(100*(60)/75), sixtyFive_);
			series2.add(Math.round(100*(65)/75), seventy_);
			series2.add((100*(70)/75), seventyFive_);
			
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 8; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 72) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series3.add((100*(0)/75), five);
					series3.add((100*(5)/75), ten);
					series3.add((100*(10)/75), fifteen);
					series3.add((100*(15)/75), twenty);
					series3.add(Math.round(100*(0)/75), five);
					series3.add(Math.round(100*(5)/75), ten);
					series3.add(Math.round(100*(10)/75), fifteen);
					series3.add(Math.round(100*(15)/75), twenty);
					series3.add(Math.round(100*(20)/75), twentyFive);
					series3.add(Math.round(100*(25)/75), thirty);
					series3.add(Math.round(100*(30)/75), thirtyFive);
					series3.add(Math.round(100*(35)/75), forty);
					series3.add(Math.round(100*(40)/75), fortyFive);
					series3.add(Math.round(100*(45)/75), fifty);
					series3.add(Math.round(100*(50)/75), fiftyFive);
					series3.add(Math.round(100*(55)/75), sixty);
					series3.add(Math.round(100*(60)/75), sixtyFive);
					series3.add(Math.round(100*(65)/75), seventy);
					series3.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 9; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series4.add((100*(0)/75), five);
					series4.add((100*(5)/75), ten);
					series4.add((100*(10)/75), fifteen);
					series4.add((100*(15)/75), twenty);
					series4.add(Math.round(100*(0)/75), five);
					series4.add(Math.round(100*(5)/75), ten);
					series4.add(Math.round(100*(10)/75), fifteen);
					series4.add(Math.round(100*(15)/75), twenty);
					series4.add(Math.round(100*(20)/75), twentyFive);
					series4.add(Math.round(100*(25)/75), thirty);
					series4.add(Math.round(100*(30)/75), thirtyFive);
					series4.add(Math.round(100*(35)/75), forty);
					series4.add(Math.round(100*(40)/75), fortyFive);
					series4.add(Math.round(100*(45)/75), fifty);
					series4.add(Math.round(100*(50)/75), fiftyFive);
					series4.add(Math.round(100*(55)/75), sixty);
					series4.add(Math.round(100*(60)/75), sixtyFive);
					series4.add(Math.round(100*(65)/75), seventy);
					series4.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 10; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series5.add((100*(0)/75), five);
					series5.add((100*(5)/75), ten);
					series5.add((100*(10)/75), fifteen);
					series5.add((100*(15)/75), twenty);
					series5.add(Math.round(100*(0)/75), five);
					series5.add(Math.round(100*(5)/75), ten);
					series5.add(Math.round(100*(10)/75), fifteen);
					series5.add(Math.round(100*(15)/75), twenty);
					series5.add(Math.round(100*(20)/75), twentyFive);
					series5.add(Math.round(100*(25)/75), thirty);
					series5.add(Math.round(100*(30)/75), thirtyFive);
					series5.add(Math.round(100*(35)/75), forty);
					series5.add(Math.round(100*(40)/75), fortyFive);
					series5.add(Math.round(100*(45)/75), fifty);
					series5.add(Math.round(100*(50)/75), fiftyFive);
					series5.add(Math.round(100*(55)/75), sixty);
					series5.add(Math.round(100*(60)/75), sixtyFive);
					series5.add(Math.round(100*(65)/75), seventy);
					series5.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 11; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series6.add((100*(0)/75), five);
					series6.add((100*(5)/75), ten);
					series6.add((100*(10)/75), fifteen);
					series6.add((100*(15)/75), twenty);
					series6.add(Math.round(100*(0)/75), five);
					series6.add(Math.round(100*(5)/75), ten);
					series6.add(Math.round(100*(10)/75), fifteen);
					series6.add(Math.round(100*(15)/75), twenty);
					series6.add(Math.round(100*(20)/75), twentyFive);
					series6.add(Math.round(100*(25)/75), thirty);
					series6.add(Math.round(100*(30)/75), thirtyFive);
					series6.add(Math.round(100*(35)/75), forty);
					series6.add(Math.round(100*(40)/75), fortyFive);
					series6.add(Math.round(100*(45)/75), fifty);
					series6.add(Math.round(100*(50)/75), fiftyFive);
					series6.add(Math.round(100*(55)/75), sixty);
					series6.add(Math.round(100*(60)/75), sixtyFive);
					series6.add(Math.round(100*(65)/75), seventy);
					series6.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 12; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series7.add((100*(0)/75), five);
					series7.add((100*(5)/75), ten);
					series7.add((100*(10)/75), fifteen);
					series7.add((100*(15)/75), twenty);
					series7.add(Math.round(100*(0)/75), five);
					series7.add(Math.round(100*(5)/75), ten);
					series7.add(Math.round(100*(10)/75), fifteen);
					series7.add(Math.round(100*(15)/75), twenty);
					series7.add(Math.round(100*(20)/75), twentyFive);
					series7.add(Math.round(100*(25)/75), thirty);
					series7.add(Math.round(100*(30)/75), thirtyFive);
					series7.add(Math.round(100*(35)/75), forty);
					series7.add(Math.round(100*(40)/75), fortyFive);
					series7.add(Math.round(100*(45)/75), fifty);
					series7.add(Math.round(100*(50)/75), fiftyFive);
					series7.add(Math.round(100*(55)/75), sixty);
					series7.add(Math.round(100*(60)/75), sixtyFive);
					series7.add(Math.round(100*(65)/75), seventy);
					series7.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 13; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series8.add((100*(0)/75), five);
					series8.add((100*(5)/75), ten);
					series8.add((100*(10)/75), fifteen);
					series8.add((100*(15)/75), twenty);
					series8.add(Math.round(100*(0)/75), five);
					series8.add(Math.round(100*(5)/75), ten);
					series8.add(Math.round(100*(10)/75), fifteen);
					series8.add(Math.round(100*(15)/75), twenty);
					series8.add(Math.round(100*(20)/75), twentyFive);
					series8.add(Math.round(100*(25)/75), thirty);
					series8.add(Math.round(100*(30)/75), thirtyFive);
					series8.add(Math.round(100*(35)/75), forty);
					series8.add(Math.round(100*(40)/75), fortyFive);
					series8.add(Math.round(100*(45)/75), fifty);
					series8.add(Math.round(100*(50)/75), fiftyFive);
					series8.add(Math.round(100*(55)/75), sixty);
					series8.add(Math.round(100*(60)/75), sixtyFive);
					series8.add(Math.round(100*(65)/75), seventy);
					series8.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 14; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series9.add((100*(0)/75), five);
					series9.add((100*(5)/75), ten);
					series9.add((100*(10)/75), fifteen);
					series9.add((100*(15)/75), twenty);
					series9.add(Math.round(100*(0)/75), five);
					series9.add(Math.round(100*(5)/75), ten);
					series9.add(Math.round(100*(10)/75), fifteen);
					series9.add(Math.round(100*(15)/75), twenty);
					series9.add(Math.round(100*(20)/75), twentyFive);
					series9.add(Math.round(100*(25)/75), thirty);
					series9.add(Math.round(100*(30)/75), thirtyFive);
					series9.add(Math.round(100*(35)/75), forty);
					series9.add(Math.round(100*(40)/75), fortyFive);
					series9.add(Math.round(100*(45)/75), fifty);
					series9.add(Math.round(100*(50)/75), fiftyFive);
					series9.add(Math.round(100*(55)/75), sixty);
					series9.add(Math.round(100*(60)/75), sixtyFive);
					series9.add(Math.round(100*(65)/75), seventy);
					series9.add((100*(70)/75), seventyFive);
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 15; i<rowLength; i++) {
						int convert = Integer.parseInt(columns[i]);
						if (convert >= 71) {
							seventyFive++;
						}else if (convert >=66){
							seventy++;
						}else if (convert >=61) {
							sixtyFive++;
						}else if (convert >=56) {
							sixty++;
						}else if (convert >=51) {
							fiftyFive++;
						}else if (convert >=46) {
							fifty++;
						}else if (convert >=41) {
							fortyFive++;
						}else if (convert >=36) {
							forty++;
						}else if (convert >=31) {
							thirtyFive++;
						}else if (convert >=26){
							thirty++;
						}else if (convert >=21) {
							twentyFive++;
						}else if (convert >=16) {
							twenty++;
						}else if (convert >=11) {
							fifteen++;
						}else if (convert >=5) {
							ten++;
						}else if (convert >0) {
							five++;
						}else {
							System.out.println("Error in Number");
						}
							
						}
					series10.add((100*(0)/75), five);
					series10.add((100*(5)/75), ten);
					series10.add((100*(10)/75), fifteen);
					series10.add((100*(15)/75), twenty);
					series10.add(Math.round(100*(0)/75), five);
					series10.add(Math.round(100*(5)/75), ten);
					series10.add(Math.round(100*(10)/75), fifteen);
					series10.add(Math.round(100*(15)/75), twenty);
					series10.add(Math.round(100*(20)/75), twentyFive);
					series10.add(Math.round(100*(25)/75), thirty);
					series10.add(Math.round(100*(30)/75), thirtyFive);
					series10.add(Math.round(100*(35)/75), forty);
					series10.add(Math.round(100*(40)/75), fortyFive);
					series10.add(Math.round(100*(45)/75), fifty);
					series10.add(Math.round(100*(50)/75), fiftyFive);
					series10.add(Math.round(100*(55)/75), sixty);
					series10.add(Math.round(100*(60)/75), sixtyFive);
					series10.add(Math.round(100*(65)/75), seventy);
					series10.add((100*(70)/75), seventyFive);
					
			//Add the Series of data points to the data set
			dataset.addSeries(series1);
			dataset.addSeries(series2);
			/*dataset.addSeries(series3);
			dataset.addSeries(series4);
			dataset.addSeries(series5);
			dataset.addSeries(series6);
			dataset.addSeries(series7);
			dataset.addSeries(series8);
			dataset.addSeries(series9);
			dataset.addSeries(series10);*/
			
			//Close the buffered reader to prevent memory leaks
			br.close();
		
			//catch number exceptions in case incorrect value or null value is in the dataset
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return dataset;
		
	}
}

		
	
