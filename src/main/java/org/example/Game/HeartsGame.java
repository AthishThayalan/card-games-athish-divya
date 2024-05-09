package org.example.Game;

import org.example.Deck.*;
import org.example.Sleep.SleepUtils;
import org.example.Users.HeartsUser;

import java.util.*;

public class HeartsGame extends Game {
    private int roundNumber = 0;
    private boolean isHeartBroken = false;
    private int userToLeadTheTrick;
    private final HeartsUser[] users;


    public HeartsGame(HeartsUser[] users) {
        super();
        this.users = users;
    }

    public void dealerDeals() {
        System.out.format("%30s", "DEALING CARDS\n");
        System.out.format("%30s", "─────────────\n");
        deckOfCards.shuffleDeck();
        for (int i = 0; i < 13; i++) {
            for (HeartsUser user : users)
                user.addCard(deckOfCards.dealCard());
        }
    }

    public void round() {
        dealerDeals();
        users[0].sortHand();
        if (roundNumber % 4 != 3)
            passCards();
        users[0].sortHand();
        userToLeadTheTrick = getUserWithTwoOfClub();
        for (int i = 0; i < 13; i++)
            trick(i == 0);
        addScores();
        displayScores();
        resetGame();
    }

    public void trick(boolean isFirstTrick) {
        System.out.println();
        System.out.println("───────────────────────────────────────────────");
        System.out.println("─────────────  STARTING A NEW TRICK  ──────────");
        System.out.println("───────────────────────────────────────────────");
        System.out.println();
        int currentUserIndex = userToLeadTheTrick;
        HeartsUser currentUser = users[currentUserIndex];
        ArrayList<Card> cardsPlayed = new ArrayList<>();
        if (isFirstTrick) {
            cardsPlayed.add(currentUser.playCard(currentUser.findIndexOfTwoOfClub()));
        } else {
            cardsPlayed.add(currentUser.selectOneCard(isHeartBroken));
        }
        System.out.println(currentUser.getName() + " played \n" + cardsPlayed.get(0).toString());
        for (int i = 1; i < 4; i++) {
            currentUserIndex++;
            if (currentUserIndex >= 4)
                currentUserIndex = 0;
            currentUser = users[currentUserIndex];
            cardsPlayed.add(currentUser.selectOneCard(cardsPlayed));
            System.out.println(currentUser.getName() + " played \n" + cardsPlayed.get(i).toString());
        }
        userToLeadTheTrick = findUserWhoTookTheTrick(cardsPlayed, userToLeadTheTrick);
        currentUser = users[userToLeadTheTrick];
        System.out.println("------------------------------");
        System.out.println(currentUser.getName() + " took the trick");
        System.out.println("------------------------------");
        currentUser.addCardsToPile(cardsPlayed);
        if (!isHeartBroken)
            isHeartBroken = checkIfHeartIsBroken(cardsPlayed);
        SleepUtils.sleep(1000);
    }

    public void passCards() {
        System.out.println(users[0].getName() + "'s cards:");
        System.out.println("───────────────────");
        users[0].printCards();
        ArrayList<Card[]> cardsToBePassed = new ArrayList<>();
        switch (roundNumber % 4) {
            case 0:
                System.out.println("Please select three cards to be passed to your left");
                break;
            case 1:
                System.out.println("Please select three cards to be passed to your right");
                break;
            case 2:
                System.out.println("Please select three cards to be passed to the player opposite to you");
                break;
        }
        for (HeartsUser user : users) {
            cardsToBePassed.add(user.selectThreeCardsToBePassed());
        }
        System.out.println();
        System.out.println("YOU HAVE RECEIVED :");
        switch (roundNumber % 4) {
            case 0:
                //Pass left
                users[0].addThreeCards(cardsToBePassed.get(3));
                for (int i = 1; i < 4; i++) {
                    users[i].addThreeCards(cardsToBePassed.get(i - 1));
                }
                Display.displayCards(cardsToBePassed.get(3), false);
                break;
            case 1:
                //Pass right
                users[3].addThreeCards(cardsToBePassed.get(0));
                for (int i = 0; i < 3; i++) {
                    users[i].addThreeCards(cardsToBePassed.get(i + 1));
                }
                Display.displayCards(cardsToBePassed.get(0), false);
                break;
            case 2:
                //pass Opposite
                users[0].addThreeCards(cardsToBePassed.get(2));
                users[1].addThreeCards(cardsToBePassed.get(3));
                users[2].addThreeCards(cardsToBePassed.get(0));
                users[3].addThreeCards(cardsToBePassed.get(1));
                Display.displayCards(cardsToBePassed.get(2), false);
                break;
        }
    }

    private int getUserWithTwoOfClub() {
        for (int i = 0; i < 4; i++) {
            if (users[i].hasTwoOfClubs())
                return i;
        }
        return -1;
    }

    public int findUserWhoTookTheTrick(ArrayList<Card> cards, int userToLeadTheTrick) {
        Suits leadSuit = cards.get(0).getSuit();
        int[] cardValues = cards.stream().mapToInt(card -> {
            if (card.getSuit() == leadSuit)
                return card.getValue();
            else return 0;
        }).toArray();
        int maxIndex = 0;
        for (int i = 1; i < 4; i++) {
            if (cardValues[i] > cardValues[maxIndex])
                maxIndex = i;
        }
        int userIndex = userToLeadTheTrick + maxIndex;
        userIndex = userIndex % 4;
        return userIndex;
    }

    public boolean checkIfHeartIsBroken(ArrayList<Card> cards) {
        for (Card card : cards) {
            if (card.getSuit() == Suits.hearts)
                return true;
        }
        return false;
    }


    public void displayScores() {
        int[][] scores = new int[4][];
        for (int i = 0; i < 4; i++) {
            scores[i] = users[i].getScores().stream().mapToInt(x -> x).toArray();
        }
        System.out.println();
        System.out.println("              ==========");
        System.out.println("                SCORES ");
        System.out.println("              ==========");
        System.out.format("%10s%10s%10s%10s%n", users[0].getName(), users[1].getName(), users[2].getName(), users[3].getName());
        for (int i = 0; i < scores[0].length; i++) {
            System.out.format("%10s%10s%10s%10s%n", scores[0][i], scores[1][i], scores[2][i], scores[3][i]);
        }
        System.out.println("----------------------------------------------");
        System.out.format("%10s%10s%10s%10s%n", users[0].totalScore(), users[1].totalScore(), users[2].totalScore(), users[3].totalScore());
        System.out.println("----------------------------------------------");
        SleepUtils.sleep(1000);
    }

    public void addScores() {
        int userShotTheMoon = -1;
        for (int i = 0; i < 4; i++)
            if (users[i].hasShotTheMoon())
                userShotTheMoon = i;
        if (userShotTheMoon == -1)
            Arrays.stream(users).forEach(user -> user.updateScores(user.findScore()));
        else
            for (int i = 0; i < 4; i++) {
                if (i == userShotTheMoon)
                    users[i].updateScores(0);
                else
                    users[i].updateScores(26);
            }
    }

    @Override
    public void resetGame() {
        for (HeartsUser user : users) {
            user.newRound();
        }
        deckOfCards = new Deck();
        isHeartBroken = false;
        roundNumber++;
    }

    @Override
    public void play() {
        while (gameOngoing()) {
            round();
        }
    }

    @Override
    public boolean gameOngoing() {
        for (HeartsUser user : users) {
            if (user.totalScore() >= 30)
                return false;
        }
        return true;
    }
}
