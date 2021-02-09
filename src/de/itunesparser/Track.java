package de.itunesparser;

import java.net.URL;
import java.util.Date;

/**
 * This class represents an iTunes Track.<br>
 * Every property of an iTunes Track is stored in this object.
 * 
 * @version 1.1
 * @author Phillip Remmert
 * @see https://developer.apple.com/documentation/ituneslibrary/itlibmediaitem
 */
public class Track {
	private String album;
	private String albumArtist;
	private Integer albumRating;
	private Boolean albumRatingComputed;
	private String artist;
	private Integer artworkCount;
	private Integer bitrate;
	private Integer bpm;
	private Boolean clean;
	private String comments;
	private Boolean compilation;
	private String composer;
	private Date dateAdded;
	private Date dateModified;
	private Boolean disabled;
	private Integer discCount;
	private Integer discNumber;
	private String episode;
	private Integer episodeOrder;
	private String equalizer;
	private Boolean explicit;
	private Integer fileFolderCount;
	private Long fileType;
	private String genre;
	private String grouping;
	private String kind;
	private Integer libraryFolderCount;
	private URL location;
	private Boolean loved;
	private String name;
	private Boolean partOfGaplessAlbum;
	private String persistentID;
	private Integer playCount;
	private Long playDate;
	private Date playDateUTC;
	private Boolean purchased;
	private Integer rating;
	private Date releaseDate;
	private Integer sampleRate;
	private Integer season;
	private String series;
	private Long size;
	private Integer skipCount;
	private Date skipDate;
	private String sortAlbum;
	private String sortAlbumArtist;
	private String sortArtist;
	private String sortComposer;
	private String sortName;
	private String sortSeries;
	private Long startTime;
	private Long stopTime;
	private Long totalTime;
	private Integer trackCount;
	private Integer trackID;
	private Integer trackNumber;
	private String trackType;
	private Integer volumeAdjustment;
	private Integer year;
	
	private Boolean video;
	private Boolean movie;
	private Integer videoHeight;
	private Integer videoWidth;
	private Boolean unplayed;
	private Boolean podcast;
	
	// --------------------------------------------------
	// Getter
	// --------------------------------------------------
	
	public String getAlbum() {
		return this.album;
	}
	
	public String getAlbumArtist() {
		return this.albumArtist;
	}
	
	public Integer getAlbumRating() {
		return this.albumRating;
	}
	
	public Boolean isAlbumRatingComputed() {
		return this.albumRatingComputed;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public Integer getArtworkCount() {
		return this.artworkCount;
	}
	
	public Integer getBitRate() {
		return this.bitrate;
	}
	
	public Integer getBpm() {
		return this.bpm;
	}
	
	public Boolean isClean() {
		return this.clean;
	}
	
	public String getComments() {
		return this.comments;
	}
	
	public Boolean isCompilation() {
		return this.compilation;
	}
	
	public String getComposer() {
		return this.composer;
	}
	
	public Date getDateAdded() {
		return this.dateAdded;
	}
	
	public Date getDateModified() {
		return this.dateModified;
	}
	
	public Boolean isDisabled() {
		return this.disabled;
	}
	
	public Integer getDiscCount() {
		return this.discCount;
	}
	
	public Integer getDiscNumber() {
		return this.discNumber;
	}
	
	public String getEpisode() {
		return this.episode;
	}
	
	public Integer getEpisodeOrder() {
		return this.episodeOrder;
	}
	
	public String getEqualizer() {
		return this.equalizer;
	}
	
	public Boolean isExplicit() {
		return this.explicit;
	}
	
	public Integer getFileFolderCount() {
		return this.fileFolderCount;
	}
	
	public Long getFileType() {
		return this.fileType;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getGrouping() {
		return this.grouping;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public Integer getLibraryFolderCount() {
		return this.libraryFolderCount;
	}
	
	public URL getLocation() {
		return this.location;
	}
	
	public Boolean isLoved() {
		return this.loved;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Boolean isPartOfGaplessAlbum() {
		return this.partOfGaplessAlbum;
	}
	
	public String getPersistentID() {
		return this.persistentID;
	}
	
	public Integer getPlayCount() {
		return this.playCount;
	}
	
	public Long getPlayDate() {
		return this.playDate;
	}
	
	public Date getPlayDateUTC() {
		return this.playDateUTC;
	}
	
	public Boolean isPurchased() {
		return this.purchased;
	}
	
	public Integer getRating() {
		return this.rating;
	}
	
	public Date getReleaseDate() {
		return this.releaseDate;
	}
	
	public Integer getSampleRate() {
		return this.sampleRate;
	}
	
	public Integer getSeason() {
		return this.season;
	}
	
	public String getSeries() {
		return this.series;
	}
	
	public Long getSize() {
		return this.size;
	}
	
	public Integer getSkipCount() {
		return this.skipCount;
	}
	
	public Date getSkipDate() {
		return this.skipDate;
	}
	
	public String getSortAlbum() {
		return this.sortAlbum;
	}
	
	public String getSortAlbumArtist() {
		return this.sortAlbumArtist;
	}
	
	public String getSortArtist() {
		return this.sortArtist;
	}
	
	public String getSortComposer() {
		return this.sortComposer;
	}
	
	public String getSortName() {
		return this.sortName;
	}
	
	public String getSortSeries() {
		return this.sortSeries;
	}
	
	public Long getStartTime() {
		return this.startTime;
	}
	
	public Long getStopTime() {
		return this.stopTime;
	}
	
	public Long getTotalTime() {
		return this.totalTime;
	}
	
	public Integer getTrackCount() {
		return this.trackCount;
	}
	
	public Integer getTrackID() {
		return this.trackID;
	}
	
	public Integer getTrackNumber() {
		return this.trackNumber;
	}
	
	public String getTrackType() {
		return this.trackType;
	}
	
	public Integer getVolumeAdjustment() {
		return this.volumeAdjustment;
	}
	
	public Integer getYear() {
		return this.year;
	}
	
	public Boolean isVideo(){
		return this.video;
	}
	
	public Boolean isMovie(){
		return this.movie;
	}
	
	public Integer getVideoHeight(){
		return this.videoHeight;
	}
	
	public Integer getVideoWidth(){
		return this.videoWidth;
	}
	
	public Boolean isUnplayed(){
		return this.unplayed;
	}
	
	public Boolean isPodcast(){
		return this.podcast;
	}
	
	
	// --------------------------------------------------
	// Setter
	// --------------------------------------------------
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}
	
	public void setAlbumRating(Integer albumRating) {
		this.albumRating = albumRating;
	}
	
	public void setAlbumRatingComputed(Boolean albumRatingComputed) {
		this.albumRatingComputed = albumRatingComputed;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setArtworkCount(Integer artworkCount) {
		this.artworkCount = artworkCount;
	}
	
	public void setBitRate(Integer bitRate) {
		this.bitrate = bitRate;
	}
	
	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}
	
	public void setClean(Boolean clean) {
		this.clean = clean;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public void setCompilation(Boolean compilation) {
		this.compilation = compilation;
	}
	
	public void setComposer(String composer) {
		this.composer = composer;
	}
	
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
	public void setDiscCount(Integer discCount) {
		this.discCount = discCount;
	}
	
	public void setDiscNumber(Integer discNumber) {
		this.discNumber = discNumber;
	}
	
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	
	public void setEpisodeOrder(Integer episodeOrder) {
		this.episodeOrder = episodeOrder;
	}
	
	public void setEqualizer(String equalizer) {
		this.equalizer = equalizer;
	}
	
	public void setExplicit(Boolean explicit) {
		this.explicit = explicit;
	}
	
	public void setFileFolderCount(Integer fileFolderCount) {
		this.fileFolderCount = fileFolderCount;
	}
	
	public void setFileType(Long fileType) {
		this.fileType = fileType;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void setLibraryFolderCount(Integer libraryFolderCount) {
		this.libraryFolderCount = libraryFolderCount;
	}
	
	public void setLocation(URL location) {
		this.location = location;
	}
	
	public void setLoved(Boolean loved) {
		this.loved = loved;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPartOfGaplessAlbum(Boolean partOfGaplessAlbum) {
		this.partOfGaplessAlbum = partOfGaplessAlbum;
	}
	
	public void setPersistentID(String persistentID) {
		this.persistentID = persistentID;
	}
	
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
	
	public void setPlayDate(Long playDate) {
		this.playDate = playDate;
	}
	
	public void setPlayDateUTC(Date playDateUTC) {
		this.playDateUTC = playDateUTC;
	}
	
	public void setPurchased(Boolean purchased) {
		this.purchased = purchased;
	}
	
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setSampleRate(Integer sampleRate) {
		this.sampleRate = sampleRate;
	}
	
	public void setSeason(Integer season) {
		this.season = season;
	}
	
	public void setSeries(String series) {
		this.series = series;
	}
	
	public void setSize(Long size) {
		this.size = size;
	}
	
	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}
	
	public void setSkipDate(Date skipDate) {
		this.skipDate = skipDate;
	}
	
	public void setSortAlbum(String sortAlbum) {
		this.sortAlbum = sortAlbum;
	}
	
	public void setSortAlbumArtist(String sortAlbumArtist) {
		this.sortAlbumArtist = sortAlbumArtist;
	}
	
	public void setSortArtist(String sortArtist) {
		this.sortArtist = sortArtist;
	}
	
	public void setSortComposer(String sortComposer) {
		this.sortComposer = sortComposer;
	}
	
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	public void setSortSeries(String sortSeries) {
		this.sortSeries = sortSeries;
	}
	
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	
	public void setStopTime(Long stopTime) {
		this.stopTime = stopTime;
	}
	
	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}
	
	public void setTrackID(Integer trackID) {
		this.trackID = trackID;
	}
	
	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}
	
	public void setTrackType(String trackType) {
		this.trackType = trackType;
	}
	
	public void setVolumeAdjustment(Integer volumeAdjustment) {
		this.volumeAdjustment = volumeAdjustment;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public void setVideo(Boolean isVideo){
		this.video = isVideo;				
	}
	
	public void setMovie(Boolean isMovie){
		this.movie = isMovie;				
	}
	
	public void setVideoHeight(Integer videoHeight){
		this.videoHeight = videoHeight;				
	}
	
	public void setVideoWidth(Integer videoWidth){
		this.videoWidth = videoWidth;	
	}
	
	public void setUnplayed(Boolean isUnplayed){
		this.unplayed = isUnplayed;				
	}
	
	public void setPodcast(Boolean isPodcast){
		this.podcast = isPodcast;
	}
	
}