package Chapter7.Question3;

import java.util.Set;

public class Jukebox {
	private CDPlayer cdp;
	private User user;
	private Set<CD> cdCollection;
	private SongSelector selector;
	
	public Jukebox(CDPlayer cdp, User u, Set<CD> col, SongSelector sc) {
//		super();
		this.cdp = cdp;
		this.user = u;
		this.cdCollection = col;
		this.selector = sc;
	}
	
	public Song getCurrentSong() {
		return selector.getCurrentSong();
	}
	
	public void setUser(User u) {
		this.user = u;
	}
}
