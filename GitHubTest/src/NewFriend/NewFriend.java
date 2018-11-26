package NewFriend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NewFriend extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JComboBox comSel;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton btnAdd;
	private JButton btnView;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane_1;
	private JTextArea taView;
	FriendDBAImpl dba=new FriendDBAImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFriend frame = new NewFriend();
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
	public NewFriend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), null, new Color(255, 200, 0), null), "Regisrate personal info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getBtnAdd());
			panel.add(getBtnView());
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_3());
		}
		return panel;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1_1());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getScrollPane_1());
		}
		return scrollPane;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getComSel());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getComSel() {
		if (comSel == null) {
			comSel = new JComboBox();
			comSel.setModel(new DefaultComboBoxModel(new String[] {"Name", "Addr"}));
			comSel.setBounds(12, 47, 64, 26);
		}
		return comSel;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(117, 47, 116, 24);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
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
			btnSearch.setBounds(245, 49, 97, 23);
		}
		return btnSearch;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(134, 29, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(134, 82, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(134, 138, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(134, 202, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add ");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f=new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setAddr(tfAddr.getText());
					f.setPhone(tfPhone.getText());
					dba.friendInsert(f);
					
				}
			});
			btnAdd.setBounds(22, 290, 97, 23);
		}
		return btnAdd;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("View All");
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
				}
			});
			btnView.setBounds(153, 290, 97, 23);
		}
		return btnView;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(22, 32, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("BirthDay");
			lblNewLabel_1.setBounds(22, 85, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Tel #");
			lblNewLabel_2.setBounds(22, 141, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Addr");
			lblNewLabel_3.setBounds(22, 205, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTaView());
		}
		return scrollPane_1;
	}
	private JTextArea getTaView() {
		if (taView == null) {
			taView = new JTextArea();
			taView.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, null, null), "View all", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		}
		return taView;
	}
}
