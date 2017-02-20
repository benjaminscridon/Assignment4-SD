/**
 * PackageModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.net.service.login;

public class PackageModel  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String description;

    private java.lang.String senderCity;

    private java.lang.String destinationCity;

    private boolean tacking;

    private UserModel sender;

    private UserModel receiver;

    private RouteItemModel[] route;

    private long id;

    public PackageModel() {
    }

    public PackageModel(
           java.lang.String name,
           java.lang.String description,
           java.lang.String senderCity,
           java.lang.String destinationCity,
           boolean tacking,
           UserModel sender,
           UserModel receiver,
           RouteItemModel[] route,
           long id) {
           this.name = name;
           this.description = description;
           this.senderCity = senderCity;
           this.destinationCity = destinationCity;
           this.tacking = tacking;
           this.sender = sender;
           this.receiver = receiver;
           this.route = route;
           this.id = id;
    }


    /**
     * Gets the name value for this PackageModel.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PackageModel.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the description value for this PackageModel.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this PackageModel.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the senderCity value for this PackageModel.
     * 
     * @return senderCity
     */
    public java.lang.String getSenderCity() {
        return senderCity;
    }


    /**
     * Sets the senderCity value for this PackageModel.
     * 
     * @param senderCity
     */
    public void setSenderCity(java.lang.String senderCity) {
        this.senderCity = senderCity;
    }


    /**
     * Gets the destinationCity value for this PackageModel.
     * 
     * @return destinationCity
     */
    public java.lang.String getDestinationCity() {
        return destinationCity;
    }


    /**
     * Sets the destinationCity value for this PackageModel.
     * 
     * @param destinationCity
     */
    public void setDestinationCity(java.lang.String destinationCity) {
        this.destinationCity = destinationCity;
    }


    /**
     * Gets the tacking value for this PackageModel.
     * 
     * @return tacking
     */
    public boolean isTacking() {
        return tacking;
    }


    /**
     * Sets the tacking value for this PackageModel.
     * 
     * @param tacking
     */
    public void setTacking(boolean tacking) {
        this.tacking = tacking;
    }


    /**
     * Gets the sender value for this PackageModel.
     * 
     * @return sender
     */
    public UserModel getSender() {
        return sender;
    }


    /**
     * Sets the sender value for this PackageModel.
     * 
     * @param sender
     */
    public void setSender(UserModel sender) {
        this.sender = sender;
    }


    /**
     * Gets the receiver value for this PackageModel.
     * 
     * @return receiver
     */
    public UserModel getReceiver() {
        return receiver;
    }


    /**
     * Sets the receiver value for this PackageModel.
     * 
     * @param receiver
     */
    public void setReceiver(UserModel receiver) {
        this.receiver = receiver;
    }


    /**
     * Gets the route value for this PackageModel.
     * 
     * @return route
     */
    public RouteItemModel[] getRoute() {
        return route;
    }


    /**
     * Sets the route value for this PackageModel.
     * 
     * @param route
     */
    public void setRoute(RouteItemModel[] route) {
        this.route = route;
    }


    /**
     * Gets the id value for this PackageModel.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this PackageModel.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PackageModel)) return false;
        PackageModel other = (PackageModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.senderCity==null && other.getSenderCity()==null) || 
             (this.senderCity!=null &&
              this.senderCity.equals(other.getSenderCity()))) &&
            ((this.destinationCity==null && other.getDestinationCity()==null) || 
             (this.destinationCity!=null &&
              this.destinationCity.equals(other.getDestinationCity()))) &&
            this.tacking == other.isTacking() &&
            ((this.sender==null && other.getSender()==null) || 
             (this.sender!=null &&
              this.sender.equals(other.getSender()))) &&
            ((this.receiver==null && other.getReceiver()==null) || 
             (this.receiver!=null &&
              this.receiver.equals(other.getReceiver()))) &&
            ((this.route==null && other.getRoute()==null) || 
             (this.route!=null &&
              java.util.Arrays.equals(this.route, other.getRoute()))) &&
            this.id == other.getId();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getSenderCity() != null) {
            _hashCode += getSenderCity().hashCode();
        }
        if (getDestinationCity() != null) {
            _hashCode += getDestinationCity().hashCode();
        }
        _hashCode += (isTacking() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSender() != null) {
            _hashCode += getSender().hashCode();
        }
        if (getReceiver() != null) {
            _hashCode += getReceiver().hashCode();
        }
        if (getRoute() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRoute());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRoute(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PackageModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://net.login/", "PackageModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "SenderCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "DestinationCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tacking");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Tacking"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Sender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://net.login/", "UserModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiver");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Receiver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://net.login/", "UserModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("route");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Route"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://net.login/", "RouteItemModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://net.login/", "RouteItemModel"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://net.login/", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
