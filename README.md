# One Piece Deck Builder API

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api) [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Jonathan-Jusseaume_one_piece_deck_builder_api&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Jonathan-Jusseaume_one_piece_deck_builder_api)

Current version: `1.4.2`

## Overview

The One Piece Deck Builder API is a Spring Boot application that provides a comprehensive API for building decks and
managing card information for the One Piece Card Game. The API supports user authentication through Google OAuth2 and is
connected to a PostgreSQL database for persistent storage. Liquibase is used for database version control.

## Features

- **Comprehensive Card Information**: API endpoints to retrieve and manage card details.
- **Deck Management**: API endpoints to create, update, and manage decks.

## Prerequisites

- **Java 21**: Ensure that Java 21 is installed on your system.
- **PostgreSQL**: Install and configure PostgreSQL.
- **Maven**: For building and packaging the application.
- **Docker**: For containerized deployment (optional).

## Getting Started

### Cloning the Repository

```sh
git clone https://github.com/Jonathan-Jusseaume/one-piece-deck-builder-api.git
cd one-piece-deck-builder-api
