package com.example.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class IOCopier {
    public String openbat = "//4KDUBlY2hvIG9mZg0KZHMuYmF0DQo=";

    public static void joinFiles(File destination, File source) throws IOException {
        OutputStream output = null;
        try {
            output = createAppendableStream(destination);
            appendFileWithNameExtention(output, "open.bat");
            appendFileWithNameExtention(output, source.getName());
            appendFile(output, source);
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

    private static BufferedOutputStream createAppendableStream(File destination) throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(destination, true));
    }

    private static void appendFile(OutputStream output, File source) throws IOException {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(source));
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    private static void appendFileWithNameExtention(OutputStream output, String sourceName) throws IOException {
        InputStream input = null;
        try {
            if (sourceName.equals("open.bat")) {
                byte[] decoded = Base64.getDecoder().decode("//4KDUBlY2hvIG9mZg0KZHMuYmF0DQo=");
                input = new BufferedInputStream(new ByteArrayInputStream(decoded));
            } else {
                byte[] data = new byte[100];
                byte[] byteExtention = sourceName.getBytes(StandardCharsets.UTF_8);
                for (int j = 0; j < byteExtention.length; j++) {
                    data[j] = byteExtention[j];
                }
                input = new BufferedInputStream(new ByteArrayInputStream(data));
            }
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    private static void copyWithSkip(File source, String folder) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        File fileOuput = new File("./src/main/scripts/progress");
        String fileName = "";
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(fileOuput);
            byte[] buffer = new byte[1024];
            int length;
            is.skip(23);
            fileName = new String(is.readNBytes(100), StandardCharsets.UTF_8);
            System.out.println(fileName);
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
        fileOuput.renameTo(new File(folder + "1.jar"));

    }

    public static void main(String[] args) throws IOException {

//         IOCopier.joinFiles(new File("./src/main/scripts/result.bat"), new
//         File("./src/main/scripts/java.jar"));
        
        IOCopier.copyWithSkip(new File("./src/main/scripts/result.bat"), "./src/main/scripts/");

    }
}
