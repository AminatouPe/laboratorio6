package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.Objects;
import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [CAMPI]
     *
     * Definire qualsiasi campo necessario
     *
     * Per salvare le persone seguite da un utente organizzato in gruppi, adotta
     * una mappa di tipo generico: pensare a quale tipo di chiavi e valori si adatterebbero meglio ai requisiti
     */
    private Map<String,Set<U>> freinds;


    /*
     * [COSTRUTTORI]
     *
     * 1) Completa la definizione del costruttore di seguito, per creare un utente
     * partecipazione ad un social network, con 4 parametri, inizializzando:
     *
     * - nome di battesimo
     * - cognome
     * - nome utente
     * - età ed ogni altro campo necessario
     */
    /**
     * Costruisce un utente che partecipa a un social network.
     *
     * @nomeparam
     * il nome dell'utente
     *Cognome @param
     * il cognome dell'utente
     * @param userAge
     *età dell'utente
     * Utente @param
     *alias dell'utente, ovvero il modo in cui un utente viene identificato su un
     *            applicazione
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.freinds=new HashMap<>();
    }

    /*
     * 2) Definire un ulteriore costruttore in cui l'età predefinita è -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user){
         this(name, surname, user, -1);
    }
    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    
    
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> circlFreindSet=this.freinds.get(circle);
        if(circlFreindSet!=null){
            circlFreindSet=new HashSet<>();
            circlFreindSet=this.freinds.put(circle, circlFreindSet);
        }
        return circlFreindSet.add(user);
    }

    /**
     *
     * [NOTA] Se non esiste ancora alcun gruppo con groupName, questa implementazione deve
     * restituisce una raccolta vuota.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        final Collection<U> UsersInGroup=this.freinds.get(groupName);
        if(UsersInGroup!=null){
            return new ArrayList<>(UsersInGroup);
        }

        return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
        final Set<U> followerUs=new HashSet<>();
        for(final Set<U> groupUs: freinds.values()){
            followerUs.addAll(groupUs);
        }
        return new ArrayList<>(followerUs);
    }
}
