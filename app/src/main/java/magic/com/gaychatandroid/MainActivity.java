package magic.com.gaychatandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import magic.com.gaychatandroid.fragment.LoginFragment;
import magic.com.gaychatandroid.tool.Factory;
import magic.com.gaychatandroid.tool.Model;

public class MainActivity extends AppCompatActivity {

    private Factory factory;
    private Model controlModel;
    private LoginFragment loginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createObj();
        setLoginFragment();
        controlModel.logSystemInfoDB();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controlModel.closeDB();
    }

    private void createObj() {
        factory = new Factory();
        controlModel = factory.createModel(this);
        loginFragment=factory.createLoginFragment();
    }


    private void setLoginFragment() {
//        bundle.putExtra(Constants.CONTROL_MODEL, controlModel);
//        getIntent()..putExtra(Constants.CONTROL_MODEL, controlModel);
        controlModel.changeFragment(getFragmentManager(), R.id.content_main, loginFragment);
    }
}
