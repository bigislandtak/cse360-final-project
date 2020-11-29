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
	public ScatterPlot() {
	XYDataset dataset = createDataset();
	JFreeChart chart = ChartFactory.createScatterPlot("Attendance Scatter Plot", "Percent  Attendance", "Total Students", dataset);
	XYPlot plot = (XYPlot)chart.getPlot();
	//plot.setBackgroundPaint(new Color(255,228,196));
	ChartPanel panel = new ChartPanel(chart);
	setContentPane(panel);
	}
	
	public XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Nov 3");
		series1.add(1, 75);
		series1.add(2,10);
		
		dataset.addSeries(series1);
		
		XYSeries series2 = new XYSeries("Nov 10");
		series2.add(1,20);
		series2.add(2,40);
		
		dataset.addSeries(series2);
		
		return dataset;
	
	}
}