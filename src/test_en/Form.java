/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_en;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static test_en.Test_en.POS_arabic;
import static test_en.Test_en.POS_english;
import static test_en.Test_en.POS_french;
import static test_en.Test_en.POS_german;
import static test_en.Test_en.POS_japan;
import static test_en.Test_en.POS_korea;
import static test_en.Test_en.POS_russian;
import static test_en.Test_en.POS_spanish;

/**
 *
 * @author tfcs
 */
public class Form implements ActionListener
{
        Frame frame;
        //Button button1; 
        JButton button1; //
        JButton button2;
        JButton button3;
        JButton button4;  
        JButton button5;  
        JButton button6;    
        JButton button7;    
        JButton button8;    
        
        Label label1;
        JTextArea  textBox_output;  JTextArea  textBox_input;
 
        @Override
        public void actionPerformed(ActionEvent e) //動作執行器
{
    String cmd = e.getActionCommand();
    String Input_text ="";
    String Output_text="";
    switch(cmd)
    {
        case "b1": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                try {
                    String [] output_text_array = POS_arabic(Input_text);
                    for (String output_text_array1 : output_text_array) {
                        Output_text += output_text_array1 + "\r\n";
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            textBox_output.setText(Output_text);
            }
            break;
        case "b2": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                try {
                    String [] output_text_array = POS_spanish(Input_text);
                    for (String output_text_array1 : output_text_array) {
                        Output_text += output_text_array1 + "\r\n";
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            textBox_output.setText(Output_text);
            break;
        case "b3": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                try {
                    String [] output_text_array = POS_english(Input_text);
                    for (String output_text_array1 : output_text_array) {
                        Output_text += output_text_array1 + "\r\n";
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            textBox_output.setText(Output_text);
            break;
        case "b4": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                try {
                    String [] output_text_array = POS_german(Input_text);
                    for (String output_text_array1 : output_text_array) {
                        Output_text += output_text_array1 + "\r\n";
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            textBox_output.setText(Output_text);
            break;
            
        case "b5": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                try {
                    String [] output_text_array = POS_french(Input_text);
                    for (String output_text_array1 : output_text_array) {
                        Output_text += output_text_array1 + "\r\n";
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            textBox_output.setText(Output_text);
            break;
            
        case "b6": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                String [] output_text_array = POS_japan(Input_text);
                for (String output_text_array1 : output_text_array) 
                {
                    Output_text += output_text_array1 + "\r\n";
                }
            }
            textBox_output.setText(Output_text);
            break;
            
        case "b7": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                String [] output_text_array = POS_korea(Input_text);
                for (String output_text_array1 : output_text_array) 
                {
                    Output_text += output_text_array1 + "\r\n";
                }
            }
            textBox_output.setText(Output_text);
            break;
            
        case "b8": 
            Input_text = textBox_input.getText();
            Output_text = "";
            {
                String [] output_text_array = POS_russian(Input_text);
                for (String output_text_array1 : output_text_array) 
                {
                    Output_text += output_text_array1 + "\r\n";
                }
            }
            textBox_output.setText(Output_text);
            break;
    }

}
    
     public void InitializeComponent()
    {
        //
        Panel panel = new Panel();
        panel.setBackground(Color.BLACK);
        //文字方塊
        textBox_input  = new JTextArea();
        //textBox_input.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        textBox_input.setBounds(15,40,800,80);
        textBox_input.setText("請輸入文字...");
        
        textBox_output = new JTextArea();
        //textBox_output.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        textBox_output.setBounds(15, 185, 800, 350);
        //按鈕
        button1 = new JButton("阿拉伯");
        button1.setBounds(15,150,95,30);
        button1.setActionCommand("b1");//傳送到執行器
        button1.addActionListener(this);
        
        button2 = new JButton("西班牙");
        button2.setBounds(115,150,95,30);
        button2.setActionCommand("b2");
        button2.addActionListener(this);
        
        button3 = new JButton("英文");
        button3.setBounds(215,150,95,30);
        button3.setActionCommand("b3");
        button3.addActionListener(this);
        
        button4 = new JButton("德文");
        button4.setBounds(315,150,95,30);
        button4.setActionCommand("b4");
        button4.addActionListener(this);

        button5 = new JButton("法文");
        button5.setBounds(415,150,95,30);
        button5.setActionCommand("b5");
        button5.addActionListener(this);

        button6 = new JButton("日文");
        button6.setBounds(515,150,95,30);
        button6.setActionCommand("b6");
        button6.addActionListener(this);

        button7 = new JButton("韓文");
        button7.setBounds(615,150,95,30);
        button7.setActionCommand("b7");
        button7.addActionListener(this);

        button8 = new JButton("俄文");
        button8.setBounds(715,150,95,30);
        button8.setActionCommand("b8");
        button8.addActionListener(this);

        
        //整個視窗畫面
        frame = new Frame("多國語言分詞系統");
        frame.addWindowListener(new AdapterDemo());//新增事件處理功能
        //frame.setLayout(new FlowLayout());
        
        frame.setSize(850, 600);//視窗大小
        frame.setLocation(50, 50);//視窗顯示位置
        
        frame.add(button1);//增加按鈕1
        frame.add(button2);//增加按鈕2
        frame.add(button3);//增加按鈕3
        frame.add(button4);//增加按鈕4
        frame.add(button5);//增加按鈕5
        frame.add(button6);//增加按鈕6
        frame.add(button7);//增加按鈕6
        frame.add(button8);//增加按鈕6
        frame.add(textBox_output);//增加文字版
        frame.add(textBox_input); //增加文字版
        //frame.add(label1);
        frame.add(panel);

        //frame.pack();
        frame.setVisible(true);
    }
}
class AdapterDemo extends WindowAdapter 
{
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}