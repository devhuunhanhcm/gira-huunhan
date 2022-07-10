package springbootapplication.girahuunhan.common.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHelper {
	public static ResponseEntity<Object> getResponse(Object obj,HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Content", obj);
		map.put("HasError", false);
		map.put("timestamp", LocalDateTime.now().toLocalTime());
		map.put("Status", status);
		return new ResponseEntity<>(map,status);
	}
	
	public static ResponseEntity<Object> getErrorResponse(BindingResult error,HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Content", null);
		map.put("HasError", true);
		map.put("Error", ErrorHelper.getAllError(error));
		map.put("timestamp", LocalDateTime.now().toLocalTime());
		map.put("Status", status);
		return new ResponseEntity<>(map,status);
	}
	public static ResponseEntity<Object> getErrorResponse(String error,HttpStatus status){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Content", null);
		map.put("HasError", true);
		map.put("Error", error);
		map.put("timestamp", LocalDateTime.now().toLocalTime());
		map.put("Status", status);
		return new ResponseEntity<>(map,status);
	}
}
