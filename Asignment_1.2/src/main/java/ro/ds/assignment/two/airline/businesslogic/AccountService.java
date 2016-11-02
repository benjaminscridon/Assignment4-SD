package ro.ds.assignment.two.airline.businesslogic;

import javax.xml.rpc.ServiceException;
import ro.ds.assignment.two.airline.dao.AccountDAO;
import ro.ds.assignment.two.airline.domain.Account;
import ro.ds.assignment.two.airline.exceptions.RepositoryException;
import ro.ds.assignment.two.airline.util.HibernateUtil;

public class AccountService {

	private AccountDAO accountDAO;

	public AccountService() {
		accountDAO = new AccountDAO(HibernateUtil.getSessionFactory());
	}

	/**
	 * 
	 * @param account
	 * @return Return the role of account.
	 */
	public String isValidAccount(Account account) throws ServiceException{

		try {
			Account databaseAccount = accountDAO.findByUsername(account.getUsername());

			if (null != databaseAccount && databaseAccount.getUsername().equals(account.getUsername())
					&& databaseAccount.getPassword().equals(account.getPassword())) {

				return databaseAccount.getRole();
			}
			return null;
		} catch (RepositoryException exc) {
			throw new ServiceException("Invalid account!");
		}
	}
}
