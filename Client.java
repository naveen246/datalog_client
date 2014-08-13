

import java.net.*;
import java.io.*;
import java.nio.channels.*;

public class Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://169.254.101.102/?log=f#");
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("log.txt");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        FileInputStream in = null;
        PrintWriter out = null;

        try {
            in = new FileInputStream("log.txt");
            out = new PrintWriter("out.txt");
            int val, count = 0;
            int c, d;

            while ( ((c = in.read()) != -1) && ((d = in.read()) != -1) )  {
                val = ((c << 8) | d);
                out.print(Integer.toString(val) + ',');
                count++;
                if(count % 4 == 0)
                    out.println();
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}