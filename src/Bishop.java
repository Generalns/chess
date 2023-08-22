import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(PieceColor color, Integer row, Integer column) {
        super(PieceType.BISHOP, color, row, column);
    }

    public List<Square> validMoves(Board board) {
        List<Square> validSquares = new ArrayList<>();
        
        for (int i = this.getRow() - 1, j = this.getColumn() - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.getSquare(i, j).getPiece() == null) {
                validSquares.add(board.getSquare(i, j));
            } else {
                if (board.getSquare(i, j).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(i, j));
                }
                break;
            }
        }

        for (int i = this.getRow() - 1, j = this.getColumn() + 1; i >= 0 && j <= 7; i--, j++) {
            if (board.getSquare(i, j).getPiece() == null) {
                validSquares.add(board.getSquare(i, j));
            } else {
                if (board.getSquare(i, j).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(i, j));
                }
                break;
            }
        }

        for (int i = this.getRow() + 1, j = this.getColumn() - 1; i <= 7 && j >= 0; i++, j--) {
            if (board.getSquare(i, j).getPiece() == null) {
                validSquares.add(board.getSquare(i, j));
            } else {
                if (board.getSquare(i, j).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(i, j));
                }
                break;
            }
        }

        for (int i = this.getRow() + 1, j = this.getColumn() + 1; i <= 7 && j <= 7; i++, j++) {
            if (board.getSquare(i, j).getPiece() == null) {
                validSquares.add(board.getSquare(i, j));
            } else {
                if (board.getSquare(i, j).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(i, j));
                }
                break;
            }
        }

        return validSquares;
    }
}
