package com.wangkang.se.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class PersonXMLDao
{
	private String xmlUrl = "src\\com\\wangkang\\se\\xml";
	private String xmlFileName = "PersonDataBase.xml";
	// 在dom4j中使用sax的解析器
	private SAXReader reader = new SAXReader();
	File file = new File(xmlUrl, xmlFileName);

	//查找所有person
	public List<Person> queryList(List<Person> list) throws DocumentException
	{
		Document document = reader.read(file);
		// 得到根节点
		Element root = document.getRootElement();
		// 遍历所有的节点
		Iterator<Element> it = root.elementIterator();
		while (it.hasNext())
		{
			Person person = new Person();
			Element element = it.next();
			// 这里属性也能作为一个子节点
			Attribute id = element.attribute("id");
			person.setId(Integer.valueOf(id.getValue()));
			person.setPassword(element.element("password").getText());
			person.setSex(element.element("sex").getText());
			person.setUsernmae(element.element("username").getText());
			list.add(person);
		}
		return list;
	}

	//添加person对象
	public int addPerson(Person person) throws DocumentException,
			IOException
	{
		Document document = reader.read(file);
		Element root = document.getRootElement();
		int personId = getMaxId(root) + 1;
		// DocumentHelper对象可以产生一个element对象
		Element personElement = DocumentHelper.createElement("person")
				.addAttribute("id", String.valueOf(personId));
		// person节点添加一个username节
		personElement.addElement("username").addText(person.getUsernmae());
		personElement.addElement("password").addText(person.getPassword());
		personElement.addElement("sex").addText(person.getSex());
		root.add(personElement);
		updateXml(document);
		return personId;
	}

	//根据Id删除person
	public void deletePersonById(int id) throws DocumentException, IOException
	{
		Document document = reader.read(file);
		//得到根节点
		Element root=document.getRootElement();
		Element  queryElement=queryElementById(root,id);
		if(queryElement==null)
			System.out.println("指定id的节点不存在");
		root.remove(queryElement);
		updateXml(document);
	}

	//得到最后一个的Id，是Id自动增长
	private int getMaxId(Element root) throws DocumentException
	{

		List<Element> elementList = root.elements();
		// 得到最后一个element的id
		int maxId = Integer.valueOf(elementList.get(elementList.size() - 1)
				.attribute("id").getText());
		return maxId;
	}

	//提交事务
	private void updateXml(Document document) throws IOException
	{
		XMLWriter write = new XMLWriter(new FileWriter(file ));
		write.write(document);
		write.close();
	}

	//根据指定的root 查找指定id的记录
	private Element  queryElementById(Element root,int  id)
	{
	
		//遍历所有的节点
		Iterator<Element> it=root.elementIterator();
		while(it.hasNext())
		{
			Element element=it.next();
			if(Integer.valueOf(element.attribute("id").getText())==id)
			return element;
		}
		return  null;
	}
	//修改person
	public  int  updateOrAddPerson(Person person) throws DocumentException, IOException 
	{
		if(person.getId()==-1)
		  return	addPerson(person);
		else
		{
			Document document=reader.read(file);
			Element root=document.getRootElement();
			Element element=queryElementById(root,person.getId());
			element.element("username").setText(person.getUsernmae());
			element.element("password").setText(person.getPassword());
			element.element("sex").setText(person.getSex());
			updateXml(document);
			return person.getId();
		}
		
			
	}
}
