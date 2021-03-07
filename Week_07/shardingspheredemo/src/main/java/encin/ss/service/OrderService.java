package encin.ss.service;

import javax.sql.DataSource;

import encin.ss.entity.Account;

public interface OrderService {

    public Boolean addOrder(DataSource dataSource, Account account);

    public Account getOrderById(DataSource dataSource, String orderId);
}
