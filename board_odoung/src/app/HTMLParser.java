package app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.DBConn;

public class HTMLParser {
    public static void main(String[] args) throws Exception {
        Connection conn = Jsoup.connect("https://www.goodchoice.kr/product/search/3");
        Document doc = conn.get();
        Elements elements = doc.select(".list_2");
        for(int i = 0; i < 20 ; i++) {
			Element el = elements.get(i);
//			System.out.println(el);
			String no = el.getElementsByTag("a").attr("data-ano");
			System.out.println("번호 : " + no);
			
			Element el2 = el.select(".name").get(0);
				
			String title = el2.selectFirst("strong").text();
			System.out.println("펜션이름 : " + title);
			
			String around = el2.select("p").get(1).text();
			System.out.println("주변지역 : " + around);
			
			String price1= el.select(".map_html").select("em").html();
			System.out.println("이전 가격 : " +price1+"원");
			String price= el.select(".map_html").select("b").html();
			System.out.println("가격 : " +price);
			
			String link = el.getElementsByTag("a").attr("href");
			System.out.println(link);
			
//			Element pic=el.selectFirst(".pic img");
//			System.out.println(pic);
			Document doc2 = Jsoup.connect(link).get();
			Elements el3 = doc2.select(".swiper-slide");
			for (int j = 0; j < 10; j++) {
				Element eximg= el3.select(".swiper-lazy").get(j);
				String img = eximg.attr("data-src");
				System.out.println(img);
			}
			String address = doc2.select(".address").text();
			System.out.println("주소" +address);
			
			String comment = doc2.select(".comment div").text();
			System.out.println("사장님 한 마디" +comment);
			
			String price2 = doc2.select(".price").select("p").text();
			System.out.println(price2);
			
			
			Elements el4= doc2.select(".gallery_m");
			for (int j = 0; j < el4.size(); j++) {
				Element eximg2 = el4.get(j);
				String test = eximg2.select(".owl-lazy").attr("data-src");
//				System.out.println(test);
			}
			Elements title2 = doc2.select("#review");
//			System.out.println(title2);
			
			Elements el5=doc2.select(".service");
			String pickup=	el5.select(".theme_62").text().equals("") ? "" : "1";
			System.out.println("픽업 가능 여부 : "+pickup);
			String cooking=	el5.select(".theme_237").text().equals("") ? "" : "1";
			System.out.println("취사 가능 여부 : "+cooking);
			String BREAKFAST=	el5.select(".theme_208").text().equals("") ? "" : "1";
			System.out.println("조식 포함 여부 : "+BREAKFAST);
			String FREE_PARKING=	el5.select(".theme_147").text().equals("") ? "" : "1";
			System.out.println("주차 가능 여부 : "+FREE_PARKING);
			String CAMPFIRE=	el5.select(".theme_330").text().equals("") ? "" : "1";
			System.out.println("캠프파이어 가능 여부 : "+CAMPFIRE);
			
//        for(int i = 0; i < elements.size(); i++) {
//            Element el = elements.get(i);
////            System.out.println(el);
//            String no = el.attr("data-no");
////            System.out.println(no);
//            String info = el.selectFirst(".list_info").text();
//            String title = el.selectFirst(".item_title").text();
////            System.out.println(title);
//            String price = el.selectFirst(".price").text();
//            String link = el.selectFirst(".list_info a").attr("href");
//            Element img = el.selectFirst(".list_img img");
            
//            Map<String, String> map = new HashMap<>();
//            map.put("no",no);
//            map.put("title",title);
//            map.put("info",info);
//            map.put("price",price);
//            map.put("link",link);
////            System.out.println(map);
//            saveDB(map);
//            saveFile(no, img.attr("data-original"));
            System.out.println(no + "번 작업 완료");
        }
    }
    
//    static void saveFile(String no, String imgSrc) throws Exception {
//          URL url = new URL(imgSrc);
//          BufferedReader bis = new BufferedReader(new InputStreamReader(url.openStream()));
//          File file = new File("D:\\mu",no);
//          if(!file.exists()) {
//        	  file.mkdirs();
//          }
//          file =new File(file,"thumb.jpg");
//          BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
//          
//
//          int b = 0;
//          while((b = bis.read()) != -1) {
//              bos.write(b);
//          }
//          bos.close();
//    }
    static void saveDB(Map<String, String> map) throws Exception{
    	java.sql.Connection conn = DBConn.getConnection();
    	PreparedStatement pstmt = DBConn.getConnection().prepareStatement(
    			"INSERT INTO TBL_OTHER VALUES(?,?,?,?,?)");
    	pstmt.setString(1, map.get("no"));
    	pstmt.setString(2, map.get("title"));
    	pstmt.setString(3, map.get("info"));
    	pstmt.setString(4, map.get("price"));
    	pstmt.setString(5, map.get("link"));
    	pstmt.executeUpdate();
    	pstmt.close();
    }
}