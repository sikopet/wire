package com.squareup.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ByteStringTest {
  @Test
  public void byteStringToString() throws Exception {
    ByteString byteString = ByteString.of((byte) 0x0, (byte) 0x1, (byte) 0x2, (byte) 0xf,
        (byte) 0x10, (byte) 0x11, (byte) 0x7f, (byte) 0x80, (byte) 0x81, (byte) 0xfe, (byte) 0xff);
    assertEquals("[0001020f10117f8081feff]", byteString.toString());
  }

  @Test
  public void byteStringEquals() throws Exception {
    ByteString byteString = ByteString.of((byte) 0x0, (byte) 0x1, (byte) 0x2);
    assertTrue(byteString.equals(byteString));
    assertTrue(byteString.equals(ByteString.of((byte) 0x0, (byte) 0x1, (byte) 0x2)));
    assertFalse(byteString.equals(new Object()));
    assertFalse(byteString.equals(ByteString.of((byte) 0x0, (byte) 0x2, (byte) 0x1)));
  }

  @Test
  public void byteStringHashCode() throws Exception {
    ByteString byteString = ByteString.of((byte) 0x1, (byte) 0x2);
    assertEquals(byteString.hashCode(), byteString.hashCode());
    assertEquals(byteString.hashCode(), ByteString.of((byte) 0x1, (byte) 0x2).hashCode());
  }

  @Test
  public void read() throws Exception {
    InputStream in = new ByteArrayInputStream("abc".getBytes("UTF-8"));
    assertEquals(ByteString.of((byte) 0x61, (byte) 0x62), ByteString.read(in, 2));
    assertEquals(ByteString.of((byte) 0x63), ByteString.read(in, 1));
    assertEquals(ByteString.of(), ByteString.read(in, 0));
  }

  @Test
  public void write() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteString.of((byte) 0x61, (byte) 0x62, (byte) 0x63).write(out);
    assertByteArraysEquals(new byte[] { 0x61, 0x62, 0x63 }, out.toByteArray());
  }

  @Test
  public void writeWithOffset() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteString.of((byte) 0x61, (byte) 0x62, (byte) 0x63).write(out, 1, 2);
    assertByteArraysEquals(new byte[] { 0x62, 0x63 }, out.toByteArray());
  }

  private static void assertByteArraysEquals(byte[] a, byte[] b) throws Exception {
    assertEquals(Arrays.toString(a), Arrays.toString(b));
  }
}
