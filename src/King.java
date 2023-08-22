import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(PieceColor color, Integer row, Integer column) {
        super(PieceType.KING, color, row, column);
    }

    public List<Square> validMoves(Board board) {
        List<Square> validSquares = new ArrayList<>();

        for (int i = this.getRow() - 1; i <= this.getRow() + 1; i++) {
            for (int j = this.getColumn() - 1; j <= this.getColumn() + 1; j++) {
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7) {
                    if (i == this.getRow() && j == this.getColumn()) {
                        continue; 
                    }
                    Square square = board.getSquare(i, j);
                    if (square.getPiece() == null || square.getPiece().getColor() != this.getColor()) {
                        validSquares.add(square);
                    }
                }
            }
        }
        return validSquares;
    }
}
