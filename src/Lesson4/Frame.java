package Lesson4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends  JFrame{
    public Frame() {
            setBounds(500, 500, 600, 600);
            setResizable(false);
            setTitle("Demo");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JLabel lab = new JLabel();
            add(lab, BorderLayout.NORTH);
            lab.setSize(100, 100);


            JTextField fi = new JTextField();
            add(fi);
            fi.setLocation(10, 510);
            fi.setSize(550, 40);
            fi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Вы ввели  : " + fi.getText());
                    lab.setText(((JTextField) e.getSource()).getText());
                    fi.setText(null);
                }
            });

            JPanel pan = new JPanel();
            add(pan);
            pan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println("Клик " + e.getX() + "   " + e.getY());
                }
            });

            JButton jb1 = new JButton("Отправить");
            add(jb1, BorderLayout.SOUTH);
            jb1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Кнопку отправить нажали!!!");
                    lab.setText(fi.getText());
                    fi.setText(null);
                }
            });
            setVisible(true);
        }

        public static void main (String[]args){
            Frame start = new Frame();
        }
    }

