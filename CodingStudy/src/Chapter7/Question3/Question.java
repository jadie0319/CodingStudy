package Chapter7.Question3;

import java.util.HashSet;

/*
 * 7-3 주크박스 : 객체 지향 원칙에 따라 음악용 주크박스를 설계하라.
 */
public class Question {

	public static void main(String[] args) {
		CD cd1 = new CD();
		Song song1 = new Song("song1",100);
		Song song2 = new Song("song2",100);
		Song song3 = new Song("song3",100);
		Song song4 = new Song("song4",100);
		Song song5 = new Song("song5",100);
		
		cd1.addSong(song1);cd1.addSong(song2);
		cd1.addSong(song3);cd1.addSong(song4);
		cd1.addSong(song5);
		cd1.addSong(song3);
		
		System.out.println("In cd1 : " + cd1.songSize());
		cd1.printSongList();
		
		Playlist playlist = new Playlist();
		playlist.setPlayName("1st album");
		
		playlist.queueUpSong(song1);
		playlist.queueUpSong(song2);
		playlist.queueUpSong(song3);
		playlist.queueUpSong(song4);
		playlist.queueUpSong(song5);
		
		System.out.println(playlist.getNextSongToPlay().getTitle());
		
		CDPlayer cdp = new CDPlayer(cd1, playlist);
		
		cdp.playSong(song3);
		
		User user = new User("Choi", 4885);
		
		Jukebox juke = new Jukebox(cdp,user, new HashSet<CD>(), new SongSelector(song1));
		
		System.out.println(user.getName() + "      " + juke.getCurrentSong().getTitle());
		
		
	}

}
