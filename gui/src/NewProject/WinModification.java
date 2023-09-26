package NewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WinModification extends JFrame {

	public WinModification(int empNo) {
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		arr = dao.readSelectedData(empNo);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("GE詳細修正");
		label.setBorder(BorderFactory.createEmptyBorder(0 , 10, 0 , 0));
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setOpaque(true);
		panel.add(label, BorderLayout.NORTH);
		
		
		

		JPanel modificationPanel = new JPanel();
		JLabel label01 = new JLabel("項目");
		JLabel label02 = new JLabel("入力");
		
		JLabel labelEmpNo = new JLabel("内定者番号");
		JTextField textEmpNo = new JTextField(25);
		textEmpNo.setText(""+arr.get(0).getEmpNo());
		textEmpNo.setEditable(false);
		JLabel labelEmpCd = new JLabel("展開エンジニアCD");
		JTextField textEmpCd = new JTextField(25);
		textEmpCd.setText(""+arr.get(0).getEmpCd());
		JLabel labelName = new JLabel("氏名");
		JTextField textName = new JTextField(25);
		textName.setText(""+arr.get(0).getName());
		JLabel labelNation = new JLabel("国籍");
		JTextField textNation = new JTextField(25);
		textNation.setText(""+arr.get(0).getNation());
		JLabel labelBirth = new JLabel("生年月日");
		JTextField textBirth = new JTextField(25);
		textBirth.setText(""+arr.get(0).getBirth());
		JLabel labelGender = new JLabel("性別");
		JTextField textGender = new JTextField(25);
		textGender.setText(""+arr.get(0).getGender());
		JLabel labelSchool = new JLabel("出身学校");
		JTextField textSchool = new JTextField(25);
		textSchool.setText(""+arr.get(0).getSchool());
		JLabel labelSalary = new JLabel("給料");
		JTextField textSalary = new JTextField(25);
		textSalary.setText(""+arr.get(0).getSalary());
		JLabel labelEmpType = new JLabel("雇用形態");
		JTextField textEmpType = new JTextField(25);
		textEmpType.setText(""+arr.get(0).getEmpType());
		JLabel labelEmpLoc = new JLabel("配属先");
		JTextField textEmpLoc = new JTextField(25);
		textEmpLoc.setText(""+arr.get(0).getEmpLoc());
		JLabel labelNote = new JLabel("備考(IT/機電)");
		JTextField textNote = new JTextField(25);
		textNote.setText(""+arr.get(0).getNote());
		JLabel labelEmail = new JLabel("メールアドレス");
		JTextField textEmail = new JTextField(25);
		textEmail.setText(""+arr.get(0).getEmail());
		JLabel labelAddress = new JLabel("住所");
		JTextField textAddress = new JTextField(25);
		textAddress.setText(""+arr.get(0).getAddress());
		JLabel labelTel = new JLabel("電話番号");
		JTextField textTel = new JTextField(25);
		textTel.setText(""+arr.get(0).getTel());
		JLabel labelMonth = new JLabel("入社予定月");
		
		
		

		JPanel panelEst = new JPanel();
		panelEst.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		String estYear[] = new String[50];
		estYear[0] = "年";
		for(int i=0 ; i<estYear.length-1 ; i++) {
			estYear[i+1] = ""+(2020 + i);
				}
		String estMon[] = new String[12];
		estMon[0] = "月";
		for(int i=0 ; i<estMon.length-1 ; i++) {
			if(i<10) {
				estMon[i+1] = "0"+(1 + i);
			}else {
				estMon[i+1] = ""+(1 + i);
			}
				}
		
		String yearMonth = arr.get(0).getEstYearMonth();
		JComboBox<String> estJoinYear = new JComboBox<String>();
		estJoinYear.setModel(new DefaultComboBoxModel<>(estYear));
		JComboBox<String> estJoinMon = new JComboBox<String>();
		estJoinMon.setModel(new DefaultComboBoxModel<>(estMon));
		if(yearMonth!=null) {
			
			estJoinYear.setSelectedIndex(Integer.parseInt(yearMonth.substring(2, 4))-19);
			estJoinMon.setSelectedIndex(Integer.parseInt(yearMonth.substring(4, 6)));
		} else{
			estJoinYear.setSelectedIndex(0);
			estJoinMon.setSelectedIndex(0);
		}
		panelEst.add(estJoinYear);
		panelEst.add(estJoinMon);
		panelEst.setBorder(BorderFactory.createEmptyBorder(0 , -5, 0 , 0));
	
		
	

		
		
		
		textTel.setText(""+arr.get(0).getTel());
		JLabel labelAvailable = new JLabel("管理必要");
		JCheckBox checkAvailable = new JCheckBox("",(arr.get(0).getAvailable()==1));
		
		modificationPanel.setLayout(new GridLayout(20,1,1,1));
		modificationPanel.add(label01);
		modificationPanel.add(label02);
		modificationPanel.add(labelMonth);
		modificationPanel.add(panelEst);
		modificationPanel.add(labelEmpNo);
		modificationPanel.add(textEmpNo);
		modificationPanel.add(labelEmpCd);
		modificationPanel.add(textEmpCd);
		modificationPanel.add(labelName);
		modificationPanel.add(textName);
		modificationPanel.add(labelNation);
		modificationPanel.add(textNation);
		modificationPanel.add(labelBirth);
		modificationPanel.add(textBirth);
		modificationPanel.add(labelGender);
		modificationPanel.add(textGender);
		modificationPanel.add(labelSchool);
		modificationPanel.add(textSchool);
		modificationPanel.add(labelSalary);
		modificationPanel.add(textSalary);
		modificationPanel.add(labelEmpType);
		modificationPanel.add(textEmpType);
		modificationPanel.add(labelEmpLoc);
		modificationPanel.add(textEmpLoc);
		modificationPanel.add(labelNote);
		modificationPanel.add(textNote);
		modificationPanel.add(labelEmail);
		modificationPanel.add(textEmail);
		modificationPanel.add(labelAddress);
		modificationPanel.add(textAddress);
		modificationPanel.add(labelTel);
		modificationPanel.add(textTel);
		modificationPanel.add(labelAvailable);
		modificationPanel.add(checkAvailable);
		
		modificationPanel.setBorder(BorderFactory.createEmptyBorder(0 , 10, 0 , 0));

		
		
		
		
		
		JPanel btnPanel = new JPanel();
		
		JButton buttonModification = new JButton("修正");
		buttonModification.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String estYearMonth = estJoinYear.getSelectedItem().toString() + estJoinMon.getSelectedItem().toString();
				
			 EmpData empData = new EmpData(
					 Integer.parseInt(textEmpNo.getText()),textName.getText(),textNation.getText(),
					 textBirth.getText(),textGender.getText(),textAddress.getText(),textTel.getText(),
					 textEmail.getText(),Integer.parseInt(textEmpCd.getText()),
					 textSchool.getText(),textEmpType.getText(),textEmpLoc.getText(),textNote.getText(),
					 Integer.parseInt(textSalary.getText()),bToI(checkAvailable.isSelected()), estYearMonth
					 );
				
			dao.updateData(empData);
			setVisible(false);
			new WinList();
				
			}
		});
		btnPanel.add(buttonModification, BorderLayout.CENTER);
		
		
		
		JButton buttonCancel = new JButton("キャンセル");
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new WinList();
			}
		});
		btnPanel.add(buttonCancel, BorderLayout.SOUTH);
		
		
		
		this.setTitle("GE入国管理");
		this.addWindowListener(new CloseEvent());
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.NORTH);
		this.add(modificationPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
		this.setSize(500,700);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	
public int bToI(boolean check){
	if(check) {
		return 1;}
	else{
		return 0;
	}
}	

}

