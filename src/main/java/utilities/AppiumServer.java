package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.net.URL;


public class AppiumServer {
    static AppiumDriverLocalService server;
    static AppiumServiceBuilder builder;

    public static  URL url;



    static void setInstance(){
        builder = new AppiumServiceBuilder ();
        //builder.withCapabilities (cap);
        builder.withArgument (GeneralServerFlag.LOCAL_TIMEZONE);
       // builder.withArgument (GeneralServerFlag.USE_PLUGINS,"pluginName");  **Start Appium with plugins**
        server = AppiumDriverLocalService.buildService(builder);
//        server.start();

    }
    static AppiumDriverLocalService getInstance(){
        if(server == null) setInstance ();
        return server;
    }

    public static void start(){
        getInstance ().start ();
        if(server.isRunning ()){
            System.out.println ("Server is running...");
            System.out.println ("Server is running in : "+server.getUrl ());
            url = server.getUrl ();
        }
    }
    public static URL getUrl(){
        return server.getUrl ();
    }
    public static void stop(){
        if(server != null){
            System.out.println ("Appium server is stopped!");
            server.stop ();

        }
    }


}
