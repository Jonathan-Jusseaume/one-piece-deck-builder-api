package com.opcgdb_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You can't unfavorite a deck which is not your favorite")
public class DeckNotFavoritedException extends Exception {
}
