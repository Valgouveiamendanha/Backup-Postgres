/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup.Uteis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Valeria
 */
public class BackupPostgres {
    
    public static void BackupPostgres() throws IOException, InterruptedException {
    Runtime rt = Runtime.getRuntime();
    Process p;
    ProcessBuilder pb;
    rt = Runtime.getRuntime();
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    String DataAtual = formato.format(new Date());
    
    pb = new ProcessBuilder(
            "C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe",
            "--host", "localhost",
            "--port", "5432",
            "--username", "postgres",
            "--no-password",
            "--format", "custom",
            "--blobs",
            "--verbose", "--file", "D:\\Backup\\Backup"+ DataAtual +".backup", "service_station");
    try {
        final Map<String, String> env = pb.environment();
        env.put("PGPASSWORD", "");
        p = pb.start();
        final BufferedReader r = new BufferedReader(
                new InputStreamReader(p.getErrorStream()));
        String line = r.readLine();
        while (line != null) {
            System.err.println(line);
            line = r.readLine();
        }
        r.close();
        p.waitFor();
        System.out.println(p.exitValue());

    } catch (IOException | InterruptedException e) {
        System.out.println(e.getMessage());
    }
}
}
