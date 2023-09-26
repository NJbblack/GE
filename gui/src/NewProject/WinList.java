package NewProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;


public class WinList extends JFrame {
	JTable table = null;
	int empNo;
	int empCd;
	String name;
	String nation;
	static String yearMonth;
	static String typedText;
	static String selectedOption;
	static String estYearMonth;
	static boolean now = true;
	static boolean optionAll = false;
	
	
	public WinList() {
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpData> arr = new ArrayList<EmpData>();
		
		if(optionAll) {
			if(selectedOption.equals("名前")) {
				arr = dao.searchAllName(typedText);
			} else if(selectedOption.equals("内定者番号")){
				arr = dao.searchAllEmpNo(Integer.parseInt(typedText));
			} else {
				arr = dao.searchAllJoin(typedText);
			}
		}
		else {
		if(typedText!=null && WinList.now) {
			if(selectedOption.equals("名前")) {
				arr = dao.searchName(typedText);
			} else if(selectedOption.equals("内定者番号")){
				arr = dao.searchEmpNo(Integer.parseInt(typedText));
			} else {
				arr = dao.searchJoin(typedText);
			}
		} else if(typedText!=null && !WinList.now) {
			if(selectedOption.equals("名前")) {
				arr = dao.searchNameClosed(typedText);
			} else if(selectedOption.equals("内定者番号")){
				arr = dao.searchEmpNoClosed(Integer.parseInt(typedText));
			} else {
				arr = dao.searchClosedJoin(typedText);
			}
		} else {
			if(WinList.now) {
				arr = dao.readData();			
			} else {
			arr = dao.readClosedData();}
			};
		}
		

		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel panelUpper = new JPanel(new GridLayout(2,1,1,1));
		JLabel label = new JLabel("GEリスト");
		label.setBorder(BorderFactory.createEmptyBorder(0 , 10, 0 , 0));
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLUE);
		label.setOpaque(true);
		panelUpper.add(label);
		panel.add(panelUpper, BorderLayout.NORTH);
		
		JPanel searchPanel = new JPanel();
		JCheckBox checkAll = new JCheckBox("全体");
		searchPanel.add(checkAll);
		
		JTextField searchText = new JTextField(25);
		searchText.setPreferredSize(new Dimension(80,25));
		searchPanel.add(searchText);
		JComboBox<String> searchOption = new JComboBox<String>();
		searchOption.setModel(new DefaultComboBoxModel<>(new String[] { "名前", "内定者番号", "入社予定年月"}));
		searchPanel.add(searchOption);
		

		JButton searchButton = new JButton("検索");
		searchPanel.add(searchButton);
		panelUpper.add(searchPanel);

		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(searchText.getText()!=null) {
					typedText = searchText.getText();
					selectedOption = searchOption.getSelectedItem().toString();
					optionAll = checkAll.isSelected();
					new WinList();
					setVisible(false);
				}

				
			}
		});
		
		
		
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(buttonPanel, BorderLayout.CENTER);
		
		JLabel labelSelected = new JLabel("選択：");
		labelSelected.setPreferredSize(new Dimension(175,20));
		labelSelected.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 11));
		labelSelected.setForeground(Color.BLUE);
		buttonPanel.add(labelSelected);
		
		
		
		JButton buttonRegistration = new JButton("新規登録");
		buttonRegistration.setBackground(Color.yellow);
		buttonRegistration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new WinRegistration();
				setVisible(false);
			}
		}
		);
		buttonPanel.add(buttonRegistration);
		
		
		
		JButton buttonModification = new JButton("修正");
		buttonModification.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(empNo!=0) {
				new WinModification(empNo);
				setVisible(false);
				}else {
				JOptionPane.showMessageDialog(null, "エンジニアを選択してください");
				}
			}
		});
		buttonPanel.add(buttonModification);
		
		
		
		JButton buttonCurrent = new JButton("現状確認");
		buttonCurrent.setBackground(Color.red);
		buttonCurrent.setForeground(Color.white);
		buttonCurrent.setOpaque(true);
		buttonCurrent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(empNo!=0) {
				new WinCurrent(empNo, empCd, name, nation);
				setVisible(false);
				} else {
				JOptionPane.showMessageDialog(null, "エンジニアを選択してください");
				}				
			}
		});
		buttonPanel.add(buttonCurrent);
		

		
		JButton buttonClosedData = new JButton();
		if(WinList.now){
			buttonClosedData.setText("済");
			buttonClosedData.setForeground(Color.WHITE);
			buttonClosedData.setBackground(Color.BLACK);
			label.setText("GEリスト(管理要)");
		} else {
			buttonClosedData.setText("現");
			buttonClosedData.setForeground(Color.BLACK);
			buttonClosedData.setBackground(Color.WHITE);
			label.setText("GEリスト(管理不要)");
			label.setForeground(Color.BLACK);
		}
		buttonClosedData.setOpaque(true);
		buttonClosedData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(WinList.now) {
				WinList.now = false;
				} else {
				WinList.now = true;
				}
				new WinList();
				setVisible(false);
			}
		});
		buttonPanel.add(buttonClosedData);



		String [] columnNames = {"内定者番号","氏名","国籍","生年月日","性別","入社予定年月"};
		Object[][] data = new Object[arr.size()+36][16];
		for(int i=0; i<arr.size();i++) {
			data[i][0]= arr.get(i).getEmpNo();
			data[i][1]= arr.get(i).getName();
			data[i][2]= arr.get(i).getNation();
			data[i][3]= arr.get(i).getBirth();
			data[i][4]= arr.get(i).getGender();
			data[i][5]= arr.get(i).getEstYearMonth();
			data[i][6]= arr.get(i).getTel();
			data[i][7]= arr.get(i).getEmail();
			data[i][8]= arr.get(i).getEmpCd();
			data[i][9]= arr.get(i).getSchool();
			data[i][10]= arr.get(i).getEmpType();
			data[i][11]= arr.get(i).getEmpLoc();
			data[i][12]= arr.get(i).getNote();
			data[i][13]= arr.get(i).getSalary();
			data[i][14]= arr.get(i).getAvailable();
			data[i][15]= arr.get(i).getAddress();
		}	
		
		
		table = new JTable(data,columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;}
		    };
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			try {
			 int row = table.getSelectedRow();
			 TableModel data = table.getModel();
			 empNo = (int) data.getValueAt(row,0);
			 empCd = (int) data.getValueAt(row,8);
			 name = (String) data.getValueAt(row,1);
			 nation = (String) data.getValueAt(row,2);
//			 yearMonth = (String) data.getValueAt(row,15);

			 labelSelected.setText("選択：" + empNo + " " + name);
			}catch (Exception e1) {
				
			}
			 
			 
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		JScrollPane scrollpane = new JScrollPane(table);

		
		
		this.setTitle("GE入国管理");
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.NORTH);
		this.add(scrollpane, BorderLayout.CENTER);
		this.setSize(500,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}
