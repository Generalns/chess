public class Piece implements Cloneable{
    public Piece(PieceType type,PieceColor color, Integer row, Integer column){
        this.setColumn(column);
        this.setRow(row);
        this.setColor(color);
        this.setType(type);
        this.setHasMoved(false);
    }
    
    @Override
    public Piece clone() {
        try {
            return (Piece) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    private PieceColor color;              // true: white, false: black
    private PieceType type;                // type of the piece. pawn, knight ect.
    private boolean hasMoved;           // false if the piece has not moved and at its starting position. Else true
    private Integer row;
    private Integer column;

    public boolean getHasMoved(){
        return this.hasMoved;
    }
    public void setHasMoved(boolean hasMoved){
        this.hasMoved=hasMoved;
    }

    public PieceType getType(){
        return this.type;
    }

    private void setType(PieceType type){
        this.type=type;
    }

    public PieceColor getColor(){
        return this.color;
    }

    private void setColor(PieceColor color){
        this.color=color;
    }

    public Integer getRow() {
        return this.row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return this.column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
}
