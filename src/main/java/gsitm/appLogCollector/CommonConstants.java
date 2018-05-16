package gsitm.appLogCollector;

import org.springframework.beans.factory.annotation.Value;

public class CommonConstants {

	//  로그 파일 위치
	@Value("${log.path}")
	public final static String LOG_PATH = "";
	@Value("${data.type.normal}")
	public static String DATA_TYPE_NORMAL = "";
	@Value("${data.type.json}")
	public static String DATA_TYPE_JSON = "";
	@Value("${data.type.xml}")
	public static String DATA_TYPE_XML = "";
}
