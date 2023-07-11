/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compress;
import comp_decomp.decompress;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mithi
 */
public class AppFrame extends JFrame implements ActionListener  {
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setTitle("Compressor - Decompressor");
         JLabel titleLabel = new JLabel("COMPRESSOR & DECOMPRESSOR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 20, 1000, 30);
        this.add(titleLabel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton = new JButton("Select file to compress");
      
        compressButton.setBounds(100, 100, 200, 50);
        
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(600, 100, 200, 50);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.black);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void  actionPerformed(ActionEvent e){
        
        if(e.getSource()== compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                
                try{
                    compress.method(file);
                }
                catch (IOException ee){
                  JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
            
            
             if(e.getSource()== decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                
                try{
                    decompress.method(file);
                }
                catch (IOException ee){
                  JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}

