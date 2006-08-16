/*
 * SIP Communicator, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package net.java.sip.communicator.service.protocol;

import java.util.*;

import net.java.sip.communicator.service.protocol.event.*;


/**
 * A represenation of a Call. The Call class must obly be created by users (i.e.
 * telephony protocols) of the PhoneUIService such as a SIP protocol
 * implemenation. Extensions of this class might have names like SipCall
 * or H323Call or AnyOtherTelephonyProtocolCall
 *
 * @author Emil Ivov
 */
public abstract class Call
{
    private String callID = null;
    private CallParticipant callCreator = null;
    private Vector callParticipants = new Vector();
    private Vector callListeners = new Vector();

    /**
     * Creates a new call with the specified id.
     * @param callID the id of the call to create.
     */
    protected Call(String callID, CallParticipant callCreator)
    {
        this.callID = callID;
    }

    /**
     * Returns the id of the specified Call.
     * @return String
     */
    public String getCallID()
    {
        return callID;
    }

    /**
     * Compares the specified object with this call and returns true if it the
     * specified object is an instance of a Call object and if the
     * extending telephony protocol considers the calls represented by both
     * objects to be the same.
     *
     * @param obj the call to compare this one with.
     * @return true in case both objects are pertaining to the same call and
     * false otherwise.
     */
    public boolean equals(Object obj)
    {
        if(obj == null
           || !(obj instanceof Call))
            return false;
        if (obj == this
           || ((Call)obj).getCallID().equals( getCallID() ))
            return true;

        return false;
    }

    /**
     * Returns the call participant that created the call.
     * @return a CallParticipant instance containing the call participant that
     * created the call.
     */
    public CallParticipant getCallCreator()
    {
        return callCreator;
    }

    /**
     * Returns an iterator over all call participants.
     * @return an Iterator over all participants currently involved in the call.
     */
    public Iterator getCallParticipants()
    {
        return callParticipants.iterator();
    }

    /**
     * Adds a call change listener to this call so that it could receive events
     * on new call participants, theme changes and others.
     * @param listener the listener to register
     */
    public void addCallChangeListener(CallChangeListener listener)
    {

    }
}
