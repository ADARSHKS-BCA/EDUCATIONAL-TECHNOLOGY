
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class lab10 {

    public static void main(String[] args) {
        new EduManagementGUI();
    }
}

class EduManagementGUI extends JFrame {

    private JTextField nameField, rollNoField;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox courseJava, coursePython;
    private JComboBox<String> departmentBox;
    private JTable studentTable;
    private DefaultListModel<String> studentListModel;
    private JList<String> studentList;
    private JToggleButton toggleEdit;

    public EduManagementGUI() {
        setTitle("Educational Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(8, 2, 5, 5));

        studentPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        studentPanel.add(nameField);

        studentPanel.add(new JLabel("Roll No:"));
        rollNoField = new JTextField();
        studentPanel.add(rollNoField);

        studentPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        studentPanel.add(genderPanel);

        studentPanel.add(new JLabel("Courses:"));
        JPanel coursePanel = new JPanel();
        courseJava = new JCheckBox("Java");
        coursePython = new JCheckBox("Python");
        coursePanel.add(courseJava);
        coursePanel.add(coursePython);
        studentPanel.add(coursePanel);

        studentPanel.add(new JLabel("Department:"));
        String[] departments = {"Computer Science", "Electronics", "Mechanical"};
        departmentBox = new JComboBox<>(departments);
        studentPanel.add(departmentBox);

        JButton addButton = new JButton("Add Student");
        studentPanel.add(addButton);

        toggleEdit = new JToggleButton("Enable/Disable Input");
        studentPanel.add(toggleEdit);

        tabbedPane.add("Student Form", studentPanel);

        JPanel listPanel = new JPanel(new BorderLayout());
        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane listScrollPane = new JScrollPane(studentList);
        listPanel.add(listScrollPane, BorderLayout.CENTER);
        tabbedPane.add("Student List", listPanel);

        JPanel tablePanel = new JPanel(new BorderLayout());
        String[] columnNames = {"Name", "Roll No", "Gender", "Department"};
        Object[][] data = {};
        studentTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
        tabbedPane.add("Student Table", tablePanel);

        JPanel treePanel = new JPanel(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Departments");
        DefaultMutableTreeNode cs = new DefaultMutableTreeNode("Computer Science");
        cs.add(new DefaultMutableTreeNode("Java"));
        cs.add(new DefaultMutableTreeNode("Python"));
        root.add(cs);
        root.add(new DefaultMutableTreeNode("Electronics"));
        root.add(new DefaultMutableTreeNode("Mechanical"));
        JTree courseTree = new JTree(root);
        JScrollPane treeScrollPane = new JScrollPane(courseTree);
        treePanel.add(treeScrollPane, BorderLayout.CENTER);
        tabbedPane.add("Course Hierarchy", treePanel);

        add(tabbedPane, BorderLayout.CENTER);

        addButton.addActionListener(e -> addStudent());
        toggleEdit.addActionListener(e -> toggleInputFields());

        setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        String rollNo = rollNoField.getText();
        String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not Selected";
        String department = (String) departmentBox.getSelectedItem();

        if (name.isEmpty() || rollNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String studentInfo = name + " - " + rollNo;
        studentListModel.addElement(studentInfo);

        JOptionPane.showMessageDialog(this, "Student Added Successfully!");
        clearFields();
    }

    private void clearFields() {
        nameField.setText("");
        rollNoField.setText("");
        maleButton.setSelected(false);
        femaleButton.setSelected(false);
        courseJava.setSelected(false);
        coursePython.setSelected(false);
        departmentBox.setSelectedIndex(0);
    }

    private void toggleInputFields() {
        boolean enabled = toggleEdit.isSelected();
        nameField.setEnabled(enabled);
        rollNoField.setEnabled(enabled);
        maleButton.setEnabled(enabled);
        femaleButton.setEnabled(enabled);
        courseJava.setEnabled(enabled);
        coursePython.setEnabled(enabled);
        departmentBox.setEnabled(enabled);
    }
}
