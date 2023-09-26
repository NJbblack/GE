package NewProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseEvent extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
    	new WinList();
    }
}
