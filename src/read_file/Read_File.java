package read_file;

import java.io.*;

public class Read_File {
    public static boolean readTextFile(String path) {
        File file = new File(path);
        FileReader fileReader =null;
        if (!file.exists()) {
            return false;
        }
        try {
            fileReader = new FileReader(file);
            int bytes;
            while ((bytes = fileReader.read()) != -1) {
                // ef kiểu số=chữ unicode
                System.out.println((char) bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean readTextFileLine(String path) {
        // đọc từng dòng
        File file = new File(path);
        FileReader fileReader =null;
        BufferedReader bufferedReader =null;
        if (!file.exists()) {
            return false;
        }
        try {
            fileReader= new FileReader(file);
            bufferedReader=new BufferedReader(fileReader);
            String lines;
            while ((lines = bufferedReader.readLine()) != null) { // vừa lấy vừa kiểm tra và in luôn ra nên k bị mất giữ liệu
                // ef kiểu số=chữ unicode
                System.out.println(lines);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }


    public static void main(String[] args) {
        Read_File read_file = new Read_File();
        readTextFile("fileDemo.txt");
        readTextFileLine("fileDemo.txt");
    }

}