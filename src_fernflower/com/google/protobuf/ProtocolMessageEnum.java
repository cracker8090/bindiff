package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLite;

public interface ProtocolMessageEnum extends Internal$EnumLite {
   int getNumber();

   Descriptors$EnumValueDescriptor getValueDescriptor();

   Descriptors$EnumDescriptor getDescriptorForType();
}
