/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ApiProto$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.TypeProto;
import java.util.List;

public final class ApiProto {
    static Descriptors$Descriptor internal_static_google_protobuf_Api_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Api_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_Method_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Method_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;

    private ApiProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    static /* synthetic */ Descriptors$FileDescriptor access$002(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        descriptor = descriptors$FileDescriptor;
        return descriptor;
    }

    static {
        String[] arrstring = new String[]{"\n\u0019google/protobuf/api.proto\u0012\u000fgoogle.protobuf\u001a$google/protobuf/source_context.proto\u001a\u001agoogle/protobuf/type.proto\"\u00b0\u0001\n\u0003Api\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012(\n\u0007methods\u0018\u0002 \u0003(\u000b2\u0017.google.protobuf.Method\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u000f\n\u0007version\u0018\u0004 \u0001(\t\u00126\n\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\"\u00ac\u0001\n\u0006Method\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010request_type_url\u0018\u0002 \u0001(\t\u0012\u0019\n\u0011request_streaming\u0018\u0003 \u0001(\b\u0012\u0019\n\u0011response_type_url\u0018\u0004 \u0001(\t\u0012\u001a\n\u0012re", "sponse_streaming\u0018\u0005 \u0001(\b\u0012(\n\u0007options\u0018\u0006 \u0003(\u000b2\u0017.google.protobuf.OptionB'\n\u0013com.google.protobufB\bApiProtoP\u0001\u00a2\u0002\u0003GPBb\u0006proto3"};
        ApiProto$1 apiProto$1 = new ApiProto$1();
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, new Descriptors$FileDescriptor[]{SourceContextProto.getDescriptor(), TypeProto.getDescriptor()}, apiProto$1);
        internal_static_google_protobuf_Api_descriptor = (Descriptors$Descriptor)ApiProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Api_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_Api_descriptor, new String[]{"Name", "Methods", "Options", "Version", "SourceContext"});
        internal_static_google_protobuf_Method_descriptor = (Descriptors$Descriptor)ApiProto.getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_Method_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_Method_descriptor, new String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options"});
        SourceContextProto.getDescriptor();
        TypeProto.getDescriptor();
    }
}

