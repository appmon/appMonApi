package gsitm.appLogCollector.service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import gsitm.appLogCollector.CommonConstants;

@Service
public class LogWriteServiceImpl implements LogWriteService {
	
	public void logWrite(Object data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String msg = mapper.writeValueAsString(data);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			String date = sdf.format(new Date());
			
			PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\admin\\Documents\\testLog\\" + date + ".txt", true));
			pw.write(msg.toString());
			pw.write("\n");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void logWrite(String dataType, Object data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String msg = mapper.writeValueAsString(data);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			String date = sdf.format(new Date());
			String appGubun = "";

			try {
				if(CommonConstants.DATA_TYPE_JSON.equals(dataType)) {
					JSONObject obj = new JSONObject(msg);
					appGubun = obj.has("app_gubun") ? "" : obj.get("app_gubun").toString();
				} else if (CommonConstants.DATA_TYPE_NORMAL.equals(dataType)) {
					HashMap<String, String> map = (HashMap<String, String>)data;
					appGubun = map.get("app_gubun") != null ? map.get("app_gubun") : "";
				} else if (CommonConstants.DATA_TYPE_XML.equals(dataType)) {
					// 미구현
				}
			} catch(Exception e) {
				System.out.println("###ERROR:ABOUT parsing app_gubun: " + e.toString());
				appGubun = "";
			}
			
			if(null == appGubun || "".equals(appGubun)) {
				logWrite(data);
			} else {
				String filePath = CommonConstants.LOG_PATH + appGubun + "/";
				//String filePath = "C:\\Users\\admin\\Documents\\testLog\\" + appGubun + "\\"; 	// local
	
				File f = new File(filePath);
				if (!f.isDirectory()) {
					f.mkdirs();
				}
				
				PrintWriter pw = new PrintWriter(new FileWriter(filePath + appGubun + "_" + date + ".txt", true));
				pw.write(msg.toString());
				pw.write("\n");
				pw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




