package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View {
    JFrame  frame;
    JPanel panel;
    int screenWidth = 1280;
    int screenHeight = 720;
    JTextField input;
    JLabel labelEnter;
    JLabel labelApp;
    JLabel labelstatus;
    JLabel labelhead;
    JLabel labelhead2;
    JButton btnSubmit;
    JTextArea foodTextArea;
    JTextArea resultTextArea;
    JScrollPane scoller;
    public ActionListener onSubmitListener;

    public View(){
        frame = new JFrame("View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(screenWidth, screenHeight));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        addContent();
    }
    private void addContent(){
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(screenWidth, screenHeight));
        panel.setBounds(0,0, screenWidth, screenHeight);;
        panel.setLayout(null);
        panel.setBackground(Color.white);

        labelApp = new JLabel("Food Expires Check");
        labelApp.setFont(labelApp.getFont().deriveFont(24f));
        labelApp.setBounds(70, 50, 250, 28);

        labelEnter = new JLabel("Enter 6 digits ID: ");
        labelEnter.setFont(labelApp.getFont().deriveFont(18f));
        labelEnter.setBounds(70, 100, 200, 24);

        labelstatus = new JLabel("This field will show status of Program");
        labelstatus.setFont(labelApp.getFont().deriveFont(12f));
        labelstatus.setBounds(220, 130, 300, 24);
        labelstatus.setVisible(false);

        labelhead = new JLabel("Food Data");
        labelhead.setFont(labelApp.getFont().deriveFont(20f));
        labelhead.setBounds(400, 50, 250, 28);

        labelhead2 = new JLabel("Food Expires Result:");
        labelhead2.setFont(labelApp.getFont().deriveFont(20f));
        labelhead2.setBounds(860, 50, 250, 28);

        input = new JTextField();
        input.setBounds(70, 130, 150, 25);

        btnSubmit = new JButton("submit");
        btnSubmit.setBounds(70, 160, 150, 50);
        btnSubmit.setFont(btnSubmit.getFont().deriveFont(20f));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setActionCommand("Submit");

        foodTextArea = new JTextArea();
        // foodTextArea.setBounds(90, 100, 410, 400);
        // foodTextArea.setRows(15);  // จำนวนบรรทัดที่ต้องการแสดงผล
        // foodTextArea.setColumns(50);  // ความกว้างของข้อความ
        foodTextArea.setLineWrap(true);  // ตัดบรรทัดอัตโนมัติ
        foodTextArea.setWrapStyleWord(true);
        foodTextArea.setFont(foodTextArea.getFont().deriveFont(14f));
        foodTextArea.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        foodTextArea.setEditable(false);

        resultTextArea = new JTextArea();
        resultTextArea.setBounds(860, 100, 300, 200);
        resultTextArea.setRows(3);  // จำนวนบรรทัดที่ต้องการแสดงผล
        resultTextArea.setColumns(30);  // ความกว้างของข้อความ
        resultTextArea.setLineWrap(true);  // ตัดบรรทัดอัตโนมัติ
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setFont(resultTextArea.getFont().deriveFont(18f));
        resultTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(foodTextArea);
        scrollPane.setBounds(370, 100, 470, 500);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel.add(labelhead);
        panel.add(labelhead2);
        panel.add(resultTextArea);
        panel.add(labelstatus);
        panel.add(labelApp);
        panel.add(btnSubmit);
        panel.add(labelEnter);
        panel.add(input);
        panel.add(scrollPane);
    
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public void setActionListener(ActionListener listener){
        btnSubmit.addActionListener(listener);
    }
    // Getter เพื่อรับค่าจาก JTextField
    public String getInputText() {
        return input.getText();
    }
    public void getControllerData(String text){
        foodTextArea.setText(text);
    }
    public void getControllerResponse(String state){
        labelstatus.setText(state);
        labelstatus.setVisible(true);
    }
    public void getExpireResult(String cntCalculate ,String ans1, String ans2, String ans3){
        resultTextArea.setText(cntCalculate + ans1 + ans2 + ans3);
    }
}
