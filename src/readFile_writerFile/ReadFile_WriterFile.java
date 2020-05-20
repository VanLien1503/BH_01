package readFile_writerFile;

import java.io.*;

public class ReadFile_WriterFile {
    public static void main(String[] args) {
        try {
            File file =new File("fileDemo.txt");
            File copy =new File("demo.txt");

            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(copy, true);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line=bufferedReader.readLine())!= null){
                bufferedWriter.write(line+"\n");
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
