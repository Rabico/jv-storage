package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int storageSize = 0;
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    @Override
    public void put(K key, V value) {
        if (storageSize > 0) {
            for (int i = 0; i < storageSize; i++) {
                if (Objects.equals(key, keys[i])) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[storageSize] = key;
        values[storageSize] = value;
        storageSize += 1;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
