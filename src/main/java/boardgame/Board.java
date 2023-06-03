package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows <1 || columns <1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[columns][rows];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int column, int row) {
        if (!positionExists(column, row)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[column][row];
    }
    
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getColumn()][position.getRow()];
    }
    
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is a already a piece on position " + position);
        }
        pieces[position.getColumn()][position.getRow()] = piece;
        piece.position = position;
    }
    
    private boolean positionExists(int column, int row) {
        return column >=0 && column < columns && row >= 0 && row < rows;
    }
    
    public boolean positionExists(Position position) {
        return positionExists(position.getColumn(), position.getRow());
    }
    
    public boolean thereIsAPiece(Position position) {
         if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
