/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;
import java.io.IOException;
import backup.Uteis.BackupPostgres;

/**
 *
 * @author Valeria
 */
public class Backup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        BackupPostgres.BackupPostgres();
    }
    
}
