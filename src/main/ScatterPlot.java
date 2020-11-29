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
		this.file = file;
	XYDataset dataset = createDataset();
	JFreeChart chart = ChartFactory.createScatterPlot("Attendance Scatter Plot", "Percent  Attendance", "Total Students", dataset);
	XYPlot plot = (XYPlot)chart.getPlot();
	//plot.setBackgroundPaint(new Color(255,228,196));
	ChartPanel panel = new ChartPanel(chart);
	setContentPane(panel);
	}
	public boolean dateTest(String date) {
		boolean ans = false;
		if (date.contains("Jan") || date.contains("Feb") || date.contains("Mar") || date.contains("Apr")|| date.contains("May") || date.contains("Jun") || date.contains("July") || date.contains("Aug") || date.contains("Sep") || date.contains("Oct") || date.contains("Nov") || date.contains("Dec"))
		{
			ans = true;
		}
			return ans;
	}
	public XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Day 1");
		XYSeries series2 = new XYSeries("Day 2");
		XYSeries series3 = new XYSeries("Day 3");
		XYSeries series4 = new XYSeries("Day 4");
		XYSeries series5 = new XYSeries("Day 5");
		XYSeries series6 = new XYSeries("Day 6");
		XYSeries series7 = new XYSeries("Day 7");
		XYSeries series8 = new XYSeries("Day 8");
		XYSeries series9 = new XYSeries("Day 9");
		XYSeries series10 = new XYSeries("Day 10");

		String[] columns = null;
		String[] headerRow = null;
		int rowLength = 0;
		int columnLength = 0;
		int five = 0, ten = 0, fifteen = 0, twenty = 0, twentyFive = 0, thirty = 0, thirtyFive = 0, forty = 0, fortyFive = 0, fifty = 0, fiftyFive = 0, sixty = 0, sixtyFive = 0, seventy = 0, seventyFive = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String header;
			String line;
			header = br.readLine();
			headerRow = header.split(",");
			

			line = br.readLine();
			while ((line = br.readLine()) != null){
				columns = line.split(",");
				rowLength = columns.length;
				columnLength = columns[0].length();
				//System.out.println("Column 7 " + columns[6]);
				for (int i = 6; i<rowLength; i++) {
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
					
					
					five = 0; ten = 0; fifteen = 0; twenty = 0; twentyFive = 0; thirty = 0; thirtyFive = 0; forty = 0; fortyFive = 0; fifty = 0; fiftyFive = 0; sixty = 0; sixtyFive = 0; seventy = 0; seventyFive = 0;
					for (int i = 7; i<rowLength; i++) {
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
					series2.add((100*(0)/75), five);
					series2.add((100*(5)/75), ten);
					series2.add((100*(10)/75), fifteen);
					series2.add((100*(15)/75), twenty);
					series2.add(Math.round(100*(0)/75), five);
					series2.add(Math.round(100*(5)/75), ten);
					series2.add(Math.round(100*(10)/75), fifteen);
					series2.add(Math.round(100*(15)/75), twenty);
					series2.add(Math.round(100*(20)/75), twentyFive);
					series2.add(Math.round(100*(25)/75), thirty);
					series2.add(Math.round(100*(30)/75), thirtyFive);
					series2.add(Math.round(100*(35)/75), forty);
					series2.add(Math.round(100*(40)/75), fortyFive);
					series2.add(Math.round(100*(45)/75), fifty);
					series2.add(Math.round(100*(50)/75), fiftyFive);
					series2.add(Math.round(100*(55)/75), sixty);
					series2.add(Math.round(100*(60)/75), sixtyFive);
					series2.add(Math.round(100*(65)/75), seventy);
					series2.add((100*(70)/75), seventyFive);
					
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
					

			dataset.addSeries(series1);
			dataset.addSeries(series2);
			dataset.addSeries(series3);
			dataset.addSeries(series4);
			dataset.addSeries(series5);
			dataset.addSeries(series6);
			dataset.addSeries(series7);
			dataset.addSeries(series8);
			dataset.addSeries(series9);
			dataset.addSeries(series10);
			br.close();
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return dataset;
		
	}
}

		
	
