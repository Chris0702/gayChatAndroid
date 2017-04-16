package magic.com.gaychatandroid.tool;

import android.app.Activity;
import android.app.Application;
import android.webkit.WebView;


import magic.com.gaychatandroid.fragment.ChatTextFragment;
import magic.com.gaychatandroid.fragment.ConfigFragment;
import magic.com.gaychatandroid.fragment.ControlFragment;
import magic.com.gaychatandroid.fragment.LoginFragment;
import magic.com.gaychatandroid.role.SystemInfo;


/**
 * Created by Chris.Wu on 2016/10/20.
 */
public class Factory {

    public LoginFragment createLoginFragment() {
        return new LoginFragment();
    }

    public ChatTextFragment createChatTextFragment() {
        return new ChatTextFragment();
    }

    public ConfigFragment createConfigFragment() {
        return new ConfigFragment();
    }

    public SystemInfo createSystemInfo() {
        return new SystemInfo();
    }

    public SystemInfo createSystemInfo(String firebaseToken) {
        return new SystemInfo(firebaseToken);
    }

    public SystemInfo createSystemInfo(int id, String firebaseToken) {
        return new SystemInfo(id, firebaseToken);
    }

    public DBConnection createDBConnection(Activity activity) {
        return new DBConnection(activity);
    }

    public DBConnection createDBConnection(Application application) {
        return new DBConnection(application);
    }


    public Model createModel(Activity activity) {
        return new Model(activity);
    }

    public Model createModel(Application application) {
        return new Model(application);
    }

    public Model createModel() {
        return new Model();
    }

    public SocketIO createSocketIO(String nameSpace) {
        return new SocketIO(nameSpace);
    }

    public HttpClient createHttpClient() {
        return new HttpClient();
    }

    public HttpClient createHttpClient(String serverToken) {
        return new HttpClient(serverToken);
    }
}
