package com.onepiecedeckbuilder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Deck with the given id does not exist")
public class DeckNotFoundException extends Exception {
}
