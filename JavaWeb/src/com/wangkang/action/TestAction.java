package com.wangkang.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("testAction")
@Scope(value="prototype")
public class TestAction
{
   public String execute()
   {
	   System.out.println("进入action");
	   return  "success";
   }
}
