/**
 * PackageServiceBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.java;

public interface PackageServiceBean extends java.rmi.Remote {
    public void deletePackage(PackageDTO p) throws java.rmi.RemoteException;
    public PackageDTO[] getAllPackages() throws java.rmi.RemoteException;
    public void setPackageTrackable(boolean trackable, long packageId) throws java.rmi.RemoteException;
    public void addRouteItemToPackage(RouteItem routeItem, long packageId) throws java.rmi.RemoteException;
    public PackageDTO[] getPackagesByNameOrId(java.lang.String name, long id) throws java.rmi.RemoteException;
    public void addPackage(PackageDTO p) throws java.rmi.RemoteException;
}
