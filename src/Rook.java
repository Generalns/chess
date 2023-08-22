import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(PieceColor color, Integer row, Integer column) {
        super(PieceType.ROOK, color,row,column);
        
    }
    public List<Square> validMoves(Board board){
        List<Square> validSquares= new ArrayList<>();
        for (int i = this.getRow() - 1; i >= 0; i--) {
            if (board.getSquare(i, this.getColumn()).getPiece() == null) {
                validSquares.add(board.getSquare(i, this.getColumn()));
            } else {
                if(board.getSquare(i, this.getColumn()).getPiece().getColor()!=this.getColor()){
                    validSquares.add(board.getSquare(i, this.getColumn()));
                }
                break;
            }
        }
        for (int i = this.getRow() + 1; i <= 7; i++) {
            if (board.getSquare(i, this.getColumn()).getPiece() == null) {
                validSquares.add(board.getSquare(i, this.getColumn()));
            } else {
                 if(board.getSquare(i, this.getColumn()).getPiece().getColor()!=this.getColor()){
                    validSquares.add(board.getSquare(i, this.getColumn()));
                }
                break;
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

        return validSquares;
    }
}