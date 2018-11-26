package NewFriend;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField tfSearch;
	private JTextArea taView;
	private JButton BtnSearch, btnUpdate, btnDelete, btnView;
	private Friend f;
	
FriendDBAImpl dba=new FriendDBAImpl();
private JTextField tfNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, null, null), "AddFriend", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(12, 36, 57, 15);
		panel.add(lblName);
		
		JTextField tfName= new JTextField();
		tfName.setBounds(71, 33, 116, 21);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Birthday");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 84, 57, 15);
		panel.add(lblNewLabel);
		
		JTextField tfBirth = new JTextField();
		tfBirth.setBounds(71, 81, 116, 21);
		panel.add(tfBirth);
		tfBirth.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tel.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 129, 57, 15);
		panel.add(lblNewLabel_1);
		
		JTextField tfPhone = new JTextField();
		tfPhone.setBounds(71, 126, 116, 21);
		panel.add(tfPhone);
		tfPhone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Addr");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(12, 176, 57, 15);
		panel.add(lblNewLabel_2);
		
		JTextField tfAddr = new JTextField();
		tfAddr.setBounds(69, 173, 116, 21);
		panel.add(tfAddr);
		tfAddr.setColumns(10);
		
		btnView = new JButton("View all");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				taView.setText("");				
				ArrayList<Friend>arr=dba.friendView();
				for (Friend f:arr) {
					taView.append("num : "+f.getNum()+"\n");
					taView.append("name : "+f.getName()+"\n");
					taView.append("birth : "+f.getBirth()+"\n");
					taView.append("phone : "+f.getPhone()+"\n");
					taView.append("addr : "+f.getAddr()+"\n");
					
				}
			}//actionPerformed		
		});//addActionListener
				
		btnView.setBounds(12, 216, 85, 23);
		panel.add(btnView);
		
		JButton BtnInsert = new JButton("Add");
		BtnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Friend f=new Friend();
				f.setName(tfName.getText());
				f.setBirth(tfBirth.getText());
				f.setAddr(tfAddr.getText());
				f.setPhone(tfPhone.getText());
				dba.friendInsert(f);
				
				
			}
		});
		BtnInsert.setBounds(102, 216, 85, 23);
		panel.add(BtnInsert);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, null, null), "ViewAll", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 385, 149);
		scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, null, null), "ViewAll", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(scrollPane);
		
		taView = new JTextArea();
		scrollPane.setViewportView(taView);
		
		JPanel panel_2 = new JPanel();
		panel_2.setEnabled(false);
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comSel = new JComboBox();
		comSel.setModel(new DefaultComboBoxModel(new String[] { "name", "addr"}));
		comSel.setBounds(46, 33, 100, 21);
		panel_2.add(comSel);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(174, 33, 120, 21);
		panel_2.add(tfSearch);
		tfSearch.setColumns(10);
		
		 BtnSearch = new JButton("Search");
		 BtnSearch.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		taView.setText("");
		 		String str="";
		 		if(comSel.getSelectedIndex()==0) {
		 			str="name";
		 		}else if(comSel.getSelectedIndex()==1) {
		 			str="addr";
		 		}else {
		 			tfSearch.setText("error");
		 			return;
		 		}
		 		ArrayList<Friend>arr=dba.friendSearch(str,tfSearch.getText());
		 		for (Friend f:arr) {
					taView.append("num : "+f.getNum()+"\n");
					taView.append("name : "+f.getName()+"\n");
					taView.append("birth : "+f.getBirth()+"\n");
					taView.append("phone : "+f.getPhone()+"\n");
					taView.append("addr : "+f.getAddr()+"\n");
					
				}
		 	}
		 });
		BtnSearch.setBounds(306, 32, 56, 23);
		panel_2.add(BtnSearch);
		
		tfNum = new JTextField();
		tfNum.setBounds(174, 79, 120, 21);
		panel_2.add(tfNum);
		tfNum.setColumns(10);
		
		JButton btnSelect = new JButton("\uC0C1\uC138\uBCF4\uAE30");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int num=Integer.parseInt(tfNum.getText());
				f=dba.friendSelect(num);
				tfName.setText(f.getName());
				tfBirth.setText(f.getBirth());
				tfAddr.setText(f.getAddr());
				tfPhone.setText(f.getPhone());
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				
				}catch(NumberFormatException b) {
					JOptionPane.showMessageDialog(null, "insert num");
				}catch(NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "no friend");
				}
				
			}
		});
		btnSelect.setBounds(46, 78, 100, 23);
		panel_2.add(btnSelect);
		
		
		
		btnUpdate = new JButton("\uC218\uC815");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfName.getText();
				String birth=tfBirth.getText();
				String phone=tfPhone.getText();
				String addr=tfAddr.getText();
				int num=Integer.parseInt(tfNum.getText());
				f=new Friend();
				f=dba.friendSelect(num);
				f.setName(name);
				f.setBirth(birth);
				f.setPhone(phone);
				f.setAddr(addr);
				//f.setNum(num);
				dba.friendUpdate(f);
				btnView.doClick();
				
				
			}
		});
		btnUpdate.setBounds(46, 124, 116, 23);
		panel_2.add(btnUpdate);
		
		
		btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(tfNum.getText());;
				dba.friendDelete(num);
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(174, 124, 120, 23);
		panel_2.add(btnDelete);
		splitPane_1.setDividerLocation(150);
		splitPane.setDividerLocation(200);
	}
	
}

