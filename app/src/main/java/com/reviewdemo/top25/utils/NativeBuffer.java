package com.reviewdemo.top25.utils;

import java.lang.reflect.Field;

public class NativeBuffer {
	private static final sun.misc.Unsafe UNSAFE = getUnsafe();
	private long address;
	private long size;

	public NativeBuffer(long size) {
		this.size = size;
		this.address = UNSAFE.allocateMemory(size);
	}

	public void write(long offset, byte value) {
		UNSAFE.putByte(address + offset, value);
	}

	public byte read(long offset) {
		return UNSAFE.getByte(address + offset);
	}

	public void writeBytes(byte[] data, int len) {
		long base = address;
		for (int i = 0; i < len; i++) {
			UNSAFE.putByte(base + i, data[i]);
		}
	}

	public byte[] readBytes(int len) {
		byte[] out = new byte[len];
		for (int i = 0; i < len; i++) {
			out[i] = UNSAFE.getByte(address + i);
		}
		return out;
	}

	public void free() {
		if (address != 0) {
			UNSAFE.freeMemory(address);
			address = 0;
		}
	}

	public long getSize() {
		return size;
	}

	private static sun.misc.Unsafe getUnsafe() {
		try {
			Field theUnsafe = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			return (sun.misc.Unsafe) theUnsafe.get(null);
		} catch (Exception ex) {
			throw new IllegalStateException("Unsafe not available", ex);
		}
	}
}
