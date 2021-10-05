package bai01;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class WriteFile extends Thread{
	String tenFile;
    public WriteFile(String tenFile) {
        super();
        this.tenFile = tenFile;
    }

    public void run() {
        FileOutputStream fos = null;
        File file;
        int numberOfCharactor = 20;
        Ramdom rand = new Ramdom();
        String mycontent = "\n" + "Dãy số ngẫu nhiên: "
                + rand.randomAlphaNumeric(numberOfCharactor);
        try {
            file = new File(tenFile);
            fos = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] bytesArray = mycontent.getBytes();
            fos.write(bytesArray);
            fos.flush();
            System.out.println("Đã tạo file");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Lỗi");
            }
        }
    }

    public static void main(String[] args) {
    	WriteFile t1 = new WriteFile("D:/file1.txt");
        t1.start();
        WriteFile t2 = new WriteFile("D:/file2.txt");
        t2.start();
        WriteFile t3 = new WriteFile("D:/file3.txt");
        t3.start();

    }
}
