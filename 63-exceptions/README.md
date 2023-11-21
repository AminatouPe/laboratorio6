# Exceptions playground

### Check arguments correctness and throw RuntimeExceptions
All'interno del costruttore `ServiceBehindUnstableNetwork(double, int)`,
aggiungi un controllo che la probabilità sia compresa tra 0 (inclusa) e 1 (esclusa).
Se il controllo fallisce, deve lanciare una `IllegalArgumentException` con un messaggio appropriato.

### Rileva le eccezioni esistenti

Implementare i metodi `UseArithmeticService.retrySendOnNetworkError`
e "UseArithmeticService.retryReceiveOnNetworkError".
come descritto nel codice sorgente.

### Progetta nuove eccezioni

Crea una `NetworkException estende IOException` con due costruttori.
Il costruttore 0-ary deve creare un'eccezione il cui messaggio è "Errore di rete: nessuna risposta".
Il costruttore 1-ary deve prendere una String come input e creare un messaggio "Errore di rete durante l'invio del messaggio: <message>"

Modifica "ServiceBehindUnstableNetwork.accessTheNetwork()".
in modo tale da lanciare la nuova Exception.
Tieni presente che i blocchi che rilevavano "IOException" funzionano ancora.

### Controlla la correttezza degli argomenti e preserva lo stacktrace sui rethrow

Modifica `ServiceBehindUnstableNetwork.sendData` in modo tale che,
invece di stampare, lancia un'IllegalArgumentException con lo stesso messaggio.

**Nota:** l'eccezione appena lanciata deve *preservare* lo stacktrace dell'originale
`NumberFormatException` (che deve essere impostato come causa dell'eccezione).

### Utilizza le eccezioni per contrassegnare lo stato eccezionale

Rimuovi tutti i `println` da `ArithmeticService`: quando il sistema entra in uno stato incoerente,
dovrebbe essere lanciata una `IllegalStateException` con lo stesso messaggio della stampa.
Ricordarsi di preservare lo stacktrace delle eccezioni della causa, se presenti.

### Utilizza `finally` per calcolare anche dopo il `return`

Modifica `ArithmeticService.process()`:
non importa cosa, una volta che il flusso di controllo esce dal metodo,
È necessario eseguire `commandQueue.clear()`.

Suggerimento: utilizzare `finalmente` in modo appropriato.