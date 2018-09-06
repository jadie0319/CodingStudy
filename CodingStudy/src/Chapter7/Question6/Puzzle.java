package Chapter7.Question6;

import java.util.LinkedList;

public class Puzzle {
	private LinkedList<Piece> pieces; // 남아있는 퍼즐조각
	private Piece[][] solution;
	private int size;
	
	public Puzzle(int size, LinkedList pieces) {
		this.size = size;
		this.pieces = pieces;
	}
	
	public void groupPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces) {
		for (Piece p : pieces) {
			if (p.isCorner()) {
				cornerPieces.add(p);
			} else if (p.isBorder()) {
				borderPieces.add(p);
			} else {
				insidePieces.add(p);
			}
		}
	}
	
	
	public void orientTopLeftCorner(Piece piece) {
		if (!piece.isCorner()) return;
		
		Orientation[] orientations = Orientation.values();
		for (int i = 0; i < orientations.length; i++) {
			Edge current = piece.getEdgeWithOrientation(orientations[i]);
			Edge next = piece.getEdgeWithOrientation(orientations[(i + 1) % orientations.length]);
			if (current.getShape() == Shape.FLAT && next.getShape() == Shape.FLAT) {
				piece.setEdgeAsOrientation(current, Orientation.LEFT);
				return;
			}	
		}
	}
	
	
	public boolean isBorderIndex(int location) {
		return location == 0 || location == size - 1;
	}
	
	
	private Edge getMatchingEdge(Edge targetEdge, LinkedList<Piece> pieces) {
		for (Piece piece : pieces) {
			Edge matchingEdge = piece.getMatchingEdge(targetEdge);
			if (matchingEdge != null) {
				return matchingEdge;
			}
		}	
		return null;
	}
	
	
	
	
	
	
	
	
	// 퍼즐조각을 적절하게 회전시킨 뒤 내려 놓고, 리스트에서 삭제한다.
	private void setEdgeInSolution(LinkedList pieces, Edge edge, int row,
			int column, Orientation orientation) {
		Piece piece = edge.getParentPiece();
		piece.setEdgeAsOrientation(edge, orientation);
		pieces.remove(piece);
		solution[row][column] = piece;
		
		
	}
	
	
	
	private LinkedList<Piece> getPieceListToSearch(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces, int row, int column) {
		if (isBorderIndex(row) && isBorderIndex(column)) {
			return cornerPieces;
		} else if (isBorderIndex(row) || isBorderIndex(column)) {
			return borderPieces;
		} else {
			return insidePieces;
		}
	}
	
	
	private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
		if (row == 0 && column == 0) {
			Piece p = piecesToSearch.remove();
			orientTopLeftCorner(p);
			solution[0][0] = p;
		} else {
			/* Get the right edge and list to match. */
			Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
			Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM : Orientation.RIGHT;
			Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
			
			/* Get matching edge. */
			Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);
			if (edge == null) return false; // Can't solve
			
			Orientation orientation = orientationToMatch.getOpposite();
			setEdgeInSolution(piecesToSearch, edge, row, column, orientation);		
		}
		return true;
	}
	
	
	public boolean solve() {
		/* Group pieces. */
		LinkedList<Piece> cornerPieces = new LinkedList<Piece>();
		LinkedList<Piece> borderPieces = new LinkedList<Piece>();
		LinkedList<Piece> insidePieces = new LinkedList<Piece>();
		groupPieces(cornerPieces, borderPieces, insidePieces);
		
		/* Walk through puzzle, finding the piece that joins the previous one. */
		solution = new Piece[size][size];	
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, column);
				if (!fitNextEdge(piecesToSearch, row, column)) {
					return false;
				}
			}
		}
		
		return true;
	}	
	
	public Piece[][] getCurrentSolution() {
		return solution;
	}

}
