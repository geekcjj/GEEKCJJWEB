package com.maike.myblog.controller.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maike.myblog.controller.BaseController;
import com.maike.myblog.entity.ArticlesLife;
import com.maike.myblog.utils.FileNameUtils;
import com.maike.myblog.utils.MyException;
import com.maike.myblog.utils.Result;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/articlesLife")
public class ArticlesLifeController extends BaseController {
	@RequestMapping("/admin/uploadAboutMePic")
	public Result uploadAboutMePic(@RequestParam("aboutMePic") MultipartFile multipartFile, HttpServletRequest request,HttpServletResponse response) {
		//ArticlesLife aboutUs=new ArticlesLife();
		//String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		//String path = ResourceUtils.getURL("classpath:").getPath();
		String filePath = "http://127.0.0.1:8090/uploadFile/userPic/";//request.getServletContext().getRealPath("/")/ridersFile/userpic/
		String localpath="/Volumes/MacFile/myWorkSpace/SpringBootTestFile/aboutUs/pic/";//System.getProperty("user.dir")+"/src/main/resources/static/uploadFile";
		// 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
		// 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
		//String localpath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
		//String filename=System.currentTimeMillis()+"";
		//TODO 判断文件格式是不是图片
        String contentType = multipartFile.getContentType();
        int index=contentType.indexOf('/');
        String fileType=contentType.substring(index+1);
        System.out.println("获取上传的文件名："+multipartFile.getOriginalFilename()+"文件的类型："+fileType);
        //byte[] imagebyte=Base64ImageUtils.base64ToByte(base64str, filePath, filename);
        System.out.println("pngjpgjpeggifJPGPNGJPEGGIF".contains(fileType));
        String picUrl=null;
        if("pngjpgjpegJPGPNGJPEG".contains(fileType)) {
        	String originalFileName="aboutMe"+FileNameUtils.getFileName(multipartFile.getOriginalFilename());
			File tmpFile = new File(localpath);
			//判断是否存在该文件夹，若不存在则创建文件夹
			if(!tmpFile.exists()){
				tmpFile.mkdir();
			}
			File file = new File(localpath, originalFileName);
	        //String fileName = file.toString();
	      //for(MultipartFile file:files){
	        try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //if(Base64ImageUtils.imgsaveToFile(imagebyte, fileName)) {
			//for(MultipartFile file:files){
			//files.transferTo(new File(filePath+files.getOriginalFilename()));
	        System.out.println(originalFileName);
	        System.out.println(file.getAbsolutePath());
	        picUrl=filePath+originalFileName;
			}
			// if(deliveryRidersService.addPerfectRder(riders)>0) {
			// 	return Result.success(true);
			// }
	        // }else {
	        // 	return Result.error("文件格式不是图片！");
	        // }
//			if(deliveryRidersService.getOne(new QueryWrapper<DeliveryRiders>().eq("phone", riders.getPhone())) != null) {
//				return Result.error(ResultEnum.USER_IS_EXISTS.getCode(),ResultEnum.USER_IS_EXISTS.getMsg());
//			}else if(deliveryRidersService.addPerfectRder(riders)>0){
//				//int flag=deliveryRidersService.riderRegister(deliveryRiders);
//				return Result.success(true);
//			}
        //}else {
        	//MyException exception=new MyException("文件类型错误！");
    		//return Result.error("文件类型错误！");
        //}
        //MyException exception=new MyException("没有完成！发生异常！");
		return Result.success(picUrl);
	}
}
