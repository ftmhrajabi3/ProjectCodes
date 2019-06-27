package Try.logic;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

import main.ID3v1;
import main.ID3v2;
import main.InvalidDataException;
import main.Mp3File;
import main.UnsupportedTagException;

public class Song implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String artist;
	private String album;
	private String path;
	
	private long lastListened;
	
	private Mp3File mp3file;

	private byte[] albumImageData;
	
	private String mimeType;
	
	public Song(String path) {
		super();
		this.path = path;
		metadata();
	}

	private void metadata() {
		try {
			mp3file = new Mp3File(path);
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mp3file.hasId3v1Tag()) {
		  ID3v1 id3v1Tag = mp3file.getId3v1Tag();
		  artist =  id3v1Tag.getArtist();
		  title = id3v1Tag.getTitle();
		  album = id3v1Tag.getAlbum();

		}
		else if (mp3file.hasId3v2Tag()) {
			  ID3v2 id3v2Tag = mp3file.getId3v2Tag();
			  artist = id3v2Tag.getArtist();
			  title = id3v2Tag.getTitle();
			  album = id3v2Tag.getAlbum();
			  albumImageData = id3v2Tag.getAlbumImage();
			  mimeType = id3v2Tag.getAlbumImageMimeType();
			  getAlbumImageData();
			}

	
	}
	
	public void getAlbumImageData() {
		try {
			if (mp3file.hasId3v2Tag()) {
				if (albumImageData != null) {
					File file = new File("D:\\Jpotify\\SampelCode\\SongPic\\" + title + ".jpeg");
					if(!file.exists()) {
						file.createNewFile();
						RandomAccessFile randomfile = new RandomAccessFile(file, "rw");
						randomfile.write(albumImageData);
						randomfile.close();						
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public long getLastListened() {
		return lastListened;
	}

	public void setLastListened(long lastListened) {
		this.lastListened = lastListened;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public String getPath() {
		return path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + (int) (lastListened ^ (lastListened >>> 32));
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (lastListened != other.lastListened)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
