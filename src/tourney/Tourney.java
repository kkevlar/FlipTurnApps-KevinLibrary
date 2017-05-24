package tourney;

public class Tourney 
{
	public static void main(String[] args)
	{
		int to = 1000;
		for(int x = 0; x < to; x++)
		{
			for(int y = x+1; y < to; y++)
			{
				System.out.println((x+1) + " " + (y+1));
			}
		}
	}
}
