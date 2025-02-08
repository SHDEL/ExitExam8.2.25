package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.View;

public class BtnActionListener implements ActionListener{
    View v;
    Controller c;
    public BtnActionListener(View v, Controller c){
        this.v = v;
        this.c = c;
    }
    //สำหรับกำหนด action ที่ปุ่ม Submit
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            String command = e.getActionCommand();
            if (command.equals("Submit")){
                handleSubmit();
            }
        } catch (Exception error) {
            // TODO: handle exception
            System.err.println(error);
        }
    }
    // method สำหรับ handle Submit button ให้ไปรับ input method getInputText จาก View แล้วส่งไปที่ mehod getViewInput ของ Controller
    private void handleSubmit(){
        String input = v.getInputText();
        c.getViewInput(input);
    }
}
