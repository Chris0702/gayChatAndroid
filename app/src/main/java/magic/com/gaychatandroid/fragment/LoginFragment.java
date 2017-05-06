package magic.com.gaychatandroid.fragment;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import magic.com.gaychatandroid.R;
import magic.com.gaychatandroid.define.Constants;
import magic.com.gaychatandroid.tool.Factory;
import magic.com.gaychatandroid.tool.HttpClient;
import magic.com.gaychatandroid.tool.Model;

/**
 * Created by DX on 2017/4/16.
 */

public class LoginFragment extends ControlFragment {
    HttpClient httpClient;
    private Button startChatButton;
    private Button configButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.login_fragment, container, false);
        createObj(returnView);
        UILayoutInit();
        setListener();
        return returnView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
    }

    private void createObj(View view) {
        factory = new Factory();
        controlActivity = getActivity();
        controlModel = factory.createModel(controlActivity);
        startChatButton = (Button) view.findViewById(R.id.start_chat_button);
        configButton = (Button) view.findViewById(R.id.config_button);
        httpClient = factory.createHttpClient();
    }

    private void UILayoutInit()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        controlActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        configButton.setText("手機銀幕大小為 "+metrics.widthPixels+" X "+metrics.heightPixels);
        controlModel.toastString("手機銀幕大小為 "+metrics.widthPixels+" X "+metrics.heightPixels+"  startChatButtonX "+startChatButton.getX()+" startChatButtonY  "+startChatButton.getY(),controlActivity);
        double screenWidth=metrics.widthPixels;
        double screenHeight=metrics.heightPixels;
        controlModel.setLocateByRelativeLayout(startChatButton, (float)(screenWidth*0.32), (float)(screenHeight*0.5), (int)(screenWidth*0.37), (int)(screenHeight*0.17));
        controlModel.setLocateByRelativeLayout(configButton, (float)(screenWidth*0.22), (float)(screenHeight*0.8), (int)(screenWidth*0.53), (int)(screenHeight*0.07));
    }

    private void setListener() {
        buttonClick();
    }

    private void buttonClick() {
        startChatButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                controlModel.toastString("startChatButton", controlActivity);
                ChatTextFragment chatTextFragment = factory.createChatTextFragment();
                controlModel.changeFragment(getFragmentManager(), R.id.content_main, chatTextFragment);
            }
        });

        configButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                controlModel.toastString("configButton", controlActivity);
                ConfigFragment configFragment = factory.createConfigFragment();
                controlModel.changeFragment(getFragmentManager(), R.id.content_main, configFragment);
            }
        });
    }
}
