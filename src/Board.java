
public class Board implements Cloneable {

    public Board(){
        this.setSquares();
        initializeBoard();
    }
    
    @Override
    public Board clone() {
        try {
            Board clonedBoard = (Board) super.clone();
            clonedBoard.squares = new Square[BOARD_SIZE][BOARD_SIZE]; // Initialize new squares array
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    clonedBoard.squares[row][col] = this.squares[row][col].clone(); // Clone each square
                }
            }
            return clonedBoard;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    private final int BOARD_SIZE = 8;
    private Square [][] squares;



    private void initializeBoard(){
        for(int row=0;row<BOARD_SIZE; row++){
            for (int col=0;col<BOARD_SIZE;col++){
                squares[row][col]=new Square(row,col);
                if(row==1 || row==6){
                    Pawn piece =new Pawn(row==6?PieceColor.WHITE:PieceColor.BLACK,row,col);
                    squares[row][col].setPiece(piece);
                }else if((row==0 || row==7) && (col==0 || col==7)){
                    Rook piece = new Rook(row==7?PieceColor.WHITE:PieceColor.BLACK,row,col);
                    squares[row][col].setPiece(piece);
                }else if((row==0 || row==7) && (col==1 || col==6)){
                    Knight piece = new Knight( row==7?PieceColor.WHITE:PieceColor.BLACK,row,col);
                    squares[row][col].setPiece(piece);
                }else if((row==0 || row==7) && (col==2 || col==5)){
                    Bishop piece = new Bishop( row==7?PieceColor.WHITE:PieceColor.BLACK,row,col);
                    squares[row][col].setPiece(piece);
                }else if((row==0 || row==7) && (col==3)){
                    Queen piece = new Queen( row==7?PieceColor.WHITE:PieceColor.BLACK,row,col);
                    squares[row][col].setPiece(piece);
                }else if((row==0 || row==7) && (col==4)){
                    King piece = new King( row==7?PieceColor.WHITE:PieceColor.BLACK,row,col);
                    squares[row][col].setPiece(piece);
                }
            }
        }
    }

    private void setSquares(){
        squares = new Square[BOARD_SIZE][BOARD_SIZE];
    }

    public Square getSquare(int row,int col){
        return this.squares[row][col];
    }


}
