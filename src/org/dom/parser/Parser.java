package org.dom.parser;

import java.io.File;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.dom.dao.LoginDAO;
import org.dom.model.Login;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Parser {
	
	public void parserXML() throws DocumentException{
		SAXReader xmlReader = new SAXReader();
		File file = new File(Parser.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", " ") + "login.xml");
		Document doc;
		Element root;
		doc = xmlReader.read(file);
		root = doc.getRootElement();
		LoginDAO lDao = new LoginDAO();
		Iterator<Element> it = root.elementIterator("login");
		while(it.hasNext()){
			Element elm = (Element) it.next();
			Iterator<Element> it2 = elm.elementIterator();
			Login login = new Login();
			while(it2.hasNext()){
				Element elm2 = it2.next();
				switch(elm2.getName()){
					
					case "id":
						login.setId(elm2.getStringValue());
						break;
					case "user":
						login.setUsername(elm2.getStringValue());
						break;
					case "pass":
						login.setPassword(elm2.getStringValue());
						break;
				}
			}
			try {
				lDao.save(login);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
