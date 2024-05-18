/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Mahasiswa.*;
import View.Mahasiswa.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hafizh
 */
public class ControllerMahasiswa {
    ViewMahasiswa tabelMahasiswa;
    InputMahasiswa inputMahasiswa;
    EditMahasiswa editMahasiswa;
    
    InterfaceDAOMahasiswa daoMahasiswa;
    
    List<ModelMahasiswa> listMahasiswa;

    public ControllerMahasiswa(ViewMahasiswa tabelMahasiswa) {
        this.tabelMahasiswa = tabelMahasiswa;
        this.daoMahasiswa = new DAOMahasiswa();
    }

    public ControllerMahasiswa(InputMahasiswa inputMahasiswa) {
        this.inputMahasiswa = inputMahasiswa;
        this.daoMahasiswa = new DAOMahasiswa();
    }

    public ControllerMahasiswa(EditMahasiswa editMahasiswa) {
        this.editMahasiswa = editMahasiswa;
        this.daoMahasiswa = new DAOMahasiswa();
    }
    
    public void showAllMahasiswa(){
        listMahasiswa = daoMahasiswa.getAll();
        ModelTableMahasiswa tabel = new ModelTableMahasiswa(listMahasiswa);
        tabelMahasiswa.getTableMahasiswa().setModel(tabel);
    }
    
    public void insertMahasiswa(){
        try{
            ModelMahasiswa maba = new ModelMahasiswa();
            
            String nama = inputMahasiswa.getInputNama();
            String nim = inputMahasiswa.getInputNIM();
            
            if("".equals(nama) || "".equals(nim)){
                throw new Exception("Nama atau NIM tidak boleh kosong");
            }
            maba.setNama(nama);
            maba.setNim(nim);
            
            daoMahasiswa.insert(maba);
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan maba");
            inputMahasiswa.dispose();
            new ViewMahasiswa();
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editMahasiswa(int id){
        try{
        ModelMahasiswa mahasiswaDiedit = new ModelMahasiswa();
        
        String nama = editMahasiswa.getInputNama();
        String nim = editMahasiswa.getInputNIM();
        
        if("".equals(nama) || "".equals(nim)){
            throw new Exception("Nama atau NIM tidak boleh kosong");
        }
        
        mahasiswaDiedit.setId(id);
        mahasiswaDiedit.setNama(nama);
        mahasiswaDiedit.setNim(nim);
        
        daoMahasiswa.update(mahasiswaDiedit);
        
        JOptionPane.showMessageDialog(null, "Berhasil mengubah data mahasiswa");
        
        editMahasiswa.dispose();
        new ViewMahasiswa();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    
    public void deleteMahasiswa(int baris){
        Integer id = (int) tabelMahasiswa.getTableMahasiswa().getValueAt(baris, 0);
        String nama = tabelMahasiswa.getTableMahasiswa().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Mahasiswa",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoMahasiswa.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllMahasiswa();
        }
    }
    
    
    
}
