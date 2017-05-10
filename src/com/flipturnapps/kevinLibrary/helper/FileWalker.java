package com.flipturnapps.kevinLibrary.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class FileWalker
{
	private boolean hasWalked = false;
	private String pathFound = null;
	
    public void walk( String path ) 
    {
    	if(this.getPathFound() != null || isHasWalked() == true || path == null)
    		return;
        File root = new File( path );
        File[] list = root.listFiles();

        if (this.getPathFound() != null || list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
            }
            else
            {
               boolean ok = isFileTheTarget(f);
               if(ok == true)
               {
            	   this.setPathFound(f.getAbsolutePath());
            	   this.setHasWalked(true);
               }
            }
        }
    }
    
    public abstract boolean isFileTheTarget(File f);
    
	public void walk()
    {
    	walk(System.getProperty("user.home"));
    }

	public boolean isHasWalked() {
		return hasWalked;
	}

	public void setHasWalked(boolean hasWalked) {
		this.hasWalked = hasWalked;
	}
	public String getPathFound() {
		return pathFound;
	}
	public void setPathFound(String pathFound) {
		this.pathFound = pathFound;
	}

	
}
