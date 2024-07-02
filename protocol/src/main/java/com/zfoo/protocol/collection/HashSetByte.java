/*
 * Copyright (C) 2020 The zfoo Authors
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.zfoo.protocol.collection;

import io.netty.util.collection.ByteObjectHashMap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author godotg
 */
public class HashSetByte extends AbstractSet<Byte> {

    private final ByteObjectHashMap<Boolean> map;

    public HashSetByte() {
        map = new ByteObjectHashMap<>();
    }

    public HashSetByte(int initialCapacity) {
        map = new ByteObjectHashMap<>(initialCapacity);
    }

    @Override
    public Iterator<Byte> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean add(Byte e) {
        return map.put(e, Boolean.TRUE) == null;
    }

    public boolean add(byte e) {
        return map.put(e, Boolean.TRUE) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Set<?> s)) {
            return false;
        }
        return s.equals(this);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}
