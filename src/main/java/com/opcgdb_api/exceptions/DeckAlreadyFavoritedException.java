package com.opcgdb_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You have already make this deck as favorite")
public class DeckAlreadyFavoritedException extends Exception {
}
