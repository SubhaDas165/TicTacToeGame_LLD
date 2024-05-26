package Model;

public class Player {
    public String player_name;
    public  PlayingPiece playingPiece;

    public Player(String player_name, PlayingPiece playingPiece) {
        this.player_name = player_name;
        this.playingPiece = playingPiece;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
