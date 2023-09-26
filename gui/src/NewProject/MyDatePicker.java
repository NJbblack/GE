package NewProject;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class MyDatePicker{
	UtilDateModel model;
	JDatePickerImpl datePicker;
	
	public MyDatePicker() {
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(300,300,400,400);
		datePicker.setVisible(true);
	}

	
	public Object getSelectedDate(boolean checked) {
	if(checked) {
	 return this.model.getYear() + "-" + (this.model.getMonth() + 1) + "-" + this.model.getDay();
	}else {
		return null;
	}
	}
	
	public Object getSelectedMonth(boolean checked) {
	if(checked) {
	 return this.model.getYear() + "-" + (this.model.getMonth() + 1);
	}else {
		return null;
	}
	}
	
	public void setDate(String str) {
		String[] date = str.split("-");
		int dateY = Integer.parseInt(date[0]);
		int dateM = Integer.parseInt(date[1]) - 1;
		int dateD = Integer.parseInt(date[2]);
		
		model.setDate(dateY, dateM, dateD);
		model.setSelected(true);
	}
	
	public void setMonth(String str) {
		String[] date = str.split("-");
		int dateY = Integer.parseInt(date[0]);
		int dateM = Integer.parseInt(date[1]) - 1;
		int dateD = Integer.parseInt(date[2]);
		
		model.setDate(dateY, dateM, dateD);
		model.setSelected(true);
	}
	
}
