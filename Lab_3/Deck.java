package com.tasks3.carddeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Deck {

    ArrayList<Card> cards = new ArrayList<>(36);

    public Deck(){
        create();
    }

    private void create(){
        cards.clear();
        for(Suit s : Suit.values)
            for(Rank r : Rank.values)
                cards.add(new Card(r, s));
    }
    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Collections.shuffle(cards);
    }
    /* * Впорядкування колоди за мастями та значеннями
     * Порядок сотрування:
     * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
     * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
     * Наприклад
     * HEARTS Ace
     * HEARTS King
     * HEARTS Queen
     * HEARTS Jack
     * HEARTS 10
     * HEARTS 9
     * HEARTS 8
     * HEARTS 7
     * HEARTS 6
     * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if(Arrays.asList(Suit.values).indexOf(o1.getSuit()) >
                        Arrays.asList(Suit.values).indexOf(o2.getSuit()))
                    return 1;
                if(Arrays.asList(Suit.values).indexOf(o1.getSuit()) <
                        Arrays.asList(Suit.values).indexOf(o2.getSuit()))
                    return -1;
                if(Arrays.asList(Rank.values).indexOf(o1.getRank()) >
                        Arrays.asList(Rank.values).indexOf(o2.getRank()))
                    return 1;
                if(Arrays.asList(Rank.values).indexOf(o1.getRank()) <
                        Arrays.asList(Rank.values).indexOf(o2.getRank()))
                    return -1;
                return 0;
            }
        });
    }


    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        return !cards.isEmpty();
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (cards.size() > 0) {
            Card c = cards.get(cards.size() - 1);
            cards.remove(c);
            return c;
        } else
            return null;
    }
}

