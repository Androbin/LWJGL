package de.androbin.lwjgl.util;

public final class Intersection
{
	public final int[]	pos;
	public final int	side;
	
	public final float	distance;
	
	public Intersection( final int[] pos, final int side, final float distance )
	{
		this.pos = pos;
		this.side = side;
		
		this.distance = distance;
	}
}