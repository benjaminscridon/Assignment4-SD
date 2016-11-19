package ro.tuc.dsrl.ds.handson.assig.three.queue.communication;

import java.io.Serializable;

import ro.tuc.dsrl.ds.handson.assig.three.producer.entities.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description:
 *	Message class, serializable, used by the socket communication between the
 * components. It represents the exchange mechanism between the clients and the queue server.
 *
 * It has 2 fields:
 *  - type: the type of the message
 *          SEND - inserting a content into the queue
 *          READ - retrieving a content from the queue
 *          ACK - operation successful on the server side
 *          ERR - operation failed on the server side
 *  - content: content associated with the message.
 */
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;
    private DVD content;

    public Message(String type, DVD dvd) {
        this.type = type;
        this.content = dvd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DVD getContent() {
        return content;
    }

    public void setContent(DVD content) {
        this.content = content;
    }
}
