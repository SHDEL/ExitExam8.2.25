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
        // กำหนด Frame
        frame = new JFrame("View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(screenWidth, screenHeight));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        addContent();
    }
    private void addContent(){
        //กำหนด content ใน panel และ add panel เข้า Frame
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(screenWidth, screenHeight));
        panel.setBounds(0,0, screenWidth, screenHeight);;
        panel.setLayout(null);
        panel.setBackground(Color.white);
        // ชื่อพาดหัว program
        labelApp = new JLabel("Food Expires Check");
        labelApp.setFont(labelApp.getFont().deriveFont(24f));
        labelApp.setBounds(70, 50, 250, 28);
        // คำแนะนำสำหรับ input 
        labelEnter = new JLabel("Enter 6 digits ID: ");
        labelEnter.setFont(labelApp.getFont().deriveFont(18f));
        labelEnter.setBounds(70, 100, 200, 24);
        // แสดงรายละเอียดข้อ สถานะ/ข้อผิดพลาดของ input
        labelstatus = new JLabel("This field will show status of Program");
        labelstatus.setFont(labelApp.getFont().deriveFont(12f));
        labelstatus.setBounds(220, 130, 300, 24);
        labelstatus.setVisible(false);
        //ชื่อพาดหัว ของข้อมูล Food
        labelhead = new JLabel("Food Data");
        labelhead.setFont(labelApp.getFont().deriveFont(20f));
        labelhead.setBounds(400, 50, 250, 28);
        //ชื่อพาดหัว ของข้อมูลที่เช็ควันหมดอายุของ Food
        labelhead2 = new JLabel("Food Expires Result:");
        labelhead2.setFont(labelApp.getFont().deriveFont(20f));
        labelhead2.setBounds(860, 50, 250, 28);
        //ช่องรับ input
        input = new JTextField();
        input.setBounds(70, 130, 150, 25);
        //ปุ่ม submit
        btnSubmit = new JButton("submit");
        btnSubmit.setBounds(70, 160, 150, 50);
        btnSubmit.setFont(btnSubmit.getFont().deriveFont(20f));
        btnSubmit.setFocusPainted(false);
        btnSubmit.setActionCommand("Submit");
        //ช่องแสดงข้อมูล Food
        foodTextArea = new JTextArea();
        // foodTextArea.setBounds(90, 100, 410, 400);
        // foodTextArea.setRows(15);  // จำนวนบรรทัดที่ต้องการแสดงผล
        // foodTextArea.setColumns(50);  // ความกว้างของข้อความ
        foodTextArea.setLineWrap(true);  // ตัดบรรทัดอัตโนมัติ
        foodTextArea.setWrapStyleWord(true);
        foodTextArea.setFont(foodTextArea.getFont().deriveFont(14f));
        foodTextArea.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        foodTextArea.setEditable(false);
        //ช่องแสดงข้อมูลที่เช็ควันหมดอายุ Food
        resultTextArea = new JTextArea();
        resultTextArea.setBounds(860, 100, 300, 200);
        resultTextArea.setRows(3);  // จำนวนบรรทัดที่ต้องการแสดงผล
        resultTextArea.setColumns(30);  // ความกว้างของข้อความ
        resultTextArea.setLineWrap(true);  // ตัดบรรทัดอัตโนมัติ
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setFont(resultTextArea.getFont().deriveFont(18f));
        resultTextArea.setEditable(false);
        //scroll bar สำหรับช่องแสดงข้อมูล Food
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
    // เพิ่ม actionlistener ให้กับ ปุ่ม Submit
    public void setActionListener(ActionListener listener){
        btnSubmit.addActionListener(listener);
    }
    // Getter เพื่อgetค่า FoodID
    public String getInputText() {
        return input.getText();
    }
    // Getter เพื่อรับข้อมูล Food จาก Controller
    public void getControllerData(String text){
        foodTextArea.setText(text);
    }
    // Getter เพื่อรับ response สถานะ/ข้อผิดพลาด จาก Controller
    public void getControllerResponse(String state){
        labelstatus.setText(state);
        labelstatus.setVisible(true);
    }
    //Getter เพื่อรับข้อมูลที่เช็ควันหมดอายุ จาก Controller
    public void getExpireResult(String cntCalculate ,String ans1, String ans2, String ans3){
        resultTextArea.setText(cntCalculate + ans1 + ans2 + ans3);
    }
}
