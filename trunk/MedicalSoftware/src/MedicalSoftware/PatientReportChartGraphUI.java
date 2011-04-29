package MedicalSoftware;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.data.*;

public class PatientReportChartGraphUI {

	private JFrame frame;
	private Info info;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientReportChartGraphUI window = new PatientReportChartGraphUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientReportChartGraphUI() {
		initialize();
		this.frame.setVisible(true);
	}
	
	public PatientReportChartGraphUI(Info info) {
		initialize();
		this.info = info;
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<TRecords> records = info.getRecord().getRecords();
		XYSeries series = new XYSeries("Average Weight");
		
		for(int i = 0; i<records.size();i++){			
			series.add((double)records.get(i).getDate(), (double)records.get(i).getWeight());
			i++;
		}
		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYAreaChart("Weight", "Date", "Weight", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		ChartFrame frame=new ChartFrame("Weight Chart",chart);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
