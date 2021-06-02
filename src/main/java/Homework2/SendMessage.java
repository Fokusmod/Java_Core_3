package Homework2;

import java.io.*;

public class SendMessage {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        String text = "Hello World!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/1.txt",true)) {

            baos.writeTo(fos);
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}





