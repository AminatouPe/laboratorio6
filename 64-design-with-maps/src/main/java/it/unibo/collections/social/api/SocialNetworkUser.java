package it.unibo.collections.social.api;

import java.util.Collection;
import java.util.List;

/**
 * Represents the user of a social network. A user follows other users and of
 * course can be followed as well.
 * 
 * @param <U>
 *            specific {@link User} type
 */
public interface SocialNetworkUser<U extends User> extends User {

    /**
     Aggiunge un amico all'elenco degli amici attuali di questo utente.
     *
     * Gruppo @param
     * il gruppo (cerchio) a cui verrà aggiunto l'utente
     * Utente @param
     *l'utente da aggiungere come utente seguito
     * @return true se l'utente da aggiungere come persona seguita non esiste
     * eppure, falso altrimenti
     */
    boolean addFollowedUser(String group, U user);

    /**
     Ottiene l'elenco di tutte le persone seguite da questo utente ignorando il file
     *gruppo.
     *
     * @return l'elenco delle persone seguite da questo utente tra tutti i suoi gruppi
     */
    List<U> getFollowedUsers();

    /**
     Ottiene l'elenco delle persone seguite appartenenti a un determinato gruppo.
     *
     * @param groupName
     *            il nome del gruppo
     * @return la raccolta di persone seguite da questo utente all'interno del gruppo
     *         "groupName".
     */

    Collection<U> getFollowedUsersInGroup(String groupName);

}
