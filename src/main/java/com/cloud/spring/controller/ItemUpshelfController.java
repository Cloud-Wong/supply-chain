package com.cloud.spring.controller;



import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloud.spring.model.Company;
import com.cloud.spring.model.ItemUpshelf;
import com.cloud.spring.model.Order;
import com.cloud.spring.service.ItemUpshelfService;
import com.cloud.spring.service.ProductService;

@Controller
@SessionAttributes("itemUpshelf")
@RequestMapping("SM-ite")
public class ItemUpshelfController {

	private ItemUpshelfService itemUpshelfService;
	private ProductService productService;

	@Autowired(required = true)
	public void setProductService(ProductService es) {
		this.productService = es;
	}

	@Autowired(required = true)
	public void setItemUpshelfService(ItemUpshelfService es) {
		this.itemUpshelfService = es;
	}

	//前往货架管理页面
	@RequestMapping(value = "/itemUpshelf", method = RequestMethod.GET)
	public String listItem(Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("itemUpshelf", new ItemUpshelf());
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		model.addAttribute("listItemUpshelf", this.itemUpshelfService.getSelfList(c.getId()));
		return "salesManagement/itemUpshelfs";
	}
	
	//显示所有上架商品（前往采购商品页面）
	@RequestMapping(value="/showAllPutaway", method = RequestMethod.GET)
	public String showAll(Model model){
		model.addAttribute("listItemUpshelf",this.itemUpshelfService.getAllPutaway());
		return "purchasingManagement/commodities";
	}
	
	//前往商品详情页面
	@RequestMapping(value="/showCommodityDetail/{id}")
	public String showCommodityDetail(@PathVariable("id") int id, Model model,HttpSession session){
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		model.addAttribute("order", new Order());
		model.addAttribute("itemUpshelf", this.itemUpshelfService.getById(id));
		return "purchasingManagement/commodityDetail";
	}

	//编辑货架信息页面
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model,HttpSession session) {
		Company c = (Company)session.getAttribute("company");
		model.addAttribute("itemUpshelf", this.itemUpshelfService.getById(id));
		model.addAttribute("listProduct", this.productService.getListByCompany(c.getId()));
		model.addAttribute("listItemUpshelf", this.itemUpshelfService.getSelfList(c.getId()));
		return "salesManagement/itemUpshelfs";
	}
	
	// 保存/编辑货架信息
	@RequestMapping(value = "/itemUpshelf/save", method = RequestMethod.POST)
	public String add(@ModelAttribute("ItemUpshelf") ItemUpshelf e) {

		if (e.getId() == 0) {
			// new person, add it
			this.itemUpshelfService.save(e);
		} else {
			
			this.itemUpshelfService.update(e);
		}
		return "redirect:/SM-ite/itemUpshelf";
	}
	
	//删除货架信息
	@RequestMapping("/delete/{id}")
	public String remove(@PathVariable("id") int id) {
		this.itemUpshelfService.delete(id);
		return "redirect:/SM-ite/itemUpshelf";
	}
	
	// 商品上架/下架
	@RequestMapping("/itemUpshelf/putaway") 
    public void ajaxPutaway(String id,PrintWriter out){  
		int changeId = Integer.parseInt(id);
		this.itemUpshelfService.changeStatus(changeId);
		out.write(""); 
    }  

}
