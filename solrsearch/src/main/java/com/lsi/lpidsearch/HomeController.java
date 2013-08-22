package com.lsi.lpidsearch;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsi.entity.AttributeValues;
import com.lsi.entity.Lpid;
import com.lsi.lpidsearch.repository.CustomRepository;
import com.lsi.lpidsearch.service.AttributeValuesService;
import com.lsi.lpidsearch.service.LpidService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired private LpidService lpidService;
	
	@Autowired private AttributeValuesService attributeValuesService;
	
	public static final String ATTR_TYPE = "attributeValues";
	
	public static final String LPID_TYPE = "lpid";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/indexlpid", method = RequestMethod.POST)
	public String indexLpid(@RequestParam(value ="id")Long pkey, @RequestParam(value = "name")String name,
							@RequestParam(value ="description")String description, @RequestParam(value="lastchanged")Date lastchanged) {
		Long date = new Date().getTime();
		Lpid lpid = new Lpid(date.toString(), pkey.toString(), description, name, lastchanged);
		lpid.setType(LPID_TYPE);
		lpidService.createLpidIndex(lpid);
		return "home";
	}
	
	@RequestMapping(value = "/avindex", method = RequestMethod.POST)
	public String indexAv(@RequestParam(value ="id")Long pkey, @RequestParam(value = "effectiveFrom")Date effectiveFrom, @RequestParam(value = "effectiveTo")Date effectiveTo,
			@RequestParam(value ="attributeName")String attributeName, @RequestParam(value="attributeValue")Object attributeValue,
			@RequestParam(value = "sellerId")Long sellerId) {
		
		Long date = new Date().getTime();
		AttributeValues av = new AttributeValues();
		av.setId(date.toString());
		av.setAttributeName(attributeName);
		av.setLpidId(pkey);
		av.setEffectiveFrom(effectiveFrom);
		av.setEffectiveTo(effectiveTo);
		av.setAttributeValue(attributeValue);
		av.setSellerId(sellerId);
		av.setType(ATTR_TYPE);
		attributeValuesService.indexAttributeValues(av);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/searchav", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public List<Lpid> searchAV(@RequestParam(value ="attributeName")String attributeName, @RequestParam(value="attributeValue")String attributeValue
						  ) {
		
		List<Lpid> list = null;
		Pageable page = new PageRequest(1, 10);
		list= lpidService.findLpidByAttributeNameAndValue(attributeName, attributeValue);
		//list= attributeValuesService.findAttributeValuesByCustomImplementaion(attributeName, attributeValue);
		return list;
	}
	
}
