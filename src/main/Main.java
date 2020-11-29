import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	private Roster roster;

	public Main() {
		setTitle("CSE360 Final Project");

		// Add menu bar to JFrame
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);

		// Add menus to menu bar
		JMenu file = new JMenu("File");
		JMenu about = new JMenu("About");
		jmb.add(file);
		jmb.add(about);

		// Add menu items to "file "menu
		JMenuItem load = new JMenuItem("Load a Roster");
		JMenuItem attendance = new JMenuItem("Add Attendance");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem plot = new JMenuItem("Plot Data");
		load.addActionListener(this);
		attendance.addActionListener(this);
		save.addActionListener(this);
		plot.addActionListener(this);
		file.add(load);
		file.add(attendance);
		file.add(save);
		file.add(plot);

		// Add menu item to "about "menu
		JMenuItem team = new JMenuItem("Team Information");
		team.addActionListener(this);
		about.add(team);

		// Add data panel to JFrame and add make it observe roster
		roster = new Roster();
		DataPanel data = new DataPanel();
		add(data);
		roster.addObserver(data);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("Load a Roster")) {
			roster.loadRoster();
		}
		else if (command.equals("Add Attendance")) {
			roster.addAttendance();
		}
		else if (command.equals("Save")) {
			roster.save();
		}
		else if (command.equals("Plot Data")) {
			roster.plotData();
		}
		else if (command.equals("Team Information")) {
			JDialog about = new JDialog(this, "Team Information");
			JLabel team = new JLabel("Takeyuki Oshima, Kevin Diaz, Bryson Gregory, Jacob L");
			about.add(team);
			about.setVisible(true);
			about.setSize(350,350);
			about.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(500, 500);
		main.setVisible(true);
	}
}