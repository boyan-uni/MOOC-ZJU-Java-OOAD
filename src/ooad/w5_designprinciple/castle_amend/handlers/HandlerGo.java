package ooad.w5_designprinciple.castle_amend.handlers;
import ooad.w5_designprinciple.castle_amend.Game;

public class HandlerGo extends Handler {

    // constructor
    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        game.goRoom(cmd);
    }
}
