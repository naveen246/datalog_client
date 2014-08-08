

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://169.254.101.102");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        PrintWriter fout = new PrintWriter("log.txt");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            //System.out.println(inputLine);
            fout.println(inputLine);
        }
        in.close();
        fout.close();
    }
}