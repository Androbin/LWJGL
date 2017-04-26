package de.androbin.lwjgl.util;

import static de.androbin.math.util.floats.FloatMathUtil.*;
import org.lwjgl.util.vector.*;

public final class Vector3fUtil
{
	private Vector3fUtil()
	{
	}
	
	public static Vector3f add( final Vector3f v, final int x, final float c )
	{
		return set( v, x, get( v, x ) + c );
	}
	
	public static Vector3f averageVector3f( final Vector3f v1, final Vector3f v2 )
	{
		final float x = ( v1.x + v2.x ) * 0.5f;
		final float y = ( v1.y + v2.y ) * 0.5f;
		final float z = ( v1.z + v2.z ) * 0.5f;
		
		return new Vector3f( x, y, z );
	}
	
	public static Vector3f edge( final Vector3f pos, final Vector3f dir, final int x )
	{
		final float c = get( pos, x );
		final float p = c - (int) c;
		
		if ( p == 0f )
		{
			return pos;
		}
		else
		{
			final int d = ( p > 0f ? 0 : 1 ) - ( get( dir, x ) > 0f ? 0 : 1 );
			return Vector3f.sub( pos, (Vector3f) normalise( dir, x, false ).scale( p + d ), null );
		}
	}
	
	public static float get( final Vector3f v, final int x )
	{
		switch ( x )
		{
			default :
				return 0f;
			
			case 0 :
				return v.x;
			case 1 :
				return v.y;
			case 2 :
				return v.z;
		}
	}
	
	public static Vector3f getDirVector( final Vector3f dst, final float degrees )
	{
		if ( dst == null )
		{
			return getDirVector( new Vector3f(), degrees );
		}
		
		final float radians = (float) Math.toRadians( degrees );
		dst.set( (float) Math.sin( radians ), 0f, (float) -Math.cos( radians ) );
		return dst;
	}
	
	public static Vector3f getDirVector( final Vector3f dst, final Vector3f dir )
	{
		if ( dst == null )
		{
			return getDirVector( new Vector3f(), dir );
		}
		
		final float pitch = (float) Math.toRadians( dir.x );
		final float cosPitch = (float) Math.cos( pitch );
		final float yaw = (float) Math.toRadians( dir.y );
		
		dst.set( (float) Math.sin( yaw ) * cosPitch, (float) -Math.sin( pitch ), (float) -Math.cos( yaw ) * cosPitch );
		return dst;
	}
	
	public static Vector3f interpolate3f( final Vector3f v1, final float p, final Vector3f v2, final Vector3f dest )
	{
		if ( dest == null )
		{
			return interpolate3f( v1, p, v2, new Vector3f() );
		}
		
		final float x = inter( v1.x, p, v2.x );
		final float y = inter( v1.y, p, v2.y );
		final float z = inter( v1.z, p, v2.z );
		
		dest.set( x, y, z );
		return dest;
	}
	
	public static Vector3f normalise( final Vector3f v, final int x, final boolean a )
	{
		final float c = get( v, x );
		return (Vector3f) new Vector3f( v ).scale( 1f / ( a ? Math.abs( c ) : c ) );
	}
	
	public static Vector3f set( final Vector3f v, final int x, final float c )
	{
		switch ( x )
		{
			default :
				break;
			
			case 0 :
				v.setX( c );
				break;
			case 1 :
				v.setY( c );
				break;
			case 2 :
				v.setZ( c );
				break;
		}
		
		return v;
	}
	
	public static Vector3f split( final Vector3f v, final int x )
	{
		final Vector3f v_ = new Vector3f();
		set( v_, x, get( v, x ) );
		return v_;
	}
	
	public static Vector3f sub( final Vector3f v, final int x, final float c )
	{
		return set( v, x, get( v, x ) - c );
	}
}