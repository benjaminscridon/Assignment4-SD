package ro.tuc.dsrl.ds.handson.assig.one.protocol.encoders;

import ro.tuc.dsrl.ds.handson.assig.one.protocol.enums.ProtocolMethod;
import ro.tuc.dsrl.ds.handson.assig.one.protocol.message.RequestMessage;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description:
 * 	Provides static methods for encoding and decoding RequestMessages, according
 * 	to the communication protocol.
 *
 * 	The format is:
 * 	    METHOD_URL_BODY
 * 	where METHOD specifies the request method (e.g. GET, POST), URL is used
 * 	to identify the resource onto the server, and BODY can contain a string
 * 	message/object.
 *
 * 	METHOD is one of the methods specified in ProtocolMethod enum.
 * 	URL can optionally be followed by ?key=value&key2=value2... to specify url parameters.
 * 	BODY can also be empty.
 */
public class RequestMessageEncoder {
    private static final int REQUEST_ALL_COMPONENTS_NUM = 3;
    private static final int REQUEST_MIN_COMPONENTS_NUM = 2;
    private static final int METHOD_WITH_PARAMS_COMPONENTS_NUM = 2;

    private RequestMessageEncoder() {
    }

    /**
     * Encode a request according to the provided parameters, in the format
     * specified above. It uses the POJOSerializer to serialized the object
     * given as parameter.
     *
     * @param method the protocol METHOD; please refer to ProtocolMethod class
     * @param url URL used to identify the resource onto the server
     * @param o object to serialize and attach as BODY
     * @return encoded request
     */
    public static String encode(ProtocolMethod method, String url, Object o) {
        String messageString = method + "_" + url + "_";

        if (o != null) {
            if (o instanceof String) {
                messageString += o;
            } else {
                messageString += POJOSerializer.serialize(o);
            }
        }

        return messageString;
    }

    public static String encode(ProtocolMethod method, String url) {
        return encode(method, url, null);
    }

    /**
     * Decode a request message from String to RequestMessage.
     * Please refer to the RequestMessage class for further details.
     *
     * @param m encoded request message to be decoded
     * @return instance of RequestMessage, representing the decoded request
     */
    public static RequestMessage decode(String m) {
        RequestMessage requestMessage = null;
        //split the encoded message by the separator _
        //the splitMessage array should now contain at least 2 elements (METHOD and URL) + optionally a third, BODY
        String[] splitMessage = m.split("_");

        if (splitMessage.length >= REQUEST_MIN_COMPONENTS_NUM) {
            requestMessage = new RequestMessage();
            //set the method field of the requestMessage to the value of splitMessage[0] (METHOD)
            requestMessage.setMethod(ProtocolMethod.valueOf(splitMessage[0]));

            //split the url by separator ?, to check if there are url passed parameters
            String[] splitUrl = splitMessage[1].split("\\?");
            //splitUrl[0] is the url, assign it to url field of requestMessage
            requestMessage.setUrl(splitUrl[0]);

            //check if there was a ? in the url (i.e. 2 strings generated by previous split)
            if(splitUrl.length == METHOD_WITH_PARAMS_COMPONENTS_NUM) {
                //further split by & keyword
                String[] splitQuery = splitUrl[1].split("&");

                //for each key=value pair, split in key and value and add it to the queryValues map of requestMessage
                for (String s : splitQuery) {
                    String[] splitKeyValue = s.split("=");
                    requestMessage.getQueryValues().put(splitKeyValue[0], splitKeyValue[1]);
                }
            }

            //if there is a 3rd component to the request message (i.e. BODY), assign it to serializedObject of requestMessage
            if (splitMessage.length == REQUEST_ALL_COMPONENTS_NUM) {
                requestMessage.setSerializedObject(splitMessage[REQUEST_ALL_COMPONENTS_NUM - 1]);
            }
        }

        return requestMessage;
    }
}
