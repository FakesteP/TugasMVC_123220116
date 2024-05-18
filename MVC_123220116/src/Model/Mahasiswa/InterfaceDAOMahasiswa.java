/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Mahasiswa;

import java.util.List;

/**
 *
 * @author Hafizh
 */
public interface InterfaceDAOMahasiswa {
   
    // Method untuk memasukkan suatu data mahasiswa
    public void insert(ModelMahasiswa mahasiswa);
    
    // Method untuk mengupdate (mengedit) suatu data mahasiswa
    public void update(ModelMahasiswa mahasiswa);
    
    // Method untuk menghapus suatu data mahasiswa
    public void delete(int id);
    
    // Method untuk mengambil data mahasiswa
    public List<ModelMahasiswa> getAll();

}
