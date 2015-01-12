package com.flipturnapps.kevinLibrary.helper;

import java.awt.Color;
import java.util.Random;


public class KevinColor 
{
	public static final Color kskyblue = new Color(5, 238, 250);
	public static final Color kblue = Color.BLUE;
	public static final Color kred = Color.RED;
	public static final Color klime = Color.GREEN;
	public static final Color kyellow = Color.YELLOW;
	public static final Color kpink = Color.PINK;
	public static final Color kmagenta = Color.MAGENTA;
	public static final Color kblack = Color.BLACK;
	public static final Color kcyan = Color.CYAN;
	public static final Color kdarkgray = Color.DARK_GRAY;
	public static final Color klightgray = Color.LIGHT_GRAY;
	public static final Color kgray = Color.GRAY;
	public static final Color kwhite = Color.WHITE;
	public static final Color kdarkpurple = Color.getHSBColor(Color.RGBtoHSB(128, 0, 128, null)[0],Color.RGBtoHSB(128, 0, 128, null)[1],Color.RGBtoHSB(128, 0, 128, null)[2]);
	public static final Color kpurple = Color.getHSBColor(Color.RGBtoHSB(139, 0, 139, null)[0],Color.RGBtoHSB(139, 0, 139, null)[1],Color.RGBtoHSB(128, 0, 139, null)[2]);
	public static final Color kdarkbrown = Color.getHSBColor(Color.RGBtoHSB(139,69,19, null)[0],Color.RGBtoHSB(139,69,19, null)[1],Color.RGBtoHSB(139,69,19, null)[2]);
	public static final Color knavy = Color.getHSBColor(Color.RGBtoHSB(0,0,128, null)[0],Color.RGBtoHSB(0,0,128, null)[1],Color.RGBtoHSB(0,0,128, null)[2]);
	public static final Color kspringgreen = Color.getHSBColor(Color.RGBtoHSB(0,225,127, null)[0],Color.RGBtoHSB(0,225,127, null)[1],Color.RGBtoHSB(0,225,127, null)[2]);
	public static final Color kgreen = Color.getHSBColor(Color.RGBtoHSB(0,128,0, null)[0],Color.RGBtoHSB(0,128,0, null)[1],Color.RGBtoHSB(0,128,0, null)[2]);
	public static final Color kindigo = Color.getHSBColor(Color.RGBtoHSB(75,0,130, null)[0],Color.RGBtoHSB(75,0,130, null)[1],Color.RGBtoHSB(75,0,130, null)[2]);
	//public static final Color kflame = KevinColor.mix(KevinColor.kred, KevinColor.korange);
	public static final Color korange = Color.getHSBColor(Color.RGBtoHSB(255,140,0, null)[0],Color.RGBtoHSB(255,140,0, null)[1],Color.RGBtoHSB(255,140,0, null)[2]);
	public static final Color[] rainbowActual = {kred,korange,kyellow,kgreen,kblue,kindigo,kpurple};
	public static final Color[] rainbow = {kred,korange,kyellow,kgreen,kblue,kdarkpurple};
	public static final Color[] all = {kblue,kred,klime,kyellow,kpink,kmagenta,kblack,kcyan,kdarkgray,klightgray,kgray,kwhite,kpurple,kdarkbrown,knavy,kspringgreen,kgreen,kindigo,korange};
	
	public static Color randomArray()
	{
		Random rand = new Random();
		return all[rand.nextInt(all.length)];
	}
	public static Color random()
	{
		return new Color(Numbers.random(255), Numbers.random(255), Numbers.random(255));
	}
	public static Color lighten (Color c)
	{
		return KevinColor.mix(c, KevinColor.kwhite, 0.8);
	}
	public static Color darken (Color c)
	{
		return KevinColor.mix(c, KevinColor.kblack, 0.8);
	}
	public static Color mix (Color a, Color b)
	{
		return KevinColor.mix(a, b, .5);
	}
	public static Color mix (Color a, Color b, double con)
	{
		int red = (int) ((a.getRed() * con) + (b.getRed() * (1-con)));
		int blue = (int) ((a.getBlue() * con) + (b.getBlue() * (1-con)));
		int green = (int) ((a.getGreen() * con) + (b.getGreen() * (1-con)));
		return new Color(red,green,blue);
	}
	
}
