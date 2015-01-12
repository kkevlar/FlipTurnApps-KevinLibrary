package com.flipturnapps.kevinLibrary.helper;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectWR {
	public static void write(Serializable o, String file) throws FileNotFoundException, IOException
	{

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(o);
		oos.close();

	}
	public static Object read(String file) throws ClassNotFoundException, FileNotFoundException, IOException
	{
		Object hehe = null;

		ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
		hehe = ois.readObject();
		ois.close();

		return hehe;

	}
}
