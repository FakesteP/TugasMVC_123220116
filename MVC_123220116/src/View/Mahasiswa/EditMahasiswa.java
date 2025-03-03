package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Model.Mahasiswa.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditMahasiswa extends JFrame {
    ControllerMahasiswa controller;
    
    JLabel header = new JLabel("Edit Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    public EditMahasiswa(ModelMahasiswa mahasiswa) {
        setTitle("Edit Mahasiswa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(480, 240);
        setLocationRelativeTo(null);

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(inputNama);
        add(inputNIM);
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputNIM.setBounds(18, 120, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolEdit.setBounds(240, 160, 215, 40);
        
        inputNama.setText(mahasiswa.getNama());
        inputNIM.setText(mahasiswa.getNim());
        
        controller = new ControllerMahasiswa(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewMahasiswa();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editMahasiswa(mahasiswa.getId());
            }
        });
    }
    
    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNIM() {
        return inputNIM.getText();
    }

    public void setID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
