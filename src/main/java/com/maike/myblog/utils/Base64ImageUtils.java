package com.maike.myblog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * @projectname ValidCode
 * @author GEEKCJJ
 * @date 2019年7月30日 下午3:21:58
 * @description:
 *
 */
public class Base64ImageUtils {

	private static final String PATH_PARENT = "/home/resources/base64/";

	// bitmap转为base64
	public static String picToBase64(String picpath) {

		String result = null;
		/**
		 * 安卓的处理方式
		 */
//        ByteArrayOutputStream baos = null;  
//        try {  
//            if (bitmap != null) {  
//                baos = new ByteArrayOutputStream();  
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);  
//      
//                baos.flush();  
//                baos.close();  
//      
//                byte[] bitmapBytes = baos.toByteArray();  
//                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);  
//            }  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } finally {  
//            try {  
//                if (baos != null) {  
//                    baos.flush();  
//                    baos.close();  
//                }  
//            } catch (IOException e) {  
//                e.printStackTrace();  
//            }  
//        }
		// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(picpath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
			result = Base64.encodeBase64String(data);
		} catch (IOException e) {
			result = "error";
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		// sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		// 返回Base64编码过的字节数组字符串
		// result = encoder.encode(data);
		return result;
	}

	// byte转为base64
	public static String byteToBase64(byte[] imgbyte) throws IOException {

		String result = null;
		// InputStream in = new FileInputStream(picpath);
		// data = new byte[in.available()];
		// in.read(data);
		// in.close();
		result = Base64.encodeBase64String(imgbyte);
		// 对字节数组Base64编码
		// sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		// 返回Base64编码过的字节数组字符串
		// result = encoder.encode(data);
		return result;
	}

	/**
	 * 
	 * 把base64编码转换为图片并保存
	 * 
	 * @param base64DataStr
	 * @return
	 */
	public static boolean savePicture(String base64DataStr, String path, String filename) {
		// 1.去掉base64中的前缀
		String base64Str = base64DataStr.substring(base64DataStr.indexOf(",") + 1, base64DataStr.length());
		// 获取手机相册的路径地址
//        String galleryPath= Environment.getExternalStorageDirectory()
//                + File.separator + Environment.DIRECTORY_DCIM
//                +File.separator+"Camera"+File.separator;
		// 创建文件来保存，第二个参数是文件名称，可以根据自己来命名
		if (path == null) {
			path = PATH_PARENT;
		}
		if (filename == null) {
			filename = System.currentTimeMillis() + "";
		}
		File file = new File(path, filename + ".png");
		String fileName = file.toString();
		// 3. 解析保存图片
		byte[] data = Base64.decodeBase64(base64Str);

		for (int i = 0; i < data.length; i++) {
			if (data[i] < 0) {
				data[i] += 256;
			}
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(fileName);
			os.write(data);
			os.flush();
			os.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} // finally {
			// 通知相册更新
			// Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
			// Uri uri = Uri.fromFile(file);
			// intent.setData(uri);
			// mContext.sendBroadcast(intent);

		// ToastUtils.show(mContext, "图片已保存在相册中");
		// }
		// return true;
	}

	public static byte[] base64ToByte(String base64DataStr, String path, String filename) {
		// 1.去掉base64中的前缀
		String base64Str = base64DataStr.substring(base64DataStr.indexOf(",") + 1, base64DataStr.length());
		// 获取手机相册的路径地址
//        String galleryPath= Environment.getExternalStorageDirectory()
//                + File.separator + Environment.DIRECTORY_DCIM
//                +File.separator+"Camera"+File.separator;
		// 创建文件来保存，第二个参数是文件名称，可以根据自己来命名
		if (path == null) {
			path = PATH_PARENT;
		}
		if (filename == null) {
			filename = System.currentTimeMillis() + "";
		}
		// File file = new File(path, filename + ".png");
		// String fileName = file.toString();
		// 3. 解析保存图片
		byte[] data = Base64.decodeBase64(base64Str);
		return data;
	}

	public static boolean byteSaveToFile(byte[] data, String filePath, String fileName) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 0) {
				data[i] += 256;
			}
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(filePath + fileName);
			os.write(data);
			os.flush();
			os.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(picToBase64("images/pic/1.png"));
	}
}
