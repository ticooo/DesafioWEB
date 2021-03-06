package desafio.utils;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import desafio.setup.Hooks;
import io.cucumber.datatable.DataTable;

public class Helper {
	
	public static List<Map<String, String>> listDataTable;
	
	public static void wait_element(WebElement elemento, int timeout) { 
		
		WebDriverWait wait = new WebDriverWait(Hooks.get_driver(), timeout);
		wait.until(ExpectedConditions.visibilityOf(elemento));
					
	}
			
	public static boolean element_exists(WebElement elemento, int timeout) { 
		
		try {			
			wait_element(elemento, timeout);
			
			return true;			
			
		} catch (Exception e) {
			System.out.println("O elemento não foi encontrado!");
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static void create_datatable(DataTable dataTable_) {
		listDataTable = dataTable_.asMaps(String.class, String.class);
	}
	
}
