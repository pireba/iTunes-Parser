package com.github.pireba.itunesparser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;

/**
 * Parses an iTunes Library XML File.
 * 
 * <h2>Creating an instance and parse</h2>
 * <pre>
 *  Parser parser = new Parser(file);
 *  parser.parse();
 * </pre>
 * 
 * <h2>Get the Library object</h2>
 * <pre>
 *  Parser parser = new Parser(file);
 *  parser.parse();
 *  Library library = parser.getLibrary();
 * </pre>
 * 
 * <h2>Get the Map with Track objects</h2>
 * <pre>
 *  Parser parser = new Parser(file);
 *  parser.parse();
 *  Map&#60;Integer, Track&#62; tracks = parser.getTracks();
 * </pre>
 * 
 * <h2>Get the Map with Playlist objects</h2>
 * <pre>
 *  Parser parser = new Parser(file);
 *  parser.parse();
 *  Map&#60;Integer, Playlist&#62; playlists = parser.getPlaylists();
 * </pre>
 * 
 * <h2>Get the Tracks of a Playlist</h2>
 * <pre>
 *  Parser parser = new Parser(file);
 *  parser.parse();
 *  Map&#60;Integer, Playlist&#62; playlists = parser.getPlaylists();
 *  Playlist playlist1 = playlists.get(1);
 *  Map&#60;Integer, Track&#62; tracks = playlist1.getPlaylistItems();
 * </pre>
 * 
 * <h2>Iterate through the Tracks of a Playlist</h2>
 * <pre>
 *  Parser parser = new Parser(file);
 *  parser.parse();
 *  Map&#60;Integer, Playlist&#62; playlists = parser.getPlaylists();
 *  Playlist playlist1 = playlists.get(1);
 *  for ( Track track : playlist1.getPlaylistItems().values() ) {
 *      System.out.println(track.getName());
 *  }
 * </pre>
 * 
 * @author Phillip Remmert
 * @version 1.1
 */
public class Parser {
	/**
	 * Logger object to log messages.
	 */
	private static final Logger log = Logger.getLogger(Parser.class.getName());
	
	/**
	 * XPath statement to select the Library properties from the XML File.
	 */
	private static final String XPATH_LIBRARY = "/plist/dict";
	
	/**
	 * XPath statement to select the Tracks properties from the XML File.
	 */
	private static final String XPATH_TRACKS = "/plist/dict/dict/dict";
	
	/**
	 * XPath statement to select the Playlists properties from the XML File.
	 */
	private static final String XPATH_PLAYLISTS = "/plist/dict/array/dict";
	
	/**
	 * The Date format used in the XML File.<br>
	 * Is needed to parse a date correctly from the XML File.
	 */
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	
	/**
	 * The iTunes XML file given by the constructor.
	 */
	private File file;
	
	/**
	 * The Library object to store the Library properties from the XML File.
	 */
	private Library library = new Library();
	
	/**
	 * The Map to store every Track given by the XML File.<br>
	 * A Track object stores every property of an iTunes Track.
	 */
	private Map<Integer, Track> tracks = new HashMap<Integer, Track>();
	
	/**
	 * The Map to store every Playlist given by the XML File.<br>
	 * A Playlist object stores every property of an iTunes Playlist.<br>
	 * This includes a Map of the Playlist Tracks.
	 */
	private Map<Integer, Playlist> playlists = new HashMap<Integer, Playlist>();
		
	/**
	 * Creates a new ITunesParser instance for the given XML file.<br>
	 * To parse the File, call the method {@code parse()}.
	 * @param file The XML File.
	 */
	public Parser(File file) {
		this.file = file;
		DATEFORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	/**
	 * Parses all the properties from the XML File.<br>
	 * After that, the result objects can be retrieved as follows:
	 * <ul>
	 *  <li>Call {@link #getLibrary()} to get the Library properties as a {@linkplain Library} object.</li>
	 *  <li>Call {@link #getTracks()} to get the Tracks properties as a Map of {@linkplain Track} objects. The Map key is the Track id.</li>
	 *  <li>Call {@link #getPlaylists()} to get the Playlists properties as a Map of {@linkplain Playlist} objects. The Map key is the Playlist id.</li>
	 * </ul>
	 * @throws DocumentException If an error occurs during parsing.
	 */
	public void parse() throws DocumentException {
		// Create a new SAXReader.
		SAXReader reader = new SAXReader();
		// Add the three handlers to the SAXReader.
		reader.addHandler(XPATH_LIBRARY, this.getLibraryHandler());
		reader.addHandler(XPATH_TRACKS, this.getTrackHandler());
		reader.addHandler(XPATH_PLAYLISTS, this.getPlaylistHandler());
		// Start reading the XML File.
		reader.read(this.file);
	}
	
	/**
	 * Creates and returns a new {@linkplain ElementHandler} that parses the library properties from the XML file.<br>
	 * @return The library {@linkplain ElementHandler}.
	 */
	private ElementHandler getLibraryHandler() {
		return new ElementHandler() {
			@Override
			public void onStart(ElementPath elementPath) {}
			
			@Override
			public void onEnd(ElementPath elementPath) {
				Parser.this.library = (Library) Parser.this.addPropertiesToObject(Parser.this.library, elementPath);
			}
		};
	}
	
	/**
	 * Creates and returns a new {@linkplain ElementHandler} that parses the tracks properties from the XML file.<br>
	 * @return The {@linkplain ElementHandler}.
	 */
	private ElementHandler getTrackHandler() {
		return new ElementHandler() {
			@Override
			public void onStart(ElementPath elementPath) {}
			
			@Override
			public void onEnd(ElementPath elementPath) {
				Track track = (Track) Parser.this.addPropertiesToObject(new Track(), elementPath);
				Parser.this.tracks.put(track.getTrackID(), track);
			}
		};
	}

	
	/**
	 * Creates and returns a new {@linkplain ElementHandler} that parses the playlists properties from the XML file.<br>
	 * @return The {@linkplain ElementHandler}.
	 */
	private ElementHandler getPlaylistHandler() {
		return new ElementHandler() {
			@Override
			public void onStart(ElementPath elementPath) {}
			
			@Override
			public void onEnd(ElementPath elementPath) {
				Playlist playlist = (Playlist) Parser.this.addPropertiesToObject(new Playlist(), elementPath);
				Parser.this.playlists.put(playlist.getPlaylistID(), playlist);
			}
		};
	}
	
	// --------------------------------------------------
	// Methods
	// --------------------------------------------------
	
	/**
	 * Parse properties from an {@linkplain ElementPath} and add them to an {@linkplain ITunes} object.
	 * @param object The {@linkplain ITunes} object to add the properties.
	 * @param elementPath The {@linkplain ElementPath} with the properties to add.
	 * @return The {@linkplain ITunes} object after the properties have been added.
	 */
	private <T> T addPropertiesToObject(T object, ElementPath elementPath) {
		List<Element> elements = elementPath.getCurrent().elements();
		
		for ( int i=0; i<elements.size(); i++ ) {
			// Get the text value (property key) of the current Element.
			String key = elements.get(i).getText();
			
			// The current Element key name must be "key". Otherwise it is not a valid property key Element.
			// Valid:
			//   <key>Major Version</key>
			// Not valid:
			//   <plist version="1.0">
			// Also the two lines which defines the arrays for the Tracks and the Playlists must be skipped:
			//   <key>Tracks</key>
			//   <key>Playlists</key>
			if ( ! elements.get(i).getName().equals("key") ) {
				continue;
			} else if ( key.equals("Tracks") ) {
				continue;
			} else if ( key.equals("Playlists") ) {
				continue;
			}
			
			// When no continue was executed, the text value is a valid property key.
			// The next Element must be the property value - increase the loop counter.
			i++;
			
			// Get the property value from the Element with the increased loop counter.
			// If the value is a boolean the Element has no value. The Element key defines true or false.
			// If the object is a Playlist and the Element name is "array", call the method to create and add the Track Map.
			String value;
			if ( elements.get(i).getName().equals("true") ) {
				value = "true";
			} else if ( elements.get(i).getName().equals("false") ) {
				value = "false";
			} else if ( object instanceof Playlist && elements.get(i).getName().equals("array") ) {
				Parser.this.addTracksToPlaylist(elements.get(i), (Playlist) object);
				continue;
			} else {
				value = elements.get(i).getText();
			}
			
			// Add the key-value pair to the object depending on the object type.
			if ( object instanceof Library ) {
				try {
					this.addToLibrary((Library) object, key, value);
				} catch (ParseException | MalformedURLException e) {
					log.log(Level.SEVERE, "Error while parsing a Library property.", e);
				}
			} else if ( object instanceof Track ) {
				try {
					this.addToTrack((Track) object, key, value);
				} catch (ParseException | MalformedURLException e) {
					log.log(Level.SEVERE, "Error while parsing a Track property.", e);
				}
			} else if ( object instanceof Playlist ) {
				try {
					this.addToPlaylist((Playlist) object, key, value);
				} catch (ParseException e) {
					log.log(Level.SEVERE, "Error while parsing a Playlist property.", e);
				}
			}
		}
		
		// Return the object.
		return object;
	}
	
	/**
	 * Add a key-value pair to the Library object.<br>
	 * This method parses the value in the correct data type if needed.
	 * @param key The key.
	 * @param value The value.
	 * @throws ParseException If the given value can not be parsed into the correct data type.
	 * @throws MalformedURLException If the given value can not be parsed into an {@linkplain URL} object.
	 */
	private void addToLibrary(Library library, String key, String value) throws ParseException, MalformedURLException {
		switch (key) {
		case "Major Version":
			library.setMajorVersion(Integer.parseInt(value));
			break;
		case "Minor Version":
			library.setMinorVersion(Integer.parseInt(value));
			break;
		case "Date":
			library.setDate(DATEFORMAT.parse(value));
			break;
		case "Application Version":
			library.setApplicationVersion(value);
			break;
		case "Features":
			library.setFeatures(Integer.parseInt(value));
			break;
		case "Show Content Ratings":
			library.setShowContentRatings(Boolean.parseBoolean(value));
			break;
		case "Music Folder":
			library.setMusicFolder(new URL(value));
			break;
		case "Library Persistent ID":
			library.setLibraryPersistentID(value);
			break;
		default:
			log.warning("Unknown Library key '"+key+"' with value '"+value+"'");
			break;
		}
	}
	
	/**
	 * Add a key-value pair to a given Track object.<br>
	 * This method parses the value in the correct data type if needed.
	 * @param track The {@linkplain Track} object.
	 * @param key The key.
	 * @param value The value.
	 * @throws ParseException If the given value can not be parsed into the correct data type.
	 * @throws MalformedURLException If the given value can not be parsed into an {@linkplain URL} object.
	 */
	private void addToTrack(Track track, String key, String value) throws ParseException, MalformedURLException {
		switch (key) {
		case "Album":
			track.setAlbum(value);
			break;
		case "Album Artist":
			track.setAlbumArtist(value);
			break;
		case "Album Rating":
			track.setAlbumRating(Integer.parseInt(value));
			break;
		case "Album Rating Computed":
			track.setAlbumRatingComputed(Boolean.parseBoolean(value));
			break;
		case "Artist":
			track.setArtist(value);
			break;
		case "Artwork Count":
			track.setArtworkCount(Integer.parseInt(value));
			break;
		case "Bit Rate":
			track.setBitRate(Integer.parseInt(value));
			break;
		case "BPM":
			track.setBpm(Integer.parseInt(value));
			break;
		case "Comments":
			track.setComments(value);
			break;
		case "Compilation":
			track.setCompilation(Boolean.parseBoolean(value));
			break;
		case "Composer":
			track.setComposer(value);
			break;
		case "Clean":
			track.setClean(Boolean.parseBoolean(value));
			break;
		case "Date Added":
			track.setDateAdded(DATEFORMAT.parse(value));
			break;
		case "Date Modified":
			track.setDateModified(DATEFORMAT.parse(value));
			break;
		case "Disc Count":
			track.setDiscCount(Integer.parseInt(value));
			break;
		case "Disc Number":
			track.setDiscNumber(Integer.parseInt(value));
			break;
		case "Disabled":
			track.setDisabled(Boolean.parseBoolean(value));
			break;
		case "Episode":
			track.setEpisode(value);
			break;
		case "Episode Order":
			track.setEpisodeOrder(Integer.parseInt(value));
			break;
		case "Equalizer":
			track.setEqualizer(value);
			break;
		case "Explicit":
			track.setExplicit(Boolean.parseBoolean(value));
			break;
		case "File Folder Count":
			track.setFileFolderCount(Integer.parseInt(value));
			break;
		case "File Type":
			track.setFileType(Long.parseLong(value));
			break;
		case "Genre":
			track.setGenre(value);
			break;
		case "Grouping":
			track.setGrouping(value);
			break;
		case "Kind":
			track.setKind(value);
			break;
		case "Library Folder Count":
			track.setLibraryFolderCount(Integer.parseInt(value));
			break;
		case "Location":
			track.setLocation(new URL(value));
			break;
		case "Loved":
			track.setLoved(Boolean.parseBoolean(value));
			break;
		case "Name":
			track.setName(value);
			break;
		case "Part Of Gapless Album":
			track.setPartOfGaplessAlbum(Boolean.parseBoolean(value));
			break;
		case "Persistent ID":
			track.setPersistentID(value);
			break;
		case "Play Count":
			track.setPlayCount(Integer.parseInt(value));
			break;
		case "Play Date":
			track.setPlayDate(Long.parseLong(value));
			break;
		case "Play Date UTC":
			track.setPlayDateUTC(DATEFORMAT.parse(value));
			break;
		case "Purchased":
			track.setPurchased(Boolean.parseBoolean(value));
			break;
		case "Rating":
			track.setRating(Integer.parseInt(value));
			break;
		case "Release Date":
			track.setReleaseDate(DATEFORMAT.parse(value));
			break;
		case "Sample Rate":
			track.setSampleRate(Integer.parseInt(value));
			break;
		case "Size":
			track.setSize(Long.parseLong(value));
			break;
		case "Skip Count":
			track.setSkipCount(Integer.parseInt(value));
			break;
		case "Skip Date":
			track.setSkipDate(DATEFORMAT.parse(value));
			break;
		case "Season":
			track.setSeason(Integer.parseInt(value));
			break;
		case "Series":
			track.setSeries(value);
			break;
		case "Sort Album":
			track.setSortAlbum(value);
			break;
		case "Sort Album Artist":
			track.setSortAlbumArtist(value);
			break;
		case "Sort Artist":
			track.setSortArtist(value);
			break;
		case "Sort Composer":
			track.setSortComposer(value);
			break;
		case "Sort Name":
			track.setSortName(value);
			break;
		case "Sort Series":
			track.setSortSeries(value);
			break;
		case "Start Time":
			track.setStartTime(Long.parseLong(value));
			break;
		case "Stop Time":
			track.setStopTime(Long.parseLong(value));
			break;
		case "Total Time":
			track.setTotalTime(Long.parseLong(value));
			break;
		case "Track Count":
			track.setTrackCount(Integer.parseInt(value));
			break;
		case "Track ID":
			track.setTrackID(Integer.parseInt(value));
			break;
		case "Track Number":
			track.setTrackNumber(Integer.parseInt(value));
			break;
		case "Track Type":
			track.setTrackType(value);
			break;
		case "Volume Adjustment":
			track.setVolumeAdjustment(Integer.parseInt(value));
			break;
		case "Year":
			track.setYear(Integer.parseInt(value));
			break;
		case "Has Video":
			track.setVideo(Boolean.parseBoolean(value));
			break;
		case "Movie":
			track.setMovie(Boolean.parseBoolean(value));
			break;
		case "Video Height":
			track.setVideoHeight(Integer.parseInt(value));
			break;
		case "Video Width":
			track.setVideoWidth(Integer.parseInt(value));
			break;
		case "Unplayed":
			track.setUnplayed(Boolean.parseBoolean(value));
			break;
		case "Podcast":
			track.setPodcast(Boolean.parseBoolean(value));
			break;
		default:
			log.warning("Unknown Track key '"+key+"' with value '"+value+"'");
			break;
		}
		
	}
	
	/**
	 * Add a key-value pair to a given Playlist object.<br>
	 * This method parses the value in the correct data type if needed.
	 * @param playlist The {@linkplain Playlist} object.
	 * @param key The key.
	 * @param value The value.
	 * @throws ParseException If the given value can not be parsed into the correct data type.
	 */
	private void addToPlaylist(Playlist playlist, String key, String value) throws ParseException {
		switch (key) {
		case "All Items":
			playlist.setAllItems(Boolean.parseBoolean(value));
			break;
		case "Audiobooks":
			playlist.setAudiobooks(Boolean.parseBoolean(value));
			break;
		case "Distinguished Kind":
			playlist.setDistinguishedKind(Integer.parseInt(value));
			break;
		case "Folder":
			playlist.setFolder(Boolean.parseBoolean(value));
			break;
		case "Master":
			playlist.setMaster(Boolean.parseBoolean(value));
			break;
		case "Movies":
			playlist.setMovies(Boolean.parseBoolean(value));
			break;
		case "Music":
			playlist.setMusic(Boolean.parseBoolean(value));
			break;
		case "Name":
			playlist.setName(value);
			break;
		case "Parent Persistent ID":
			playlist.setParentPersistentID(value);
			break;
		case "Playlist ID":
			playlist.setPlaylistID(Integer.parseInt(value));
			break;
		case "Playlist Items":
			// Playlist items will not be added here.
			// In the ElementHandler for Playlists, the method "addTracksToPlaylist" is called to add the Tracks Map.
			break;
		case "Playlist Persistent ID":
			playlist.setPlaylistPersistentID(value);
			break;
		case "Podcasts":
			playlist.setPodcasts(Boolean.parseBoolean(value));
			break;
		case "Smart Criteria":
			value = value.replaceAll("\\s+", "");
			playlist.setSmartCriteria(value);
			break;
		case "Smart Info":
			value = value.replaceAll("\\s+", "");
			playlist.setSmartInfo(value);
			break;
		case "TV Shows":
			playlist.setTvShows(Boolean.parseBoolean(value));
			break;
		case "Visible":
			playlist.setVisible(Boolean.parseBoolean(value));
			break;
		default:
			log.warning("Unknown Playlist key '"+key+"' with value '"+value+"'");
			break;
		}
	}
	
	/**
	 * Creates a Map of Tracks for the given XML {@linkplain Element}.<br>
	 * The created Map will be set as "playlistItems" for the given Playlist object.
	 * @param element The XML {@linkplain Element} of this Playlist.
	 * @param playlist The {@linkplain Playlist} object.
	 */
	private void addTracksToPlaylist(Element element, Playlist playlist) {
		List<Element> elements = element.elements();
		Map<Integer, Track> tracks = new HashMap<>();
		
		for ( int i=0; i<elements.size(); i++ ) {
			int id = Integer.parseInt(elements.get(i).elements().get(1).getText());
			Track track = this.tracks.get(id);
			tracks.put(id, track);
		}
		
		playlist.setPlaylistItems(tracks);
	}
	
	// --------------------------------------------------
	// Getter & Setter
	// --------------------------------------------------
	
	/**
	 * Get the iTunes XML File.
	 * @return The iTunes XML file.
	 */
	public File getFile() {
		return this.file;
	}
	
	/**
	 * Set the iTunes XML File to parse.
	 * @param file The iTunes XML file.
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
	/**
	 * Get the parsed {@linkplain Library} object.<br>
	 * Returns null if the Library was not parsed.
	 * @return The {@linkplain Library} object.
	 */
	public Library getLibrary() {
		return this.library;
	}
	
	/**
	 * Get the parsed Map of {@linkplain Track} objects.<br>
	 * Returns null if the Tracks were not parsed.
	 * @return The Map of {@linkplain Track} objects.
	 */
	public Map<Integer, Track> getTracks() {
		return this.tracks;
	}
	
	/**
	 * Get the parsed Map of {@linkplain Playlist} objects.<br>
	 * Returns null if the Playlists were not parsed.
	 * @return The Map of {@linkplain Playlist} objects.
	 */
	public Map<Integer, Playlist> getPlaylists() {
		return this.playlists;
	}

}