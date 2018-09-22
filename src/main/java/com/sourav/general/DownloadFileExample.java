package com.sourav.general;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileExample {
    public static void main(String[] args) {

        String url1 = "https://www.journaldev.com/sitemap.xml";
        String url2 = "http://www.landxmlproject.org/file-cabinet/MntnRoad.xml?attredirects=0&d=1";
        try {
            // 1. using Java IO..
            downloadUsingIO(url1);
            // 2. Using NIO
            downloadUsingNIO(url2);
            //3. Async Http Client
            // downloadUsingHttpClinet();
            //4. Apache commons IO
            // downloadUsingApacheCommonIO();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    private static void downloadUsingIO(String url) throws IOException {
        URLConnection urlConn = new URL(url).openConnection();
        urlConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        BufferedInputStream bis = new BufferedInputStream(urlConn.getInputStream());
        FileOutputStream fis = new FileOutputStream("sitemap_stream.xml");
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private static void downloadUsingNIO(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("sample1.xml");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}
