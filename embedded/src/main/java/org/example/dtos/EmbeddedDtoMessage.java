package org.example.dtos;

import com.google.protobuf.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class EmbeddedDtoMessage implements Message {
    private EmbeddedDto embeddedDto;

    @Override
    public void writeTo(CodedOutputStream output) throws IOException {

    }

    @Override
    public int getSerializedSize() {
        return 0;
    }

    @Override
    public Parser<? extends Message> getParserForType() {
        return null;
    }

    @Override
    public ByteString toByteString() {
        return null;
    }

    @Override
    public byte[] toByteArray() {
        return new byte[0];
    }

    @Override
    public void writeTo(OutputStream output) throws IOException {

    }

    @Override
    public void writeDelimitedTo(OutputStream output) throws IOException {

    }

    @Override
    public Builder newBuilderForType() {
        return null;
    }

    @Override
    public Builder toBuilder() {
        return null;
    }

    @Override
    public Message getDefaultInstanceForType() {
        return null;
    }

    @Override
    public boolean isInitialized() {
        return false;
    }

    @Override
    public List<String> findInitializationErrors() {
        return null;
    }

    @Override
    public String getInitializationErrorString() {
        return null;
    }

    @Override
    public Descriptors.Descriptor getDescriptorForType() {
        return null;
    }

    @Override
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return null;
    }

    @Override
    public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
        return false;
    }

    @Override
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
        return null;
    }

    @Override
    public boolean hasField(Descriptors.FieldDescriptor field) {
        return false;
    }

    @Override
    public Object getField(Descriptors.FieldDescriptor field) {
        return null;
    }

    @Override
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
        return 0;
    }

    @Override
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
        return null;
    }

    @Override
    public UnknownFieldSet getUnknownFields() {
        return null;
    }
}
