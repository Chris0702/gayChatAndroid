package magic.com.gaychatandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import magic.com.gaychatandroid.R;
import magic.com.gaychatandroid.define.Constants;
import magic.com.gaychatandroid.tool.Factory;
import magic.com.gaychatandroid.tool.HttpClient;
import magic.com.gaychatandroid.tool.Model;

/**
 * Created by DX on 2017/4/16.
 */

public class LoginFragment  extends ControlFragment {
    HttpClient httpClient;
    private Button startChatButton;
    private Button configButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.login_fragment, container, false);
        createObj(returnView);
        setListener();
        autoLogin();
        return returnView;
    }



    private void createObj(View view) {
        factory = new Factory();
        controlActivity = getActivity();
        controlModel = factory.createModel(controlActivity);
        startChatButton= (Button) view.findViewById(R.id.start_chat_button);
        configButton=(Button) view.findViewById(R.id.config_button);
        httpClient = factory.createHttpClient();

    }

    private void setListener() {
        buttonClick();
    }

    private void autoLogin() {
        if (controlModel.isLogin()) {
            controlModel.toastString("現在開始嘗試自動登入", controlActivity);
//            loginRequest();
        } else {
            controlModel.toastString("請手動登入", controlActivity);
        }
    }

    private void buttonClick() {
        startChatButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                controlModel.toastString("startChatButton", controlActivity);
            }
        });

        configButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                controlModel.toastString("configButton", controlActivity);
            }
        });
    }

//    private void loginRequest() {
//        if (!username.equals(Constants.ENPTY_STRING) && !password.equals(Constants.ENPTY_STRING)) {
//            httpClient.login(username, password, this);
//        } else {
//            controlModel.toastString(Constants.INPUT_ERROR_ACCOUNT, controlActivity);
//        }
//    }
//
//    public void loginResponse(String receiveMessage) {
//        Log.d("debug", " loginResponse    receiveMessage    " + receiveMessage);
//        if (controlModel.getHttpResult(receiveMessage)) {
//            controlModel.toastString("登入成功", controlActivity);
//            loginSuccess();
//        } else {
//            resolveLoginErrorResString(receiveMessage);
//        }
//    }
//
//    private void loginSuccess() {
//        SearchFriendFragment searchFriendFragment = factory.createSearchFriendFragment();
//        controlModel.saveLoginAccount(username, password);
//        controlModel.changeFragment(getFragmentManager(), R.id.content_main, searchFriendFragment);
//    }
//
//    private void resolveLoginErrorResString(String receiveMessage) {
//        String resString = controlModel.getJSONProtString(Constants.RES_STRING_REST_API, receiveMessage);
//        if (resString.equals(Constants.INPUT_ERROR_ACCOUNT_RES_STRING)) {
//            controlModel.toastString(Constants.INPUT_ERROR_ACCOUNT, controlActivity);
//        } else if (resString.equals(Constants.USERNAME_ERROR_ACCOUNT_RES_STRING)) {
//            controlModel.toastString(Constants.USERNAME_ERROR_ACCOUNT, controlActivity);
//        } else if (resString.equals(Constants.PASSWORD_ERROR_ACCOUNT_RES_STRING)) {
//            controlModel.toastString(Constants.PASSWORD_ERROR_ACCOUNT, controlActivity);
//        }
//    }
}
