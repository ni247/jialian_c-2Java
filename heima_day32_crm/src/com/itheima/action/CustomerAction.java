package com.itheima.action;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer cus = new Customer();

	@Override
	public Customer getModel() {
		return cus;
	}

	@Override
	public String execute() throws Exception {
		new CustomerService().saveOrUpdateCustomer(cus);
		return SUCCESS;
	}

}
