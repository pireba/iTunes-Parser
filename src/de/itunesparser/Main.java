package de.itunesparser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.dom4j.DocumentException;

public class Main {
	public static void main(String[] args) throws DocumentException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Parser parser = new Parser(new File("/home/phillip/MEGA/iTunes Library.xml"));
		parser.parse();
		
//		Library object = parser.getLibrary();
//		for ( Method method : object.getClass().getMethods() ) {
//			if ( method.getName().startsWith("get") || method.getName().startsWith("is") ) {
//				System.out.println(method.getName()+": '"+method.invoke(object, new Object[] {})+"'");
//			}
//		}
		
		Map<Integer, Track> tracks = parser.getTracks();
		for ( Track track : tracks.values() ) {
			for ( Method method : track.getClass().getMethods() ) {
				if ( method.getName().startsWith("get") || method.getName().startsWith("is") ) {
					System.out.println(method.getName()+": '"+method.invoke(track, new Object[] {})+"'");
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.in.read();
		}
		
//		Map<Integer, Playlist> playlists = parser.getPlaylists();
//		for ( Playlist playlist : playlists.values() ) {
//			for ( Method method : playlist.getClass().getMethods() ) {
//				if ( method.getName().startsWith("get") || method.getName().startsWith("is") ) {
//					System.out.println(method.getName()+": '"+method.invoke(playlist, new Object[] {})+"'");
//				}
//			}
//			System.out.println("----------------------------------------------------------------------------------------------------");
//			System.in.read();
//		}
	}
}