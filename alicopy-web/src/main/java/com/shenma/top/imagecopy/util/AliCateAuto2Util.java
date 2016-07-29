package com.shenma.top.imagecopy.util;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.shenma.top.imagecopy.util.exception.BusinessException;



public class AliCateAuto2Util {
	/*
	 * 
	 */
	public static long startTime=System.currentTimeMillis();
	public static Integer num=0;
	protected static Logger logger = Logger.getLogger("HttpClientAliUtil");
	private static HttpClient httpclient=null;

	public static String cookieValue="	ali_beacon_id=117.136.13.51.1457585905626.827514.9; cna=8exnDyQO7nkCAXWIDTN2nPq1; l=AicnCMmBx6GA5dMpNMfk77pal1HxrPuO; alicnweb=touch_tb_at%3D1468626751979%7Clastlogonid%3Dkongjishisecom%7Cshow_inter_tips%3Dfalse; __last_loginid__=kongjishisecom; ali_apache_track=\"c_ms=1|c_mt=3|c_mid=b2b-2135715960|c_lid=kongjishisecom\"; _cn_slid_=\"m0Ql%2BnA5vS\"; last_mid=b2b-2135715960; __utma=62251820.1445308915.1457746361.1467823536.1468535580.27; __utmz=62251820.1468535580.27.19.utmcsr=fuwu.1688.com|utmccn=(referral)|utmcmd=referral|utmcct=/; ali_ab=115.219.33.106.1457795959128.4; ad_prefer=\"2016/04/01 09:34:44\"; h_keys=\"%u963f%u91cc%u5df4%u5df4%u5206%u9500%u5e73%u53f0#%u513f%u7ae5%u5957%u4ef6#%u8fde%u8863%u88d9#%u7eaf%u68c9T%u6064\"; isg=AqOjluGa8AMWHrzD8IFFiEyTMecmnzfaTbemDdUA-oJ5FMM2XWjHKoGEeGvK; JSESSIONID=8L78onQv1-RZ1W96abSadkLjdTj7-0GcR4rP-FPR2; _tmp_ck_0=\"5mJ3TrvnyLjQHYMDjRSIK4PCr7T2%2BudNPrZTafyVKOhXiDh8DJA1Emu6h2ohk6Sf30K%2Fo087k1L%2BRX8O5T7tmrxpDrCKPp%2BkCpJUjNciwWlfXHKsNLsl0UCaozkuP2L7dokkEG0AZGZWty%2BvC5CtDmH25%2BlvxuI468amkc5CEPlqo5IJRVS7tB8Rxo6Uh6d1GOE9m0Jg%2Bn%2BteR8e801imxq33YMxYX2bNHtRr3ylq2yGJ6wuDbS7m1o4F9h3Y3zjuUU6sIjxANE%2BivePUTBCRveB2xAy5p1GftOR16l0sYzIhBl1nxjmt1bqzk8UQ15vNL8fBWvuvG%2B8uQOljfjLupV8WK8po53vVfUWpThEjhuS8KaK9WzwYiS4bp6USxjBrowCr5ueuTl5sMHJLZG7hio5lDBfSUG6v0iVL5z26P8%2BzTrgEARHBlphiDJ%2BXbT0xJNzovs9bfkDyg9axLVmuF%2FhYh8hEHWtt0Z1bBoZ8FJNlJFV3QpZRDzfzOHTtUZunmBiS%2BFwF6gFvfTaNzRx3jMpntXOOsI2M4d1H3GIpUWmqGRF13xvmA%3D%3D\"; __cn_logon__=true; __cn_logon_id__=kongjishisecom; ali_apache_tracktmp=\"c_w_signed=Y\"; cn_tmp=\"Z28mC+GqtZ0s9gBWlWQ3oKZL3kJv01YZSxJPP0Npl7CGE5apwtkL/+GRO3vYOWrhXTlTpK2rvHq9O1LOIA7AF0VQnm8BOn6TYciFdJeruvho37SDvi8njfBVVLa1UwXV1W4zF07I1zqQhCoiyXfMzXof3FBIbH/enXQg5oBi3Niutne6Zc0Eg7W/DrZk0aHb/gVejRhuKY6fYdmUVtk7uNirAZdKH6b5B1lCwyDIXDyVUF8QSRPuYUZuPZVsv+Ur\"; _nk_=\"4XqXIR1qHwaJZNpI%2BUE0Kw%3D%3D\"; tbsnid=Pg3ayIcGBCvxd23zCKh3RYqAEcB7%2F97%2FGCWv2BcX6v06sOlEpJKl9g%3D%3D; LoginUmid=\"5bKWLcinI%2B2job4ZN69p4qItjQR8EGTsNgTc5BFMqKO%2BkczvUn3C%2FQ%3D%3D\"; userID=\"TXCwIFJjO7nDcjS6V3o2J0nzxCTzjlzdJ4zVn7jahM86sOlEpJKl9g%3D%3D\"; unb=2135715960; userIDNum=\"Q66meEyBOf1nhRthAUduHA%3D%3D\"; login=\"kFeyVBJLQQI%3D\"; _csrf_token=1468626661534; _is_show_loginId_change_block_=b2b-2135715960_false; _show_force_unbind_div_=b2b-2135715960_false; _show_sys_unbind_div_=b2b-2135715960_false; _show_user_unbind_div_=b2b-2135715960_false; __rn_alert__=false";

	public static String csrf_token="24f108dc827a98b19be3cc6743eb59c6";

	public static HttpClient getHttpClient(){
		if(httpclient==null){
			HttpState initialState = new HttpState();

		    Cookie mycookie = new Cookie(".1688.com", "mycookie", "stuff", "/", null, false);
		    mycookie.setValue(cookieValue);
		    initialState.addCookie(mycookie);
	
		    // Get HTTP client instance
		    httpclient = new HttpClient();
		    httpclient.getHttpConnectionManager().
		        getParams().setConnectionTimeout(30000);
		    httpclient.setState(initialState);
	
		}
	    return httpclient;
	}
	
	@SuppressWarnings("unchecked")
	public static synchronized String getSkuInfo(Integer topCategoryId,Integer secondCategoryId,Integer thirdCategoryId,Integer tradeType) throws InterruptedException{
		if(httpclient==null)getHttpClient();
		long endTime=System.currentTimeMillis();
		if(endTime-startTime>100){
			
		}else{
			//Thread.sleep(80);
		}
		startTime=endTime;
		num++;
		String cateURL="http://offer.1688.com/offer/post/fill_product_info.htm";
		PostMethod httppost=new PostMethod(cateURL);
		NameValuePair token   = new NameValuePair("_csrf_token", csrf_token);
        NameValuePair catType      = new NameValuePair("catType", "0");
        NameValuePair currentPage   = new NameValuePair("currentPage", "chooseCategory");
        NameValuePair fromWhere = new NameValuePair("fromWhere", "normal");
        NameValuePair operator = new NameValuePair("operator", "new");
        NameValuePair price = new NameValuePair("price", "0.0");
        NameValuePair topCategoryIdNP = new NameValuePair("topCategoryId", topCategoryId.toString());
        NameValuePair secondCategoryIdNP = new NameValuePair("secondCategoryId", secondCategoryId.toString());
        NameValuePair tradeTypeN = new NameValuePair("tradeType", tradeType.toString());
        NameValuePair thirdCategoryIdN = new NameValuePair("thirdCategoryId", thirdCategoryId==null?"":thirdCategoryId.toString());
        NameValuePair[] params=null;
        if(thirdCategoryId==null){
        	params=new NameValuePair[] {token, catType, currentPage, fromWhere,operator,price,topCategoryIdNP,secondCategoryIdNP,tradeTypeN};
        }else{
        	params=new NameValuePair[] {token, catType, currentPage, fromWhere,operator,price,topCategoryIdNP,secondCategoryIdNP,tradeTypeN,thirdCategoryIdN};
        }
        httppost.setRequestBody(params);

        String body=null;
        try {
			httpclient.executeMethod(httppost);
			body=httppost.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error(e);
		} finally{
			 httppost.releaseConnection();
		}
        Document doc=Jsoup.parse(body);
        String properties=doc.select("#properties").attr("data-mod-config");
        if(properties==null)throw new BusinessException();
        //System.out.println(properties);
       
        return properties;

	}
	public static void main(String[] args) {
		AliCateAuto2Util.getHttpClient();
		//AliCateAuto2Util.getSkuInfo("4","422",null,"1");
	}
}
