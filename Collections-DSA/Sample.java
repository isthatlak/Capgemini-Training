import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample {
    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream("data.txt");
        FileOutputStream fout = new FileOutputStream("dataCopy.txt");

        int ch;

        while ((ch = fin.read()) != -1) {
            fout.write(ch);
            fin.read();
        }

        fin.close();
        fout.close();

        System.out.println("Even index characters copied");
    }
}