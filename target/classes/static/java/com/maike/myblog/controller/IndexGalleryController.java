package com.maike.myblog.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maike.myblog.entity.IndexGallery;
import com.maike.myblog.utils.FileNameUtils;
import com.maike.myblog.utils.MyException;
import com.maike.myblog.utils.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-01
 */
@RestController
//@RequestMapping("/index-gallery")
public class IndexGalleryController extends BaseController{
	@RequestMapping(value="/backManage/indexGallery/getAllGallery")
	public Result getAllGallery() {
		List<IndexGallery> gallery=galleryService.selectAllGallery();
		if(gallery!=null) {
			Integer count=galleryService.count();
			return Result.success(0,count,gallery);	
		}
		return Result.error("没有数据请添加!");
	}
	@RequestMapping(value="/backManage/indexGallery/insertOneGallery")
	public Result insertOneGallery(@RequestBody IndexGallery gallery,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("imgFile") MultipartFile multipartFile) throws IllegalStateException, IOException {
		String filePath = "/sourceFile/indexSliderPicture/";//request.getServletContext().getRealPath("/")/ridersFile/userpic/
		String localpath="/Volumes/MacFile/WorkSpace/SpringBootTestFile/imageFile/userpic/";//System.getProperty("user.dir")+"/src/main/resources/static/uploadFile";
		//int flag=galleryService.insertOneGallery(gallery);
//		if(flag>0) {
//			return Result.success("添加成功!");	
//		}
//		return Result.error("添加失败!");
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
		System.out.println("pngjpgjpegJPGPNGJPEG".contains(fileType));
		if("pngjpgjpegJPGPNGJPEG".contains(fileType)) {
			String originalFileName="indexGallery"+FileNameUtils.getFileName(multipartFile.getOriginalFilename());
			File tmpFile = new File(localpath);
			//判断是否存在该文件夹，若不存在则创建文件夹
			if(!tmpFile.exists()){
				tmpFile.mkdir();
			}
			File file = new File(localpath, originalFileName);
			//String fileName = file.toString();
			//for(MultipartFile file:files){
			multipartFile.transferTo(file);
			//if(Base64ImageUtils.imgsaveToFile(imagebyte, fileName)) {
			//for(MultipartFile file:files){
			//files.transferTo(new File(filePath+files.getOriginalFilename()));
			System.out.println(originalFileName);
			System.out.println(file.getAbsolutePath());
			gallery.setSliderImg(filePath+originalFileName);
			//}
			if(galleryService.insertOneGallery(gallery)>0) {
				return Result.success(true);
			}
			}else {
			    return Result.error("文件格式不是图片！");
			}
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
		    MyException exception=new MyException("没有完成！发生异常！");
		return Result.error(exception);
	}
	@RequestMapping(value="/backManage/indexGallery/deleteOneGallery")
	public Result deleteOneGallery(@RequestParam("id") int id) {
		int flag=galleryService.deleteOneGallery(id);
		if(flag>0) {
			return Result.success("删除成功!");	
		}
		return Result.error("删除失败!");
	}
	@RequestMapping(value="/backManage/indexGallery/updateOneGallery")
	public Result updateOneGallery(@RequestBody IndexGallery gallery) {
		int flag=galleryService.updateOneGallery(gallery);
		if(flag>0) {
			return Result.success("更新成功!");	
		}
		return Result.error("更新失败!");
	}
	@RequestMapping(value="/blog/indexGallery/allIndexGallery")
	public Result blogIndexGallery() {
		List<IndexGallery> list=galleryService.blogIndexGallery();
		return Result.success(list);
	}
}
