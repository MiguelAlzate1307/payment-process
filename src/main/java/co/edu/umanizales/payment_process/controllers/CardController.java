package co.edu.umanizales.payment_process.controllers;

import co.edu.umanizales.payment_process.models.Card;
import co.edu.umanizales.payment_process.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        return cardService.getCard(id);
    }

    @GetMapping
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @DeleteMapping("/{id}")
    public void removeCard(@PathVariable Long id) {
        cardService.removeCard(id);
    }
}
