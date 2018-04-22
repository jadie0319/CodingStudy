package Chapter7.Question3;

public class CDPlayer {
	private Playlist p;
	private CD c;
	
	public CDPlayer(Playlist p) {
		this.p = p;
	}
	public CDPlayer(CD c) {
		this.c = c;
	}
	
	public CDPlayer(CD c, Playlist p) {
		this.p = p;
		this.c = c;
	}
	
	
	public Playlist getPlayList() {
		return p;
	}
	public void setPlayList(Playlist list) {
		p = list;
	}
	
	public CD getCD() {
		return c;
	}
	public void setCD(CD c) {
		this.c = c;
	}
	
	public void playSong(Song s) {
		System.out.println(s.getTitle() + " playing~~~ ");
	}
	

}
