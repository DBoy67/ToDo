package models;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToDoForm extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ToDoForm() {
		setLayout(null);
		
		JTextArea txtrTasklist = new JTextArea();
		txtrTasklist.setBounds(10, 13, 203, 294);
		add(txtrTasklist);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(223, 15, 110, 20);
		add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(223, 46, 110, 20);
		add(btnRemove);
		
		JButton btnSearchTask = new JButton("Search task");
		btnSearchTask.setBounds(223, 77, 110, 20);
		add(btnSearchTask);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(223, 108, 110, 20);
		add(btnEdit);
		
		JButton btnChangeStatus = new JButton("Change status");
		btnChangeStatus.setBounds(223, 139, 110, 20);
		add(btnChangeStatus);
		
		JButton btnRemoveDone = new JButton("Remove done");
		btnRemoveDone.setBounds(223, 170, 110, 20);
		add(btnRemoveDone);
		
		JButton btnListAll = new JButton("List all");
		btnListAll.setBounds(223, 201, 110, 20);
		add(btnListAll);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							System.exit(0);
			}
		});
		btnExit.setBounds(223, 287, 110, 20);
		add(btnExit);

	}
}
