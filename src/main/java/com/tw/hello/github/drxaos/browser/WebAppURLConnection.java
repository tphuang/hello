package com.tw.hello.github.drxaos.browser;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

/**
 * Register a protocol handler for URLs like this: <code>webapp:///pics/sland.gif</code><br>
 */
public class WebAppURLConnection extends URLConnection {

    Class target;
    private byte[] data;

    protected WebAppURLConnection(URL url, Class target) {
        super(url);
        this.target = target;
    }

    @Override
    public void connect() throws IOException {
        if (connected) {
            return;
        }
        loadData();
        connected = true;
    }

    public InputStream getInputStream() throws IOException {
        connect();
        return new ByteArrayInputStream(data);
    }

    private void loadData() throws IOException {
        if (data != null) {
            return;
        }
        URL url = getURL();
        String filePath = url.toExternalForm();
        filePath = filePath.startsWith("webapp://") ? filePath.substring("webapp://".length()) : filePath.substring("webapp:".length()); // attention: triple '/' is reduced to a single '/'
        try {
            URL resource = target.getResource(filePath);
            if (resource != null) {
                data = IOUtils.toByteArray(resource.openConnection());
            } else {
                data = new byte[0];
            }
        } catch (IOException e) {
            data = new byte[0];
        }
    }

    public OutputStream getOutputStream() throws IOException {
        return new ByteArrayOutputStream();
    }

    public java.security.Permission getPermission() throws IOException {
        return null;
    }

}