package com.google.common.hash;

enum LittleEndianByteArray$UnsafeByteArray$2
{
    LittleEndianByteArray$UnsafeByteArray$2(final String s, final int n) {
    }
    
    @Override
    public long getLongLittleEndian(final byte[] array, final int n) {
        return Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.access$200().getLong(array, n + LittleEndianByteArray$UnsafeByteArray.access$100()));
    }
    
    @Override
    public void putLongLittleEndian(final byte[] array, final int n, final long n2) {
        LittleEndianByteArray$UnsafeByteArray.access$200().putLong(array, n + LittleEndianByteArray$UnsafeByteArray.access$100(), Long.reverseBytes(n2));
    }
}
