package ro.tuc.dsrl.ds.handson.assig.one.server.servlets;

import ro.tuc.dsrl.ds.handson.assig.one.protocol.servlets.AbstractServlet;
import ro.tuc.dsrl.ds.handson.assig.one.server.dao.StudentDAO;
import ro.tuc.dsrl.ds.handson.assig.one.protocol.encoders.ResponseMessageEncoder;
import ro.tuc.dsrl.ds.handson.assig.one.server.entities.Student;
import ro.tuc.dsrl.ds.handson.assig.one.protocol.enums.StatusCode;
import ro.tuc.dsrl.ds.handson.assig.one.protocol.message.RequestMessage;
import org.hibernate.cfg.Configuration;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-server
 * @Since: Sep 1, 2015
 * @Description: Serves for generating a response for the student related
 *               requests
 */
public class StudentServlet extends AbstractServlet {
	private StudentDAO studentDao;

	public StudentServlet() {
		studentDao = new StudentDAO(new Configuration().configure().buildSessionFactory());
	}

	@Override
	public String doPost(RequestMessage message) {
		String response;

		// Attempt deserializing a Student object from the request
		Student student = message.getDeserializedObject(Student.class);

		// Deserializing successful, add student to database and provide OK
		// response
		if (student != null) {
			studentDao.addStudent(student);
			response = ResponseMessageEncoder.encode(StatusCode.OK, String.valueOf(student.getId()));
		} else {
			response = ResponseMessageEncoder.encode(StatusCode.BAD_REQUEST);
		}

		return response;
	}

	@Override
	public String doGet(RequestMessage message) {
		String response;

		// Get from the query values the desired id
		String id = message.getQueryValues().get("id");
		// Find student in database and generate response
		if (id != null) {
			try {
				Student student = studentDao.findStudent(Integer.parseInt(id));

				if (student == null) {
					response = ResponseMessageEncoder.encode(StatusCode.NOT_FOUND);
				} else {
					response = ResponseMessageEncoder.encode(StatusCode.OK, student);
				}
			} catch (NumberFormatException e) {
				response = ResponseMessageEncoder.encode(StatusCode.BAD_REQUEST);
			}
		}
		// Id missing from request
		else {
			response = ResponseMessageEncoder.encode(StatusCode.BAD_REQUEST);
		}

		return response;
	}

	@Override
	public String doDelete(RequestMessage message) {
		String response = ResponseMessageEncoder.encode(StatusCode.NOT_ALLOWED);
		String id = message.getQueryValues().get("id");

		if (null != id) {
			boolean flag = studentDao.deleteStudent(Integer.parseInt(id));
			if (flag == true) {
				response = ResponseMessageEncoder.encode(StatusCode.OK);
			} else {
				response = ResponseMessageEncoder.encode(StatusCode.NOT_FOUND);
			}
		}
		return response;
	}

	@Override
	public String doDelete2(RequestMessage message) {
		String response = null;
		String id = message.getSerializedObject();

		if (null != id) {
			Student resultStudent = studentDao.findStudent(Integer.parseInt(id));

			if (null != resultStudent) {
				studentDao.deleteStudent(resultStudent.getId());
				response = ResponseMessageEncoder.encode(StatusCode.OK, resultStudent);
			} else {
				response = ResponseMessageEncoder.encode(StatusCode.NOT_FOUND);
			}
		} else {
			response = ResponseMessageEncoder.encode(StatusCode.BAD_REQUEST);
		}
		return response;
	}
}
