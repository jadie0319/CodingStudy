package Chapter7.Question6;

public class Edge {
	private Shape shape;
	private Piece parentPiece;
	private String code;
	
	public Edge(Shape shape, String code) {
		this.shape = shape;
		this.code = code;
	}
	
	private String getCode() {
		return code;
	}
	
	public Edge _createMatchingEdge() {
		if(shape == shape.FLAT) {
			return null;
		}
		return new Edge(shape.getOpposite(), getCode());
	}
	
	// Check
	public boolean fitsWith(Edge edge) {
		return edge.getCode().equals(getCode());
	}
	
	// Set parent piece
	public void setParentPiece(Piece parentPiece) {
		this.parentPiece = parentPiece;
	}
	
	// get parent piece
	public Piece getParentPiece() {
		return parentPiece;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public String toString() {
		return code;
	}
	
	
	

}
