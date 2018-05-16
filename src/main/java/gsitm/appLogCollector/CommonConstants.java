package gsitm.appLogCollector;

import org.springframework.beans.factory.annotation.Value;

public class CommonConstants {

	//  로그 파일 위치
	//@Value("${log.path}")
	public final static String LOG_PATH = "/app/appmon/was/appmon_api/logs/appLogs/";
	//@Value("${data.type.normal}")
	public static String DATA_TYPE_NORMAL = "normal";
	//@Value("${data.type.json}")
	public static String DATA_TYPE_JSON = "json";
	//@Value("${data.type.xml}")
	public static String DATA_TYPE_XML = "xml";
}
