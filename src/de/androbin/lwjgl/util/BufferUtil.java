package de.androbin.lwjgl.util;

import static org.lwjgl.BufferUtils.*;
import java.nio.*;
import org.lwjgl.util.vector.*;

public final class BufferUtil {
  private BufferUtil() {
  }
  
  public static ByteBuffer wrapByteBuffer( final byte ... array ) {
    return putBuffer( createByteBuffer( array.length ), array );
  }
  
  public static FloatBuffer wrapFloatBuffer( final float ... array ) {
    return putBuffer( createFloatBuffer( array.length ), array );
  }
  
  public static FloatBuffer wrapFloatVector( final Vector3f v ) {
    return wrapFloatBuffer( v.x, v.y, v.z, 1f );
  }
  
  public static IntBuffer wrapIntBuffer( final int ... array ) {
    return putBuffer( createIntBuffer( array.length ), array );
  }
  
  public static ShortBuffer wrapShortBuffer( final short ... array ) {
    return putBuffer( createShortBuffer( array.length ), array );
  }
  
  public static byte[] getBuffer( final ByteBuffer buffer, final byte[] array ) {
    buffer.position( 0 );
    buffer.get( array );
    buffer.rewind();
    return array;
  }
  
  public static float[] getBuffer( final FloatBuffer buffer, final float[] array ) {
    buffer.position( 0 );
    buffer.get( array );
    buffer.rewind();
    return array;
  }
  
  public static int[] getBuffer( final IntBuffer buffer, final int[] array ) {
    buffer.position( 0 );
    buffer.get( array );
    buffer.rewind();
    return array;
  }
  
  public static short[] getBuffer( final ShortBuffer buffer, final short[] array ) {
    buffer.position( 0 );
    buffer.get( array );
    buffer.rewind();
    return array;
  }
  
  public static ByteBuffer putBuffer( final ByteBuffer buffer, final byte[] array ) {
    buffer.position( 0 );
    buffer.put( array );
    buffer.rewind();
    return buffer;
  }
  
  public static FloatBuffer putBuffer( final FloatBuffer buffer, final float[] array ) {
    buffer.position( 0 );
    buffer.put( array );
    buffer.rewind();
    return buffer;
  }
  
  public static IntBuffer putBuffer( final IntBuffer buffer, final int[] array ) {
    buffer.position( 0 );
    buffer.put( array );
    buffer.rewind();
    return buffer;
  }
  
  public static ShortBuffer putBuffer( final ShortBuffer buffer, final short[] array ) {
    buffer.position( 0 );
    buffer.put( array );
    buffer.rewind();
    return buffer;
  }
}