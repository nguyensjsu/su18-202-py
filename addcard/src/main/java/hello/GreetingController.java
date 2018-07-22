package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); 

	private Card cc = new Card("1234567887654321","9876",51.00);

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/getBalance")
	public Card getBalance(@RequestParam(value="cardNum", defaultValue="1234567887654321") String cardNum){
		return cc;
	}
}