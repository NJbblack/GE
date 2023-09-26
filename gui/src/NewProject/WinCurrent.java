package NewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class WinCurrent extends JFrame{

	public WinCurrent(int empNo, int empCd, String name, String nation) {
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpCurrent> arr = new ArrayList<EmpCurrent>();
		arr = dao.readSelectedCurrent(empNo);
		
		

		JPanel infoPanel = new JPanel(new GridLayout(2,1,1,1));

		JLabel label = new JLabel("GE現状確認");
		label.setBorder(BorderFactory.createEmptyBorder(0 , 10, 0 , 0));
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.RED);
		label.setOpaque(true);
		infoPanel.add(label);

		JLabel info = new JLabel("番号："+ empNo + "   展開エンジニアCD：" + empCd + "   氏名：" + name + "   国籍：" + nation);
		info.setBackground(Color.WHITE);
		info.setOpaque(true);
		infoPanel.add(info);
		
		
		
		JPanel checkPanel = new JPanel(new GridLayout(3,1,1,1));
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("1.在留資格認定証明書交付申請書");
		label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		label1.setForeground(Color.RED);
		//修正箇所
		JCheckBox check11 = new JCheckBox("作成依頼済み",(arr.get(0).getCoeFormRequest()==1));
		JCheckBox check12 = new JCheckBox("申請書作成待ち",(arr.get(0).getCoeFormReceive()==1));
		JCheckBox check13 = new JCheckBox("その他書類待ち",(arr.get(0).getCoeRefReceive()==1));
		JCheckBox check14 = new JCheckBox("原本送付待ち",(arr.get(0).getCoeOriginReceive()==1));
		JCheckBox check15 = new JCheckBox("キャル作成待ち",(arr.get(0).getCoeApplication()==1));
		JCheckBox check16 = new JCheckBox("出せる",(arr.get(0).getCoeReceive()==1));
		JCheckBox check17 = new JCheckBox("提出済み",(arr.get(0).getVisaRequest()==1));
		JCheckBox check18 = new JCheckBox("本人へ送付済み",(arr.get(0).getVisaApplication()==1));
		JCheckBox check19 = new JCheckBox("完了",(arr.get(0).getVisaReceive()==1));
		
		MyDatePicker datePicker11 = new MyDatePicker();
		if(arr.get(0).getCalendercoeFormRequest() != null) datePicker11.setDate(arr.get(0).getCalendercoeFormRequest());
		MyDatePicker datePicker12 = new MyDatePicker();
		if(arr.get(0).getCalendercoeFormReceive() != null) datePicker12.setDate(arr.get(0).getCalendercoeFormReceive());

		JTextField note13 = new JTextField();
		note13.setText(arr.get(0).getNote13());
		note13.setBorder(BorderFactory.createEmptyBorder(0 , 0, 0 , 0));
		
		MyDatePicker datePicker14 = new MyDatePicker();
		if(arr.get(0).getCalendercoeOriginReceive() != null) datePicker14.setDate(arr.get(0).getCalendercoeOriginReceive());
		MyDatePicker datePicker15 = new MyDatePicker();
		if(arr.get(0).getCalendercoeApplication() != null) datePicker15.setDate(arr.get(0).getCalendercoeApplication());
		MyDatePicker datePicker16 = new MyDatePicker();
		if(arr.get(0).getCalendercoeReceive() != null) datePicker16.setDate(arr.get(0).getCalendercoeReceive());
		
		MyDatePicker datePicker17 = new MyDatePicker();
		if(arr.get(0).getCalender() != null) datePicker17.setDate(arr.get(0).getCalender());
		
		
		
		MyDatePicker datePicker18 = new MyDatePicker();
		if(arr.get(0).getCalendervisaApplication() != null) datePicker18.setDate(arr.get(0).getCalendervisaApplication());
		MyDatePicker datePicker19 = new MyDatePicker();
		if(arr.get(0).getCalendervisaReceive() != null) datePicker19.setDate(arr.get(0).getCalendervisaReceive());
		
		panel1.setLayout(new GridLayout(10,2,1,1));
		panel1.add(label1);
		panel1.add(new JLabel(""));
		panel1.add(check11);
		panel1.add(datePicker11.datePicker);
		panel1.add(check12);
		panel1.add(datePicker12.datePicker);
		panel1.add(check13);
		panel1.add(note13);
		panel1.add(check14);
		panel1.add(datePicker14.datePicker);
		panel1.add(check15);
		panel1.add(datePicker15.datePicker);
		panel1.add(check16);
		panel1.add(datePicker16.datePicker);
		panel1.add(check17);
		panel1.add(datePicker17.datePicker);
		panel1.add(check18);
		panel1.add(datePicker18.datePicker);
		panel1.add(check19);
		panel1.add(datePicker19.datePicker);
		checkPanel.add(panel1, BorderLayout.NORTH);
		

		
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("2.スキルシート");
		label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		label2.setForeground(Color.RED);
		JCheckBox check21 = new JCheckBox("案内済",(arr.get(0).getIdPhoto()==1));
		JCheckBox check22 = new JCheckBox("添削中",(arr.get(0).getSheetGuide()==1));
		JCheckBox check23 = new JCheckBox("本人へ修正依頼中",(arr.get(0).getSheetCorrect()==1));
		JCheckBox check24 = new JCheckBox("村垣さん添削中",(arr.get(0).getSheetCorrectRequest()==1));
		JCheckBox check25 = new JCheckBox("催促中",(arr.get(0).getSheetCorrectM()==1));
		JCheckBox check26 = new JCheckBox("完成後本人へ送付済",(arr.get(0).getSheetUrge()==1));
		JCheckBox check27 = new JCheckBox("不要（内勤）",(arr.get(0).getSheetFinish()==1));
		JCheckBox check28 = new JCheckBox("",(arr.get(0).getSheetNotRequire()==1));
		JTextField note28 = new JTextField(15);
		note28.setText(arr.get(0).getNote28());
		note28.setBorder(BorderFactory.createEmptyBorder(0 , 0, 0 , 0));
		
		panel2.setLayout(new GridLayout(10,1,1,1));
		panel2.add(label2);
		panel2.add(check21);
		panel2.add(check22);
		panel2.add(check23);
		panel2.add(check24);
		panel2.add(check25);
		panel2.add(check26);
		panel2.add(check27);
		panel2.add(new JLabel("備考："));
		panel2.add(note28);
		checkPanel.add(panel2, BorderLayout.CENTER);

		
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(9,1,1,1));
		
		JLabel label3 = new JLabel("3.展開");
		label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		label3.setForeground(Color.RED);
		JCheckBox check31 = new JCheckBox("業打ち研修",(arr.get(0).getEmsGuide()==1));
		JCheckBox check32 = new JCheckBox("入国前面談",(arr.get(0).getEmsSend()==1));
		JCheckBox check33 = new JCheckBox("展開メール作成",(arr.get(0).getEmsSend()==1));
		JCheckBox check34 = new JCheckBox("展開済",(arr.get(0).getEmsSend()==1));
		panel3.add(label3);
		panel3.add(check31);
		panel3.add(check32);
		panel3.add(check33);
		panel3.add(check34);
		
		JLabel label4 = new JLabel("4.赴任案内");
		label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		label4.setForeground(Color.RED);

		JCheckBox check41 = new JCheckBox("荷物送付先、航空券手配",(arr.get(0).getFlightGuide()==1));
		JCheckBox check42 = new JCheckBox("航空券手配確認",(arr.get(0).getFlightArrange()==1));
		JCheckBox check43 = new JCheckBox("前日案内",(arr.get(0).getFlightArrange()==1));


		panel3.add(label4);
		panel3.add(check41);
		panel3.add(check42);		panel3.add(check43);

		checkPanel.add(panel3, BorderLayout.SOUTH);

		
		
		
		
		
		JPanel btnPanel = new JPanel(new BorderLayout());
		JButton btnOK = new JButton("保存");
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 EmpCurrent empCurrent = new EmpCurrent(
						 empNo,
						 bToI(check11.isSelected()), bToI(check12.isSelected()),bToI(check13.isSelected()),bToI(check14.isSelected()),
						 bToI(check15.isSelected()),bToI(check16.isSelected()),bToI(check17.isSelected()),bToI(check18.isSelected()),
						 bToI(check19.isSelected()),bToI(check21.isSelected()),bToI(check22.isSelected()),bToI(check23.isSelected()),
						 bToI(check24.isSelected()),bToI(check25.isSelected()),bToI(check26.isSelected()),bToI(check27.isSelected()),
						 bToI(check28.isSelected()),bToI(check31.isSelected()),bToI(check32.isSelected()),bToI(check41.isSelected()),
						 bToI(check42.isSelected()),
						 (String)datePicker11.getSelectedDate(check11.isSelected()),(String)datePicker12.getSelectedDate(check12.isSelected()),
						 note13.getText(),(String)datePicker14.getSelectedDate(check14.isSelected()),
						 (String)datePicker15.getSelectedDate(check15.isSelected()),(String)datePicker16.getSelectedDate(check16.isSelected()),
						 (String)datePicker18.getSelectedDate(check18.isSelected()),(String)datePicker19.getSelectedDate(check19.isSelected()),
						 note28.getText(),(String)datePicker17.getSelectedDate(check17.isSelected()));
					
				dao.updateCurrent(empCurrent);
				setVisible(false);
				new WinList();
			}
		});
		btnPanel.add(btnOK, BorderLayout.NORTH);
		
		
		
		JButton btnNG = new JButton("キャンセル");
		btnNG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new WinList();
			}
		});
		btnPanel.add(btnNG, BorderLayout.SOUTH);
		
		
		
		this.setTitle("GE入国管理");
		this.addWindowListener(new CloseEvent());
		this.addWindowListener(new CloseEvent());
		this.setLayout(new BorderLayout());
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(checkPanel, BorderLayout.CENTER);
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
