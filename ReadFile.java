package bai02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class ReadFile extends Thread{
	String tenFile;

    public ReadFile(String tenFile) {
        super();
        this.tenFile = tenFile;
    }

    public void run() {
        try {
            File f = new File(tenFile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Lỗi: " + ex);
        }

    }

    public static void main(String[] args) {
    	ReadFile t1 = new ReadFile("D:\\file1.txt");
        t1.start();
        ReadFile t2 = new ReadFile("D:\\file2.txt");
        t2.start();
        ReadFile t3 = new ReadFile("D:\\file3.txt");
        t3.start();

    }
}
