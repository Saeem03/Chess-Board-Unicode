import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public  abstract class ChessPiece implements Comparable{
    public static void main(String[] args) {
        chessBoardBuild();
    }

    static void  chessBoardBuild(){
        List<ChessPiece> piece = new LinkedList<>();
        piece.add(new BlackQueen());
        piece.add(new BlackKing());
        piece.add(new BlackKnight());
        piece.add(new BlackKnight());
        piece.add(new BlackRook());
        piece.add(new BlackRook());
        piece.add(new BlackBishop());
        piece.add(new BlackBishop());
        for (int i = 0; i < 8; i++) {
            piece.add(new BlackPawn());
        }
        piece.add(new WhiteQueen());
        piece.add(new WhiteKing());
        piece.add(new WhiteKnight());
        piece.add(new WhiteKnight());
        piece.add(new WhiteRook());
        piece.add(new WhiteRook());
        piece.add(new WhiteBishop());
        piece.add(new WhiteBishop());
        for (int i = 0; i < 8; i++) {
            piece.add(new WhitePawn());
        }
        Collections.shuffle(piece);
        ArrayList<Integer> sequence = new ArrayList<>();
        int count=0;
        for (int i = 0; i < 64; i++) {
            sequence.add(count++);
        }
        Collections.shuffle(sequence);
        count=0;
        System.out.print("X   ");
        for (int i = 0; i < 8; i++) {
            System.out.print((char)('a'+i)+"   ");
        }
        System.out.println();
        for (int i = 1; i <=8 ; i++) {
            System.out.print(i+"   ");
            for (int j = 0; j <8 ; j++) {
                if(piece.size()>sequence.get(count)){
                    piece.get(sequence.get(count)).Position = ""+(char)('h'-j);
                    piece.get(sequence.get(count)).Position+=""+i;
                    System.out.print(piece.get(sequence.get(count)).getUnicode()+"  ");
                }
                else
                    System.out.print('X'+"   ");
                count++;
            }
            System.out.println();
        }
        for(ChessPiece c : piece)
            System.out.println(c);
    }
    private char unicode;
    private Color color;
    public int ID;
    public String Position;

    public ChessPiece() {
    }

    public ChessPiece(char unicode,Color color,int ID) {
        this.unicode = unicode;
        this.color = color;
        this.ID=ID;
    }

    public char getUnicode() {
        return unicode;
    }

    @Override
    public int compareTo(Object p) {
        ChessPiece o = (ChessPiece) p;
        if(this==o && (this.color.equals(o.color)) && (this.ID==o.ID)  && (this.color.equals(o.color)) && (this.Position.equals(o.Position)))
            return 1;
        return 0;
    }
    @Override
    public String toString() {
        return this.getClass().getName()+"{ ID= " + ID + ' ' +
                "Position= " + Position + " }";
    }
}
class WhiteQueen extends ChessPiece{
    public static int count=0;
    WhiteQueen(){
        super('\u2654',Color.White,++count);
    }
}
class WhiteKing extends ChessPiece{
    public static int count=0;
    WhiteKing(){
        super('\u2655',Color.White,++count);
    }
}
class WhiteRook extends ChessPiece{
    public static int count=0;
    WhiteRook(){
        super('\u2656',Color.White,++count);
    }
}
class WhiteBishop extends ChessPiece{
    public static int count=0;
    WhiteBishop(){
        super('\u2657',Color.White,++count);
    }
}
class WhiteKnight extends ChessPiece{
    public static int count=0;
    WhiteKnight(){
        super('\u2658',Color.White,++count);
    }
}
class WhitePawn extends ChessPiece{
    public static int count=0;
    WhitePawn(){
        super('\u2659',Color.White,++count);
    }
}
class BlackQueen extends ChessPiece{
    public static int count=0;
    BlackQueen(){
        super('\u265A',Color.Black,++count);
    }
}
class BlackKing extends ChessPiece{
    public static int count=0;
    BlackKing(){
        super('\u265B',Color.Black,++count);
    }
}
class BlackRook extends ChessPiece{
    public static int count=0;
    BlackRook(){
        super('\u265C',Color.Black,++count);
    }
}
class BlackBishop extends ChessPiece{
    public static int count=0;
    BlackBishop(){
        super('\u265D',Color.Black,++count);
    }
}
class BlackKnight extends ChessPiece{
    public static int count=0;
    BlackKnight(){
        super('\u265E',Color.Black,++count);
    }
}
class BlackPawn extends ChessPiece{
    public static int count=0;
    BlackPawn(){
        super('\u265F',Color.Black,++count);
    }
}

enum Color{
    White,
    Black
}