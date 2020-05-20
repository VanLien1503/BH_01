package filedir;

import java.io.*;

public class FileManager {
    public static void main(String[] args) {
        //bat dau lam viec tren file thì phai khai bao
        File file=new File("fileDemo1.txt");

        // kiem tra file ton tai hay khong
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        // duong dan tuyet doi
        System.out.println(file.getAbsoluteFile());
        readTextFileLine("fileDemo.txt");
        try {
            FileWriter writer =new FileWriter("fileDemo2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean readTextFileLine(String path) {
        // đọc từng dòng
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        if (!file.exists()) {
            return false;
        }
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String lines;
            while ((lines = bufferedReader.readLine()) != null) { // vừa lấy vừa kiểm tra và in luôn ra nên k bị mất giữ liệu
                // ef kiểu số=chữ unicode
                System.out.println(lines);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }
}
