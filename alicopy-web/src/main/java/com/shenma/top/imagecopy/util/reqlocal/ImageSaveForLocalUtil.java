package com.shenma.top.imagecopy.util.reqlocal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shenma.aliutil.exception.AliReqException;
import com.shenma.aliutil.service.AlbumService;
import com.shenma.aliutil.util.AliConstant;
import com.shenma.top.imagecopy.util.image.ImageSaveManager;

@Component
public class ImageSaveForLocalUtil {
	protected static Logger logger = Logger.getLogger("ImageSaveForLocalUtil");
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AliConstant aliConstant;
	public Map<String,Object> saveImage(String url,String albumId,String name,String description) throws  AliReqException{
		Map<String, Object> ret=new HashMap<String,Object>(2);
		if(url.endsWith("startFlag.gif")||url.endsWith("endFlag.gif")){
			ret.put("newUrl", url);
			return ret;
		}
		logger.error(url);
		byte[] imgByte = null;
		try {
			imgByte = ImageSaveManager.reqImage(url).getData();
		} catch (Exception e) {
			logger.error("图片地址不存在url:" + url);
			ret.put("newUrl", url);
			return ret;
		}
		if (imgByte == null || imgByte.length == 0)	{
			logger.error("图片地址不存在url:" + url);
			ret.put("newUrl", url);
			return ret;
		}
			
		long maxSize = (2 << 16) * 30;
		if (imgByte.length > maxSize) {
			logger.error("文件超过3M:" + url);
			ret.put("newUrl", url);
			return ret;
		}
		Map<String, Object> bean = null;
		try {
			bean =albumService.uploadImage(albumId,name, description, imgByte);
		} catch (AliReqException e) {
			if(e.getCode().equals("090008")){
				ret.put("newUrl", url);
				return ret;
			}else{
				throw e;
			}
		}
		Map<String, Object> result = (Map<String, Object>) bean.get("result");
		List<Map<String, Object>> rtlist = (List<Map<String, Object>>) result.get("toReturn");
		String lastImageUrl = (String) rtlist.get(0).get("url");
		lastImageUrl = aliConstant.image_uri_prefix + lastImageUrl;
		ret.put("newUrl", lastImageUrl);
		return ret;
		
	}
}
