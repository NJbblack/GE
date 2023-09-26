package NewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WinRegistration extends JFrame {

	public WinRegistration() {
		EmpDAO dao = EmpDAO.getInstance();
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel("グローバルエンジニア新規登録");
		label.setBorder(BorderFactory.createEmptyBorder(0 , 10, 0 , 0));
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		label.setForeground(Color.BLACK);
		label.setBackground(Color.YELLOW);
		label.setOpaque(true);
		panel.add(label, BorderLayout.NORTH);
		
		
		
		JPanel registrationPanel = new JPanel();
		registrationPanel.setLayout(new GridLayout(20,1,1,1));
		registrationPanel.setBorder(BorderFactory.createEmptyBorder(0 , 5, 0 , 0));
		
		JLabel labelName = new JLabel("氏名");
		JTextField textName = new JTextField(25);
		JLabel labelNation = new JLabel("国籍");
		JTextField textNation = new JTextField(25);
		JLabel labelBirth = new JLabel("生年月日");
		JTextField textBirth = new JTextField(25);
		JLabel labelGender = new JLabel("性別");
		JTextField textGender = new JTextField(25);
		
		registrationPanel.add(labelName);
		registrationPanel.add(textName);
		registrationPanel.add(labelNation);
		registrationPanel.add(textNation);
		registrationPanel.add(labelBirth);
		registrationPanel.add(textBirth);
		registrationPanel.add(labelGender);
		registrationPanel.add(textGender);
		
		
		
		
		
		
		JPanel btnPanel = new JPanel();
		JButton buttonRegistration = new JButton("登録");
		buttonRegistration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			dao.insertData(textName.getText(),textNation.getText(),textBirth.getText(),textGender.getText());
			dao.insertCurrentData();
			setVisible(false);
			new WinList();
			}
		});
		btnPanel.add(buttonRegistration, BorderLayout.CENTER);
		
		

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
		this.add(registrationPanel);
		this.add(panel,BorderLayout.NORTH);
		this.add(btnPanel, BorderLayout.SOUTH);
		this.setSize(500,700);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

