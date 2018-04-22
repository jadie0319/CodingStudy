package Chapter7.Question3;

import java.util.LinkedList;
import java.util.Queue;

public class Playlist {
	private String playlistName;
	private Song song;
	private Queue<Song> queue = new LinkedList<Song>();
	public Playlist() {}
	
	public Playlist(Song song, Queue<Song> que) {
//		super();
		this.song = song;
		this.queue = que;
	}
	
	public void setPlayName(String str) {
		playlistName = str;
	}
	public String getPlayName() {
		return playlistName;
	}
	
	
	public Playlist(Song song) {
		this.song = song;
	}
	
	public Song getNextSongToPlay() {
		return queue.peek();
	}
	
	public void queueUpSong(Song s) {
		queue.add(s);
	}
	
	public void deleteSong(Song s) {
		queue.remove(s);
		
	}
	

}
