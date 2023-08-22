public class Move {
    
    private Piece piece;
    private Square startSquare;
    private Square endSquare;
    private boolean isCapture;          // true if the move indicates a capture. Else false
    private boolean isCheck;            // true if the move indicates a check. Else false
    private boolean isCheckMate;        // true if the move indicates a checkmate. Else false

    public Move(Piece piece, Square startSquare, Square endSquare){
        this.setPiece(piece);
        this.setStartSquare(startSquare);
        this.setEndSquare(endSquare);
        this.setIsCapture(false);
        this.setIsCheck(false);
        this.setIsCheckMate(false);
    }

    public Piece getPiece(){
        return this.piece;
    }
    private void setPiece(Piece piece){
        this.piece=piece;
    }
    public Square getStartSquare(){
        return this.startSquare;
    }
    private void setStartSquare(Square square){
        this.startSquare=square;
    }
    public Square getEndSquare(){
        return this.endSquare;
    }
    private void setEndSquare(Square square){
        this.endSquare=square;
    }
    public boolean getIsCapture(){
        return this.isCapture;
    }
    public void setIsCapture(boolean isCapture){
        this.isCapture=isCapture;
    }
    public boolean getIsCheck(){
        return this.isCheck;
    }
    public void setIsCheck(boolean isCheck){
        this.isCheck=isCheck;
    }
    public boolean getIsCheckMate(){
        return this.isCheckMate;
    }
    public void setIsCheckMate(boolean isCheckMate){
        this.isCheckMate=isCheckMate;
    }
}
