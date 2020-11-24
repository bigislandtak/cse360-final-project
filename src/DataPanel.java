import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

public class DataPanel extends JPanel implements Observer {
	JTable jt;
	JScrollPane sp;
	
	public DataPanel() {
		jt = new JTable();
		sp = new JScrollPane(jt);
		add(sp);
	}

	/**
	* This method is called whenever the Roster is changed.
	* It updates the JTable to match the current Roster data.
	*
	* @param  o   the observable object
	* @param  arg an argument passed to the notifyObservers method
	* @return None
	*/
	@Override
	public void update(Observable o, Object arg) {
		DefaultTableModel updatedModel = new DefaultTableModel(((Roster)o).getTable(), ((Roster)o).getColumnNames());
		jt.setModel(updatedModel);
	}
}