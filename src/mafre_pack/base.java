package mafre_pack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by mihkelm on 10/11/15.
 * http://www.promenaadimaja.ee/korterid/korrused/linnamaja-2nd-floor
 */
public class base {
    public static void main(String[] args)  throws IOException {
        File input = new File ("promenaadi.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Elements links = doc.select("table");

        for (Element link : links) {
            System.out.println("\"" + link.text() + "\"");
        }


    }
}
