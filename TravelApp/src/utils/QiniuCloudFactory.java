package utils;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuCloudFactory {

	//设置好账号的 七牛的ACCESS_KEY和SECRET_KEY
	private final static String ACCESS_KEY = "7liTTSbPN-8HBZh1jU9-Ovs-DBDrP0i9xOxwqayG";
	private final static String SECRET_KEY = "jDYhEHRImWAmVFeFRHGn34ZuQS0CPI6quyDWa_5Q";

	// 构造私有空间需要生成的下载的链接
	private static String url = "http://obdwmygqa.bkt.clouddn.com/";

	// 密钥配置
	private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	public static Auth getAuth() {
		return auth;
	}

	public static String getUrl() {
		return url;
	}
	
	//下载
	public static class Download {
		// 密钥配置
		Auth auth = getAuth();
		// 构造私有空间需要生成的下载的链接
		String URL = getUrl();

		public String download(String target) {
			URL = URL + target;
			//调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
			String downloadRUL = auth.privateDownloadUrl(URL, 3600);
			return downloadRUL;
		}
	}
	
	public class Upload {
		// 要上传的空间
		private String bucketname;
		// 上传到七牛后保存的文件名
		private String key;
		// 上传文件的路径
		private String filePath;
		
		public Upload(String bucketname,String key,String filePath) {
			this.bucketname = bucketname;
			this.key = key;
			this.filePath = filePath;
		}
		
		
		Auth auth = getAuth();
		// 创建上传对象
		UploadManager uploadManager = new UploadManager();
		
		// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
		public String getUpToken() {
			//获取token
			return auth.uploadToken(bucketname);
		}

		
		public void upload() throws IOException {
			try {
				// 调用put方法上传
				Response res = uploadManager.put(filePath, key, getUpToken());
				// 打印返回的信息
				System.out.println(res.bodyString());
			} catch (QiniuException e) {
				Response r = e.response;
				// 请求失败时打印的异常的信息
				System.out.println(r.toString());
				try {
					// 响应的文本信息
					System.out.println(r.bodyString());
				} catch (QiniuException e1) {
					// ignore
				}
			}
		}
	}

}
