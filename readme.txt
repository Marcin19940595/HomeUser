W dalszej fazie rozwoju apki planowane są poniższe funkcjonalności takie jak:


Jeżeli użytkownik będzie chciał to może zagrać w grę podobna do teleturnieju „Milionerzy” emitowanego na antenie TVN. Wówczas losowane jest jedno pytanie z bazy i użytkownik musi odpowiedzieć na nie w określonym czasie. Czasu jest tym mniej im wyższa jest stawka pytania. Wyniki każdego użytkownika będzie zapisywany w bazie danych.

Lista endpointów:
Niektóre endpointy sa zabezpieczone tokenami. Są to Bearer Token.

Link do apki: 
https://aplikacja555.herokuapp.com/...

1. /login -	Generuje token. Request powinien wygladać tak:
{
    "login":"marcin",
    "password":"1994"
}

2. /questions - Wyswietla wszystkie pytania z bazy.
Tutaj używamy tokena.

3. /newQuestion	- Dodanie pytania do bazy danych. Request powinien wygladać tak:
{
    "question":"...................",
    "odpA":".......................",
    "odpB":"................."
}
Tutaj używamy tokena.

4. /questions/{id}	- Usuwa pytanie o danym id z bazy pytań.
Tutaj bez tokena usuniemy pytanie.

5. /drawQuestions - Losuje jeden z rekord z bazy danych.
Tutaj używamy tokena.

6. /score - Pobiera wyniki wszystkich userów.
Tutaj używamy tokena.

7. /score/id - Pobiera wynik pojedynczego usera.
Tutaj używamy tokena.

8. /users -	Pobiera wszystkich userów.
Tutaj używamy tokena.

9. /user/id - Pobiera pojedynczego usera.
Tutaj bez tokena wyświetlimy użytkownika.

10. /newUser - Tworzy nowego usera. Request powinien wygladac tak:
{
    "name":"...............",
    "surname":"..........",
    "age":...,
    "city":"......"
    }
Tutaj używamy tokena.

11.	/user/id - Usuwa danego usera.
Tutaj bez tokena usuniemy użytkownika.
