package magic.com.gaychatandroid.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import magic.com.gaychatandroid.R;
import magic.com.gaychatandroid.tool.Factory;
import magic.com.gaychatandroid.tool.HttpClient;

/**
 * Created by DX on 2017/4/17.
 */

public class ConfigFragment extends ControlFragment {
    HttpClient httpClient;
    private Button saveConfigButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.config_fragment, container, false);
        createObj(returnView);
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
                    LoginFragment loginFragment = factory.createLoginFragment();
                    controlModel.changeFragment(getFragmentManager(), R.id.content_main, loginFragment);
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
        saveConfigButton = (Button) view.findViewById(R.id.save_config_button);
        httpClient = factory.createHttpClient();
    }

    private void setListener() {
        buttonClick();
    }

    private void buttonClick() {
        saveConfigButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                controlModel.toastString("saveConfigButton", controlActivity);
                LoginFragment loginFragment = factory.createLoginFragment();
                controlModel.changeFragment(getFragmentManager(), R.id.content_main, loginFragment);
            }
        });
    }

}
