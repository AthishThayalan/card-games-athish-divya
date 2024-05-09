package org.example.Game;

import org.example.Sleep.SleepUtils;
import org.example.Users.*;

public class RunGame implements ChooseGame {

    @Override
    public void runBlackjack(String name) {
        System.out.println("Loading Blackjack ... ");
        SleepUtils.sleep(1000);
        BlackjackDisplay blackjackDisplay = new BlackjackDisplay();
        blackjackDisplay.blackjackDisplayMessage();
        BlackjackUser user = new BlackjackUser(name);
        Computer computer = new Computer();
        User[] users = {user, computer};
        Blackjack blackjack = new Blackjack(users);
        blackjack.play();
    }

    @Override
    public void runHearts(String name) {
        HeartsUser player = new HeartsUser(name);
        HeartsUser[] players = new HeartsUser[]{player, new HeartsComputerUser("CPU-1"), new HeartsComputerUser("CPU-2"), new HeartsComputerUser("CPU-3")};
        Game hearts = new HeartsGame(players);
        hearts.play();

    }
}
