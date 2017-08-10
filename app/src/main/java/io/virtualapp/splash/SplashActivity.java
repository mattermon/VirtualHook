package io.virtualapp.splash;

import android.os.Bundle;
import android.view.WindowManager;

import com.lody.virtual.GmsSupport;
import com.lody.virtual.client.core.VirtualCore;

import io.virtualhook.R;
import io.virtualapp.VCommends;
import io.virtualapp.abs.ui.VActivity;
import io.virtualapp.abs.ui.VUiKit;
import io.virtualapp.home.HomeActivity;
import jonathanfinerty.once.Once;

public class SplashActivity extends VActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        @SuppressWarnings("unused")
        boolean enterGuide = !Once.beenDone(Once.THIS_APP_INSTALL, VCommends.TAG_NEW_VERSION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        showBanner();
        VUiKit.defer().when(() -> {
            long time = System.currentTimeMillis();
            doActionInThread();
            time = System.currentTimeMillis() - time;
            long delta = 1000L - time;
            if (delta > 0) {
                VUiKit.sleep(delta);
            }
        }).done((res) -> {
            HomeActivity.goHome(this);
            finish();
        });
    }

    private void showBanner() {

    }

    private void doActionInThread() {
        if (!VirtualCore.get().isEngineLaunched()) {
            VirtualCore.get().waitForEngine();
        }
    }
}
