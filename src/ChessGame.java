import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    
    private Board board;
    private Player[] players;
    private List<Move> moves;
    private Player currentPlayer;
    private boolean isGameOver;
    private boolean isStateChanged;
    private List<Square> validMoves;
    private JFrame frame;
    private ImageIcon rookW;
    private ImageIcon knightW;
    private ImageIcon bishopW;
    private ImageIcon queenW;
    private ImageIcon kingW;
    private ImageIcon pawnW;
    private ImageIcon rookB;
    private ImageIcon knightB;
    private ImageIcon bishopB;
    private ImageIcon queenB;
    private ImageIcon kingB;
    private ImageIcon pawnB;
    private ImageIcon circleDot;
    private Piece selectedPiece;
    private boolean isWhiteChecked;
    private boolean isBlackChecked;




    public ChessGame(){
        board = new Board();
        players = new Player[2];
        King blackKing=new King(PieceColor.BLACK, 0,4 );
        King whiteKing=new King(PieceColor.WHITE, 7,4 );
        players[0] = new Player(PieceColor.WHITE);
        players[0].setKing(whiteKing);
        players[1] = new Player(PieceColor.BLACK);
        players[1].setKing(blackKing);
        currentPlayer = players[0];
        isGameOver = false;
        validMoves = new ArrayList<>();
        moves = new ArrayList<>();
        setIsStateChanged(true);
        frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 8));
        ImageIcon originalRookWImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "rookW.png");
        Image scaledRookWImage = originalRookWImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledRookWImageIcon = new ImageIcon(scaledRookWImage);
        this.setRookW(scaledRookWImageIcon);
        ImageIcon originalKnightWImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "knıghtW.png");
        Image scaledKnightWImage = originalKnightWImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledKnightWImageIcon = new ImageIcon(scaledKnightWImage);
        this.setKnightW(scaledKnightWImageIcon);
        ImageIcon originalBishopWImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "bıshopW.png");
        Image scaledBishopWImage = originalBishopWImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledBishopWImageIcon = new ImageIcon(scaledBishopWImage);
        this.setBishopW(scaledBishopWImageIcon);
        ImageIcon originalQueenWImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "queenW.png");
        Image scaledQueenWImage = originalQueenWImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledQueenWImageIcon = new ImageIcon(scaledQueenWImage);
        this.setQueenW(scaledQueenWImageIcon);
        ImageIcon originalKingWImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "kıngW.png");
        Image scaledKingWImage = originalKingWImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledKingWImageIcon = new ImageIcon(scaledKingWImage);
        this.setKingW(scaledKingWImageIcon);
        ImageIcon originalPawnWImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "pawnW.png");
        Image scaledPawnWImage = originalPawnWImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledPawnWImageIcon = new ImageIcon(scaledPawnWImage);
        this.setPawnW(scaledPawnWImageIcon);
        ImageIcon originalRookBImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "rookB.png");
        Image scaledRookBImage = originalRookBImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledRookBImageIcon = new ImageIcon(scaledRookBImage);
        this.setRookB(scaledRookBImageIcon);
        ImageIcon originalBishopBImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "bıshopB.png");
        Image scaledBishopBImage = originalBishopBImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledBishopBImageIcon = new ImageIcon(scaledBishopBImage);
        this.setBishopB(scaledBishopBImageIcon);
        ImageIcon originalKnightBImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "knıghtB.png");
        Image scaledKnightBImage = originalKnightBImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledKnightBImageIcon = new ImageIcon(scaledKnightBImage);
        this.setKnightB(scaledKnightBImageIcon);
        ImageIcon originalQueenBImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "queenB.png");
        Image scaledQueenBImage = originalQueenBImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledQueenBImageIcon = new ImageIcon(scaledQueenBImage);
        this.setQueenB(scaledQueenBImageIcon);
        ImageIcon originalKingBImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "kıngB.png");
        Image scaledKingBImage = originalKingBImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledKingBImageIcon = new ImageIcon(scaledKingBImage);
        this.setKingB(scaledKingBImageIcon);
        ImageIcon originalPawnBImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "pawnB.png");
        Image scaledPawnBImage = originalPawnBImage.getImage().getScaledInstance(80, 80,
            Image.SCALE_REPLICATE);
        ImageIcon scaledPawnBImageIcon = new ImageIcon(scaledPawnBImage);
        this.setPawnB(scaledPawnBImageIcon);
        ImageIcon originalCircleDotImage = new ImageIcon(
            System.getProperty("user.dir") + "/media/" + "circleDot.png");
        Image scaledCircleDotImage = originalCircleDotImage.getImage().getScaledInstance(40, 40,
            Image.SCALE_REPLICATE);
        ImageIcon scaledCircleDotImageIcon = new ImageIcon(scaledCircleDotImage);
        this.setCircleDot(scaledCircleDotImageIcon);
        
    }

    public void setRookW(ImageIcon rookW){
        this.rookW=rookW;
    }
    public void setKnightW(ImageIcon knightW){
        this.knightW=knightW;
    }
    public void setBishopW(ImageIcon bishopW){
        this.bishopW=bishopW;
    }
    public void setQueenW(ImageIcon queenW){
        this.queenW=queenW;
    }
    public void setKingW(ImageIcon kingW){
        this.kingW=kingW;
    }
    public void setPawnW(ImageIcon pawnW){
        this.pawnW=pawnW;
    }

     public ImageIcon getRookW(){
        return this.rookW;
    }
    public ImageIcon getKnightW(){
        return this.knightW;
    }
    public ImageIcon getBishopW( ){
        return this.bishopW;
    }
    public ImageIcon getQueenW(){
        return this.queenW;
    }
    public ImageIcon getKingW(){
        return this.kingW;
    }
    public ImageIcon getPawnW(){
        return this.pawnW;
    }
     public void setRookB(ImageIcon rookB){
        this.rookB=rookB;
    }
    public void setKnightB(ImageIcon knightB){
        this.knightB=knightB;
    }
    public void setBishopB(ImageIcon bishopB){
        this.bishopB=bishopB;
    }
    public void setQueenB(ImageIcon queenB){
        this.queenB=queenB;
    }
    public void setKingB(ImageIcon kingB){
        this.kingB=kingB;
    }
    public void setPawnB(ImageIcon pawnB){
        this.pawnB=pawnB;
    }
    public boolean getIsWhiteChecked(){
        return this.isWhiteChecked;
    }
    public boolean getIsBlackChecked(){
        return this.isBlackChecked;
    }
    public void setIsWhiteChecked(boolean isWhiteChecked){
        this.isWhiteChecked=isWhiteChecked;
    }
    public void setIsBlackChecked(boolean isBlackChecked){
        this.isBlackChecked=isBlackChecked;
    }

     public ImageIcon getRookB(){
        return this.rookB;
    }
    public ImageIcon getKnightB(){
        return this.knightB;
    }
    public ImageIcon getBishopB( ){
        return this.bishopB;
    }
    public ImageIcon getQueenB(){
        return this.queenB;
    }
    public ImageIcon getKingB(){
        return this.kingB;
    }
    public ImageIcon getPawnB(){
        return this.pawnB;
    }
     public void setCircleDot(ImageIcon circleDot){
        this.circleDot=circleDot;
    }
     public ImageIcon getCircleDot(){
        return this.circleDot;
    }
    public List<Square> getValidMoves() {
        return this.validMoves;
    }

    public void setValidMoves(List<Square> validMoves) {
        this.validMoves = validMoves;
    }

    public boolean getIsStateChanged() {
        return this.isStateChanged;
    }

    public void setIsStateChanged(boolean isStateChanged) {
        this.isStateChanged = isStateChanged;
    }
    public Piece getSelectedPiece() {
        return this.selectedPiece;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean getIsGameOver() {
        return this.isGameOver;
    }

    public void setIsGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
    
    public void startGame() {
            displayBoard();
            System.out.println(getCurrentPlayer().getColor() + "'s Turn"); 
    }
    
    public List<Move> getMoves() {
        return this.moves;
    }

    public void addMove(Move move){
        this.moves.add(move);
    }

    private class SquareMouseListener extends MouseAdapter {
        private Square square;

        public SquareMouseListener(Square square) {
            this.square = square;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(square.getPiece()!=null &&square.getPiece().getColor()==currentPlayer.getColor()){
                Piece clickedPiece = square.getPiece();
                highlightLegalMoves(square, clickedPiece,board);

                if(getIsWhiteChecked() || getIsBlackChecked()){
                    List<Square> safeMoves = new ArrayList<>(validMoves); // Create a list to store safe moves

                    for (Square validMove : validMoves) {
                        Square initialSquare = board.getSquare(clickedPiece.getRow(), clickedPiece.getColumn());
                        Square targetSquare = board.getSquare(validMove.getRow(), validMove.getColumn());

                        // Simulate the move on the actual board
                        Piece capturedPiece = targetSquare.getPiece();
                        int initialKingCol=players[0].getColor()==clickedPiece.getColor()?players[1].getKing().getColumn():players[1].getKing().getColumn();
                        int initialKingRow=players[0].getColor()==clickedPiece.getColor()?players[1].getKing().getRow():players[1].getKing().getRow();;
                        if(clickedPiece.getType()==PieceType.KING){
                            initialKingCol=clickedPiece.getColumn();
                            initialKingRow=clickedPiece.getRow();
                            if(clickedPiece.getColor()==players[0].getColor()){
                                players[0].getKing().setColumn(targetSquare.getColumn());
                                players[0].getKing().setRow(targetSquare.getRow());
                            }else{
                                players[1].getKing().setColumn(targetSquare.getColumn());
                                players[1].getKing().setRow(targetSquare.getRow());
                            }
                        }
                        
                        targetSquare.setPiece(clickedPiece);
                        initialSquare.setPiece(null);

                        // Check if the move leads to a situation where the king is still in check
                        if (isCheck(board)) {
                            safeMoves.remove(validMove); // Remove the move if it leads to check
                        }

                        // Revert the move on the actual board
                        targetSquare.setPiece(capturedPiece);
                        initialSquare.setPiece(clickedPiece);
                        if(clickedPiece.getType()==PieceType.KING){
                            if(clickedPiece.getColor()==players[0].getColor()){
                                players[0].getKing().setColumn(initialKingCol);
                                players[0].getKing().setRow(initialKingRow);
                            }else{
                                players[1].getKing().setColumn(initialKingCol);
                                players[1].getKing().setRow(initialKingRow);
                            }
                        }
                    }

                    validMoves = safeMoves;
                }else{
                    List<Square> safeMoves = new ArrayList<>(validMoves);
                    for (Square validMove : validMoves) {
                        Square initialSquare = board.getSquare(clickedPiece.getRow(), clickedPiece.getColumn());
                        Square targetSquare = board.getSquare(validMove.getRow(), validMove.getColumn());
                        Piece capturedPiece = targetSquare.getPiece();
                        targetSquare.setPiece(clickedPiece);
                        initialSquare.setPiece(null);
                        if (isCheck(board)) {
                            safeMoves.remove(validMove);
                        }
                        targetSquare.setPiece(capturedPiece);
                        initialSquare.setPiece(clickedPiece);
                        validMoves = safeMoves;
                        setIsBlackChecked(false);
                        setIsWhiteChecked(false);
                    }
                }
                selectedPiece = square.getPiece();

                displayBoard();
            }else{
                move(square,selectedPiece);
            }
            setIsStateChanged(true);
        }
    }
    private void move(Square square, Piece piece){
        this.setIsStateChanged(true);
        Move move=new Move(piece,board.getSquare(piece.getRow(), piece.getColumn()),square);
        if(square.getPiece()!=null){
            move.setIsCapture(true);
        }
        addMove(move);
       

        if(currentPlayer.getColor()==PieceColor.WHITE){
            setCurrentPlayer(this.getPlayers()[1]);
        }else{
            setCurrentPlayer(this.getPlayers()[0]);
        }
        piece.setHasMoved(true);

        board.getSquare(piece.getRow(), piece.getColumn()).setPiece(null);
        if(square.getPiece()!=null){
            square.setPiece(null);
        }
        piece.setColumn(square.getColumn());
        piece.setRow(square.getRow());
        board.getSquare(square.getRow(), square.getColumn()).setPiece(piece);
        List<Square> validMoves = new ArrayList<>();
        this.setValidMoves(List.copyOf(validMoves));
        this.setIsBlackChecked(false);
        this.setIsWhiteChecked(false);
        ArrayList<Square> emptyValidMoves=new ArrayList<Square>();

        if(isCheck(board)){
            move.setIsCheck(true);
            if(isCheckmate(board, currentPlayer)){
                setIsGameOver(true);
                PieceColor winner = getCurrentPlayer().getColor()==PieceColor.BLACK?PieceColor.WHITE:PieceColor.BLACK;
                System.out.println("Checkmate! " + winner + " wins.");
            }
        }
        
        this.setSelectedPiece(null);
        this.setValidMoves(emptyValidMoves);
        displayBoard();
    }
    private boolean isCheck(Board boardToCheck){
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                if(boardToCheck.getSquare(i, j).getPiece()!=null){
                    highlightLegalMoves(boardToCheck.getSquare(i, j), boardToCheck.getSquare(i, j).getPiece(),boardToCheck);
                    for(int k=0;k<this.getValidMoves().size();k++){
                        if(boardToCheck.getSquare(i, j).getPiece().getColor()==PieceColor.WHITE && this.getValidMoves().get(k).getColumn()==players[1].getKing().getColumn() && this.getValidMoves().get(k).getRow()==players[1].getKing().getRow()){
                            this.setIsBlackChecked(true);
                            return true;
                        }else if(boardToCheck.getSquare(i, j).getPiece().getColor()==PieceColor.BLACK && this.getValidMoves().get(k).getColumn()==players[0].getKing().getColumn() && this.getValidMoves().get(k).getRow()==players[0].getKing().getRow()){
                            this.setIsWhiteChecked(true);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isCheckmate(Board boardToCheck, Player playerInCheck) {
        if (!isCheck(boardToCheck)) {
            return false; 
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = boardToCheck.getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece != null && piece.getColor() == playerInCheck.getColor()) {
                    highlightLegalMoves(square, piece, boardToCheck);
                    List<Square> safeMoves = new ArrayList<>(validMoves); 

                    if(piece.getType()==PieceType.KING){
                        Piece clickedPiece = this.getIsBlackChecked()?players[1].getKing():players[0].getKing();
                        for (Square validMove : validMoves) {
                            Square initialSquare = board.getSquare(clickedPiece.getRow(), clickedPiece.getColumn());
                            Square targetSquare = board.getSquare(validMove.getRow(), validMove.getColumn());
                        Piece capturedPiece = targetSquare.getPiece();
                        int initialKingCol=players[0].getColor()==clickedPiece.getColor()?players[1].getKing().getColumn():players[1].getKing().getColumn();
                        int initialKingRow=players[0].getColor()==clickedPiece.getColor()?players[1].getKing().getRow():players[1].getKing().getRow();;
                        if(clickedPiece.getType()==PieceType.KING){
                            initialKingCol=clickedPiece.getColumn();
                            initialKingRow=clickedPiece.getRow();
                            if(clickedPiece.getColor()==players[0].getColor()){
                                players[0].getKing().setColumn(targetSquare.getColumn());
                                players[0].getKing().setRow(targetSquare.getRow());
                            }else{
                                players[1].getKing().setColumn(targetSquare.getColumn());
                                players[1].getKing().setRow(targetSquare.getRow());
                            }
                        }
                        
                            targetSquare.setPiece(clickedPiece);
                            initialSquare.setPiece(null);
                            if (isCheck(board)) {
                                safeMoves.remove(validMove);
                            }
                            targetSquare.setPiece(capturedPiece);
                            initialSquare.setPiece(clickedPiece);
                            if(clickedPiece.getType()==PieceType.KING){
                                if(clickedPiece.getColor()==players[0].getColor()){
                                    players[0].getKing().setColumn(initialKingCol);
                                    players[0].getKing().setRow(initialKingRow);
                                }else{
                                    players[1].getKing().setColumn(initialKingCol);
                                    players[1].getKing().setRow(initialKingRow);
                                }
                            }
                        }
                        if(safeMoves.size()>0){
                            System.out.println("Safe moves: "+safeMoves);
                            System.out.println("Found some king moves");
                            return false;
                        }

                    }
                    else{
                        for (Square move : validMoves) {
                            // Simulate the move to see if it gets the king out of check
                            Piece capturedPiece = move.getPiece();
                            square.setPiece(null);
                            move.setPiece(piece);

                            if (!isCheck(boardToCheck)) {
                                // The move gets the king out of check, so it's not checkmate
                                System.out.println("There is a legal move !: "+square.getPiece()+ piece.getType());
                                square.setPiece(piece);
                                move.setPiece(capturedPiece);
                                return false;
                            }

                            // Revert the move
                            square.setPiece(piece);
                            move.setPiece(capturedPiece);
                        }
                    }
                }
            }
        }
                    

        return true;
    }

    private void highlightLegalMoves(Square square, Piece clickedPiece,Board board) {  
        this.setSelectedPiece(square.getPiece());
        if (clickedPiece.getType() == PieceType.PAWN) {
            Pawn pawn = (Pawn) clickedPiece;
            List<Square> validMoves = new ArrayList<>();
            validMoves = pawn.validMoves(board);
            this.setValidMoves(List.copyOf(validMoves));
        }
        else if (clickedPiece.getType() == PieceType.ROOK) {
            Rook rook = (Rook) clickedPiece;
            List<Square> validMoves = new ArrayList<>();
            validMoves = rook.validMoves(board);
            this.setValidMoves(List.copyOf(validMoves));
        }
        else if (clickedPiece.getType() == PieceType.KNIGHT) {
            Knight knight = (Knight) clickedPiece;
            List<Square> validMoves = new ArrayList<>();
            validMoves = knight.validMoves(board);
            this.setValidMoves(List.copyOf(validMoves));
        }
        else if (clickedPiece.getType() == PieceType.BISHOP) {
            Bishop bishop = (Bishop) clickedPiece;
            List<Square> validMoves = new ArrayList<>();
            validMoves = bishop.validMoves(board);
            this.setValidMoves(List.copyOf(validMoves));
        }
        else if (clickedPiece.getType() == PieceType.QUEEN) {
            Queen queen = (Queen) clickedPiece;
            List<Square> validMoves = new ArrayList<>();
            validMoves = queen.validMoves(board);
            this.setValidMoves(List.copyOf(validMoves));
        }
        else if (clickedPiece.getType() == PieceType.KING) {
            King king = (King) clickedPiece;
            List<Square> validMoves = new ArrayList<>();
            validMoves = king.validMoves(board);
            this.setValidMoves(List.copyOf(validMoves));
            if(clickedPiece.getColor()==PieceColor.WHITE){
                players[0].setKing(king);
            }else{
                players[1].setKing(king);
            }
        }


    }
    private void displayBoard(){
            frame.getContentPane().removeAll();
            int boardSize = 8; 
            

            for (int row = 0; row < boardSize; row++) {
                for (int col = 0; col < boardSize; col++) {
                    
                    JPanel panel = new JPanel();
                    panel.removeAll();
                    panel.setPreferredSize(new Dimension(100, 100));
                    Square square = board.getSquare(row, col);
                    panel.putClientProperty("Square", square);

                    if (square.getPiece() != null && getCurrentPlayer().getColor()==square.getPiece().getColor()) {
                        panel.addMouseListener(new SquareMouseListener(square));
                    }

                    if ((row + col) % 2 == 0) {
                        panel.setBackground(Color.WHITE);
                    } else {
                        panel.setBackground(Color.GRAY);
                    }
                    if(row==players[0].getKing().getRow() && col==players[0].getKing().getColumn() && isWhiteChecked){
                        panel.setBackground(new Color (255,0,0,100));
                    }else if (row==players[1].getKing().getRow() && col==players[1].getKing().getColumn() && isBlackChecked){
                        panel.setBackground(new Color (255,0,0,100));
                    }

                    if (validMoves.contains(square)) {
                        if(square.getPiece()!=null){
                            panel.setBackground(new Color(0, 255, 0, 100));
                            panel.addMouseListener(new SquareMouseListener(square));
                        }else{
                            JPanel centeringPanel = new JPanel(new GridBagLayout());
                            centeringPanel.setOpaque(false); 
                            JLabel pieceLabel = new JLabel(this.getCircleDot());
                            centeringPanel.add(pieceLabel);
                            panel.setLayout(new GridBagLayout()); 
                            panel.add(centeringPanel);
                            panel.addMouseListener(new SquareMouseListener(square));
                        }
                       
                    }

                    Piece piece = board.getSquare(row, col).getPiece();

                    if (piece != null) {
                            if(piece.getType()==PieceType.PAWN){
                                if(piece.getColor()==PieceColor.WHITE){
                                    JLabel pieceLabel = new JLabel(this.getPawnW());
                                    panel.add(pieceLabel);
                                }else{
                                    JLabel pieceLabel = new JLabel(this.getPawnB());
                                    panel.add(pieceLabel);
                                }
                            }
                            else if(piece.getType()==PieceType.ROOK){
                                if(piece.getColor()==PieceColor.WHITE){
                                    JLabel pieceLabel = new JLabel(this.getRookW());
                                    panel.add(pieceLabel);
                                }else{
                                    JLabel pieceLabel = new JLabel(this.getRookB());
                                    panel.add(pieceLabel);
                                } 
                            }
                            else if(piece.getType()==PieceType.KNIGHT){
                                if(piece.getColor()==PieceColor.WHITE){
                                    JLabel pieceLabel = new JLabel(this.getKnightW());
                                    panel.add(pieceLabel);
                                }else{
                                    JLabel pieceLabel = new JLabel(this.getKnightB());
                                    panel.add(pieceLabel);
                                } 
                            }
                            else if(piece.getType()==PieceType.QUEEN){
                                if(piece.getColor()==PieceColor.WHITE){
                                    JLabel pieceLabel = new JLabel(this.getQueenW());
                                    panel.add(pieceLabel);
                                }else{
                                    JLabel pieceLabel = new JLabel(this.getQueenB());
                                    panel.add(pieceLabel);
                                } 
                            }
                            else if(piece.getType()==PieceType.KING){
                                if(piece.getColor()==PieceColor.WHITE){
                                    JLabel pieceLabel = new JLabel(this.getKingW());
                                    panel.add(pieceLabel);
                                }else{
                                    JLabel pieceLabel = new JLabel(this.getKingB());
                                    panel.add(pieceLabel);
                                } 
                            }
                            else if(piece.getType()==PieceType.BISHOP){
                                if(piece.getColor()==PieceColor.WHITE){
                                    JLabel pieceLabel = new JLabel(this.getBishopW());
                                    panel.add(pieceLabel);
                                }else{
                                    JLabel pieceLabel = new JLabel(this.getBishopB());
                                    panel.add(pieceLabel);
                                } 
                            }
                    }

                    frame.add(panel);
                }
            }
            frame.pack();
            frame.revalidate();
            frame.repaint();
            frame.setVisible(true);        
    }

    public static void main(String[] args) {
            ChessGame game = new ChessGame();
            game.startGame();
    }
}
