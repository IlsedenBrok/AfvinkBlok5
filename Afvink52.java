package afvink5.pkg2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Afvink52 extends JFrame implements ActionListener {

    public Enumeration key;
    public Enumeration element;
    private Dictionary dict;
    JTextField tekst1;
    JTextField tekst2;
    JLabel label1;
    JLabel label2;
    JButton button;
    String input;
    String output = "";
    String input_2;
    String output_2 = "";

    public static void main(String[] args) {
        Afvink52 mygui;
        mygui = new Afvink52();
        mygui.setTitle("afvink 5.2");
        mygui.setSize(200, 200);
        mygui.createGUI();
        mygui.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        tekst1 = new JTextField("", 10);
        window.add(tekst1);
        label1 = new JLabel("");
        window.add(label1);
        button = new JButton("Translate");
        window.add(button);
        button.addActionListener(this);
        tekst2 = new JTextField("", 10);
        window.add(tekst2);
        label2 = new JLabel("");
        window.add(label2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dictionary dict = new Hashtable();
        dict.put("A", "ALA");
        dict.put("R", "ARG");
        dict.put("N", "ASN");
        dict.put("D", "ASP");
        dict.put("C", "CYS");
        dict.put("F", "PHE");
        dict.put("Q", "GLN");
        dict.put("E", "GLU");
        dict.put("G", "GLY");
        dict.put("H", "HIS");
        dict.put("I", "ILE");
        dict.put("L", "LEU");
        dict.put("K", "LYS");
        dict.put("M", "MET");
        dict.put("P", "PRO");
        dict.put("S", "SER");
        dict.put("T", "THR");
        dict.put("W", "TRP");
        dict.put("Y", "TYR");
        dict.put("V", "VAL");

        Dictionary dict_2 = new Hashtable();
        dict_2.put("ALA", "A");
        dict_2.put("ARG", "R");
        dict_2.put("ASN", "N");
        dict_2.put("ASP", "D");
        dict_2.put("CYS", "C");
        dict_2.put("PHE", "F");
        dict_2.put("GLN", "Q");
        dict_2.put("GLU", "E");
        dict_2.put("GLY", "G");
        dict_2.put("HIS", "H");
        dict_2.put("ILE", "I");
        dict_2.put("LEU", "L");
        dict_2.put("LYS", "K");
        dict_2.put("MET", "M");
        dict_2.put("PRO", "P");
        dict_2.put("SER", "S");
        dict_2.put("THR", "T");
        dict_2.put("TRP", "W");
        dict_2.put("TYR", "Y");
        dict_2.put("VAL", "V");

        if (tekst2.getText().trim().isEmpty()) {
            input = tekst1.getText();
            for (String letter : input.toUpperCase().split("")) {
                output = output + (String) dict.get(letter) + '-';
                if (output.contains("null")) {
                    System.out.println("Dit is geen aminozuur");
                    output = output.replace("null-", "*-");
                }
            }
            tekst2.setText(output);

        }
        if (tekst1.getText().trim().isEmpty()) {
            input_2 = tekst2.getText();
            key = dict.keys();
            element = dict.elements();
            for (String letter_2 : input_2.toUpperCase().split("-")) {
                System.out.println(letter_2);
                output_2 += (String) dict_2.get(letter_2);
                System.out.println(output_2);
            }
            System.out.println(output_2);
            tekst1.setText(output_2);
        }

    }
}