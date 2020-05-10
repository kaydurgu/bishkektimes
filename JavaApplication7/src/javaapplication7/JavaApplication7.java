
package javaapplication7;

import java.io.IOException;
import javax.lang.model.util.Elements;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class JavaApplication7 {
    public static void main(String[] args) throws IOException {
        
        
        //Parsing date for weather Jframe 
          String url = "https://pogoda.co.il/kyrgyzstan/bishkek";
           Document document = Jsoup.connect(url).get();
           Element tmp = document.select("strong").first();
           Element All = document.select("div.now_block").first();
           Element uls = All.select("ul").first();
           String temp_now = tmp.text();
           org.jsoup.select.Elements spns = uls.select("span");
           String[] wth_d = new String[7];
           int i = 0;
           for (Element div : spns){
               i++;
               wth_d[i]=div.text();
            }
           // Parsing KGZ covid -19 statments
            String urls = "https://www.worldometers.info/coronavirus/country/kyrgyzstan/";
           Document document_cov = Jsoup.connect(urls).get();
           
           org.jsoup.select.Elements All_cov = document_cov.select("div#maincounter-wrap");
           org.jsoup.select.Elements spns_cov = All_cov.select("span");
           String[] cov_d = new String[6];
           int j = 0;
           for (Element i_cov : spns_cov){
               j++;
               cov_d[j] = i_cov.text();
              // System.out.println(i_cov.text());
           }
        
           
           //Parsing World covid -19 statments
           String urlk = "https://www.worldometers.info/coronavirus/";
           Document document_covd = Jsoup.connect(urlk).get();
           
           org.jsoup.select.Elements All_covd = document_covd.select("div.maincounter-number");
           org.jsoup.select.Elements spns_covd = All_covd.select("span");
           String[] cov_dd = new String[6];
           int j1 = 0;
           for (Element id : spns_covd){
               j1++;
               cov_dd[j1] = id.text();
           }
           
        //Kabar.kg
            String url_sport = "http://kabar.kg/";
           Document document_sport = Jsoup.connect(url_sport).get();
           
           org.jsoup.select.Elements All_sport = document_sport.select("h3.news-title>a");
          String kabar = "";
          int cnt = 0;
          for (Element ids:All_sport){
              cnt++;
              String links = ids.attr("href");
              String txt = ids.text();
              kabar = kabar+txt;
              kabar = kabar+"\n";
              kabar = kabar+("http://kabar.kg/"+links);
              kabar = kabar+"\n";
              kabar = kabar+"\n";
              if (cnt == 6)
                  break;
          }
        
         //Main Jframe   
                   
        NewJFrame  main_window = new NewJFrame();
        main_window.setVisible(true);
        main_window.setTitle("Bishkek"); 
       
        //weather data
        NewJFrame.wth1=temp_now;
        NewJFrame.wth2=wth_d[1];
        NewJFrame.wth3=wth_d[2];
        NewJFrame.wth4=wth_d[3];
        NewJFrame.wth5=wth_d[4];
        NewJFrame.wth6=wth_d[5];
        
        //covid data KGZ
        NewJFrame.kg_cs = cov_d[1];
        NewJFrame.kg_des = cov_d[2];
        NewJFrame.kg_rec= cov_d[3];
        
        //covid data WORLD
        NewJFrame.word_cs=cov_dd[1];
        NewJFrame.word_des=cov_dd[2];
        NewJFrame.word_rec=cov_dd[3];
        
        //kabar kg 
        
        main_window.jTextArea1.setText(kabar);
    }
}
