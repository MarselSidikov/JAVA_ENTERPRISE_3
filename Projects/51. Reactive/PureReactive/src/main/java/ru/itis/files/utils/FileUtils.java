package ru.itis.files.utils;

import ru.itis.files.dto.FileInfo;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 19.02.2021
 * PureReactive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileUtils {
    public FileInfo getSize(String fileUrl) {
        FileInfo fileInfo = FileInfo.builder()
                .url(fileUrl)
                .isAvailable(true)
                .build();

        URL url;
        try {
            url = new URL(fileUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        // create a connection
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.getInputStream();
            BigInteger size = BigInteger.valueOf(connection.getContentLength());
            connection.getInputStream().close();
            fileInfo.setSize(size.longValue());

            if (fileInfo.getSize() == -1) {
                fileInfo.setAvailable(false);
            }
        } catch (Exception e) {
            fileInfo.setAvailable(false);
        }
        return fileInfo;
    }

    public FileInfo getMime(String fileUrl) {
        FileInfo fileInfo = FileInfo
                .builder()
                .isAvailable(true)
                .url(fileUrl)
                .build();
        try {
            URL url = new URL(fileUrl);
            URLConnection urlConnection;
            urlConnection = url.openConnection();
            fileInfo.setMIME(urlConnection.getContentType());
        } catch (Exception e) {
            fileInfo.setAvailable(false);
        }
        return fileInfo;
    }
}
