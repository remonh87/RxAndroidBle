package com.polidea.rxandroidble;

import android.content.Context;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import rx.Observable;

public interface RxBleConnection {

    // TODO: 26.01.2016 [PU] Why not an enum?
    class RxBleConnectionState {

        public static final RxBleConnectionState DISCONNECTING = new RxBleConnectionState();

        public static final RxBleConnectionState DISCONNECTED = new RxBleConnectionState();

        public static final RxBleConnectionState CONNECTING = new RxBleConnectionState();

        public static final RxBleConnectionState CONNECTED = new RxBleConnectionState();
    }

    Observable<RxBleConnection> connect(Context context); // TODO: hide from the user

    // TODO: 26.01.2016 [PU] Consider another layer of abstraction for Services and Characteristics instead of plain UUIDs.
    Observable<Map<UUID, Set<UUID>>> discoverServices();

    Observable<Observable<byte[]>> getNotification(UUID characteristicUuid);

    Observable<byte[]> readCharacteristic(UUID characteristicUuid);

    Observable<byte[]> writeCharacteristic(UUID characteristicUuid, byte[] data);

    Observable<byte[]> readDescriptor(UUID descriptorUuid);

    Observable<byte[]> writeDescriptor(UUID descriptorUuid, byte[] data);

    Observable<Integer> readRssi();
}
