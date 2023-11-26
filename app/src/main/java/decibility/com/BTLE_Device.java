package decibility.com;

import android.bluetooth.BluetoothDevice;

// Wrapper class for BluetoothDevice object
public class BTLE_Device {

    private BluetoothDevice bluetoothDevice;
    // Need to store rssi values when our scanner detects a bluetooth device
    private int rssi;

    public BTLE_Device(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    public String getAddress() {
        return bluetoothDevice.getAddress();
    }

    public String getName() {
        return bluetoothDevice.getName();
    }

    public void setRSSI(int rssi) {
        this.rssi = rssi;
    }

    public int getRSSI() {
        return rssi;
    }
}
