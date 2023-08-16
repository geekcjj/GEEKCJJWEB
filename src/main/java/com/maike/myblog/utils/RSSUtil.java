package com.maike.myblog.utils;

import com.rsslibj.elements.Channel;

/**
 * @projectname GEEKCJJWeb
 * @author GEEKCJJ
 * @date 2019年10月20日 下午11:26:15
 * @description:
 *
 */
public class RSSUtil {
	public void GenRSS() {
//		Channel channel = new Channel(); 
//		channel.setDescription(account.getDescription()); 
//		baseUrl = baseUrl.substring(0, n); 
//		channel.setLink("http://server-name/home.c?accountId=" + accountId); 
//		channel.setTitle(account.getTitle()); 
//		List articles = facade.getArticles(accountId, account.getMaxPerPage(), 1); 
//		Iterator it = articles.iterator(); 
//		while(it.hasNext()) { 
//		    Article article = (Article)it.next(); 
//		    channel.addItem("http://server-name/article.c?articleId=" + article.getArticleId(), 
//		        article.getSummary(), article.getTitle() 
//		    ); 
//		} 
//		// 输出xml: 
//		response.setContentType("text/xml"); 
//		PrintWriter pw = response.getWriter(); 
//		pw.print(channel.getFeed("rss")); 
//		pw.close();
	}

	public static void main(String[] args)
			throws InstantiationException, ClassNotFoundException, IllegalAccessException {
		Channel channel = new Channel();
		channel.setDescription("This is my sample channel.");
		channel.setLink("http://localhost/");
		channel.setTitle("My Channel");
		channel.setImage("http://localhost/", "The Channel Image", "http://localhost/foo.jpg");
		channel.setTextInput("http://localhost/search", "Search The Channel Image", "The Channel Image", "s");
		channel.addItem("http://localhost/item1", "The First Item covers details on the first item>", "The First Item")
				.setDcContributor("Joseph B. Ottinger");
		channel.addItem("http://localhost/item2", "The Second Item covers details on the second item",
				"The Second Item").setDcCreator("Jason Bell");
		System.out.println("The feed in RDF: " + channel.getFeed("rss"));
	}
}
