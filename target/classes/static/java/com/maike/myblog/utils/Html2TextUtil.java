package com.maike.myblog.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

/**
 * @projectname GEEKCJJBlog
 * @author GEEKCJJ
 * @date 2019年10月3日 下午3:23:43
 * @description:
 *
 */
public class Html2TextUtil {
	private static Html2TextUtil html2Text = new Html2TextUtil();

    StringBuffer s;

    public Html2TextUtil() {
    }

    public void parse(String str) throws IOException {

        InputStream iin = new ByteArrayInputStream(str.getBytes());
        Reader in = new InputStreamReader(iin);
        s = new StringBuffer();
        HTMLEditorKit.ParserCallback cb = new HTMLEditorKit.ParserCallback();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, cb, Boolean.TRUE);
        iin.close();
        in.close();
    }

    public void handleText(char[] text, int pos) {
        s.append(text);
    }

    public String getText() {
        return s.toString();
    }

    public static String getContent(String str) {
        try {
            html2Text.parse(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return html2Text.getText();
    }
    /**
     * 得到网页中图片的地址
     * @param sets html字符串
     */
    public static Set<String> getImgStr(String htmlStr) {
	    Set<String> pics = new HashSet<String>();
	    String img = "";
	    Pattern p_image;
	    Matcher m_image;
	    String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
	    p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
	    m_image = p_image.matcher(htmlStr);
	    if (m_image.find()) {
		     // 得到<img />数据
		     img = m_image.group();
		     // 匹配<img>中的src数据
		     Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
		     while (m.find()) {
		    	 pics.add(m.group(1));
		     }
	    }
	    return pics;
    }
    public static void main(String[] args) {
    	//第二种方法:将set集合转换成list集合 取第一个
        //List<?> list = new ArrayList<?>(set);
		System.out.println("String:"+getImgStr("<img src='/images/sffssdf.png'></img><img src='/images/ettntenegkdn.png' /><img src='/images/sfdfgdjfndfkjgndf.png' />"));
	}
}
