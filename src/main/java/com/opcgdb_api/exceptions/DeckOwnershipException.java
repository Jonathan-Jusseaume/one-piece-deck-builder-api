package com.opcgdb_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Deck does not belong to the user")
public class DeckOwnershipException extends Exception {
}
