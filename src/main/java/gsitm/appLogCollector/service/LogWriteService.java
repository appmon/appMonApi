package gsitm.appLogCollector.service;

public interface LogWriteService {
	public void logWrite(Object data);
	public void logWrite(String dataType, Object data);

}
