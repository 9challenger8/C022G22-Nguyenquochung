package ss15_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
        private static String sourceFile = "src/ss15_text_file/bai_tap/copy_file_text/SourceFile";
        private static String targetFile = "src/ss15_text_file/bai_tap/copy_file_text/TargetFile";


        public static void main(String[] args) {
            CopyFileText copyFileText = new CopyFileText();
            List<String> stringList = copyFileText.readFile(sourceFile);
            writeFile(targetFile, stringList);
            System.out.println("The number of characters in the file is "+stringList.size());
        }

        public static List<String> readFile(String sourceFilePath) {
            List<String> stringList = new ArrayList<>();
            try {
                File file = new File(sourceFilePath);
                if (!file.exists()) {
                    throw new FileNotFoundException();
                }
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringList.add(line);
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return stringList;
        }

        public static void writeFile(String targetFilePath, List<String> stringList) {
            try {
                FileWriter fileWriter = new FileWriter(targetFilePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String s : stringList) {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
