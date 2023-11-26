package decibility.com;

import android.bluetooth.BluetoothAdapter;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;

public class Scanner_BTLE {

//    private MainActivity mMainActivity;
//    private BluetoothAdapter mBluetoothAdapter;
//    private boolean mScanning; // holds scanning state of scanner
//    private Handler mHandler; // used when scanner is scanning
//
//    private long scanPeriod;
//    private int signalStrength;
//
//    /**
//     * Constructor
//     * @param mainActivity used to reference methods in mainActivity
//     * @param scanPeriod determines how long scanner should scan for
//     * @param signalStrength sets signal threshold so scanner app
//     *                       does not detect distant and weak bluetooth signals
//     */
//    public Scanner_BTLE(MainActivity mainActivity, long scanPeriod, int signalStrength) {
//        mMainActivity = mainActivity;
//
//        mHandler = new Handler();
//
//        this.scanPeriod = scanPeriod;
//        this.signalStrength = signalStrength;
//
//        final BluetoothManager bluetoothManager =
//                // gets reference to bluetooth service on phone
//                (BluetoothManager) mMainActivity.getSystemService(Context.BLUETOOTH_SERVICE);
//
//        // accesses bluetooth module on phone so we can make it do things like scan
//        mBluetoothAdapter = bluetoothManager.getAdapter();
//    }
//
//    public boolean isScanning() {
//        return mScanning;
//    }
//
//    public void start() {
//        if (!Utils.checkBluetooth(mBluetoothAdapter)) {
//            Utils.requestUserBluetooth(mMainActivity);
//            mMainActivity.stopScan();
//        }
//        else {
//            scanLeDevice(true);
//        }
//    }
//
//    public void stop() {
//        scanLeDevice(false);
//    }
//
//    private void scanLeDevice(final boolean enable) {
//
//        if (enable && !mScanning) {
//            Utils.toast(mMainActivity.getApplication(), "Starting BLE Scan...");
//
//            /**
//             * Looks at scan period and wait that amount of time to run this function
//             */
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Utils.toast(mMainActivity.getApplicationContext(), "Stopping BLE Scan...");
//
//                    mScanning = false;
//                    mBluetoothAdapter.stopLeScan((mLeScanCallback));
//
//                    mMainActivity.stopScan();
//                }
//            }, scanPeriod );
//
//            mScanning = true;
//
//            mBluetoothAdapter.startLeScan(mLeScanCallback);
//        }
//    }
//
//    private BluetoothAdapter.LeScanCallback mLeScanCallback =
//            new BluetoothAdapter.LeScanCallback() {
//                @Override
//                public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
//
//                    final int new_rssi = rssi;
//                    if (rssi > signalStrength) {
//                        // pass off device to main activity
//                        mHandler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                mMainActivity.addDevice(device, new_rssi);
//                            }
//                        });
//                    }
//                }
//            };
}
