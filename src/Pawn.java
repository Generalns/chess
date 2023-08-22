import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(PieceColor color, Integer row, Integer column) {
        super(PieceType.PAWN, color,row,column);
        
    }
    public List<Square> validMoves(Board board){
        System.out.println("In pawn validMoves method hasMoved: "+ this.getHasMoved());
        System.out.println("Piece in pawn class: " + this);

        List<Square> validSquares= new ArrayList<>();
        checkDiagonalCapture(board, validSquares, this.getRow() + (this.getColor()==PieceColor.WHITE ? -1 : +1), this.getColumn() - 1);
        checkDiagonalCapture(board, validSquares, this.getRow() + (this.getColor()==PieceColor.WHITE ? -1 : +1), this.getColumn() + 1);

        if(this.getColor()==PieceColor.WHITE && !this.getHasMoved() 
            && board.getSquare(this.getRow()-1,this.getColumn()).getPiece()==null 
            && board.getSquare(this.getRow()-2,this.getColumn()).getPiece()==null){
                validSquares.add(board.getSquare(this.getRow()-2,this.getColumn()));
                validSquares.add(board.getSquare(this.getRow()-1,this.getColumn()));
            }
        else if(this.getColor()==PieceColor.WHITE && board.getSquare(this.getRow()-1,this.getColumn()).getPiece()==null){
            validSquares.add(board.getSquare(this.getRow()-1,this.getColumn()));
        }
        if(this.getColor()==PieceColor.BLACK && !this.getHasMoved() 
            && board.getSquare(this.getRow()+1,this.getColumn()).getPiece()==null 
            && board.getSquare(this.getRow()+2,this.getColumn()).getPiece()==null){
                validSquares.add(board.getSquare(this.getRow()+2,this.getColumn()));
                validSquares.add(board.getSquare(this.getRow()+1,this.getColumn()));


        }
        else if(this.getColor()==PieceColor.BLACK && board.getSquare(this.getRow()+1,this.getColumn()).getPiece()==null){
            validSquares.add(board.getSquare(this.getRow()+1,this.getColumn()));
        }
        return validSquares;
    }

    private void checkDiagonalCapture(Board board, List<Square> validSquares, int row, int col) {
        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            Piece targetPiece = board.getSquare(row, col).getPiece();
            if (targetPiece != null && targetPiece.getColor() != this.getColor()) {
                validSquares.add(board.getSquare(row, col));
            }
        }
    }
}