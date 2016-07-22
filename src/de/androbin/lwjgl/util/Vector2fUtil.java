package de.androbin.lwjgl.util;

import static de.androbin.collection.util.IntegerCollectionUtil.*;
import static de.androbin.math.util.floats.FloatMathUtil.*;
import de.androbin.collection.map.*;
import org.lwjgl.util.vector.*;

public final class Vector2fUtil
{
	private static final int DIM = 2;
	
	private Vector2fUtil()
	{
	}
	
	public static Vector2f add( final Vector2f v, final int x, final float c )
	{
		return set( v, x, get( v, x ) + c );
	}
	
	public static Vector2f edge( final Vector2f pos, final Vector2f dir, final int x )
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
			return Vector2f.sub( pos, (Vector2f) normalise( dir, x, false ).scale( p + d ), null );
		}
	}
	
	public static float get( final Vector2f v, final int x )
	{
		switch ( x )
		{
			default :
				return 0f;
			
			case 0 :
				return v.x;
			case 1 :
				return v.y;
		}
	}
	
	public static Vector2f getDirVector( final Vector2f dst, final float degrees )
	{
		final float radians = (float) Math.toRadians( degrees );
		dst.set( (float) Math.sin( radians ), (float) -Math.cos( radians ) );
		return dst;
	}
	
	public static <T> Intersection getIntersection( final Vector2f pos, final Vector2f dir, final Map2D<T> map, final float max_distance )
	{
		final Intersection[] i = new Intersection[ DIM ];
		final float[] l = new float[ DIM ];
		
		for ( int x = 0; x < DIM; x++ )
		{
			final float c = get( dir, x );
			
			if ( c == 0f )
			{
				continue;
			}
			
			final boolean e = c > 0f;
			final int[] b = getIntersection( pos, dir, map, max_distance, l, x, e );
			
			if ( b == null )
			{
				continue;
			}
			
			i[ x ] = new Intersection( b, e ? x << 1 : ( x << 1 ) + 1, l[ x ] );
		}
		
		{
			int n = 0;
			
			for ( int s = 1; s < DIM; s++ )
			{
				if ( i[ s ] != null && l[ s ] < l[ n ] )
				{
					n = s;
				}
			}
			
			return i[ n ];
		}
	}
	
	public static <T> int[] getIntersection( final Vector2f pos, final Vector2f dir, final Map2D<T> map, final float max_distance_, final float[] l, final int x, final boolean e )
	{
		int[] b = null;
		
		final Vector2f p = edge( pos, dir, x );
		final Vector2f d = normalise( dir, x, true );
		
		for ( int n = 1; b == null && l[ x ] < max_distance_; n++ )
		{
			{
				final Vector2f a = (Vector2f) new Vector2f( d ).scale( n );
				final Vector2f t = Vector2f.add( p, a, null );
				l[ x ] = Vector2f.sub( pos, t, null ).lengthSquared();
				
				{
					final int x_ = x;
					b = fill( new int[ DIM ], j -> j == x_ ? round( e ? get( t, x_ ) : get( t, x_ ) - 1f ) : floor( get( t, j ) ) );
				}
			}
			
			if ( !map.isElementAt( b[ 0 ], b[ 1 ] ) )
			{
				b = null;
			}
		}
		
		return b;
	}
	
	public static Vector2f interpolate2f( final Vector2f v1, final float p, final Vector2f v2 )
	{
		final float x = interpolate( v1.x, p, v2.x );
		final float y = interpolate( v1.y, p, v2.y );
		
		return new Vector2f( x, y );
	}
	
	public static Vector2f normalise( final Vector2f v, final int x, final boolean a )
	{
		final float c = get( v, x );
		return (Vector2f) new Vector2f( v ).scale( 1f / ( a ? Math.abs( c ) : c ) );
	}
	
	public static Vector2f set( final Vector2f v, final int x, final float c )
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
		}
		
		return v;
	}
	
	public static Vector2f split( final Vector2f v, final int x )
	{
		final Vector2f v_ = new Vector2f();
		set( v_, x, get( v, x ) );
		return v_;
	}
	
	public static Vector2f sub( final Vector2f v, final int x, final float c )
	{
		return set( v, x, get( v, x ) - c );
	}
}