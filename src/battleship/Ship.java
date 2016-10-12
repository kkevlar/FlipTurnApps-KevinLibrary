package battleship;

public class Ship 
{
	
	private boolean[][] filled;

	public void simplify() 
	{
		boolean failed = true;
		while (failed) {
			boolean xleft = false;
			boolean xright = false;
			boolean ytop = false;
			boolean ybot = false;
			int width = filled.length;
			int height = filled[0].length;
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++)
					if (filled[x][y] == true) {
						if (x == 0)
							xleft = true;
						if (x == filled.length - 1)
							xright = true;
						if (y == 0)
							ytop = true;
						if (y == filled[x].length - 1)
							ybot = true;
					}
			boolean[][] result;
			boolean shiftLeft = xleft;
			boolean xHelp = xleft || xright;
			if (xHelp) {
				result = new boolean[width - 1][height];
				for (int x = 0; x < width; x++)
					for (int y = 0; y < height; y++)
						if (shiftLeft)
							result[x][y] = filled[x + 1][y];
						else
							result[x][y] = filled[x][y];
				filled = result;
			}
			boolean shiftUp = ytop;
			boolean yHelp = ytop || ybot;
			if (yHelp && !xHelp) {
				result = new boolean[width][height-1];
				for (int x = 0; x < width; x++)
					for (int y = 0; y < height; y++)
						if (shiftUp)
							result[x][y] = filled[x][y+1];
						else
							result[x][y] = filled[x][y];
				filled = result;
			}

			failed = (xleft || xright) || (ytop || ybot);
		}
	}

}
