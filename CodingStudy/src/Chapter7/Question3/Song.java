package Chapter7.Question3;

public class Song {
	private String title;
	private long length;
	
	public Song(String title, long length) {
		this.title = title;
		this.length = length;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setLength(long len) {
		length = len;
	}
	
	public long getLength() {
		return length;
	}
	
//	@Override
//	public boolean equals(Object o) {
//		Song s2 = (Song)o;
//		if(title.equals(s2.getTitle())) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	

}
