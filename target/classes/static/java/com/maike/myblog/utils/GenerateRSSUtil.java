package com.maike.myblog.utils;

import java.util.Iterator;
import java.util.List;

import com.rsslibj.elements.Channel;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年10月9日 下午6:04:31
 * @description:
 *
 */
public class GenerateRSSUtil {
	private static String getBlogRSS() {
		Channel channel = new Channel(); 
		channel.setDescription("本站面向全国互联网科技爱好者，是互联网信息资讯共享的友好平台，共享优质的互联网信息资讯、技术文章、源代码项目等……"); 
		//baseUrl = baseUrl.substring(0, n); 
		channel.setLink("http://server-name/home.c?accountId="); 
		channel.setTitle("梦极客园"); 
//		List<?> articles = facade.getArticles(accountId, account.getMaxPerPage(), 1);
//		Iterator<?> it = articles.iterator(); 
//		while(it.hasNext()) { 
//		    Article article = (Article)it.next(); 
//		    channel.addItem("http://server-name/article.c?articleId=" + article.getArticleId(), 
//		        article.getSummary(), article.getTitle() 
//		    ); 
//		} 
		try {
			return channel.getFeed("rss");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// 输出xml: 
//		response.setContentType("text/xml"); 
//		PrintWriter pw = response.getWriter(); 
//		pw.print(channel.getFeed("rss")); 
//		pw.close();
	}
	private static void getRSS(){
		Channel channel = new Channel();
		 
		channel.setDescription("GEEKCJJ's Blog");
		channel.setLink("http://localhost:8090/");
		channel.setTitle("My Channel");
		channel.setImage("http://localhost:8090/", "The Channel Image",
				"http://localhost:8090/images/bloglogo.png");
		channel.setTextInput("http://localhost/search",
				"Search The Channel Image", "The Channel Image", "s");
		channel.addItem("http://localhost:8090/",
				"The First Item covers details on the first item>",
				"The First Item");
		try {
			System.out.println("The feed in RSS:" + channel.getFeed("rss"));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getRSS();
	}
}
