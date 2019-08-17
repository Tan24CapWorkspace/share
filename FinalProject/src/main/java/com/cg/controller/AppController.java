package com.cg.controller;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.PDLOverrideSupported;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Admin;
import com.cg.bean.Capstore;
import com.cg.bean.Cart;
import com.cg.bean.Coupon;
import com.cg.bean.Discount;
import com.cg.bean.Invoice;
import com.cg.bean.Merchant;
import com.cg.bean.Product;
import com.cg.bean.Promocode;
import com.cg.bean.Return;
import com.cg.bean.Review;
import com.cg.bean.SecurityAns;
import com.cg.bean.SortingFormat;
import com.cg.bean.Token;
import com.cg.bean.Transaction;
import com.cg.bean.User1;
import com.cg.bean.Wishlist;
import com.cg.dao.AdminDAO;
import com.cg.dao.CapStoreDAO;
import com.cg.dao.CartDAO;
import com.cg.dao.CouponDAO;
import com.cg.dao.DiscountDAO;
import com.cg.dao.InvoiceDAO;
import com.cg.dao.MerchantDAO;
import com.cg.dao.ProductDAO;
import com.cg.dao.PromocodeDAO;
import com.cg.dao.ReturnDAO;
import com.cg.dao.ReviewDAO;
import com.cg.dao.SecurityDAO;
import com.cg.dao.TokenDAO;
import com.cg.dao.TransactionDAO;
import com.cg.dao.User1DAO;
import com.cg.dao.WishlistDAO;
import com.cg.exception.ApplicationException;
import com.cg.service.LoginService;
import com.cg.service.ProductService;
import com.sun.swing.internal.plaf.metal.resources.metal;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private LoginService service1;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired 
	private MerchantDAO merchantDAO;
	
	@Autowired
	private User1DAO user1DAO;
	
	@Autowired
	private DiscountDAO discountDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private SecurityDAO securityDAO;
	
	@Autowired
	private CapStoreDAO capstoreDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CouponDAO couponDAO;
	
	
	@Autowired
	private InvoiceDAO invoiceDAO;
	
	@Autowired
	private PromocodeDAO promocodeDAO;
	
	@Autowired
	private ReturnDAO returnDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private TokenDAO tokenDAO;
	
	@Autowired
	private WishlistDAO wishlistDAO;
	@PostConstruct
	public void setup() {
		//Product p = new Product(100, "Vivo Y 66", 100, null, "Vivo", null, "Nothing", new Review(), category, views, quantity, soldQuantities, price)
//		Product p = new Product(102, "Vivo", 100, null, "Vivo", null, "", "", "Electronics", "Mobile", 100, 100, 10, 100);
		List<String> tags = new ArrayList<>();
		tags.add("Vivo");
		//p.setTag(tags);
//		User1 u1=new User1("subbu@gmail.com","Subhanshu","Bigasia","subbu",9875463215L,"Pune","Link1");
//		User1 u2=new User1("tanmay@gmail.com","Tanmay","Pathak","tanmay",9875463975L,"Pune","Link2");
//		User1 u3=new User1("akhil@gmail.com","Akhil","Bigasia","akhil",8745463215L,"Pune","Link3");
//		User1 u4=new User1("rohit@gmail.com","Rohit","Sammanwar","rohit",9563143215L,"Pune","Link4");
//		User1 u5=new User1("prince@gmail.com","Prince","Kumar","prince",9856412347L,"Pune","Link5");
//		Admin a=new Admin("Subhanshu","Bigasia","subbu@gmail.com","subbu@123","Link6");
//		Merchant m=new Merchant("Naman","Jain","Jain Exports","naman@gmail.com",9875641234L,"nammujain","Link7",4.5,"Approved");
//		
//		user1DAO.saveAndFlush(u1);
//		user1DAO.saveAndFlush(u2);
//		user1DAO.saveAndFlush(u3);
//		user1DAO.saveAndFlush(u4);
//		user1DAO.saveAndFlush(u5);
//		adminDAO.saveAndFlush(a);
//		merchantDAO.saveAndFlush(m);
		
//		
//		Optional<Merchant> mer = merchantDAO.findById(7);
//		
//		Merchant m1 = mer.get();
//		
//		
//		Product p=new Product("Vivo Y67",m1,tags,"Vivo","Link8","Simple Mobile",10,"Electronics","Mobile",10,1000, new Date(2019, 8, 14));
//		Product p1=new Product("Vivo Y68",m1,tags,"Vivo","Link8","Simple Mobile",10,"Electronics","Mobile",10,1000, new Date(2019, 8, 14));
//		Product p2=new Product("Vivo Y69",m1,tags,"Vivo","Link8","Simple Mobile",10,"Electronics","Mobile",10,1000, new Date(2019, 8, 14));
//		Product p3=new Product("Vivo Y70",m1,tags,"Vivo","Link8","Simple Mobile",10,"Electronics","Mobile",10,1000, new Date(2019, 8, 14));
//		productDAO.saveAndFlush(p);
//		productDAO.saveAndFlush(p1);
//		productDAO.saveAndFlush(p2);
//		productDAO.saveAndFlush(p3);
		
//		
//		Optional<Product> box = productDAO.findById(8);
//		if(box.isPresent()) {
//			Product product = box.get();
//			product.setReleaseDate(new Date(2019, 8, 14));
//			productDAO.saveAndFlush(product);
//		}
		
//		Optional<Product> box = productDAO.findById(8);
//		if(box.isPresent()) {
//			Product product = box.get();
//			Discount d = new Discount(product, 5D, new Date(2019, 8, 14), new Date(2019, 8, 24));
//			discountDAO.saveAndFlush(d);
//		}
//		
//		
//		SecurityAns s = new SecurityAns("tanmay@gmail.com", "noting", "noting");
//		SecurityAns s1 = new SecurityAns("rohit@gmail.com", "noting", "noting");
//		securityDAO.saveAndFlush(s);
//		securityDAO.saveAndFlush(s1);
		
		
//		
//		Optional<Discount> box = discountDAO.findById(11);
//		if(box.isPresent()) {
//			Discount d = box.get();
//			System.out.println(d);
//			Product p = d.getProduct();
//			System.out.println(p.getProductName());
//		}
		
		
//		Optional<User1> box = user1DAO.findById(1);
//		User1 u = box.get();
//		Integer[] array = {3, 1, 1000};
//		Integer[] array2 = {4, 1, 1000};
//		List<Integer[]> list = new ArrayList<>();
//		list.add(array);
//		list.add(array2);
//		
//		Transaction t = new Transaction(u, list, "Delivered", new Date(2019, 8, 24), "Cash");
//		
//		transactionDAO.saveAndFlush(t);

		
//		Optional<User1> box = user1DAO.findById(1);
//		User1 user = box.get();
//		
//		List<Integer[]> list = new ArrayList<Integer[]>();
//		Integer[] array = {8,1};
//		Integer[] array1 = {9,1};
//		list.add(array);
//		list.add(array1);
//		Cart c = new Cart(user, list, 1000D);
//		cartDAO.saveAndFlush(c);
		
		
//		Optional<Transaction> box = transactionDAO.findById(1);
//		Transaction t = box.get();
//		List<Integer[]> list = new ArrayList<>();
//		Integer[] array = {3, 1};
//		Integer[] array2 = {4, 1};
//		list.add(array);
//		list.add(array2);
//		t.setProducts(list);
//		transactionDAO.saveAndFlush(t);
		

		
		
	}
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping("/addaccount")
//	public List<Product> getProducts(@RequestParam String category, @RequestParam String subcategory) {
//		try {
//			return service.getProducts(category, subcategory);
//		} catch (ApplicationException ex) {
//			return null;
//		}
//	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/similar")
	public List<Product> getSimilarProducts(@RequestParam String category, @RequestParam String subcategory, @RequestParam Integer productId) {
		try {
			return service.getSimilarProducts(category, subcategory, productId);
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getproducts")
	public List<Product> getProducts() {
		try {
			return service.getProducts();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	// For getting products of a category in order of product price from low to high
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/sortproductsasc")
		public ResponseEntity<List<Product>> getProductsAsc(@RequestBody SortingFormat input) {
			List<Product> productAsc = service.getProductsAsc(input.getCategory());
			if (productAsc.isEmpty())
				return new ResponseEntity("Sorry! Products can't Retrieved!", HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<List<Product>>(productAsc, HttpStatus.OK);

		}

	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/gettransaction")
	public List<Transaction> getTransaction() {
		try {
			return transactionDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getsecurity")
	public List<SecurityAns> getSecurity() {
		try {
			return securityDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getdiscount")
	public List<Discount> getDiscount() {
		try {
			return discountDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getadmin")
	public List<Admin> getAdmin() {
		try {
			return adminDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getcapstore")
	public List<Capstore> getCapstore() {
		try {
			return capstoreDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getcart")
	public List<Cart> getCart() {
		try {
			return cartDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getinvoice")
	public List<Invoice> getInvoice() {
		try {
			return invoiceDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getcoupon")
	public List<Coupon> getCoupon() {
		try {
			return couponDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getpromocode")
	public List<Promocode> getPromocode() {
		try {
			return promocodeDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getreturn")
	public List<Return> getReturn() {
		try {
			return returnDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getreview")
	public List<Review> getReview() {
		try {
			return reviewDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/gettoken")
	public List<Token> getToken() {
		try {
			return tokenDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getwishlist")
	public List<Wishlist> getWishlist() {
		try {
			return wishlistDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getuser")
	public List<User1> getUser() {
		try {
			return user1DAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getmerchant")
	public List<Merchant> getMerchant() {
		try {
			return merchantDAO.findAll();
		} catch (ApplicationException ex) {
			return null;
		}
	}
	
	// setters
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setadmin")
	public void setAdmin(@RequestBody List<Admin> admin) {
		for(Admin e : admin) {
			adminDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setcapstore")
	public void setCapstore(@RequestBody List<Capstore> capstore) {
		for(Capstore e : capstore) {
			capstoreDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setcart")
	public void setCart(@RequestBody List<Cart> element) {
		for(Cart e: element ) {
			cartDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setcoupon")
	public void setCoupon(@RequestBody List<Coupon> element) {
		for(Coupon e: element ) {
			couponDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setdiscount")
	public void setDiscount(@RequestBody List<Discount> element) {
		for(Discount e : element) {
			discountDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setinvoice")
	public void setInvoice(@RequestBody List<Invoice> element) {
		for(Invoice e : element) {
			invoiceDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setmerchant")
	public void setMerchant(@RequestBody List<Merchant> element) {
		for(Merchant e : element) {
			merchantDAO.saveAndFlush(e);
		}
	}
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setproduct")
	public void setProduct(@RequestBody List<Product> element) {
		for(Product e : element) {
			productDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setpromocode")
	public void setPromocode(@RequestBody List<Promocode> element) {
		for(Promocode e : element) {
			promocodeDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setreturn")
	public void setReturn(@RequestBody List<Return> element) {
		for(Return e : element) {
			returnDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setreview")
	public void setReview(@RequestBody List<Review> element) {
		for(Review e : element) {
			reviewDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setsecurity")
	public void setSecurity(@RequestBody List<SecurityAns> element) {
		for(SecurityAns e : element) {
			securityDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/settoken")
	public void setToken(@RequestBody List<Token> element) {
		for(Token e : element) {
			tokenDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/settransaction")
	public void setTransaction(@RequestBody List<Transaction> element) {
		for(Transaction e : element) {
			transactionDAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setuser")
	public void setUser(@RequestBody List<User1> element) {
		for(User1 e : element) {
			user1DAO.saveAndFlush(e);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setwishlist")
	public void setWishlist(@RequestBody List<Wishlist> element) {
		for(Wishlist e : element) {
			wishlistDAO.saveAndFlush(e);
		}
	}
	
	
	
	//Finding A particular Account
	@GetMapping("/find/admin/{username}/{password}")
	public Admin getAccountAdmin(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		Admin ad = service1.findAdmin(username,password); 
		System.out.println(ad);
		System.out.println(username+ " " +password);
		if(ad == null)
		{
			Admin ad1 = new Admin("","","","","");
			return ad1;
		}
		return ad;
	}

	//Finding A particular Account
	@GetMapping("/find/customer/{username}/{password}")
	public User1 getAccountCustomer(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		User1 ad = service1.findCustomer(username,password); 
		System.out.println(ad);
		if(ad == null)
		{
			User1 ad1 = new User1("","","","",0L,"","");
			return ad1;
		}
		return ad;
	}

	//Finding A particular Account
	@GetMapping("/find/merchant/{username}/{password}")
	public Merchant getAccountMerchant(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		Merchant ad = service1.findMerchant(username,password); 
		System.out.println(ad);
		if(ad == null)
		{
			Merchant ad1 = new Merchant("","","","",0L,"","",0D,"");
			return ad1;
		}
		return ad;
	}

	
	
	

}
