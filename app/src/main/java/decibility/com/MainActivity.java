package decibility.com;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

// Great portion of code from https://github.com/kaviles/BLE_Tutorials/blob/master/Android/01/Final/app/src/main/res/layout/btle_device_list_item.xml

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private final static String TAG = MainActivity.class.getSimpleName();

//    public static final int REQUEST_ENABLE_BT = 1;

//    private HashMap<String, BTLE_Device> mBTDevicesHashMap;
//    private ArrayList<BTLE_Device> mBTDevicesArrayList;
//    private ListAdapter_BTLE_Devices adapter;

    private Button btn_Scan;
    private Button connect_device_btn;
    private Button config_range_btn;

//    private BroadcastReceiver_BTState mBTStateUpdateReceiver;
//    private Scanner_BTLE mBTLeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // connect layout to activity

//        Button connect_device_btn = findViewById(R.id.connect_device_btn);
//        connect_device_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, BluetoothPage.class);
//                startActivity(intent);
//            }
//        });
//
//        Button config_range_btn = findViewById(R.id.config_range_btn);
//        config_range_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this, ConfigRangePage.class);
//                startActivity(intent1);
//            }
//        });

//        // Checks whether BLE is supported on the device
//        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
//            Utils.toast(getApplicationContext(), "BLE not supported");
//            finish();
//        }
//
//        mBTStateUpdateReceiver = new BroadcastReceiver_BTState(getApplicationContext());
//        mBTLeScanner = new Scanner_BTLE(this, 7500, -75); // 7.5 seconds
//
//        // instantiate data structures that keep track of bluetooth devices
//        mBTDevicesHashMap = new HashMap<>();
//        mBTDevicesArrayList = new ArrayList<>();
//
//        // instantiate adapter to update UI as data structures above change
//        adapter = new ListAdapter_BTLE_Devices(this, R.layout.btle_device_list_item, mBTDevicesArrayList);
//
//        // add list view to UI
//        ListView listView = new ListView(this);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);
//        ((ScrollView) findViewById(R.id.scrollView)).addView((listView));

        // set onclick listener for button
//        btn_Scan = (Button) findViewById(R.id.btn_scan);
//        findViewById(R.id.btn_scan).setOnClickListener(this);
        config_range_btn = (Button) findViewById(R.id.config_range_btn);
        findViewById(R.id.config_range_btn).setOnClickListener(this);
        connect_device_btn = (Button) findViewById(R.id.connect_device_btn);
        findViewById(R.id.connect_device_btn).setOnClickListener(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        // register bluetooth state update receiver to tell us when bluetooth state on device changes
//        registerReceiver(mBTStateUpdateReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        stopScan();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        unregisterReceiver(mBTStateUpdateReceiver);
//        stopScan();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Check which request we're responding to
//        if (requestCode == REQUEST_ENABLE_BT) {
//            // Make sure the request was successful
//            if (resultCode == RESULT_OK) {
//                // Utils.toast(getApplicationContext(), "Thank you for turning on Bluetooth");
//            }
//            else if (resultCode == RESULT_CANCELED) {
//                Utils.toast(getApplicationContext(), "Please turn on Bluetooth");
//            }
//        }
//    }

    // Called when an item in the ListView is clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Used in future BLE development, not used for scanner
    }

    /**
     * Called when scan button is clicked
     * @param v the view that was clicked
     */
    // Called when scan button is clicked
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

//            case R.id.btn_scan:
//                Utils.toast(getApplicationContext(), "Scan Button Pressed");
//
//                if (!mBTLeScanner.isScanning()) {
//                    // not scanning, start scan
//                    startScan();
//                }
//                else {
//                    // already scanning, stop scan
//                    stopScan();
//                }
//
//                break;

            case R.id.connect_device_btn:
                Intent intent = new Intent(MainActivity.this, BluetoothPage.class);
                startActivity(intent);
                break;

            case R.id.config_range_btn:
                Intent intent1 = new Intent(MainActivity.this, ConfigRangePage.class);
                Intent this_intent = getIntent();
                if (this_intent.hasExtra("min_volume_input")) {
                    intent1.putExtra("min_volume_input", this_intent.getStringExtra("min_volume_input"));
                }
                if (this_intent.hasExtra("max_volume_input")) {
                    intent1.putExtra("max_volume_input", this_intent.getStringExtra("max_volume_input"));
                }
                if (this_intent.hasExtra("min_frequency_input")) {
                    intent1.putExtra("min_frequency_input", this_intent.getStringExtra("min_frequency_input"));
                }
                if (this_intent.hasExtra("max_frequency_input")) {
                    intent1.putExtra("max_frequency_input", this_intent.getStringExtra("max_frequency_input"));
                }
                startActivity(intent1);
                break;

            default:
                break;
        }
    }

//    /**
//     * Adds a device to the ArrayList and Hashmap that the ListAdapter is keeping track of
//     * @param device the BluetoothDevice to be added
//     * @param rssi the rssi of the BluetoothDevice
//     */
//    public void addDevice(BluetoothDevice device, int rssi) {
//        // when phone scans for other ble devices it finds same device multiple times
//        // using hashmap and device address to keep from creating many references to same device
//
//        String address = device.getAddress();
//        // check if it exists in hash map
//        if (!mBTDevicesHashMap.containsKey(address)) {
//            // doesn't exist, add to hash map and list
//            BTLE_Device btle_device = new BTLE_Device(device);
//            btle_device.setRSSI(rssi);
//
//            mBTDevicesHashMap.put(address, btle_device);
//            mBTDevicesArrayList.add(btle_device);
//        }
//        else {
//            // exists, get btle device address from hash map
//            mBTDevicesHashMap.get(address).setRSSI(rssi);
//        }
//
//        // notify list adapter of changes
//        adapter.notifyDataSetChanged();
//    }
//
//    /**
//     * Clears the ArrayList and Hashmap the ListAdapter is keeping track of.
//     * Starts Scanner_BTLE.
//     * Changes the scan button text.
//     */
//    public void startScan(){
//        btn_Scan.setText("Scanning...");
//
//        mBTDevicesArrayList.clear();
//        mBTDevicesHashMap.clear();
//
//        adapter.notifyDataSetChanged();
//
//        mBTLeScanner.start();
//    }
//
//    /**
//     * Stops Scanner_BTLE
//     * Changes the scan button text.
//     */
//    public void stopScan() {
//        btn_Scan.setText("Scan Again");
//
//        mBTLeScanner.stop();
//    }
}
