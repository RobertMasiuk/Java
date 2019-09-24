/*
 * Program for downloading temperature from the website
 */
package jsouptemperaturefromwebside;

import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

/**
 * @author Robert Masiuk
 */
public class JsoupTemperatureFromWebside {
     
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(1000);

                try {
                    Connection connect = Jsoup.connect("https://pogoda.onet.pl/prognoza-pogody/gdynia-287798");
                    Document document = connect.get();
                    //  Elements temperature  = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.mainParams > div.temperature > div.feelTemp > span.feelTempValue");
                    Elements temperature = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.mainParams > div.temperature > div.temp");
                    for (Element elem : temperature) {
                        System.out.println("Temperatura w Gdyni wynosi: " + elem.text());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (InterruptedException e) {

            }

        }
    }

}
