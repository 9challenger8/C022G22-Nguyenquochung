package com.dayaway.subscription.core.utils;


import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReadFileUtils {

    private final int bufferSize = 1024 * 20;

    /**
     * @param url
     * @return
     * @throws IOException
     */
    public String readFile(String url) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(url);
        String result = this.readFile(inputStream);
        // Close input stream
        inputStream.close();
        return result;
    }

    /**
     * @param resource
     * @return
     * @throws IOException
     */
    public String readFile(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        String result = this.readFile(inputStream);
        // Close input stream
        inputStream.close();
        return result;
    }

    /**
     * @param inputStream
     * @return
     * @throws IOException
     */
    public String readFile(InputStream inputStream) throws IOException {
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        int charsRead;
        while ((charsRead = in.read(buffer, 0, buffer.length)) > 0) {
            out.append(buffer, 0, charsRead);
        }
        return out.toString();
    }

    /**
     * @param
     * @return
     * @throws IOException
     */
    public byte[] readFileToByteArray(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }

    /**
     * @param resources
     * @return
     */
    public Map<String, String> readFiles(Resource[] resources) throws IOException {
        Map<String, String> result = new HashMap<>();
        if (resources != null) {
            for (Resource resource : resources) {
                String name = resource.getFilename();
                String content = this.readFile(resource);
                // Add result
                result.put(name, content);

            }
        }
        return result;
    }
}
