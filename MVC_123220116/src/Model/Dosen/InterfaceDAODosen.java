/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dosen;

import java.util.List;

/**
 *
 * @author Hafizh
 */
public interface InterfaceDAODosen {
   
    // Method untuk memasukkan suatu data dosen
    public void insert(ModelDosen dosen);
    
    // Method untuk mengupdate (mengedit) suatu data dosen
    public void update(ModelDosen dosen);
    
    // Method untuk menghapus suatu data dosen
    public void delete(int id);
    
    // Method untuk mengambil data dosen
    public List<ModelDosen> getAll();

}
