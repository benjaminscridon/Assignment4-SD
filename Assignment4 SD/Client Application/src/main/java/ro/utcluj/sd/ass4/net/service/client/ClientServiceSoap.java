/**
 * ClientServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.net.service.client;

public interface ClientServiceSoap extends java.rmi.Remote {
    public PackageModel[] getAllPackagesByUserEmail(java.lang.String email) throws java.rmi.RemoteException;
    public PackageModel[] getAllPackagesByUserEmailAndId(java.lang.String email, long id, java.lang.String name) throws java.rmi.RemoteException;
}
