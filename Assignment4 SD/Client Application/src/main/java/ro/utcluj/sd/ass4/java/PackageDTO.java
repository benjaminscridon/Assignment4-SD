/**
 * PackageDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.java;

public class PackageDTO  implements java.io.Serializable {
    private java.lang.String description;

    private java.lang.String destinationCity;

    private long id;

    private java.lang.String name;

    private UserDTO receiver;

    private RouteItem[] route;

    private UserDTO sender;

    private java.lang.String senderCity;

    private boolean tacking;

    public PackageDTO() {
    }

    public PackageDTO(
           java.lang.String description,
           java.lang.String destinationCity,
           long id,
           java.lang.String name,
          UserDTO receiver,
           RouteItem[] route,
          UserDTO sender,
           java.lang.String senderCity,
           boolean tacking) {
           this.description = description;
           this.destinationCity = destinationCity;
           this.id = id;
           this.name = name;
           this.receiver = receiver;
           this.route = route;
           this.sender = sender;
           this.senderCity = senderCity;
           this.tacking = tacking;
    }


    /**
     * Gets the description value for this PackageDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this PackageDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the destinationCity value for this PackageDTO.
     * 
     * @return destinationCity
     */
    public java.lang.String getDestinationCity() {
        return destinationCity;
    }


    /**
     * Sets the destinationCity value for this PackageDTO.
     * 
     * @param destinationCity
     */
    public void setDestinationCity(java.lang.String destinationCity) {
        this.destinationCity = destinationCity;
    }


    /**
     * Gets the id value for this PackageDTO.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this PackageDTO.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the name value for this PackageDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PackageDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the receiver value for this PackageDTO.
     * 
     * @return receiver
     */
    public UserDTO getReceiver() {
        return receiver;
    }


    /**
     * Sets the receiver value for this PackageDTO.
     * 
     * @param receiver
     */
    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }


    /**
     * Gets the route value for this PackageDTO.
     * 
     * @return route
     */
    public RouteItem[] getRoute() {
        return route;
    }


    /**
     * Sets the route value for this PackageDTO.
     * 
     * @param route
     */
    public void setRoute(RouteItem[] route) {
        this.route = route;
    }


    /**
     * Gets the sender value for this PackageDTO.
     * 
     * @return sender
     */
    public UserDTO getSender() {
        return sender;
    }


    /**
     * Sets the sender value for this PackageDTO.
     * 
     * @param sender
     */
    public void setSender(UserDTO sender) {
        this.sender = sender;
    }


    /**
     * Gets the senderCity value for this PackageDTO.
     * 
     * @return senderCity
     */
    public java.lang.String getSenderCity() {
        return senderCity;
    }


    /**
     * Sets the senderCity value for this PackageDTO.
     * 
     * @param senderCity
     */
    public void setSenderCity(java.lang.String senderCity) {
        this.senderCity = senderCity;
    }


    /**
     * Gets the tacking value for this PackageDTO.
     * 
     * @return tacking
     */
    public boolean isTacking() {
        return tacking;
    }


    /**
     * Sets the tacking value for this PackageDTO.
     * 
     * @param tacking
     */
    public void setTacking(boolean tacking) {
        this.tacking = tacking;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PackageDTO)) return false;
        PackageDTO other = (PackageDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.destinationCity==null && other.getDestinationCity()==null) || 
             (this.destinationCity!=null &&
              this.destinationCity.equals(other.getDestinationCity()))) &&
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.receiver==null && other.getReceiver()==null) || 
             (this.receiver!=null &&
              this.receiver.equals(other.getReceiver()))) &&
            ((this.route==null && other.getRoute()==null) || 
             (this.route!=null &&
              java.util.Arrays.equals(this.route, other.getRoute()))) &&
            ((this.sender==null && other.getSender()==null) || 
             (this.sender!=null &&
              this.sender.equals(other.getSender()))) &&
            ((this.senderCity==null && other.getSenderCity()==null) || 
             (this.senderCity!=null &&
              this.senderCity.equals(other.getSenderCity()))) &&
            this.tacking == other.isTacking();
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDestinationCity() != null) {
            _hashCode += getDestinationCity().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
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
        if (getSender() != null) {
            _hashCode += getSender().hashCode();
        }
        if (getSenderCity() != null) {
            _hashCode += getSenderCity().hashCode();
        }
        _hashCode += (isTacking() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PackageDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "PackageDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "destinationCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiver");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "receiver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "UserDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("route");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "route"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://entities.assignment4.sd.utcluj.ro", "RouteItem"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.assignment4.sd.utcluj.ro", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "sender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "UserDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "senderCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tacking");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.assignment4.sd.utcluj.ro", "tacking"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
