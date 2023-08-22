import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(PieceColor color, Integer row, Integer column) {
        super(PieceType.KNIGHT, color, row, column);
    }

    public List<Square> validMoves(Board board) {
        List<Square> validSquares = new ArrayList<>();

        int[][] knightMoves = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
        };

        for (int[] move : knightMoves) {
            int newRow = this.getRow() + move[0];
            int newColumn = this.getColumn() + move[1];
            
            if (newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8) {
                Square targetSquare = board.getSquare(newRow, newColumn);
                if (targetSquare.getPiece() == null || targetSquare.getPiece().getColor() != this.getColor()) {
                    validSquares.add(targetSquare);
                }
            }
        }

        return validSquares;
    }
}
