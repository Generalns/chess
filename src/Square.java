public class Square implements Cloneable{
    
    public Square(int row,int col){
        setColumn(col);
        setRow(row);
        this.setPiece(null);
    }
    
    @Override
    public Square clone() {
        try {
            Square clonedSquare = (Square) super.clone();
            if (this.piece != null) {
                clonedSquare.piece = this.piece.clone(); // Clone the contained piece
            }
            return clonedSquare;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private Integer row;
    private Integer column;
    private Piece piece;

    public Integer getRow(){
        return this.row;
    }
    private void setRow(Integer row){
        this.row=row;
    }
    public Integer getColumn(){
        return this.column;
    }
    private void setColumn(Integer column){
        this.column=column;
    }
    public Piece getPiece(){
        return this.piece;
    }
    public void setPiece(Piece piece){
        this.piece=piece;
    }
    public void removePiece(){
        this.setPiece(null);
    }
}
