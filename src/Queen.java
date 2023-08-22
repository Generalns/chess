import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(PieceColor color, Integer row, Integer column) {
        super(PieceType.QUEEN, color, row, column);
    }

    public List<Square> validMoves(Board board) {
        List<Square> validSquares = new ArrayList<>();

        for (int i = this.getRow() - 1; i >= 0; i--) {
            if (board.getSquare(i, this.getColumn()).getPiece() == null) {
                validSquares.add(board.getSquare(i, this.getColumn()));
            } else {
                if (board.getSquare(i, this.getColumn()).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(i, this.getColumn()));
                }
                i = -1;
            }
        }
        for (int i = this.getRow() + 1; i <= 7; i++) {
            if (board.getSquare(i, this.getColumn()).getPiece() == null) {
                validSquares.add(board.getSquare(i, this.getColumn()));
            } else {
                if (board.getSquare(i, this.getColumn()).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(i, this.getColumn()));
                }
                i = 8;
            }
        }
        for (int i = this.getColumn() - 1; i >= 0; i--) {
            if (board.getSquare(this.getRow(), i).getPiece() == null) {
                validSquares.add(board.getSquare(this.getRow(), i));
            } else {
                if (board.getSquare(this.getRow(), i).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(this.getRow(), i));
                }
                break;
            }
        }

        for (int i = this.getColumn() + 1; i <= 7; i++) {
            if (board.getSquare(this.getRow(), i).getPiece() == null) {
                validSquares.add(board.getSquare(this.getRow(), i));
            } else {
                if (board.getSquare(this.getRow(), i).getPiece().getColor() != this.getColor()) {
                    validSquares.add(board.getSquare(this.getRow(), i));
                }
                break;
            }
        }

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
