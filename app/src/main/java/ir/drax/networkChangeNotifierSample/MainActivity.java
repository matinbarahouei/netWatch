package ir.drax.networkChangeNotifierSample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ir.drax.netwatch.NetWatch;
import ir.drax.netwatch.cb.NetworkChangeReceiver_navigator;

public class MainActivity extends AppCompatActivity implements NetworkChangeReceiver_navigator {

    TextView statusTv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTv = findViewById(R.id.liveStatus);

        NetWatch.builder(this)
                /* setIcon(R.drawable) : Sets notification icon drawable */
                .setIcon(R.drawable.ic_signal_wifi_off)
                /* .setNotificationCancelable(boolean yes) : Sets if appbar notification can be closed via swipe */
                .setNotificationCancelable(false)
                /* setCallBack(): Network interaction events will be notified using this callback */
                .setCallBack(this)
                .build();
    }


    /**
     * On connection established ..
     * @param source
     * source can be :  WIFI=1 or :MOBILE=2
     */
    @Override
    public void onConnected(int source) {
        statusTv.setText(R.string.connected);
        statusTv.setTextColor(getResources().getColor(android.R.color.black));
    }

    /**
     * On connection lost ..
     */
    @Override
    public void onDisconnected() {
        statusTv.setText(R.string.disconnected);
        statusTv.setTextColor(getResources().getColor(android.R.color.holo_red_light));
    }
}

