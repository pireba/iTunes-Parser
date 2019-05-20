package de.itunesparser;

import java.util.Map;

/**
 * This class represents an iTunes Playlist.<br>
 * Every property of an iTunes Playlist is stored in this object.<br>
 * The Tracks of a Playlist are stored as a Map of {@linkplain Track} objects in the attribute "playlistItems".
 * 
 * @version 1.0
 * @author Phillip Remmert
 * @see https://developer.apple.com/documentation/ituneslibrary/itlibplaylist
 */
public class Playlist {
	private Boolean allItems;
	private Boolean audiobooks;
	private Integer distinguishedKind;
	private Boolean folder;
	private Boolean master;
	private Boolean movies;
	private Boolean music;
	private String name;
	private String parentPersistentID;
	private Integer playlistID;
	private Map<Integer, Track> playlistItems;
	private String playlistPersistentID;
	private Boolean podcasts;
	private String smartCriteria;
	private String smartInfo;
	private Boolean tvShows;
	private Boolean visible;
	
	// --------------------------------------------------
	// Getter
	// --------------------------------------------------
	
	public Boolean isAllItems() {
		return this.allItems;
	}
	
	public Boolean isAudiobooks() {
		return this.audiobooks;
	}
	
	public Integer getDistinguishedKind() {
		return this.distinguishedKind;
	}
	
	public Boolean isFolder() {
		return this.folder;
	}
	
	public Boolean isMaster() {
		return this.master;
	}
	
	public Boolean isMovies() {
		return this.movies;
	}
	
	public Boolean isMusic() {
		return this.music;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getParentPersistentID() {
		return this.parentPersistentID;
	}
	
	public Integer getPlaylistID() {
		return this.playlistID;
	}
	
	public Map<Integer, Track> getPlaylistItems() {
		return this.playlistItems;
	}
	
	public String getPlaylistPersistentID() {
		return this.playlistPersistentID;
	}
	
	public Boolean isPodcasts() {
		return this.podcasts;
	}
	
	public String getSmartCriteria() {
		return this.smartCriteria;
	}
	
	public String getSmartInfo() {
		return this.smartInfo;
	}
	
	public Boolean isTvShows() {
		return this.tvShows;
	}
	
	public Boolean isVisible() {
		return this.visible;
	}
	
	// --------------------------------------------------
	// Setter
	// --------------------------------------------------
	
	public void setAllItems(Boolean allItems) {
		this.allItems = allItems;
	}
	
	public void setAudiobooks(Boolean audiobooks) {
		this.audiobooks = audiobooks;
	}
	
	public void setDistinguishedKind(Integer distinguishedKind) {
		this.distinguishedKind = distinguishedKind;
	}
	
	public void setFolder(Boolean folder) {
		this.folder = folder;
	}
	
	public void setMaster(Boolean master) {
		this.master = master;
	}
	
	public void setMovies(Boolean movies) {
		this.movies = movies;
	}
	
	public void setMusic(Boolean music) {
		this.music = music;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setParentPersistentID(String parentPersistentID) {
		this.parentPersistentID = parentPersistentID;
	}
	
	public void setPlaylistID(Integer playlistID) {
		this.playlistID = playlistID;
	}
	
	public void setPlaylistItems(Map<Integer, Track> playlistItems) {
		this.playlistItems = playlistItems;
	}
	
	public void setPlaylistPersistentID(String playlistPersistentID) {
		this.playlistPersistentID = playlistPersistentID;
	}
	
	public void setPodcasts(Boolean podcasts) {
		this.podcasts = podcasts;
	}
	
	public void setSmartCriteria(String smartCriteria) {
		this.smartCriteria = smartCriteria;
	}
	
	public void setSmartInfo(String smartInfo) {
		this.smartInfo = smartInfo;
	}
	
	public void setTvShows(Boolean tvShows) {
		this.tvShows = tvShows;
	}
	
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
}