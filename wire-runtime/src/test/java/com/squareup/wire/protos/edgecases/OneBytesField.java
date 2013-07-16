/**
 * Code generated by "Wire" protobuf compiler, do not edit.
 * Source file: ../wire-runtime/src/test/proto/edge_cases.proto
 */
package com.squareup.wire.protos.edgecases;

import com.squareup.wire.ByteString;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import com.squareup.wire.Wire;

public final class OneBytesField
    implements Message {

  public static final ByteString DEFAULT_OPT_BYTES = null;

  @ProtoField(
    tag = 1,
    type = Wire.BYTES
  )
  public final ByteString opt_bytes;

  private OneBytesField(Builder builder) {
    this.opt_bytes = builder.opt_bytes;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof OneBytesField)) return false;
    return Wire.equals(opt_bytes, ((OneBytesField) other).opt_bytes);
  }

  @Override
  public int hashCode() {
    return opt_bytes != null ? opt_bytes.hashCode() : 0;
  }

  @Override
  public String toString() {
    return String.format("OneBytesField{" +
        "opt_bytes=%s}",
        opt_bytes);
  }

  public static final class Builder
      implements Message.Builder<OneBytesField> {

    public ByteString opt_bytes;

    public Builder() {
    }

    public Builder(OneBytesField message) {
      if (message == null) return;
      this.opt_bytes = message.opt_bytes;
    }

    public Builder opt_bytes(ByteString opt_bytes) {
      this.opt_bytes = opt_bytes;
      return this;
    }

    @Override
    public boolean isInitialized() {
      return true;
    }

    @Override
    public OneBytesField build() {
      return new OneBytesField(this);
    }
  }
}
