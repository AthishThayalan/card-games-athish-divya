package org.example.Game;

import org.example.Deck.*;
import org.example.Users.User;

import java.util.*;
import java.util.stream.Collectors;

public class HeartsGame extends Game {
    private int roundNumber = 0;
    private boolean isHeartBroken = false;
    private int userToLeadTheTrick;


    public HeartsGame(User[] users) {
        super(users);
    }

    public void dealerDeals() {
        System.out.println("Dealing Cards");
        deckOfCards.shuffleDeck();
        for (int i = 0; i < 13; i++) {
            for (User user : users)
                user.addCard(deckOfCards.dealCard());
        }
    }


    public void trick(boolean isFirstTrick) {
        int currentUser = userToLeadTheTrick;
        ArrayList<Card> cardsPlayed = new ArrayList<>();
        for (User user : users) {
            System.out.println(user.getName());
            user.printCards();
        }
        if (isFirstTrick) {
            cardsPlayed.add(users[userToLeadTheTrick].playCard(findOptionOfTwoOfClub(userToLeadTheTrick)));
        } else {
            cardsPlayed.add(users[userToLeadTheTrick].selectOneCard(isHeartBroken));
        }
        System.out.println("User " + users[userToLeadTheTrick].getName() + " played " + cardsPlayed.get(0).toString());
        for (int i = 1; i < 4; i++) {
            currentUser++;
            if (currentUser >= 4)
                currentUser = 0;
            cardsPlayed.add(users[currentUser].selectOneCard(cardsPlayed));
            System.out.println("User " + users[currentUser].getName() + " played " + cardsPlayed.get(i).toString());
        }
        userToLeadTheTrick = findUserWhoTookTheTrick(cardsPlayed, userToLeadTheTrick);
        System.out.println("User " + users[userToLeadTheTrick].getName() + " took the trick");
        users[userToLeadTheTrick].addCardToPile(cardsPlayed);
        if (!isHeartBroken)
            isHeartBroken = checkIfHeartIsBroken(cardsPlayed);
    }

    private int findOptionOfTwoOfClub(int userToLeadTheTrick) {
        for (int i = 0; i < 13; i++) {
            Card card = users[userToLeadTheTrick].getCardsInHand().get(i);
            if (card.equals(new Card(Suits.clubs, FaceValue.TWO))) {
                return i + 1;
            }
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

    public void round() {
        dealerDeals();
        users[0].sortHand();
        users[0].printCards();
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

    public void displayScores() {
        System.out.println("Display scores");
    }

    private int getUserWithTwoOfClub() {
        for (int i = 0; i < 4; i++) {
            if (users[i].hasTwoOfClubs())
                return i;
        }
        return -1;
    }

    public void passCards() {
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
        for (User user : users) {
            cardsToBePassed.add(user.selectThreeCardsToBePassed());
        }
        System.out.println("You have received :");
        switch (roundNumber % 4) {
            case 0:
                //Pass left
                users[0].addThreeCards(cardsToBePassed.get(3));
                for (int i = 1; i < 4; i++) {
                    users[i].addThreeCards(cardsToBePassed.get(i - 1));
                }
                Arrays.stream(cardsToBePassed.get(3)).forEach(System.out::println);
                break;
            case 1:
                //Pass right
                users[3].addThreeCards(cardsToBePassed.get(0));
                for (int i = 0; i < 3; i++) {
                    users[i].addThreeCards(cardsToBePassed.get(i + 1));
                }
                Arrays.stream(cardsToBePassed.get(0)).forEach(System.out::println);
                break;
            case 2:
                //pass Opposite
                users[0].addThreeCards(cardsToBePassed.get(2));
                users[1].addThreeCards(cardsToBePassed.get(3));
                users[2].addThreeCards(cardsToBePassed.get(0));
                users[3].addThreeCards(cardsToBePassed.get(1));
                Arrays.stream(cardsToBePassed.get(2)).forEach(System.out::println);
                break;
        }


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
        deckOfCards = new Deck();
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
        return Arrays.stream(users).anyMatch(user -> user.totalScore() < 100);
    }

    @Override
    public boolean gameWon() {
        return false;
    }

    @Override
    public boolean gameLost() {
        return false;
    }


}
