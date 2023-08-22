import java.util.ArrayList;

public class Player {

    private PieceColor color; 
    private ArrayList<Piece> pieces;
    private boolean isHuman;
    private King king;

    public Player (PieceColor color){
        this.setColor(color);
        this.setIsHuman(true);
    }

    public King getKing(){
        return this.king;
    }
    public void setKing(King king){
        this.king=king;
    }
    public PieceColor getColor() {
        return this.color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean getIsHuman(){
        return this.isHuman;
    }

    public void setIsHuman(boolean isHuman){
        this.isHuman= isHuman;
    }

    public void addPiece(Piece piece){
        pieces.add(piece);
    }
}