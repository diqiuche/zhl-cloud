package net.tfedu.zhl.sso.user;

import javax.servlet.http.HttpServletRequest;

import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;
import net.tfedu.zhl.sso.user.entity.UserSimple;

/**
 * 处理用户的头像
 * 
 * @author wangwr
 *
 */
public class UserImageCheckUtil {

	public static void checkUserImage(UserSimple user, CommonWebConfig commonWebConfig, HttpServletRequest request) {
		// 如果头像不是系统头像，而是在文件服务中保存的头像的话，需要修改userimage 为 （文件服务中保存的）头像的可访问路径
		if (user.getUserImage() != null) {
			String userImage =  checkUserImage(user.getUserImage(), commonWebConfig, request);
			user.setUserImage(userImage);
		}

	}

	public static String checkUserImage(String userImage, CommonWebConfig commonWebConfig, HttpServletRequest request) {
		// 如果头像不是系统头像，而是在文件服务中保存的头像的话，需要修改userimage 为 （文件服务中保存的）头像的可访问路径
		if (userImage != null && userImage.trim().contains(ZhlResourceCenterWrap.userimage_upload_prefix)) {

			// 获取文件服务器的访问url
			String resServiceLocal = commonWebConfig.getResServiceLocal();
			String currentResPath = commonWebConfig.getCurrentResPath(request);

			String temp = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, userImage);
			temp = temp.replace(resServiceLocal, currentResPath);
			return temp;
		} else {
			return userImage;
		}
	}

}
