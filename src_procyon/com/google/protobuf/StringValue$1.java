package com.google.protobuf;

final class StringValue$1 extends AbstractParser
{
    public StringValue parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new StringValue(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
