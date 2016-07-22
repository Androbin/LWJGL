package de.androbin.lwjgl.util;

import static org.lwjgl.BufferUtils.*;
import java.nio.*;
import org.lwjgl.util.vector.*;

public final class BufferUtil
{
	private BufferUtil()
	{
	}
	
	public static ByteBuffer wrapByteBuffer( final byte ... array )
	{
		return put( createByteBuffer( array.length ), array );
	}
	
	public static FloatBuffer wrapFloatBuffer( final float ... array )
	{
		return put( createFloatBuffer( array.length ), array );
	}
	
	public static FloatBuffer wrapFloatVector( final Vector3f v )
	{
		return wrapFloatBuffer( v.x, v.y, v.z, 1f );
	}
	
	public static IntBuffer wrapIntBuffer( final int ... array )
	{
		return put( createIntBuffer( array.length ), array );
	}
	
	public static byte[] get( final ByteBuffer buffer, final byte[] array )
	{
		buffer.position( 0 );
		buffer.get( array );
		buffer.rewind();
		return array;
	}
	
	public static float[] get( final FloatBuffer buffer, final float[] array )
	{
		buffer.position( 0 );
		buffer.get( array );
		buffer.rewind();
		return array;
	}
	
	public static int[] get( final IntBuffer buffer, final int[] array )
	{
		buffer.position( 0 );
		buffer.get( array );
		buffer.rewind();
		return array;
	}
	
	public static ByteBuffer put( final ByteBuffer buffer, final byte[] array )
	{
		buffer.position( 0 );
		buffer.put( array );
		buffer.rewind();
		return buffer;
	}
	
	public static FloatBuffer put( final FloatBuffer buffer, final float[] array )
	{
		buffer.position( 0 );
		buffer.put( array );
		buffer.rewind();
		return buffer;
	}
	
	public static IntBuffer put( final IntBuffer buffer, final int[] array )
	{
		buffer.position( 0 );
		buffer.put( array );
		buffer.rewind();
		return buffer;
	}
}