package com.google.protos.BinExport;

import com.google.protobuf.*;

final class BinExport$Callgraph$1 extends AbstractParser
{
    @Override
    public BinExport$Callgraph parsePartialFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return new BinExport$Callgraph(codedInputStream, extensionRegistryLite, null);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
}
