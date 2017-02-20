/**
 * LoginServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.net.service.login;

public interface LoginServiceSoap extends java.rmi.Remote {
    public long addUser(java.lang.String firstName, java.lang.String lastName, java.lang.String password, java.lang.String email, int type) throws java.rmi.RemoteException;
    public UserModel getUser(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException;
}
