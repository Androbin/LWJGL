package de.androbin.lwjgl.util;

import static de.androbin.math.util.floats.FloatMathUtil.*;
import org.lwjgl.util.vector.*;

public final class Vector2fUtil {
  private Vector2fUtil() {
  }
  
  public static Vector2f add( final Vector2f v, final int x, final float c ) {
    return set( v, x, get( v, x ) + c );
  }
  
  public static Vector2f edge( final Vector2f pos, final Vector2f dir, final int x ) {
    final float c = get( pos, x );
    final float p = c - (int) c;
    
    if ( p == 0f ) {
      return pos;
    } else {
      final int d = ( p > 0f ? 0 : 1 ) - ( get( dir, x ) > 0f ? 0 : 1 );
      return Vector2f.sub( pos, (Vector2f) normalise( dir, x, false ).scale( p + d ), null );
    }
  }
  
  public static float get( final Vector2f v, final int x ) {
    switch ( x ) {
      default:
        return 0f;
      
      case 0:
        return v.x;
      case 1:
        return v.y;
    }
  }
  
  public static Vector2f getDirVector( final Vector2f dst, final float degrees ) {
    final float radians = (float) Math.toRadians( degrees );
    dst.set( (float) Math.sin( radians ), (float) -Math.cos( radians ) );
    return dst;
  }
  
  public static Vector2f interpolate2f( final Vector2f v1, final float p, final Vector2f v2 ) {
    final float x = inter( v1.x, p, v2.x );
    final float y = inter( v1.y, p, v2.y );
    
    return new Vector2f( x, y );
  }
  
  public static Vector2f normalise( final Vector2f v, final int x, final boolean a ) {
    final float c = get( v, x );
    return (Vector2f) new Vector2f( v ).scale( 1f / ( a ? Math.abs( c ) : c ) );
  }
  
  public static Vector2f set( final Vector2f v, final int x, final float c ) {
    switch ( x ) {
      case 0:
        v.setX( c );
        break;
      case 1:
        v.setY( c );
        break;
    }
    
    return v;
  }
  
  public static Vector2f split( final Vector2f v, final int x ) {
    final Vector2f v_ = new Vector2f();
    set( v_, x, get( v, x ) );
    return v_;
  }
  
  public static Vector2f sub( final Vector2f v, final int x, final float c ) {
    return set( v, x, get( v, x ) - c );
  }
}