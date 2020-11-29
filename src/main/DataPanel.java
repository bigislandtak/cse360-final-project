import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

public class DataPanel extends JPanel implements Observer {
	JTable jt;
	JScrollPane sp;

	public DataPanel() {
		jt = new JTable();
		sp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
		if (jt.getColumnCount() > 0) {
			jt.getColumnModel().getColumn(0).setPreferredWidth(100);
			jt.getColumnModel().getColumn(3).setPreferredWidth(150);
			jt.getColumnModel().getColumn(4).setPreferredWidth(150);
			jt.getColumnModel().getColumn(5).setPreferredWidth(100);
		}
	}
}