package chinaPress.common.face;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.facebody.model.v20191230.CompareFaceRequest;
import com.aliyuncs.facebody.model.v20191230.CompareFaceResponse;
import com.aliyuncs.facebody.model.v20191230.CompareFaceResponse.Data;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;

public class CompareFace {

	private static final String ACCESS_KEY_ID = "L111TAI4G7RC4sWCXBHCqojCLE2";

	private static final String ACCESS_KEY_SECRET = "kqi89kEa4MXX1bVP9obAlNePAGvKvx";

	public static Result compareFace(String imageURLA, String imageURLB) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
		IAcsClient client = new DefaultAcsClient(profile);

		CompareFaceRequest request = new CompareFaceRequest();
		request.setRegionId("cn-shanghai");
		request.setImageURLA(imageURLA);
		request.setImageURLB(imageURLB);

		try {
			CompareFaceResponse response = client.getAcsResponse(request);
			System.out.println(new Gson().toJson(response));
			Data data = response.getData();
			// 相似度 1 ~ 100
			Float confidence = data.getConfidence();
			if (confidence > 80) {
				return ResultUtil.custom(0, "匹配成功");
			} else {
				return ResultUtil.custom(-1, "匹配失败");
			}

		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
			return ResultUtil.custom(-4, "异常", e);
		}
	}

	public static void main(String[] args) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
		IAcsClient client = new DefaultAcsClient(profile);

		CompareFaceRequest request = new CompareFaceRequest();
		request.setRegionId("cn-shanghai");
		request.setImageURLA(
				"http://explorer-image.oss-cn-shanghai.aliyuncs.com/1455274160764180/photo.jpg?OSSAccessKeyId=LTAI4Fk9FstqSEYnqKJ5Dpeo&Expires=1599030793&Signature=Ficenx7Le4RHFqfya2W%2FvylRIk4%3D");
		request.setImageURLB(
				"http://explorer-image.oss-cn-shanghai.aliyuncs.com/1455274160764180/photo.jpg?OSSAccessKeyId=LTAI4Fk9FstqSEYnqKJ5Dpeo&Expires=1599030016&Signature=BXKgHs6Lqi5o84YQqJn58SM3pDA%3D");

		try {
			CompareFaceResponse response = client.getAcsResponse(request);
			System.out.println(new Gson().toJson(response));
		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
		}
	}

}
