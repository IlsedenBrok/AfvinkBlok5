package afvink7;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class JFrameTest extends JFrame implements ActionListener {

    int reply;
    private JPanel panel;
    private JLabel bestandLabel;
    private JLabel infoLabel;
    private JTextField bestandField;
    private JButton bladerButton;
    private JButton visueelButton;
    private JTextArea infoArea;
    private JFileChooser fileChooser;
    private BufferedReader inFile;
    private char[] aminoAcid = new char[]{};
    static char[] aminoarray = new char[]{'A', 'R', 'N', 'D', 'C', 'Q', 'E', 'G', 'H', 'I', 'L', 'K', 'M', 'F', 'P', 'S', 'T', 'W', 'Y', 'V'};
    static char[] hydrofielarray = new char[]{'S', 'T', 'C', 'N', 'Q', 'Y'};
    static char[] hydrofoobarray = new char[]{'A', 'G', 'I', 'L', 'M', 'F', 'P', 'V'};

    private static final String TITEL = "eindopdracht";

    public static void main(String[] args) {
        JFrameTest frame;
        frame = new JFrameTest();
        frame.setTitle(TITEL);
        frame.setSize(490, 600);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        bestandLabel = new JLabel();
        bestandLabel.setText("bestand");
        window.add(bestandLabel);

        bestandField = new JTextField();
        bestandField.setText("Klik op de blader knop en open uw bestand");
        window.add(bestandField);

        bladerButton = new JButton("blader");
        window.add(bladerButton);
        bladerButton.addActionListener(this);

        visueelButton = new JButton("visualiseer");
        window.add(visueelButton);
        visueelButton.addActionListener(this);

        infoLabel = new JLabel();
        infoLabel.setText("informatie");
        window.add(infoLabel);

        infoArea = new JTextArea(15, 30);
        infoArea.setText("eigenschappen van aminozuren");
        window.add(infoArea);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(450, 250));
        panel.setBackground(Color.gray);
        window.add(panel);

    }

    public char[] readFile() {
        try {
            inFile = new BufferedReader(new FileReader(bestandField.getText()));
            String line;
            while ((line = inFile.readLine()) != null) {
                aminoAcid = line.toCharArray();
                for (int z = 0; z < line.length(); z++) {
                    if (new String(aminoarray).indexOf(aminoAcid[z]) != -1) {
                        infoArea.setText("Alle aminozuren zijn juist!   Dit is uw sequentie:  " + "\n" + line);
                    } else {
                        JOptionPane.showMessageDialog(null,"Er staat een niet aminozuur letter in uw sequentie!");
                        infoArea.setText("Er staat een niet aminozuur letter in uw bestand, controleer uw sequentie!\n  Als u alsnog de hydrofobe/hydrofiele/neutrale aminozuren wilt zien,\n kan u alsnog op de visualiseer knop klikken.\n De niet aminozuur letter(s) worden gezien als neutraal.");
                    }
                }
            }
            inFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File Error: " + e.toString());
        }
        return aminoAcid;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Graphics visualPanel = panel.getGraphics();
        Object src = event.getSource();

        if (src == visueelButton) {
            visualPanel.setColor(Color.black);
            visualPanel.fillRect(20, 200, 20, 20);
            visualPanel.drawString("neutraal", 45, 215);
            visualPanel.setColor(Color.white);
            visualPanel.fillRect(20, 20, 400, 75);
            visualPanel.setColor(Color.yellow);
            visualPanel.fillRect(20, 180, 20, 20);
            visualPanel.drawString("hydrofoob", 45, 195);
            visualPanel.setColor(Color.blue);
            visualPanel.fillRect(20, 160, 20, 20);
            visualPanel.drawString("hydrofiel", 45, 175);

            int rectLength = 400;
            if (aminoAcid.length != 0) {
                int aminoLength = rectLength / aminoAcid.length;
                for (int z = 0; z < aminoAcid.length; z++) {
                    if (new String(hydrofoobarray).indexOf(aminoAcid[z]) != -1) {
                        int locatie = (20 + (aminoLength * z));
                        visualPanel.setColor(Color.yellow);
                        visualPanel.fillRect(locatie, 20, aminoLength, 75);
                    } else if (new String(hydrofielarray).indexOf(aminoAcid[z]) != -1) {
                        int locatie = (20 + (aminoLength * z));
                        visualPanel.setColor(Color.blue);
                        visualPanel.fillRect(locatie, 20, aminoLength, 75);
                    } else {
                        int locatie = (20 + (aminoLength * z));
                        visualPanel.setColor(Color.black);
                        visualPanel.fillRect(locatie, 20, aminoLength, 75);
                    }
                }
            } else {
                infoArea.setText("Sorry, de lengte van uw sequentie lijkt 0 te zijn! controlleer alstublieft uw input.");
            }
        }

        File selectedFile;

        if (event.getSource() == bladerButton) {
            fileChooser = new JFileChooser();
            reply = fileChooser.showOpenDialog(this);
            if (reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                bestandField.setText(selectedFile.getAbsolutePath());
                readFile();
            }
        }
    }
}
