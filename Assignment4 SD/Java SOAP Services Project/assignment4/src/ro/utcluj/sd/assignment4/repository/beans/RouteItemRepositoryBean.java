package ro.utcluj.sd.assignment4.repository.beans;

import ro.utcluj.sd.assignment4.entities.RouteItem;
import ro.utcluj.sd.assignment4.repository.RouteItemRepository;

public class RouteItemRepositoryBean extends BaseRepositoryBean<RouteItem> implements RouteItemRepository {

	public RouteItemRepositoryBean() {
		super(RouteItem.class);

	}
}
