package services;

import java.util.HashMap;
import java.util.Map;

public class ServiceManager {
	
//	private static Map<Class,FrameService> services = new HashMap<>();
	
	private static AppService appService;
	private static PegawaiService pegawaiService;

//	public static FrameService get(Class className) {
//		if ( ! services.containsKey(className)) {
//			try {
//				services.put(
//					className, 
//					(FrameService)className.newInstance()	
//				);
//				
//			} catch (InstantiationException e) {
//				System.err.println("Can't instantiate the object.");
//			} catch (IllegalAccessException e) {
//				System.err.println("Illegal access.");
//			}
//		}
//		
//		return services.get(className);
//	}
	
	public static AppService getAppService() {
		if (appService == null) {
			appService = new AppService();
		}
		
		return appService;
	}
	
	public static PegawaiService getPegawaiService() {
		if (pegawaiService == null) {
			pegawaiService = new PegawaiService();
		}
		
		return pegawaiService;
	}
}
