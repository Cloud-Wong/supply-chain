package com.cloud.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.spring.model.Company;
import com.cloud.spring.model.Order;
import com.cloud.spring.service.OrderService;

@Controller
@RequestMapping("SM-ord")
public class OrderController {

	private OrderService orderService;

	@Autowired(required = true)
	public void setOrderService(OrderService es) {
		this.orderService = es;
	}

	// 获取采购订单列表
	@RequestMapping(value = "/porder", method = RequestMethod.GET)
	public String listPOrders(Model model, HttpSession session) {
		Company c = (Company) session.getAttribute("company");
		List<Order> listOrder;
		List<Order> listOrder0 = new ArrayList<Order>();
		List<Order> listOrder12 = new ArrayList<Order>();
		List<Order> listOrder3 = new ArrayList<Order>();
		listOrder = this.orderService.getByPCompany(c.getId());
		for (Order o : listOrder) {
			if (o.getStatus() == 0) {
				listOrder0.add(o);
			} else if (o.getStatus() == 3) {
				listOrder3.add(o);
			} else {
				listOrder12.add(o);
			}
		}
		model.addAttribute("listOrder0", listOrder0);
		model.addAttribute("listOrder12", listOrder12);
		model.addAttribute("listOrder3", listOrder3);
		return "purchasingManagement/purchasingOrders";
	}

	// 获取销售订单列表
	@RequestMapping(value = "/sorder", method = RequestMethod.GET)
	public String listSOrders(Model model, HttpSession session) {
		Company c = (Company) session.getAttribute("company");
		List<Order> listOrder;
		List<Order> listOrder0 = new ArrayList<Order>();
		List<Order> listOrder12 = new ArrayList<Order>();
		List<Order> listOrder3 = new ArrayList<Order>();
		listOrder = this.orderService.getBySCompany(c.getId());
		for (Order o : listOrder) {
			if (o.getStatus() == 0) {
				listOrder0.add(o);
			} else if (o.getStatus() == 3) {
				listOrder3.add(o);
			} else {
				listOrder12.add(o);
			}
		}
		model.addAttribute("listOrder0", listOrder0);
		model.addAttribute("listOrder12", listOrder12);
		model.addAttribute("listOrder3", listOrder3);
		return "salesManagement/salesOrders";
	}
	// 发货单列表
	@RequestMapping(value = "/dispatch", method = RequestMethod.GET)
	public String dispatchBill(Model model, HttpSession session) {
		Company c = (Company) session.getAttribute("company");
		List<Order> listOrder;
		List<Order> listOrder12 = new ArrayList<Order>();
		List<Order> listOrder3 = new ArrayList<Order>();
		listOrder = this.orderService.getBySCompany(c.getId());
		for (Order o : listOrder) {
			if (o.getStatus() == 1 || o.getStatus() == 2) {
				listOrder12.add(o);
			} else if(o.getStatus() == 3){
				listOrder3.add(o);
			}
		}	

		model.addAttribute("listOrder12", listOrder12);
		model.addAttribute("listOrder3", listOrder3);
		return "inventorymana/dispatchBill";
	}
	// 到货单列表
	@RequestMapping(value = "/warehousingEntry", method = RequestMethod.GET)
	public String warehousingEntry(Model model, HttpSession session) {
		Company c = (Company) session.getAttribute("company");
		List<Order> listOrder;
		List<Order> listOrder12 = new ArrayList<Order>();
		List<Order> listOrder3 = new ArrayList<Order>();
		listOrder = this.orderService.getByPCompany(c.getId());
		for (Order o : listOrder) {
			if (o.getStatus() == 1 || o.getStatus() == 2) {
				listOrder12.add(o);
			} else if(o.getStatus() == 3){
				listOrder3.add(o);
			}
		}	
		model.addAttribute("listOrder12", listOrder12);
		model.addAttribute("listOrder3", listOrder3);
		return "inventorymana/warehousingEntry";
	}

	// 下订单
	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	public String addOrder(@ModelAttribute("order") Order e) {

		if (e.getId() == 0) {
			// new person, add it
			this.orderService.save(e);
		} else {
			// existing person, call update
			this.orderService.update(e);
		}

		return "redirect:/SM-ord/porder";
	}

	@RequestMapping("/comfirm/{id}")
	public String comfirm(@PathVariable("id") int id) {
		this.orderService.confirmedOrder(id);
		return "redirect:/SM-ord/sorder";
	}

	@RequestMapping("/deliver/{id}")
	public String deliver(@PathVariable("id") int id) {
		this.orderService.deliverGoods(id);
		return "redirect:/SM-ord/dispatch";
	}

	@RequestMapping("/finish/{id}")
	public String finish(@PathVariable("id") int id) {
		this.orderService.finishOrder(id);
		return "redirect:/SM-ord/warehousingEntry";
	}

}
