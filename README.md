
[![Maven Central](https://img.shields.io/maven-central/v/com.github.pireba/itunesparser?color=success&logo=apachemaven&style=for-the-badge)](https://mvnrepository.com/artifact/com.github.pireba/itunesparser)
[![Javadoc](https://javadoc.io/badge2/com.github.pireba/itunesparser/javadoc.svg?color=success&logo=readthedocs&style=for-the-badge)](https://javadoc.io/doc/com.github.pireba/itunesparser)

# iTunes Parser
A Java parser for the iTunes Library XML file.

# Depencies
dom4j to parse the XML file.
https://dom4j.github.io/

# How to use
## Create a parser object
    File file = new File("/home/phillip/iTunes Library.xml");
    Parser parser = new Parser(file);

## Parse the XML file
    try {
        parser.parse()
    } catch ( DocumentException e ) {
        e.printStackTrace();
    }

## Library
The global properties of the iTunes Library (application version, path to music folder etc.) are stored in a Library object.
If a property of the Library is not set in the XML file, the getter returns null.

### Get the Library object and print some properties
    Library library = parser.getLibrary();
    System.out.println(library.getApplicationVersion());
    System.out.println(library.getMusicFolder());
    ...

## Tracks
The properties of a Track (name, artist etc.) are stored in a Track object.
If a property of a Track is not set in the XML file, the getter returns null.
The Tracks of the Library are collected in a Track Map. The Map key is the Track ID of the Track.

### Get the Map with Tracks and print some properties of one
    Map<Integer, Track> tracks = parser.getTracks();
    Track track1 = tracks.get(100);
    System.out.println(track1.getName());
    System.out.println(track1.isDisabled());
    ...

### Iterate through the Tracks
    Map<Integer, Track> tracks = parser.getTracks();
    for ( Track track : tracks.values() ) {
        System.out.println(track.getName());
    }

## Playlists
The properties of a Playlist (name, is folder etc.) are stored in a Playlist object.
If a property of a Playlist is not set in the XML file, the getter returns null.
The Playlists of the Library are collected in a Playlist Map. The Map key is the Playlist ID of the Playlist.
The Tracks of a Playlist are collected as a Track Map in the attribute "playlistItems".

### Get the Map with Playlists and print some properties of one
    Map<Integer, Playlist> playlists = parser.getPlaylists();
    Playlist playlist1 = playlists.get(100);
    System.out.println(playlist1.getName());
    System.out.println(playlist1.isFolder());
    ...

### Iterate through the Playlists
    Map<Integer, Playlist> playlists = parser.getPlaylists();
    for ( Playlist playlist;playlists.values() ) {
        System.out.println(playlist.getName());
    }

### Get the Tracks of a Playlist
    Map<Integer, Playlist> playlists = parser.getPlaylists();
    Playlist playlist1 = playlists.get(100);
    Map<Integer, Track> tracksOfPlaylist1 = playlist1.getPlaylistItems();
    for ( Track track : tracksOfPlaylist1.values() ) {
        System.out.println(track.getName());
    }

## Build
iTunes-Parser is a Maven project.

Build an executable jar from the source:

```
mvn clean compile package
```

Create a new release and deploy it to Maven central:

```
mvn clean release:clean release:prepare release:perform || mvn release:rollback
```

# TODO
- [ ] Save the order of the songs in a playlist.
