package co.edu.umanizales.payment_process.services;

import co.edu.umanizales.payment_process.models.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private List<Card> cards = new ArrayList<>();
    private Long currentId = 1L;

    public Card createCard(Card card) {
        card.setId(currentId++);
        cards.add(card);
        return card;
    }

    public Card getCard(Long id) {
        return cards.stream()
                .filter(card -> card.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void removeCard(Long id) {
        cards.removeIf(card -> card.getId().equals(id));
    }
}
