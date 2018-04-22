package Chapter7.Question3;

import java.util.ArrayList;
import java.util.List;

public class CD {
	private String artistName;
	private List<Song> songs = new ArrayList<Song>();
	
	public String getArtistName() {
		return artistName;
	}
	// deleteSong() ....? not yet.
	
	public void addSong(Song song) {
		if(songs.size() == 0) {
			songs.add(song);
			return;
		}
		
		if(!songs.contains(song)) {
			songs.add(song);
		} else {
			System.out.println("Already exist song(" + song.getTitle() + ")");
		}
		
		
		
		
//		for(Song s : songs) {
//			if(s.getTitle().equals(song.getTitle())) {
//				System.out.println("Already exist song");
//			} else {
//				songs.add(song);
//			}
//		}
		
		
	}
	
	public int songSize() {
		return songs.size();
	}
	
	
	public void printSongList() {
		for(int i=0 ; i < songs.size() ; i++) {
			System.out.println("Song [" + i + "] : " + songs.get(i).getTitle());
		}
	}
	

}
